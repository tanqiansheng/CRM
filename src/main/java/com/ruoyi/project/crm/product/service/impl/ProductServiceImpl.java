package com.ruoyi.project.crm.product.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.crm.product.domain.Product;
import com.ruoyi.project.crm.product.mapper.ProductMapper;
import com.ruoyi.project.crm.product.service.IProductService;
import com.ruoyi.project.crm.type.mapper.ProductTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品Service业务层处理
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Service
public class ProductServiceImpl implements IProductService 
{
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductTypeMapper productTypeMapper;

    /**
     * 查询产品
     * 
     * @param productId 产品ID
     * @return 产品
     */
    @Override
    public Product selectProductById(Long productId)
    {
        return productMapper.selectProductById(productId);
    }

    /**
     * 查询产品列表
     * 
     * @param product 产品
     * @return 产品
     */
    @Override
    public List<Product> selectProductList(Product product)
    {
        return productMapper.selectProductList(product);
    }

    /**
     * 新增产品
     * 
     * @param product 产品
     * @return 结果
     */
    @Override
    public int insertProduct(Product product)throws RuntimeException
    {
        int i ;
        try {
            i= productMapper.insertProduct(product);
        } catch (Exception e) {
            return 0;
        }
        return i;
    }

    /**
     * 修改产品
     * 
     * @param product 产品
     * @return 结果
     */
    @Override
    public int updateProduct(Product product)
    {
        int i ;
        try {
            i= productMapper.updateProduct(product);
        } catch (Exception e) {
            return 0;
        }
        return i;

    }

    /**
     * 删除产品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProductByIds(String ids)
    {
        return productMapper.deleteProductByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品信息
     * 
     * @param productId 产品ID
     * @return 结果
     */
    @Override
    public int deleteProductById(Long productId)
    {
        return productMapper.deleteProductById(productId);
    }
}
