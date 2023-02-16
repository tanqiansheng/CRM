package com.ruoyi.project.crm.info.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.crm.compact.mapper.CompactMapper;
import com.ruoyi.project.crm.compact.service.ICompactService;
import com.ruoyi.project.crm.contacts.mapper.ContactsMapper;
import com.ruoyi.project.crm.info.domain.BusinessInfo;
import com.ruoyi.project.crm.info.mapper.BusinessInfoMapper;
import com.ruoyi.project.crm.info.service.IBusinessInfoService;
import com.ruoyi.project.crm.product.mapper.ProductMapper;
import com.ruoyi.project.crm.records.mapper.FollowUpRecordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商业信息Service业务层处理
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Service
public class BusinessInfoServiceImpl implements IBusinessInfoService 
{
    @Autowired
    private BusinessInfoMapper businessInfoMapper;
    @Autowired
    private CompactMapper compactMapper;
    @Autowired
    private FollowUpRecordsMapper followUpRecordsMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ContactsMapper contactsMapper;

    @Autowired
    private ICompactService compactService;

    /**
     * 查询商业信息
     * 
     * @param busId 商业信息ID
     * @return 商业信息
     */
    @Override
    public BusinessInfo selectBusinessInfoById(Long busId)
    {
        return businessInfoMapper.selectBusinessInfoById(busId);
    }

    /**
     * 查询商业信息列表
     * 
     * @param businessInfo 商业信息
     * @return 商业信息
     */
    @Override
    public List<BusinessInfo> selectBusinessInfoList(BusinessInfo businessInfo)
    {
        return businessInfoMapper.selectBusinessInfoList(businessInfo);
    }

    /**
     * 新增商业信息
     * 
     * @param businessInfo 商业信息
     * @return 结果
     */
    @Override
    public int insertBusinessInfo(BusinessInfo businessInfo)
    {
        int i ;
        try {
            i=  businessInfoMapper.insertBusinessInfo(businessInfo);
        } catch (Exception e) {
            return 0;
        }
        return i;
    }

    /**
     * 修改商业信息
     * 
     * @param businessInfo 商业信息
     * @return 结果
     */
    @Override
    public int updateBusinessInfo(BusinessInfo businessInfo)
    {
        int i ;
        try {
            i=  businessInfoMapper.updateBusinessInfo(businessInfo);
        } catch (Exception e) {
            return 0;
        }
        return i;
    }

    /**
     * 删除商业信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusinessInfoByIds(String ids)
    {

        Long[] cids = Convert.toLongArray(ids);
        for (int i = 0; i <cids.length ; i++) {
            productMapper.deleteProductByCompaToProduct(cids[i]);
            compactMapper.deleteCompactByBus(cids[i]);
            followUpRecordsMapper.deleteFollowUpRecordsByBus(cids[i]);
            contactsMapper.deleteContactsByInfo(cids[i]);
        }
        return businessInfoMapper.deleteBusinessInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商业信息信息
     * 
     * @param busId 商业信息ID
     * @return 结果
     */
    @Override
    public int deleteBusinessInfoById(Long busId)
    {
        return businessInfoMapper.deleteBusinessInfoById(busId);
    }
}
