package com.itheima;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(true)
public class BookDaoTests {

    @Autowired
    private BookService bookService;

    @Test
    void serviceTest() {
        Book book = new Book();
        book.setName("springBoot2");
        book.setType("springBoot2");
        book.setDescription("springBoot2");
        bookService.save(book);
    }
}
