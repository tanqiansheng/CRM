package com.ruoyi.project.employment.slideshow.controller;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.employment.slideshow.domain.Slideshow;
import com.ruoyi.project.employment.slideshow.service.ISlideshowService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 轮播图Controller
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Controller
@RequestMapping("/employment/slideshow")
public class SlideshowController extends BaseController
{
    private String prefix = "employment/slideshow";

    @Autowired
    private ISlideshowService slideshowService;
    @Autowired
    private ServerConfig serverConfig;

    @RequiresPermissions("employment:slideshow:view")
    @GetMapping()
    public String slideshow()
    {
        return prefix + "/slideshow";
    }

    /**
     * 查询轮播图列表
     */
    @RequiresPermissions("employment:slideshow:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Slideshow slideshow)
    {
        startPage();
        List<Slideshow> list = slideshowService.selectSlideshowList(slideshow);
        return getDataTable(list);
    }

    /**
     * 导出轮播图列表
     */
    @RequiresPermissions("employment:slideshow:export")
    @Log(title = "轮播图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Slideshow slideshow)
    {
        List<Slideshow> list = slideshowService.selectSlideshowList(slideshow);
        ExcelUtil<Slideshow> util = new ExcelUtil<Slideshow>(Slideshow.class);
        return util.exportExcel(list, "slideshow");
    }

    /**
     * 新增轮播图
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存轮播图
     */
    @RequiresPermissions("employment:slideshow:add")
    @Log(title = "轮播图", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file) throws Exception
    {
     /*   HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String filePath = request.getServletContext().getRealPath("/img/slideshow_img");*/
       // String filePath = ResourceUtils.getURL("static/img").getPath();
        String filePath = ResourceUtils.getURL("classpath:").getPath()+"static/img/slideshow_img";

        try
        {
            // 上传文件路径
            /*String filePath = RuoYiConfig.getUploadPath();*/
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);

            System.out.println(fileName);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 修改轮播图
     */
    @GetMapping("/edit/{fileId}")
    public String edit(@PathVariable("fileId") Long fileId, ModelMap mmap)
    {
        Slideshow slideshow = slideshowService.selectSlideshowById(fileId);
        mmap.put("slideshow", slideshow);
        return prefix + "/edit";
    }

    /**
     * 修改保存轮播图
     */
    @RequiresPermissions("employment:slideshow:edit")
    @Log(title = "轮播图", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Slideshow slideshow)
    {
        return toAjax(slideshowService.updateSlideshow(slideshow));
    }

    /**
     * 删除轮播图
     */
    @RequiresPermissions("employment:slideshow:remove")
    @Log(title = "轮播图", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(slideshowService.deleteSlideshowByIds(ids));
    }
}
