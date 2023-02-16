package com.ruoyi.project.crm.records.service;

import java.util.List;
import com.ruoyi.project.crm.records.domain.FollowUpRecords;

/**
 * 跟进记录Service接口
 * 
 * @author tqs
 * @date 2020-11-30
 */
public interface IFollowUpRecordsService 
{
    /**
     * 查询跟进记录
     * 
     * @param recordsId 跟进记录ID
     * @return 跟进记录
     */
    public FollowUpRecords selectFollowUpRecordsById(Long recordsId);

    /**
     * 查询跟进记录列表
     * 
     * @param followUpRecords 跟进记录
     * @return 跟进记录集合
     */
    public List<FollowUpRecords> selectFollowUpRecordsList(FollowUpRecords followUpRecords);

    /**
     * 新增跟进记录
     * 
     * @param followUpRecords 跟进记录
     * @return 结果
     */
    public int insertFollowUpRecords(FollowUpRecords followUpRecords);

    /**
     * 修改跟进记录
     * 
     * @param followUpRecords 跟进记录
     * @return 结果
     */
    public int updateFollowUpRecords(FollowUpRecords followUpRecords);

    /**
     * 批量删除跟进记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFollowUpRecordsByIds(String ids);

    /**
     * 删除跟进记录信息
     * 
     * @param recordsId 跟进记录ID
     * @return 结果
     */
    public int deleteFollowUpRecordsById(Long recordsId);
}
