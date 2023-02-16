package com.ruoyi.project.crm.records.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.crm.records.domain.FollowUpRecords;
import com.ruoyi.project.crm.records.mapper.FollowUpRecordsMapper;
import com.ruoyi.project.crm.records.service.IFollowUpRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 跟进记录Service业务层处理
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Service
public class FollowUpRecordsServiceImpl implements IFollowUpRecordsService 
{
    @Autowired
    private FollowUpRecordsMapper followUpRecordsMapper;

    /**
     * 查询跟进记录
     * 
     * @param recordsId 跟进记录ID
     * @return 跟进记录
     */
    @Override
    public FollowUpRecords selectFollowUpRecordsById(Long recordsId)
    {
        return followUpRecordsMapper.selectFollowUpRecordsById(recordsId);
    }

    /**
     * 查询跟进记录列表
     * 
     * @param followUpRecords 跟进记录
     * @return 跟进记录
     */
    @Override
    public List<FollowUpRecords> selectFollowUpRecordsList(FollowUpRecords followUpRecords)
    {
        return followUpRecordsMapper.selectFollowUpRecordsList(followUpRecords);
    }

    /**
     * 新增跟进记录
     * 
     * @param followUpRecords 跟进记录
     * @return 结果
     */
    @Override
    public int insertFollowUpRecords(FollowUpRecords followUpRecords)
    {
        followUpRecords.setCreateTime(DateUtils.getNowDate());
        int i ;
        try {
            i= followUpRecordsMapper.insertFollowUpRecords(followUpRecords);
        } catch (Exception e) {
            return 0;
        }
        return i;
    }



    /**
     * 修改跟进记录
     * 
     * @param followUpRecords 跟进记录
     * @return 结果
     */
    @Override
    public int updateFollowUpRecords(FollowUpRecords followUpRecords)
    {
        int i ;
        try {
            i=  followUpRecordsMapper.updateFollowUpRecords(followUpRecords);
        } catch (Exception e) {
            return 0;
        }
        return i;
    }

    /**
     * 删除跟进记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFollowUpRecordsByIds(String ids)
    {
        return followUpRecordsMapper.deleteFollowUpRecordsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除跟进记录信息
     * 
     * @param recordsId 跟进记录ID
     * @return 结果
     */
    @Override
    public int deleteFollowUpRecordsById(Long recordsId)
    {
        return followUpRecordsMapper.deleteFollowUpRecordsById(recordsId);
    }
}
