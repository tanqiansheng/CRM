package com.ruoyi.project.crm.contacts.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 联系人对象 crm_contacts
 * 
 * @author tqs
 * @date 2020-11-30
 */
public class Contacts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 联系人ID */
    private Long contactsId;

    /** 客户id */
    @Excel(name = "客户id")
    private Long cid;

    /** 商业ID */
    @Excel(name = "商业ID")
    private Long busId;

    /** 联系人姓名 */
    @Excel(name = "联系人姓名")
    private String name;

    /** 生日 */
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 联系人岗位 */
    @Excel(name = "联系人岗位")
    private String post;

    /** 联系人部门 */
    @Excel(name = "联系人部门")
    private String department;

    /** 联系人性别 */
    @Excel(name = "联系人性别")
    private String sex;

    /** 联系人称呼 */
    @Excel(name = "联系人称呼")
    private String saltName;

    /** 移动电话1 */
    @Excel(name = "移动电话1")
    private String mobilePhone1;

    /** 移动电话2 */
    @Excel(name = "移动电话2")
    private String mobilePhone2;

    /** 办公电话 */
    @Excel(name = "办公电话")
    private String workPhone;

    /** 微信 */
    @Excel(name = "微信")
    private String wx;

    /** qq */
    @Excel(name = "qq")
    private String qq;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 邮编 */
    @Excel(name = "邮编")
    private String zipCode;

    /** 联系人信息备注 */
    @Excel(name = "联系人信息备注")
    private String description;

    public void setContactsId(Long contactsId) 
    {
        this.contactsId = contactsId;
    }

    public Long getContactsId() 
    {
        return contactsId;
    }
    public void setCid(Long cid) 
    {
        this.cid = cid;
    }

    public Long getCid() 
    {
        return cid;
    }
    public void setBusId(Long busId) 
    {
        this.busId = busId;
    }

    public Long getBusId() 
    {
        return busId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setPost(String post) 
    {
        this.post = post;
    }

    public String getPost() 
    {
        return post;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setSaltName(String saltName) 
    {
        this.saltName = saltName;
    }

    public String getSaltName() 
    {
        return saltName;
    }
    public void setMobilePhone1(String mobilePhone1) 
    {
        this.mobilePhone1 = mobilePhone1;
    }

    public String getMobilePhone1() 
    {
        return mobilePhone1;
    }
    public void setMobilePhone2(String mobilePhone2) 
    {
        this.mobilePhone2 = mobilePhone2;
    }

    public String getMobilePhone2() 
    {
        return mobilePhone2;
    }
    public void setWorkPhone(String workPhone) 
    {
        this.workPhone = workPhone;
    }

    public String getWorkPhone() 
    {
        return workPhone;
    }
    public void setWx(String wx) 
    {
        this.wx = wx;
    }

    public String getWx() 
    {
        return wx;
    }
    public void setQq(String qq) 
    {
        this.qq = qq;
    }

    public String getQq() 
    {
        return qq;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setZipCode(String zipCode) 
    {
        this.zipCode = zipCode;
    }

    public String getZipCode() 
    {
        return zipCode;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("contactsId", getContactsId())
            .append("cid", getCid())
            .append("busId", getBusId())
            .append("name", getName())
            .append("birthday", getBirthday())
            .append("post", getPost())
            .append("department", getDepartment())
            .append("sex", getSex())
            .append("saltName", getSaltName())
            .append("mobilePhone1", getMobilePhone1())
            .append("mobilePhone2", getMobilePhone2())
            .append("workPhone", getWorkPhone())
            .append("wx", getWx())
            .append("qq", getQq())
            .append("email", getEmail())
            .append("address", getAddress())
            .append("zipCode", getZipCode())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("description", getDescription())
            .toString();
    }
}
