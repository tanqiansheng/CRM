package com.ruoyi.project.crm.fucntion.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.crm.fucntion.mapper.FucntionMapper;
import com.ruoyi.project.crm.fucntion.domain.Fucntion;
import com.ruoyi.project.crm.fucntion.service.IFucntionService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 功能操作Service业务层处理
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Service
public class FucntionServiceImpl implements IFucntionService 
{
    @Autowired
    private FucntionMapper fucntionMapper;

    /**
     * 查询功能操作
     * 
     * @param fucntionId 功能操作ID
     * @return 功能操作
     */
    @Override
    public Fucntion selectFucntionById(Long fucntionId)
    {
        return fucntionMapper.selectFucntionById(fucntionId);
    }

    /**
     * 查询功能操作列表
     * 
     * @param fucntion 功能操作
     * @return 功能操作
     */
    @Override
    public List<Fucntion> selectFucntionList(Fucntion fucntion)
    {
        return fucntionMapper.selectFucntionList(fucntion);
    }

    /**
     * 新增功能操作
     * 
     * @param fucntion 功能操作
     * @return 结果
     */
    @Override
    public int insertFucntion(Fucntion fucntion)
    {
        return fucntionMapper.insertFucntion(fucntion);
    }

    /**
     * 修改功能操作
     * 
     * @param fucntion 功能操作
     * @return 结果
     */
    @Override
    public int updateFucntion(Fucntion fucntion)
    {
        return fucntionMapper.updateFucntion(fucntion);
    }

    /**
     * 删除功能操作对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFucntionByIds(String ids)
    {
        return fucntionMapper.deleteFucntionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除功能操作信息
     * 
     * @param fucntionId 功能操作ID
     * @return 结果
     */
    @Override
    public int deleteFucntionById(Long fucntionId)
    {
        return fucntionMapper.deleteFucntionById(fucntionId);
    }
}
