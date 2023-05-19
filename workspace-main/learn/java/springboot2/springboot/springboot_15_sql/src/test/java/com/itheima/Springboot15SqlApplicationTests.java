package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Springboot15SqlApplicationTests {

//	@Autowired
//	private BookDao bookDao;

    @Test
    void test() {
        // bookDao.selectById(1);
    }

    @Test
    void testJdbcTemplate(@Autowired JdbcTemplate jdbcTemplate) {
        String sql = "select * from tbl_book";
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
//        maps.forEach(System.out::println);
        RowMapper<Book> rm = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setType(rs.getString("type"));
                book.setDescription(rs.getString("description"));
                return book;
            }
        };
        List<Book> list = jdbcTemplate.query(sql, rm);
        list.forEach(System.out::println);
    }
}
