package com.ruoyi.project.crm.contacts.mapper;

import com.ruoyi.project.crm.contacts.domain.Contacts;

import java.util.List;

/**
 * 联系人Mapper接口
 * 
 * @author tqs
 * @date 2020-11-30
 */
public interface ContactsMapper 
{
    /**
     * 查询联系人
     * 
     * @param contactsId 联系人ID
     * @return 联系人
     */
    public Contacts selectContactsById(Long contactsId);

    /**
     * 查询联系人列表
     * 
     * @param contacts 联系人
     * @return 联系人集合
     */
    public List<Contacts> selectContactsList(Contacts contacts);

    /**
     * 新增联系人
     * 
     * @param contacts 联系人
     * @return 结果
     */
    public int insertContacts(Contacts contacts);

    /**
     * 修改联系人
     * 
     * @param contacts 联系人
     * @return 结果
     */
    public int updateContacts(Contacts contacts);

    /**
     * 删除联系人
     * 
     * @param contactsId 联系人ID
     * @return 结果
     */
    public int deleteContactsById(Long contactsId);

    /**
     * 批量删除联系人
     * 
     * @param contactsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteContactsByIds(String[] contactsIds);

    public int deleteContactsByInfo(Long bus_id);

    public int deleteContactsByCust(Long cid);


}
