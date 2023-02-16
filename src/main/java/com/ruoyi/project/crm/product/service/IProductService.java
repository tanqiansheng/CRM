package com.ruoyi.project.crm.product.service;

import java.util.List;
import com.ruoyi.project.crm.product.domain.Product;

/**
 * 产品Service接口
 * 
 * @author tqs
 * @date 2020-11-30
 */
public interface IProductService 
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
     * 批量删除产品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductByIds(String ids);

    /**
     * 删除产品信息
     * 
     * @param productId 产品ID
     * @return 结果
     */
    public int deleteProductById(Long productId);
}
