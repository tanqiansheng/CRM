package com.ruoyi.project.crm.customer.mapper;

import com.ruoyi.project.crm.customer.domain.Customer;

import java.util.List;

/**
 * 客户(企业，组织或个人)Mapper接口
 * 
 * @author tqs
 * @date 2020-11-30
 */
public interface CustomerMapper 
{
    /**
     * 查询客户(企业，组织或个人)
     * 
     * @param cid 客户(企业，组织或个人)ID
     * @return 客户(企业，组织或个人)
     */
    public Customer selectCustomerById(Long cid);

    /**
     * 查询客户(企业，组织或个人)列表
     * 
     * @param customer 客户(企业，组织或个人)
     * @return 客户(企业，组织或个人)集合
     */
    public List<Customer> selectCustomerList(Customer customer);

    /**
     * 新增客户(企业，组织或个人)
     * 
     * @param customer 客户(企业，组织或个人)
     * @return 结果
     */
    public int insertCustomer(Customer customer);

    /**
     * 修改客户(企业，组织或个人)
     * 
     * @param customer 客户(企业，组织或个人)
     * @return 结果
     */
    public int updateCustomer(Customer customer);

    /**
     * 删除客户(企业，组织或个人)
     * 
     * @param cid 客户(企业，组织或个人)ID
     * @return 结果
     */
    public int deleteCustomerById(Long cid);

    /**
     * 批量删除客户(企业，组织或个人)
     * 
     * @param cids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCustomerByIds(String[] cids);

}
