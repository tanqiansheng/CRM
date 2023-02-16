package com.ruoyi.project.crm.type.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 产品类型对象 crm_product_type
 * 
 * @author tqs
 * @date 2020-11-30
 */
public class ProductType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品类型ID */
    private Long productTypeId;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String name;

    /** 产品系列 */
    @Excel(name = "产品系列")
    private String prodType;

    /** 产品特性 */
    @Excel(name = "产品特性")
    private String productFeature;

    public void setProductTypeId(Long productTypeId) 
    {
        this.productTypeId = productTypeId;
    }

    public Long getProductTypeId() 
    {
        return productTypeId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setProdType(String prodType) 
    {
        this.prodType = prodType;
    }

    public String getProdType() 
    {
        return prodType;
    }
    public void setProductFeature(String productFeature) 
    {
        this.productFeature = productFeature;
    }

    public String getProductFeature() 
    {
        return productFeature;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productTypeId", getProductTypeId())
            .append("name", getName())
            .append("prodType", getProdType())
            .append("productFeature", getProductFeature())
            .toString();
    }
}
