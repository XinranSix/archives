package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-！");
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable("id") Integer id) {
        return new R(bookService.removeById(id));
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Integer id) {
        return new R(true, bookService.getById(id));
    }

//    @GetMapping("/{currentPage}/{pageSize}")
//    public R getPage(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize) {
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        if (currentPage > page.getPages()) {
//            page = bookService.getPage((int) page.getPages(), pageSize);
//        }
//        return new R(true, page);
//    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize, Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize, book);
        }
        return new R(true, page);
    }
}
