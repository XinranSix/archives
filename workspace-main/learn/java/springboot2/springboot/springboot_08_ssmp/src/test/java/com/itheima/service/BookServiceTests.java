package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BookServiceTests {

    @Autowired
    IBookService ibookService;

    @Test
    void testGetById() {
        System.out.println(ibookService.getById(1));
    }

    void testSave() {
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        ibookService.save(book);
    }

    @Test
    void tesUpdate() {
        Book book = new Book();
        book.setId(1);
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        ibookService.updateById(book);
    }

    @Test
    void testDelete() {
        ibookService.removeById(1);
    }

    @Test
    void testGetAll() {
        ibookService.list();
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page(2, 5);
        ibookService.page(page);
        page.getRecords().forEach(System.out::println);
    }

    @Test
    void testGetBy() {
    }

}
