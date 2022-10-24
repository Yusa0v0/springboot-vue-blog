package com.yusa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yusa.constants.SystemConstants;
import com.yusa.domain.ResponseResult;
import com.yusa.domain.entity.Link;
import com.yusa.domain.vo.LinkVO;
import com.yusa.mapper.LinkMapper;
import com.yusa.service.LinkService;
import com.yusa.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.yusa.constants.SystemConstants.LINK_STATUS_NORMAL;

/**
 * 友链(Link)表服务实现类
 *
 * @author makejava
 * @since 2022-10-24 15:42:44
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResult getAllLink() {
        // 查询所有审核通过的友链
        LambdaQueryWrapper<Link> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(Link::getStatus, LINK_STATUS_NORMAL);
        List<Link> links = list(lambdaQueryWrapper);
        // 转换成VO
        return ResponseResult.okResult(BeanCopyUtils.copyBeanList(links, LinkVO.class));
    }
}

