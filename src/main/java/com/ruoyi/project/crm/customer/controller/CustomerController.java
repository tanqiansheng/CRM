package com.ruoyi.project.crm.customer.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.crm.compact.mapper.CompactMapper;
import com.ruoyi.project.crm.customer.domain.Customer;
import com.ruoyi.project.crm.customer.service.ICustomerService;
import com.ruoyi.project.crm.info.mapper.BusinessInfoMapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 客户(企业，组织或个人)Controller
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Controller
@RequestMapping("/crm/customer")
public class CustomerController extends BaseController
{
    private String prefix = "crm/customer";

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private CompactMapper compactMapper;
    @Autowired
    private BusinessInfoMapper businessInfoMapper;

    @RequiresPermissions("crm:customer:view")
    @GetMapping()
    public String customer()
    {
        return prefix + "/customer";
    }

    /**
     * 查询客户(企业，组织或个人)列表
     */
    @RequiresPermissions("crm:customer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Customer customer)
    {

        startPage();
        List<Customer> list = customerService.selectCustomerList(customer);
        return getDataTable(list);
    }

    /**
     * 导出客户列表
     */
    @RequiresPermissions("crm:customer:export")
    @Log(title = "客户(企业，组织或个人)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Customer customer)
    {
        List<Customer> list = customerService.selectCustomerList(customer);
        ExcelUtil<Customer> util = new ExcelUtil<Customer>(Customer.class);
        return util.exportExcel(list, "customer");
    }

    /**
     * 新增客户(企业，组织或个人)
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户(企业，组织或个人)
     */
    @RequiresPermissions("crm:customer:add")
    @Log(title = "客户(企业，组织或个人)", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Customer customer)
    {
        return toAjax(customerService.insertCustomer(customer));
    }

    /**
     * 修改客户(企业，组织或个人)
     */
    @GetMapping("/edit/{cid}")
    public String edit(@PathVariable("cid") Long cid, ModelMap mmap)
    {
        Customer customer = customerService.selectCustomerById(cid);
        mmap.put("customer", customer);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户(企业，组织或个人)
     */
    @RequiresPermissions("crm:customer:edit")
    @Log(title = "客户(企业，组织或个人)", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Customer customer)
    {
        return toAjax(customerService.updateCustomer(customer));
    }

    /**
     * 删除客户(企业，组织或个人)
     */
    @RequiresPermissions("crm:customer:remove")
    @Log(title = "客户(企业，组织或个人)", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(customerService.deleteCustomerByIds(ids));
    }
}
