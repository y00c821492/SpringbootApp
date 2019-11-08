package com.example.springbootapp.controlllers;

import com.example.springbootapp.base.BaseResponse;
import com.example.springbootapp.base.ResultCode;
import com.example.springbootapp.models.BookInfo;
import com.example.springbootapp.models.requests.QueryBookReq;
import com.example.springbootapp.models.responses.BookInfoRsp;
import com.example.springbootapp.models.responses.QueryBookRsp;
import com.example.springbootapp.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * desc: 图书管理接口
 * author: yudeshui
 * date: 2019/10/1
 **/
@RestController
@RequestMapping("/book")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class.getSimpleName());

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 根据id查询图书详情
     *
     * @param id 图书id
     * @return 图书详情
     */
    @GetMapping("/getBookInfo")
    public BookInfoRsp getBookInfo(@RequestParam int id) {
        logger.info("start to getBookInfo:{}", id);
        BookInfoRsp bookInfoRsp = BookInfoRsp.builder().build();
        try {
            BookInfo bookInfo = bookService.getBookInfo(id);
            if (bookInfo != null) {
                bookInfoRsp.setBookInfo(bookInfo);
                bookInfoRsp.ok();
            }
        } catch (Exception e) {
            logger.error("start to getBookInfo:{}, {}", id, e);
        }
        bookInfoRsp.setResultCode(ResultCode.SERVER_ERROR);
        return bookInfoRsp;
    }

    /**
     * 获取所有的图书列表
     *
     * @return 所有的图书列表
     */
    @GetMapping("/getAllBooks")
    public QueryBookRsp getAllBooks() {
        logger.info("start to getAllBooks:{}");
        QueryBookRsp queryBookRsp = QueryBookRsp.builder().build();
        try {
            List<BookInfo> bookInfoList = bookService.getAllBooks();
            queryBookRsp.setBookList(bookInfoList);
            queryBookRsp.ok();
        } catch (Exception e) {
            logger.error("failed to getAllBooks:{}", e);
            queryBookRsp.setResultCode(ResultCode.SERVER_ERROR);
        }
        return queryBookRsp;
    }


    /**
     * 查询图书列表
     *
     * @param queryBookReq 查询请求参数
     * @return 查询结果
     */
    @PostMapping("/queryBooks")
    public QueryBookRsp queryBooks(@RequestBody QueryBookReq queryBookReq) {
        logger.info("start to queryBooks:{}", queryBookReq);
        QueryBookRsp queryBookRsp = QueryBookRsp.builder().build();
        try {
            List<BookInfo> bookInfoList = bookService.queryBooks(queryBookReq);
            queryBookRsp.setBookList(bookInfoList);
            queryBookRsp.ok();
        } catch (Exception e) {
            logger.error("failed to queryBooks:{}, {}", queryBookReq, e);
            queryBookRsp.setResultCode(ResultCode.SERVER_ERROR);
        }
        return queryBookRsp;
    }

    /**
     * 新增一个图书记录
     *
     * @param bookInfo 图书信息
     * @return 新增结果
     */
    @PostMapping("/saveBook")
    public BaseResponse saveBook(@RequestBody @Valid BookInfo bookInfo) {
        logger.info("start to saveBook:{}", bookInfo);
        BaseResponse response = new BaseResponse();
        try {
            int count = bookService.saveBook(bookInfo);
            response.setResultCode(count > 0 ? ResultCode.SUCCESSFUL : ResultCode.DB_ERROR);
        } catch (Exception e) {
            logger.error("failed to saveBook:{}, {}", bookInfo, e);
            response.setResultCode(ResultCode.SERVER_ERROR);
        }
        return response;
    }

    /**
     * 删除图书信息
     *
     * @param id 图书id
     * @return 删除结果
     */
    @PostMapping("/deleteBook/{id}")
    public BaseResponse deleteBook(@PathVariable("id") Integer id) {
        logger.info("start to deleteBook:{}", id);
        BaseResponse response = new BaseResponse();
        try {
            int count = bookService.deleteBook(id);
            response.setResultCode(count > 0 ? ResultCode.SUCCESSFUL : ResultCode.DB_ERROR);
        } catch (Exception e) {
            logger.error("failed to deleteBook:{}, {}", id, e);
            response.setResultCode(ResultCode.SERVER_ERROR);
        }
        return response;
    }
}
