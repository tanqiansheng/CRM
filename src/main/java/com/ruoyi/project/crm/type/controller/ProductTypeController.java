package com.ruoyi.project.crm.type.controller;

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
import com.ruoyi.project.crm.type.domain.ProductType;
import com.ruoyi.project.crm.type.service.IProductTypeService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 产品类型Controller
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Controller
@RequestMapping("/crm/type")
public class ProductTypeController extends BaseController
{
    private String prefix = "crm/type";

    @Autowired
    private IProductTypeService productTypeService;

    @RequiresPermissions("crm:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询产品类型列表
     */
    @RequiresPermissions("crm:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProductType productType)
    {
        startPage();
        List<ProductType> list = productTypeService.selectProductTypeList(productType);
        return getDataTable(list);
    }

    /**
     * 导出产品类型列表
     */
    @RequiresPermissions("crm:type:export")
    @Log(title = "产品类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProductType productType)
    {
        List<ProductType> list = productTypeService.selectProductTypeList(productType);
        ExcelUtil<ProductType> util = new ExcelUtil<ProductType>(ProductType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增产品类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产品类型
     */
    @RequiresPermissions("crm:type:add")
    @Log(title = "产品类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProductType productType)
    {
        return toAjax(productTypeService.insertProductType(productType));
    }

    /**
     * 修改产品类型
     */
    @GetMapping("/edit/{productTypeId}")
    public String edit(@PathVariable("productTypeId") Long productTypeId, ModelMap mmap)
    {
        ProductType productType = productTypeService.selectProductTypeById(productTypeId);
        mmap.put("productType", productType);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品类型
     */
    @RequiresPermissions("crm:type:edit")
    @Log(title = "产品类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProductType productType)
    {
        return toAjax(productTypeService.updateProductType(productType));
    }

    /**
     * 删除产品类型
     */
    @RequiresPermissions("crm:type:remove")
    @Log(title = "产品类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(productTypeService.deleteProductTypeByIds(ids));
    }
}
