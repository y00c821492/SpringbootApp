package com.example.springbootapp.services;

import com.example.springbootapp.common.DefaultQueryCondition;
import com.example.springbootapp.common.QueryCondition;
import com.example.springbootapp.mappers.BookMapper;
import com.example.springbootapp.models.BookInfo;
import com.example.springbootapp.models.requests.QueryBookReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * desc: 书籍管理接口
 * author: sadcoder333
 * date: 2019/10/1
 **/
@Component
public class BookService {

    private BookMapper bookMapper;

    @Autowired
    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    /**
     * 根据id查询书籍详情信息
     *
     * @param id 书籍id
     * @return 书籍详情
     */
    public BookInfo getBookInfo(Integer id) {
        return bookMapper.getBookInfo(id);
    }


    /**
     * 查询所有的图书列表
     *
     * @return 图书列表
     */
    public List<BookInfo> getAllBooks() {
        QueryCondition condition = new DefaultQueryCondition();
        return bookMapper.getBooks(condition);
    }

    /**
     * 查询图书列表
     *
     * @param queryBookReq 查询参数
     * @return 书籍列表
     */
    public List<BookInfo> queryBooks(QueryBookReq queryBookReq) {
        QueryCondition condition = new DefaultQueryCondition();
        condition.register("id", queryBookReq.getId());
        condition.register("bookName", queryBookReq.getName());
        condition.register("bookAuthor", queryBookReq.getAuthor());
        condition.register("book_isbn", queryBookReq.getIsbn());
        if (queryBookReq.getPrice() > 0) {
            condition.register("bookPrice", queryBookReq.getPrice());
        }
        return bookMapper.getBooks(condition);
    }

    /**
     * 根据id删除图书信息
     *
     * @param id 书籍id
     * @return 删除行数
     */
    @Transactional
    public int deleteBook(Integer id) {
        return bookMapper.deleteBook(id);
    }

    /**
     * 保存一条书籍信息
     *
     * @param bookInfo 新增的图书信息
     * @return 新增行数
     */
    @Transactional
    public int saveBook(BookInfo bookInfo) {
        return bookMapper.saveBook(bookInfo);
    }
}
