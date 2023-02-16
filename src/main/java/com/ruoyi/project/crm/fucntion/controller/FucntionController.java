package com.ruoyi.project.crm.fucntion.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.crm.fucntion.domain.Fucntion;
import com.ruoyi.project.crm.fucntion.service.IFucntionService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 功能操作Controller
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Controller
@RequestMapping("/crm/fucntion")
public class FucntionController extends BaseController
{
    private String prefix = "crm/fucntion";

    @Autowired
    private IFucntionService fucntionService;

    @RequiresPermissions("crm:fucntion:view")
    @GetMapping()
    public String fucntion()
    {
        return prefix + "/fucntion";
    }

    /**
     * 查询功能操作列表
     */
    @RequiresPermissions("crm:fucntion:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Fucntion fucntion)
    {
        startPage();
        List<Fucntion> list = fucntionService.selectFucntionList(fucntion);
        return getDataTable(list);
    }

    /**
     * 导出功能操作列表
     */
    @RequiresPermissions("crm:fucntion:export")
    @Log(title = "功能操作", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fucntion fucntion)
    {
        List<Fucntion> list = fucntionService.selectFucntionList(fucntion);
        ExcelUtil<Fucntion> util = new ExcelUtil<Fucntion>(Fucntion.class);
        return util.exportExcel(list, "fucntion");
    }

    /**
     * 新增功能操作
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存功能操作
     */
    @RequiresPermissions("crm:fucntion:add")
    @Log(title = "功能操作", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Fucntion fucntion)
    {
        return toAjax(fucntionService.insertFucntion(fucntion));
    }

    /**
     * 修改功能操作
     */
    @GetMapping("/edit/{fucntionId}")
    public String edit(@PathVariable("fucntionId") Long fucntionId, ModelMap mmap)
    {
        Fucntion fucntion = fucntionService.selectFucntionById(fucntionId);
        mmap.put("fucntion", fucntion);
        return prefix + "/edit";
    }

    /**
     * 修改保存功能操作
     */
    @RequiresPermissions("crm:fucntion:edit")
    @Log(title = "功能操作", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Fucntion fucntion)
    {
        return toAjax(fucntionService.updateFucntion(fucntion));
    }

    /**
     * 删除功能操作
     */
    @RequiresPermissions("crm:fucntion:remove")
    @Log(title = "功能操作", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fucntionService.deleteFucntionByIds(ids));
    }
}
