package com.test.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ConnectionTests {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSource() throws SQLException {

        assertNotNull(dataSource);

        Connection conn = dataSource.getConnection();

        assertFalse(conn.isClosed());
    }

}
