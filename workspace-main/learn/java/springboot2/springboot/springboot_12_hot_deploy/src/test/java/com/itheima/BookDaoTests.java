package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.mysql.cj.util.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        bookDao.selectById(1);
    }


    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
    }

    @Test
    void tesUpdate() {
        Book book = new Book();
        book.setId(1);
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.updateById(book);
    }

    @Test
    void testDelete() {
        bookDao.deleteById(2);
    }

    @Test
    void testGetAll() {
        bookDao.selectList(null);
    }

    @Test
    void testGetPage() {
        IPage page = new Page(2, 5);
        bookDao.selectPage(page, null);
        List records = page.getRecords();
        records.forEach(System.out::println);
    }

    @Test
    void testGetBy1() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "Spring");
        bookDao.selectList(queryWrapper);
    }

    @Test
    void testGetBy2() {
        String name = null;
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(!StringUtils.isNullOrEmpty(name), Book::getName, name);
        bookDao.selectList(queryWrapper);
    }
}
