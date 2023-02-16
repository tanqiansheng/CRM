package com.ruoyi.project.crm.compact.mapper;

import com.ruoyi.project.crm.compact.domain.Compact;

import java.util.List;

/**
 * 合同Mapper接口
 * 
 * @author tqs
 * @date 2020-11-30
 */
public interface CompactMapper 
{
    /**
     * 查询合同
     * 
     * @param compactId 合同ID
     * @return 合同
     */
    public Compact selectCompactById(Long compactId);

    /**
     * 查询合同列表
     * 
     * @param compact 合同
     * @return 合同集合
     */
    public List<Compact> selectCompactList(Compact compact);

    /**
     * 新增合同
     * 
     * @param compact 合同
     * @return 结果
     */
    public int insertCompact(Compact compact);

    /**
     * 修改合同
     * 
     * @param compact 合同
     * @return 结果
     */
    public int updateCompact(Compact compact);

    /**
     * 删除合同
     * 
     * @param compactId 合同ID
     * @return 结果
     */
    public int deleteCompactById(Long compactId);

    /**
     * 批量删除合同
     * 
     * @param compactIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCompactByIds(String[] compactIds);


    public int deleteCompactByCus(Long customer_id);

    public int deleteCompactByBus(Long bus_id);

    public int deleteCompactByCust(Long cid);



}
