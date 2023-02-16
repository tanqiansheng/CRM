package com.ruoyi.project.crm.product.mapper;

import com.ruoyi.project.crm.product.domain.Product;

import java.util.List;

/**
 * 产品Mapper接口
 * 
 * @author tqs
 * @date 2020-11-30
 */
public interface ProductMapper 
{
    /**
     * 查询产品
     * 
     * @param productId 产品ID
     * @return 产品
     */
    public Product selectProductById(Long productId);

    /**
     * 查询产品列表
     * 
     * @param product 产品
     * @return 产品集合
     */
    public List<Product> selectProductList(Product product);

    /**
     * 新增产品
     * 
     * @param product 产品
     * @return 结果
     */
    public int insertProduct(Product product);

    /**
     * 修改产品
     * 
     * @param product 产品
     * @return 结果
     */
    public int updateProduct(Product product);

    /**
     * 删除产品
     * 
     * @param productId 产品ID
     * @return 结果
     */
    public int deleteProductById(Long productId);

    /**
     * 批量删除产品
     * 
     * @param productIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductByIds(String[] productIds);

    public int   deleteProductByType(Long product_type_id);

    public int   deleteProductByCompa(Long compact_id);

    public int   deleteProductByCompaToProduct(Long bus_id);

    public int   deleteProductByCustToProduct(Long customer_id);



}
