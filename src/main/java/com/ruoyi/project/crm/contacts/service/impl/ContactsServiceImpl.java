package com.ruoyi.project.crm.contacts.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.crm.contacts.domain.Contacts;
import com.ruoyi.project.crm.contacts.mapper.ContactsMapper;
import com.ruoyi.project.crm.contacts.service.IContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 联系人Service业务层处理
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Service
public class ContactsServiceImpl implements IContactsService 
{
    @Autowired
    private ContactsMapper contactsMapper;

    /**
     * 查询联系人
     * 
     * @param contactsId 联系人ID
     * @return 联系人
     */
    @Override
    public Contacts selectContactsById(Long contactsId)
    {
        return contactsMapper.selectContactsById(contactsId);
    }

    /**
     * 查询联系人列表
     * 
     * @param contacts 联系人
     * @return 联系人
     */
    @Override
    public List<Contacts> selectContactsList(Contacts contacts)
    {
        return contactsMapper.selectContactsList(contacts);
    }

    /**
     * 新增联系人
     * 
     * @param contacts 联系人
     * @return 结果
     */
    @Override
    public int insertContacts(Contacts contacts)
    {
        contacts.setCreateTime(DateUtils.getNowDate());
        int i ;
        try {
            i=  contactsMapper.insertContacts(contacts);
        } catch (Exception e) {
            return 0;
        }
        return i;

    }

    /**
     * 修改联系人
     *
     * @param contacts 联系人
     * @return 结果
     */
    @Override
    public int updateContacts(Contacts contacts)
    {
        contacts.setUpdateTime(DateUtils.getNowDate());
        int i ;
        try {
            i=  contactsMapper.updateContacts(contacts);
        } catch (Exception e) {
            return 0;
        }
        return i;
    }

    /**
     * 删除联系人对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteContactsByIds(String ids)
    {
        return contactsMapper.deleteContactsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除联系人信息
     * 
     * @param contactsId 联系人ID
     * @return 结果
     */
    @Override
    public int deleteContactsById(Long contactsId)
    {
        return contactsMapper.deleteContactsById(contactsId);
    }
}
