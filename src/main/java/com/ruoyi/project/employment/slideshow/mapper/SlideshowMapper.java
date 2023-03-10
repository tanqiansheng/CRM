package com.ruoyi.project.employment.slideshow.mapper;

import java.util.List;
import com.ruoyi.project.employment.slideshow.domain.Slideshow;

/**
 * 轮播图Mapper接口
 * 
 * @author tqs
 * @date 2020-11-30
 */
public interface SlideshowMapper 
{
    /**
     * 查询轮播图
     * 
     * @param fileId 轮播图ID
     * @return 轮播图
     */
    public Slideshow selectSlideshowById(Long fileId);

    /**
     * 查询轮播图列表
     * 
     * @param slideshow 轮播图
     * @return 轮播图集合
     */
    public List<Slideshow> selectSlideshowList(Slideshow slideshow);

    /**
     * 新增轮播图
     * 
     * @param slideshow 轮播图
     * @return 结果
     */
    public int insertSlideshow(Slideshow slideshow);

    /**
     * 修改轮播图
     * 
     * @param slideshow 轮播图
     * @return 结果
     */
    public int updateSlideshow(Slideshow slideshow);

    /**
     * 删除轮播图
     * 
     * @param fileId 轮播图ID
     * @return 结果
     */
    public int deleteSlideshowById(Long fileId);

    /**
     * 批量删除轮播图
     * 
     * @param fileIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSlideshowByIds(String[] fileIds);
}
