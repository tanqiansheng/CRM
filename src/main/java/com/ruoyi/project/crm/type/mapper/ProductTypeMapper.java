package com.ruoyi.project.crm.type.mapper;

import com.ruoyi.project.crm.type.domain.ProductType;

import java.util.List;

/**
 * 产品类型Mapper接口
 * 
 * @author tqs
 * @date 2020-11-30
 */
public interface ProductTypeMapper 
{
    /**
     * 查询产品类型
     * 
     * @param productTypeId 产品类型ID
     * @return 产品类型
     */
    public ProductType selectProductTypeById(Long productTypeId);

    /**
     * 查询产品类型列表
     * 
     * @param productType 产品类型
     * @return 产品类型集合
     */
    public List<ProductType> selectProductTypeList(ProductType productType);

    /**
     * 新增产品类型
     * 
     * @param productType 产品类型
     * @return 结果
     */
    public int insertProductType(ProductType productType);

    /**
     * 修改产品类型
     * 
     * @param productType 产品类型
     * @return 结果
     */
    public int updateProductType(ProductType productType);

    /**
     * 删除产品类型
     * 
     * @param productTypeId 产品类型ID
     * @return 结果
     */
    public int deleteProductTypeById(Long productTypeId);

    /**
     * 批量删除产品类型
     * 
     * @param productTypeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductTypeByIds(String[] productTypeIds);

}
