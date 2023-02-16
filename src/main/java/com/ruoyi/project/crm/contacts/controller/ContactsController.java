package com.ruoyi.project.crm.contacts.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.crm.contacts.domain.Contacts;
import com.ruoyi.project.crm.contacts.service.IContactsService;
import com.ruoyi.project.crm.customer.domain.Customer;
import com.ruoyi.project.crm.customer.service.ICustomerService;
import com.ruoyi.project.crm.info.domain.BusinessInfo;
import com.ruoyi.project.crm.info.service.IBusinessInfoService;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.dept.service.IDeptService;
import com.ruoyi.project.system.post.service.IPostService;
import com.ruoyi.project.system.role.service.IRoleService;
import com.ruoyi.project.system.user.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 联系人Controller
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Controller
@RequestMapping("/crm/contacts")
public class ContactsController extends BaseController
{
    private String prefix = "crm/contacts";

    @Autowired
    private IContactsService contactsService;
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPostService postService;
    @Autowired
    private IDeptService deptService;
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IBusinessInfoService businessInfoService;

    @RequiresPermissions("crm:contacts:view")
    @GetMapping()
    public String contacts(ModelMap mmap ,HttpServletRequest request)
    {
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("postList", postService.selectPostAll());
        servletContext.setAttribute("deptList",deptService.selectDeptList(new Dept()));
        servletContext.setAttribute("BusinessInfoList", businessInfoService.selectBusinessInfoList(new BusinessInfo()));
        servletContext.setAttribute("customerList",customerService.selectCustomerList(new Customer()));
        return prefix + "/contacts";
    }

    /**
     * 查询联系人列表
     */
    @RequiresPermissions("crm:contacts:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Contacts contacts)
    {
        startPage();
        List<Contacts> list = contactsService.selectContactsList(contacts);
        return getDataTable(list);
    }

    /**
     * 导出联系人列表
     */
    @RequiresPermissions("crm:contacts:export")
    @Log(title = "联系人", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Contacts contacts)
    {
        System.out.println(contacts);
        List<Contacts> list = contactsService.selectContactsList(contacts);
        ExcelUtil<Contacts> util = new ExcelUtil<Contacts>(Contacts.class);
        return util.exportExcel(list, "contacts");
    }

    /**
     * 新增联系人
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存联系人
     */
    @RequiresPermissions("crm:contacts:add")
    @Log(title = "联系人", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Contacts contacts)
    {
        return toAjax(contactsService.insertContacts(contacts));
    }

    /**
     * 修改联系人
     */
    @GetMapping("/edit/{contactsId}")
    public String edit(@PathVariable("contactsId") Long contactsId, ModelMap mmap)
    {
        Contacts contacts = contactsService.selectContactsById(contactsId);
        mmap.put("contacts", contacts);
        return prefix + "/edit";
    }

    /**
     * 修改保存联系人
     */
    @RequiresPermissions("crm:contacts:edit")
    @Log(title = "联系人", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Contacts contacts)
    {
        return toAjax(contactsService.updateContacts(contacts));
    }

    /**
     * 删除联系人
     */
    @RequiresPermissions("crm:contacts:remove")
    @Log(title = "联系人", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(contactsService.deleteContactsByIds(ids));
    }
}
