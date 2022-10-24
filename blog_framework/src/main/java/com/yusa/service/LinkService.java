package com.yusa.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yusa.domain.ResponseResult;
import com.yusa.domain.entity.Link;
import org.springframework.stereotype.Service;

/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2022-10-24 15:42:44
 */
@Service
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}

