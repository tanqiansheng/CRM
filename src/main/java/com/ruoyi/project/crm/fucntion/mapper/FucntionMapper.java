package com.ruoyi.project.crm.fucntion.mapper;

import java.util.List;
import com.ruoyi.project.crm.fucntion.domain.Fucntion;

/**
 * 功能操作Mapper接口
 * 
 * @author tqs
 * @date 2020-11-30
 */
public interface FucntionMapper 
{
    /**
     * 查询功能操作
     * 
     * @param fucntionId 功能操作ID
     * @return 功能操作
     */
    public Fucntion selectFucntionById(Long fucntionId);

    /**
     * 查询功能操作列表
     * 
     * @param fucntion 功能操作
     * @return 功能操作集合
     */
    public List<Fucntion> selectFucntionList(Fucntion fucntion);

    /**
     * 新增功能操作
     * 
     * @param fucntion 功能操作
     * @return 结果
     */
    public int insertFucntion(Fucntion fucntion);

    /**
     * 修改功能操作
     * 
     * @param fucntion 功能操作
     * @return 结果
     */
    public int updateFucntion(Fucntion fucntion);

    /**
     * 删除功能操作
     * 
     * @param fucntionId 功能操作ID
     * @return 结果
     */
    public int deleteFucntionById(Long fucntionId);

    /**
     * 批量删除功能操作
     * 
     * @param fucntionIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteFucntionByIds(String[] fucntionIds);
}
