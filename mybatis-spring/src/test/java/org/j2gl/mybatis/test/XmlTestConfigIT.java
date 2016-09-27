package org.j2gl.mybatis.test;

import org.j2gl.mybatis.domain.User;
import org.j2gl.mybatis.mapper.UserMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"classpath:testApplicationContext.xml"}
)
public class XmlTestConfigIT extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserMapper userMapper;


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUser("test");
        user.setEmail("xml@config.com");

        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }

}