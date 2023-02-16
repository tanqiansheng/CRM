package com.ruoyi.project.crm.type.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.crm.product.mapper.ProductMapper;
import com.ruoyi.project.crm.type.domain.ProductType;
import com.ruoyi.project.crm.type.mapper.ProductTypeMapper;
import com.ruoyi.project.crm.type.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品类型Service业务层处理
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Service
public class ProductTypeServiceImpl implements IProductTypeService 
{
    @Autowired
    private ProductTypeMapper productTypeMapper;
    @Autowired
    private ProductMapper productMapper;
    /**
     * 查询产品类型
     * 
     * @param productTypeId 产品类型ID
     * @return 产品类型
     */
    @Override
    public ProductType selectProductTypeById(Long productTypeId)
    {
        return productTypeMapper.selectProductTypeById(productTypeId);
    }

    /**
     * 查询产品类型列表
     * 
     * @param productType 产品类型
     * @return 产品类型
     */
    @Override
    public List<ProductType> selectProductTypeList(ProductType productType)
    {
        return productTypeMapper.selectProductTypeList(productType);
    }

    /**
     * 新增产品类型
     * 
     * @param productType 产品类型
     * @return 结果
     */
    @Override
    public int insertProductType(ProductType productType)
    {
        return productTypeMapper.insertProductType(productType);
    }

    /**
     * 修改产品类型
     * 
     * @param productType 产品类型
     * @return 结果
     */
    @Override
    public int updateProductType(ProductType productType)
    {
        return productTypeMapper.updateProductType(productType);
    }

    /**
     * 删除产品类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProductTypeByIds(String ids)
    {
        Long[] cids = Convert.toLongArray(ids);
        for (int i = 0; i <cids.length ; i++) {
        productMapper.deleteProductByType(cids[i]);
    }
        return productTypeMapper.deleteProductTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品类型信息
     * 
     * @param productTypeId 产品类型ID
     * @return 结果
     */
    @Override
    public int deleteProductTypeById(Long productTypeId)
    {
        return productTypeMapper.deleteProductTypeById(productTypeId);
    }
}
