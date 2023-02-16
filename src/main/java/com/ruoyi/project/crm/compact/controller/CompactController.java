package com.ruoyi.project.crm.compact.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.crm.compact.domain.Compact;
import com.ruoyi.project.crm.compact.service.ICompactService;
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
 * 合同Controller
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Controller
@RequestMapping("/crm/compact")
public class CompactController extends BaseController
{
    private String prefix = "crm/compact";
    @Autowired
    private ICompactService compactService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IBusinessInfoService businessInfoService;

    @RequiresPermissions("crm:compact:view")
    @GetMapping()
    public String compact(HttpServletRequest request)
    {
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("BusinessInfoList", businessInfoService.selectBusinessInfoList(new BusinessInfo()));
        servletContext.setAttribute("customerList",customerService.selectCustomerList(new Customer()));
        return prefix + "/compact";
    }

    /**
     * 查询合同列表
     */
    @RequiresPermissions("crm:compact:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Compact compact)
    {
        startPage();
        List<Compact> list = compactService.selectCompactList(compact);
        return getDataTable(list);
    }

    /**
     * 导出合同列表
     */
    @RequiresPermissions("crm:compact:export")
    @Log(title = "合同", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Compact compact)
    {
        List<Compact> list = compactService.selectCompactList(compact);
        ExcelUtil<Compact> util = new ExcelUtil<Compact>(Compact.class);
        return util.exportExcel(list, "compact");
    }

    /**
     * 新增合同
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存合同
     */
    @RequiresPermissions("crm:compact:add")
    @Log(title = "合同", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Compact compact)
    {
        return toAjax(compactService.insertCompact(compact));
    }

    /**
     * 修改合同
     */
    @GetMapping("/edit/{compactId}")
    public String edit(@PathVariable("compactId") Long compactId, ModelMap mmap)
    {
        Compact compact = compactService.selectCompactById(compactId);
        mmap.put("compact", compact);
        return prefix + "/edit";
    }

    /**
     * 修改保存合同
     */
    @RequiresPermissions("crm:compact:edit")
    @Log(title = "合同", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Compact compact)
    {
        return toAjax(compactService.updateCompact(compact));
    }

    /**
     * 删除合同
     */
    @RequiresPermissions("crm:compact:remove")
    @Log(title = "合同", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(compactService.deleteCompactByIds(ids));
    }
}
