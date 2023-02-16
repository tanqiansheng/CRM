package com.ruoyi.project.crm.records.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.crm.info.domain.BusinessInfo;
import com.ruoyi.project.crm.info.service.IBusinessInfoService;
import com.ruoyi.project.crm.records.domain.FollowUpRecords;
import com.ruoyi.project.crm.records.service.IFollowUpRecordsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 跟进记录Controller
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Controller
@RequestMapping("/crm/records")
public class FollowUpRecordsController extends BaseController
{
    private String prefix = "crm/records";

    @Autowired
    private IFollowUpRecordsService followUpRecordsService;
    @Autowired
    private IBusinessInfoService businessInfoService;

    @RequiresPermissions("crm:records:view")
    @GetMapping()
    public String records()
    {
        return prefix + "/records";
    }

    /**
     * 查询跟进记录列表
     */
    @RequiresPermissions("crm:records:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FollowUpRecords followUpRecords ,HttpServletRequest request)
    {
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("BusinessInfoList", businessInfoService.selectBusinessInfoList(new BusinessInfo()));
        startPage();
        List<FollowUpRecords> list = followUpRecordsService.selectFollowUpRecordsList(followUpRecords);
        return getDataTable(list);
    }

    /**
     * 导出跟进记录列表
     */
    @RequiresPermissions("crm:records:export")
    @Log(title = "跟进记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FollowUpRecords followUpRecords)
    {
        List<FollowUpRecords> list = followUpRecordsService.selectFollowUpRecordsList(followUpRecords);
        ExcelUtil<FollowUpRecords> util = new ExcelUtil<FollowUpRecords>(FollowUpRecords.class);
        return util.exportExcel(list, "records");
    }

    /**
     * 新增跟进记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存跟进记录
     */
    @RequiresPermissions("crm:records:add")
    @Log(title = "跟进记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FollowUpRecords followUpRecords)
    {
        return toAjax(followUpRecordsService.insertFollowUpRecords(followUpRecords));
    }

    /**
     * 修改跟进记录
     */
    @GetMapping("/edit/{recordsId}")
    public String edit(@PathVariable("recordsId") Long recordsId, ModelMap mmap)
    {
        FollowUpRecords followUpRecords = followUpRecordsService.selectFollowUpRecordsById(recordsId);
        mmap.put("followUpRecords", followUpRecords);
        return prefix + "/edit";
    }

    /**
     * 修改保存跟进记录
     */
    @RequiresPermissions("crm:records:edit")
    @Log(title = "跟进记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FollowUpRecords followUpRecords)
    {
        return toAjax(followUpRecordsService.updateFollowUpRecords(followUpRecords));
    }

    /**
     * 删除跟进记录
     */
    @RequiresPermissions("crm:records:remove")
    @Log(title = "跟进记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(followUpRecordsService.deleteFollowUpRecordsByIds(ids));
    }
}
