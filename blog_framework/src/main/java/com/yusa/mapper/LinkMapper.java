package com.yusa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yusa.domain.entity.Link;
import org.apache.ibatis.annotations.Mapper;

/**
 * 友链(Link)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-24 15:42:33
 */
@Mapper
public interface LinkMapper extends BaseMapper<Link> {

}

