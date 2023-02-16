package com.ruoyi.project.crm.records.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 跟进记录对象 crm_follow_up_records
 * 
 * @author tqs
 * @date 2020-11-30
 */
public class FollowUpRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long recordsId;

    /** 商业信息ID */
    @Excel(name = "商业信息ID")
    private Long busId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long uid;

    /** 跟进方式 */
    @Excel(name = "跟进方式")
    private Integer method;

    /** 记录内容 */
    @Excel(name = "记录内容")
    private String content;

    /** 备注 */
    @Excel(name = "备注")
    private String comment;

    public void setRecordsId(Long recordsId) 
    {
        this.recordsId = recordsId;
    }

    public Long getRecordsId() 
    {
        return recordsId;
    }
    public void setBusId(Long busId) 
    {
        this.busId = busId;
    }

    public Long getBusId() 
    {
        return busId;
    }
    public void setUid(Long uid) 
    {
        this.uid = uid;
    }

    public Long getUid() 
    {
        return uid;
    }
    public void setMethod(Integer method) 
    {
        this.method = method;
    }

    public Integer getMethod() 
    {
        return method;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
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
            .append("recordsId", getRecordsId())
            .append("busId", getBusId())
            .append("uid", getUid())
            .append("method", getMethod())
            .append("createTime", getCreateTime())
            .append("content", getContent())
            .append("comment", getComment())
            .toString();
    }
}
