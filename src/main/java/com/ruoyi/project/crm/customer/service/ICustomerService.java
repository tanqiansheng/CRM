package com.ruoyi.project.crm.customer.service;

import java.util.List;
import com.ruoyi.project.crm.customer.domain.Customer;

/**
 * 客户(企业，组织或个人)Service接口
 * 
 * @author tqs
 * @date 2020-11-30
 */
public interface ICustomerService 
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
     * 批量删除客户(企业，组织或个人)
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCustomerByIds(String ids);

    /**
     * 删除客户(企业，组织或个人)信息
     * 
     * @param cid 客户(企业，组织或个人)ID
     * @return 结果
     */
    public int deleteCustomerById(Long cid);
}
