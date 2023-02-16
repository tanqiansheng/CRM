package com.ruoyi.project.crm.type.service;

import java.util.List;
import com.ruoyi.project.crm.type.domain.ProductType;

/**
 * 产品类型Service接口
 * 
 * @author tqs
 * @date 2020-11-30
 */
public interface IProductTypeService 
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
     * 批量删除产品类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductTypeByIds(String ids);

    /**
     * 删除产品类型信息
     * 
     * @param productTypeId 产品类型ID
     * @return 结果
     */
    public int deleteProductTypeById(Long productTypeId);
}
