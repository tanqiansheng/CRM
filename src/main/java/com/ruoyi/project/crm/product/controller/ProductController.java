package com.ruoyi.project.crm.product.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.crm.compact.domain.Compact;
import com.ruoyi.project.crm.compact.service.ICompactService;
import com.ruoyi.project.crm.product.domain.Product;
import com.ruoyi.project.crm.product.service.IProductService;
import com.ruoyi.project.crm.type.domain.ProductType;
import com.ruoyi.project.crm.type.service.IProductTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 产品Controller
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Controller
@RequestMapping("/crm/product")
public class ProductController extends BaseController
{
    private String prefix = "crm/product";

    @Autowired
    private IProductService productService;
    @Autowired
    private IProductTypeService productTypeService;
    @Autowired
    private ICompactService compactService;

    @RequiresPermissions("crm:product:view")
    @GetMapping()
    public String product()
    {
        return prefix + "/product";
    }

    /**
     * 查询产品列表
     */
    @RequiresPermissions("crm:product:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Product product , ModelMap mmap , HttpServletRequest request)
    {
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("typeList",productTypeService.selectProductTypeList(new ProductType()));
        servletContext.setAttribute("compactList",compactService.selectCompactList(new Compact()));
        startPage();
        List<Product> list = productService.selectProductList(product);
        return getDataTable(list);
    }

    /**
     * 导出产品列表
     */
    @RequiresPermissions("crm:product:export")
    @Log(title = "产品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Product product)
    {
        List<Product> list = productService.selectProductList(product);
        ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
        return util.exportExcel(list, "product");
    }

    /**
     * 新增产品
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产品
     */
    @RequiresPermissions("crm:product:add")
    @Log(title = "产品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Product product)
    {
        return toAjax(productService.insertProduct(product));
    }

    /**
     * 修改产品
     */
    @GetMapping("/edit/{productId}")
    public String edit(@PathVariable("productId") Long productId, ModelMap mmap)
    {
        Product product = productService.selectProductById(productId);
        mmap.put("product", product);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品
     */
    @RequiresPermissions("crm:product:edit")
    @Log(title = "产品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Product product)
    {
        return toAjax(productService.updateProduct(product));
    }

    /**
     * 删除产品
     */
    @RequiresPermissions("crm:product:remove")
    @Log(title = "产品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(productService.deleteProductByIds(ids));
    }
}
