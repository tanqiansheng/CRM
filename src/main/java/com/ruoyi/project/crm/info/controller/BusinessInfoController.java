package com.ruoyi.project.crm.info.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.crm.customer.domain.Customer;
import com.ruoyi.project.crm.customer.service.ICustomerService;
import com.ruoyi.project.crm.info.domain.BusinessInfo;
import com.ruoyi.project.crm.info.service.IBusinessInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 商业信息Controller
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Controller
@RequestMapping("/crm/info")
public class BusinessInfoController extends BaseController
{
    private String prefix = "crm/info";

    @Autowired
    private IBusinessInfoService businessInfoService;
    @Autowired
    private ICustomerService customerService;

    @RequiresPermissions("crm:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询商业信息列表
     */
    @RequiresPermissions("crm:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusinessInfo businessInfo, HttpServletRequest request)
    {
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("customerList",customerService.selectCustomerList(new Customer()));
        startPage();
        List<BusinessInfo> list = businessInfoService.selectBusinessInfoList(businessInfo);
        return getDataTable(list);
    }

    /**
     * 导出商业信息列表
     */
    @RequiresPermissions("crm:info:export")
    @Log(title = "商业信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusinessInfo businessInfo)
    {
        List<BusinessInfo> list = businessInfoService.selectBusinessInfoList(businessInfo);
        ExcelUtil<BusinessInfo> util = new ExcelUtil<BusinessInfo>(BusinessInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 新增商业信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商业信息
     */
    @RequiresPermissions("crm:info:add")
    @Log(title = "商业信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusinessInfo businessInfo)
    {
        return toAjax(businessInfoService.insertBusinessInfo(businessInfo));
    }

    /**
     * 修改商业信息
     */
    @GetMapping("/edit/{busId}")
    public String edit(@PathVariable("busId") Long busId, ModelMap mmap)
    {
        BusinessInfo businessInfo = businessInfoService.selectBusinessInfoById(busId);
        mmap.put("businessInfo", businessInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存商业信息
     */
    @RequiresPermissions("crm:info:edit")
    @Log(title = "商业信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusinessInfo businessInfo)
    {
        return toAjax(businessInfoService.updateBusinessInfo(businessInfo));
    }

    /**
     * 删除商业信息
     */
    @RequiresPermissions("crm:info:remove")
    @Log(title = "商业信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(businessInfoService.deleteBusinessInfoByIds(ids));
    }
}
