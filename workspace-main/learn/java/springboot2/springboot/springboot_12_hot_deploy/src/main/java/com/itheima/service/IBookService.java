package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;

public interface IBookService extends IService<Book> {


    IPage<Book> getPage(Integer currentPage, int pageSize);

    IPage<Book> getPage(Integer currentPage, int pageSize, Book book);
}
