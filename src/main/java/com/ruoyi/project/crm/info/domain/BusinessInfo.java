package com.ruoyi.project.crm.info.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 商业信息对象 crm_business_info
 * 
 * @author tqs
 * @date 2020-11-30
 */
public class BusinessInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商业信息ID */
    private Long busId;

    /** 客户id */
    @Excel(name = "客户id")
    private Long cid;

    /** 用户id */
    @Excel(name = "用户id")
    private Long uid;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 营销方式 */
    @Excel(name = "营销方式")
    private String marketingMode;

    /** 价值 */
    @Excel(name = "价值")
    private Long value;

    /** 产品总数 */
    @Excel(name = "产品总数")
    private Long totalAmount;

    /** 预计成交日期 */
    @Excel(name = "预计成交日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dueDate;

    /** 实际交付日期 */
    @Excel(name = "实际交付日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date practicalDate;

    /** 商机创建时间 */
    @Excel(name = "商机创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 修改时间 */
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /** 商业金额 */
    @Excel(name = "商业金额")
    private Long totalPrice;

    /** 备注 */
    @Excel(name = "备注")
    private String comment;

    public void setBusId(Long busId) 
    {
        this.busId = busId;
    }

    public Long getBusId() 
    {
        return busId;
    }
    public void setCid(Long cid) 
    {
        this.cid = cid;
    }

    public Long getCid() 
    {
        return cid;
    }
    public void setUid(Long uid) 
    {
        this.uid = uid;
    }

    public Long getUid() 
    {
        return uid;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setMarketingMode(String marketingMode) 
    {
        this.marketingMode = marketingMode;
    }

    public String getMarketingMode() 
    {
        return marketingMode;
    }
    public void setValue(Long value) 
    {
        this.value = value;
    }

    public Long getValue() 
    {
        return value;
    }
    public void setTotalAmount(Long totalAmount) 
    {
        this.totalAmount = totalAmount;
    }

    public Long getTotalAmount() 
    {
        return totalAmount;
    }
    public void setDueDate(Date dueDate) 
    {
        this.dueDate = dueDate;
    }

    public Date getDueDate() 
    {
        return dueDate;
    }
    public void setPracticalDate(Date practicalDate) 
    {
        this.practicalDate = practicalDate;
    }

    public Date getPracticalDate() 
    {
        return practicalDate;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }
    public void setTotalPrice(Long totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public Long getTotalPrice() 
    {
        return totalPrice;
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
            .append("busId", getBusId())
            .append("cid", getCid())
            .append("uid", getUid())
            .append("name", getName())
            .append("marketingMode", getMarketingMode())
            .append("value", getValue())
            .append("totalAmount", getTotalAmount())
            .append("dueDate", getDueDate())
            .append("practicalDate", getPracticalDate())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("totalPrice", getTotalPrice())
            .append("comment", getComment())
            .toString();
    }
}
