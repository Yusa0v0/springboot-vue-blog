package com.yusa.utils;

import com.yusa.domain.entity.Article;
import com.yusa.domain.vo.HotArticleVo;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yusa
 * @version 1.0
 */
public class BeanCopyUtils {
    private BeanCopyUtils(){}
    public static <V>V copyBean(Object source,Class<V> clazz){
        // 创建目标对象
        V o = null;
        try {
            o = clazz.newInstance();
            // 实现属性拷贝
            BeanUtils.copyProperties(source,o);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // 返回结果
        return o;
    }
    public static <O,V> List<V> copyBeanList(List<O> list, Class<V> clazz) {
        return list.stream()
                .map(o -> copyBean(o,clazz))
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        Article article =new Article();
        article.setId(1L);
        article.setTitle("s");
        HotArticleVo hotArticleVo = copyBean(article,HotArticleVo.class);
        System.out.println(hotArticleVo);


    }
}
