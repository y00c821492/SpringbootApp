package com.example.springbootapp.mappers;

import com.example.springbootapp.common.QueryCondition;
import com.example.springbootapp.models.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * desc: 书籍操作接口
 * author: sadcoder333
 * date: 2019/10/1
 **/
@Mapper
public interface BookMapper {

    /**
     * 保存一条数据到数据库
     *
     * @param bookInfo 书籍信息
     * @return 插入数据行数
     */
    int saveBook(BookInfo bookInfo);

    /**
     * 根据id查询书籍详情信息
     *
     * @param id 书籍id
     * @return 书籍详情
     */
    BookInfo getBookInfo(@Param("id") Integer id);


    /**
     * 根据查询条件查询书籍列表
     *
     * @param condition 查询条件
     * @return 满足查询条件的记录列表
     */
    List<BookInfo> getBooks(@Param("condition") QueryCondition condition);


    /**
     * 根据书籍id删除记录
     *
     * @param id 书籍id
     * @return 删除行数
     */
    int deleteBook(@Param("id") Integer id);


}
