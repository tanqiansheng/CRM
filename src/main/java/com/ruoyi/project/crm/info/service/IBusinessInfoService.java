package com.ruoyi.project.crm.info.service;

import java.util.List;
import com.ruoyi.project.crm.info.domain.BusinessInfo;

/**
 * 商业信息Service接口
 * 
 * @author tqs
 * @date 2020-11-30
 */
public interface IBusinessInfoService 
{
    /**
     * 查询商业信息
     * 
     * @param busId 商业信息ID
     * @return 商业信息
     */
    public BusinessInfo selectBusinessInfoById(Long busId);

    /**
     * 查询商业信息列表
     * 
     * @param businessInfo 商业信息
     * @return 商业信息集合
     */
    public List<BusinessInfo> selectBusinessInfoList(BusinessInfo businessInfo);

    /**
     * 新增商业信息
     * 
     * @param businessInfo 商业信息
     * @return 结果
     */
    public int insertBusinessInfo(BusinessInfo businessInfo);

    /**
     * 修改商业信息
     * 
     * @param businessInfo 商业信息
     * @return 结果
     */
    public int updateBusinessInfo(BusinessInfo businessInfo);

    /**
     * 批量删除商业信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessInfoByIds(String ids);

    /**
     * 删除商业信息信息
     * 
     * @param busId 商业信息ID
     * @return 结果
     */
    public int deleteBusinessInfoById(Long busId);
}
