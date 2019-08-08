package com.springboot.springboot6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot6ApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Test
	public void contextLoads() throws SQLException {

		System.out.println(jdbcTemplate.queryForList("select * from user")); //dbcp c3p0 driud

		System.out.println(dataSource.getConnection());

		System.out.println(dataSource.getClass());

	}

}
