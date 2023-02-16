package com.ruoyi.project.crm.fucntion.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 功能操作对象 crm_fucntion
 * 
 * @author tqs
 * @date 2020-11-30
 */
public class Fucntion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 功能id */
    private Long fucntionId;

    /** name */
    @Excel(name = "name")
    private String name;

    /** url */
    @Excel(name = "url")
    private String url;

    public void setFucntionId(Long fucntionId) 
    {
        this.fucntionId = fucntionId;
    }

    public Long getFucntionId() 
    {
        return fucntionId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fucntionId", getFucntionId())
            .append("name", getName())
            .append("url", getUrl())
            .toString();
    }
}
