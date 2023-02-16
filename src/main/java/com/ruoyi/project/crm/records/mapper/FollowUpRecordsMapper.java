package com.ruoyi.project.crm.records.mapper;

import com.ruoyi.project.crm.records.domain.FollowUpRecords;

import java.util.List;

/**
 * 跟进记录Mapper接口
 * 
 * @author tqs
 * @date 2020-11-30
 */
public interface FollowUpRecordsMapper 
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
     * 删除跟进记录
     * 
     * @param recordsId 跟进记录ID
     * @return 结果
     */
    public int deleteFollowUpRecordsById(Long recordsId);

    /**
     * 批量删除跟进记录
     * 
     * @param recordsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteFollowUpRecordsByIds(String[] recordsIds);

    public int deleteFollowUpRecordsByBus(Long recordsId);

    public int deleteFollowUpRecordsByCust(Long cid);


}
