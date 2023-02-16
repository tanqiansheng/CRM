package com.ruoyi.project.crm.compact.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.crm.compact.domain.Compact;
import com.ruoyi.project.crm.compact.mapper.CompactMapper;
import com.ruoyi.project.crm.compact.service.ICompactService;
import com.ruoyi.project.crm.info.mapper.BusinessInfoMapper;
import com.ruoyi.project.crm.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 合同Service业务层处理
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Service
public class CompactServiceImpl implements ICompactService 
{
    @Autowired
    private CompactMapper compactMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private BusinessInfoMapper businessInfoMapper;

    /**
     * 查询合同
     * 
     * @param compactId 合同ID
     * @return 合同
     */
    @Override
    public Compact selectCompactById(Long compactId)
    {
        return compactMapper.selectCompactById(compactId);
    }

    /**
     * 查询合同列表
     * 
     * @param compact 合同
     * @return 合同
     */
    @Override
    public List<Compact> selectCompactList(Compact compact)
    {
        return compactMapper.selectCompactList(compact);
    }

    /**
     * 新增合同
     * 
     * @param compact 合同
     * @return 结果
     */
    @Override
    public int insertCompact(Compact compact)
    {
        int i ;
        try {
            i= compactMapper.insertCompact(compact);
        } catch (Exception e) {
            return 0;
        }
        return i;
    }

    /**
     * 修改合同
     * 
     * @param compact 合同
     * @return 结果
     */
    @Override
    public int updateCompact(Compact compact)
    {
        int i ;
        try {
            i= compactMapper.updateCompact(compact);
        } catch (Exception e) {
            return 0;
        }
        return i;
    }

    /**
     * 删除合同对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCompactByIds(String ids)
    {
        Long[] cids = Convert.toLongArray(ids);
        for (int i = 0; i <cids.length ; i++) {productMapper.deleteProductByCompa(cids[i]);

        }
        return compactMapper.deleteCompactByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除合同信息
     * 
     * @param compactId 合同ID
     * @return 结果
     */
    @Override
    public int deleteCompactById(Long compactId)
    {
        return compactMapper.deleteCompactById(compactId);
    }
}
