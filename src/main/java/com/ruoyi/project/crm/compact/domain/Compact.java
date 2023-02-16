package com.ruoyi.project.crm.compact.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 合同对象 crm_compact
 * 
 * @author tqs
 * @date 2020-11-30
 */
public class Compact extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同ID */
    private Long compactId;

    /** 客户_id */
    @Excel(name = "客户_id")
    private Long customerId;

    /** 商业ID */
    @Excel(name = "商业ID")
    private Long busId;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private Long compact;

    /** 合同时间 */
    @Excel(name = "合同时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date compactTime;

    /** 甲方 */
    @Excel(name = "甲方")
    private String partyA;

    /** 乙方 */
    @Excel(name = "乙方")
    private String partyB;

    /** 合同内容 */
    @Excel(name = "合同内容")
    private String text;

    public void setCompactId(Long compactId) 
    {
        this.compactId = compactId;
    }

    public Long getCompactId() 
    {
        return compactId;
    }
    public void setCustomerId(Long customerId) 
    {
        this.customerId = customerId;
    }

    public Long getCustomerId() 
    {
        return customerId;
    }
    public void setBusId(Long busId) 
    {
        this.busId = busId;
    }

    public Long getBusId() 
    {
        return busId;
    }
    public void setCompact(Long compact) 
    {
        this.compact = compact;
    }

    public Long getCompact() 
    {
        return compact;
    }
    public void setCompactTime(Date compactTime) 
    {
        this.compactTime = compactTime;
    }

    public Date getCompactTime() 
    {
        return compactTime;
    }
    public void setPartyA(String partyA) 
    {
        this.partyA = partyA;
    }

    public String getPartyA() 
    {
        return partyA;
    }
    public void setPartyB(String partyB) 
    {
        this.partyB = partyB;
    }

    public String getPartyB() 
    {
        return partyB;
    }
    public void setText(String text) 
    {
        this.text = text;
    }

    public String getText() 
    {
        return text;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("compactId", getCompactId())
            .append("customerId", getCustomerId())
            .append("busId", getBusId())
            .append("compact", getCompact())
            .append("compactTime", getCompactTime())
            .append("partyA", getPartyA())
            .append("partyB", getPartyB())
            .append("text", getText())
            .toString();
    }
}
