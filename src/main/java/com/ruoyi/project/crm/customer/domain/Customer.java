package com.ruoyi.project.crm.customer.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 客户(企业，组织或个人)对象 crm_customer
 * 
 * @author tqs
 * @date 2020-11-30
 */
public class Customer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户id */
    private Long cid;

    /** 用户_id */
    @Excel(name = "用户_id")
    private Long uid;

    /** name */
    @Excel(name = "name")
    private String name;

    /** 国家 */
    @Excel(name = "国家")
    private String country;

    /** 客户地址 */
    @Excel(name = "客户地址")
    private String address;

    /** url */
    @Excel(name = "url")
    private String url;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** phone */
    @Excel(name = "phone")
    private String phone;

    /** 传真 */
    @Excel(name = "传真")
    private String fax;

    /** 其它联系方式 */
    @Excel(name = "其它联系方式")
    private String other;

    /** 行业 */
    @Excel(name = "行业")
    private String industry;

    /** 年营业额 */
    @Excel(name = "年营业额")
    private String annualRevenue;

    /** 开户银行 */
    @Excel(name = "开户银行")
    private String bankOfDeposit;

    /** 银行帐号 */
    @Excel(name = "银行帐号")
    private String bankAccount;

    /** 最近跟进时间 */
    @Excel(name = "最近跟进时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastTime;

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
    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setFax(String fax) 
    {
        this.fax = fax;
    }

    public String getFax() 
    {
        return fax;
    }
    public void setOther(String other) 
    {
        this.other = other;
    }

    public String getOther() 
    {
        return other;
    }
    public void setIndustry(String industry) 
    {
        this.industry = industry;
    }

    public String getIndustry() 
    {
        return industry;
    }
    public void setAnnualRevenue(String annualRevenue) 
    {
        this.annualRevenue = annualRevenue;
    }

    public String getAnnualRevenue() 
    {
        return annualRevenue;
    }
    public void setBankOfDeposit(String bankOfDeposit) 
    {
        this.bankOfDeposit = bankOfDeposit;
    }

    public String getBankOfDeposit() 
    {
        return bankOfDeposit;
    }
    public void setBankAccount(String bankAccount) 
    {
        this.bankAccount = bankAccount;
    }

    public String getBankAccount() 
    {
        return bankAccount;
    }
    public void setLastTime(Date lastTime) 
    {
        this.lastTime = lastTime;
    }

    public Date getLastTime() 
    {
        return lastTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cid", getCid())
            .append("uid", getUid())
            .append("name", getName())
            .append("country", getCountry())
            .append("address", getAddress())
            .append("url", getUrl())
            .append("email", getEmail())
            .append("phone", getPhone())
            .append("fax", getFax())
            .append("other", getOther())
            .append("industry", getIndustry())
            .append("annualRevenue", getAnnualRevenue())
            .append("bankOfDeposit", getBankOfDeposit())
            .append("bankAccount", getBankAccount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("lastTime", getLastTime())
            .toString();
    }
}
