package com.ruoyi.project.crm.product.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 产品对象 crm_product
 * 
 * @author tqs
 * @date 2020-11-30
 */
public class Product extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品ID */
    private Long productId;

    /** 合同ID */
    @Excel(name = "合同ID")
    private Long compactId;

    /** 产品类型ID */
    @Excel(name = "产品类型ID")
    private Long productTypeId;

    /** 产品SN */
    @Excel(name = "产品SN")
    private String sn;

    /** 生产日期 */
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date productDate;

    /** 出厂日期 */
    @Excel(name = "出厂日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date productionDate;

    /** 备注 */
    @Excel(name = "备注")
    private String comment;

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setCompactId(Long compactId) 
    {
        this.compactId = compactId;
    }

    public Long getCompactId() 
    {
        return compactId;
    }
    public void setProductTypeId(Long productTypeId) 
    {
        this.productTypeId = productTypeId;
    }

    public Long getProductTypeId() 
    {
        return productTypeId;
    }
    public void setSn(String sn) 
    {
        this.sn = sn;
    }

    public String getSn() 
    {
        return sn;
    }
    public void setProductDate(Date productDate) 
    {
        this.productDate = productDate;
    }

    public Date getProductDate() 
    {
        return productDate;
    }
    public void setProductionDate(Date productionDate) 
    {
        this.productionDate = productionDate;
    }

    public Date getProductionDate() 
    {
        return productionDate;
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("compactId", getCompactId())
            .append("productTypeId", getProductTypeId())
            .append("sn", getSn())
            .append("productDate", getProductDate())
            .append("productionDate", getProductionDate())
            .append("comment", getComment())
            .toString();
    }
}
