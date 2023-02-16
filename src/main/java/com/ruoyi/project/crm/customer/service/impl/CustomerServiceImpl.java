package com.ruoyi.project.crm.customer.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.crm.compact.mapper.CompactMapper;
import com.ruoyi.project.crm.contacts.mapper.ContactsMapper;
import com.ruoyi.project.crm.customer.domain.Customer;
import com.ruoyi.project.crm.customer.mapper.CustomerMapper;
import com.ruoyi.project.crm.customer.service.ICustomerService;
import com.ruoyi.project.crm.info.mapper.BusinessInfoMapper;
import com.ruoyi.project.crm.product.mapper.ProductMapper;
import com.ruoyi.project.crm.records.mapper.FollowUpRecordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户(企业，组织或个人)Service业务层处理
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Service
public class CustomerServiceImpl implements ICustomerService 
{
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CompactMapper compactMapper;
    @Autowired
    private BusinessInfoMapper businessInfoMapper;
    @Autowired
    private FollowUpRecordsMapper followUpRecordsMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ContactsMapper contactsMapper;


    /**
     * 查询客户(企业，组织或个人)
     * 
     * @param cid 客户(企业，组织或个人)ID
     * @return 客户(企业，组织或个人)
     */
    @Override
    public Customer selectCustomerById(Long cid)
    {
        return customerMapper.selectCustomerById(cid);
    }

    /**
     * 查询客户(企业，组织或个人)列表
     * 
     * @param customer 客户(企业，组织或个人)
     * @return 客户(企业，组织或个人)
     */
    @Override
    public List<Customer> selectCustomerList(Customer customer)
    {
        return customerMapper.selectCustomerList(customer);
    }

    /**
     * 新增客户(企业，组织或个人)
     * 
     * @param customer 客户(企业，组织或个人)
     * @return 结果
     */
    @Override
    public int insertCustomer(Customer customer)
    {
        customer.setCreateTime(DateUtils.getNowDate());
        return customerMapper.insertCustomer(customer);
    }

    /**
     * 修改客户(企业，组织或个人)
     * 
     * @param customer 客户(企业，组织或个人)
     * @return 结果
     */
    @Override
    public int updateCustomer(Customer customer)
    {
        customer.setUpdateTime(DateUtils.getNowDate());
        return customerMapper.updateCustomer(customer);
    }

    /**
     * 删除客户(企业，组织或个人)对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCustomerByIds(String ids)
    {
        Long[] cids = Convert.toLongArray(ids);
        for (int i = 0; i <cids.length ; i++) {
        /*    businessInfoMapper.deleteBusinessInfoByCus(cids[i]);*/
            contactsMapper.deleteContactsByCust(cids[i]);
            compactMapper.deleteCompactByCust(cids[i]);
            followUpRecordsMapper.deleteFollowUpRecordsByCust(cids[i]);
            compactMapper.deleteCompactByCus(cids[i]);
            productMapper.deleteProductByCustToProduct(cids[i]);
            businessInfoMapper.deleteBusinessInfoByCus(cids[i]);

        }
        return customerMapper.deleteCustomerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户(企业，组织或个人)信息
     * 
     * @param cid 客户(企业，组织或个人)ID
     * @return 结果
     */
    @Override
    public int deleteCustomerById(Long cid)
    {
        return customerMapper.deleteCustomerById(cid);
    }
}
