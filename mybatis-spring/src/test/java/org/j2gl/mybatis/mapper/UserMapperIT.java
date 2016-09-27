package org.j2gl.mybatis.mapper;

import org.hamcrest.core.Is;
import org.j2gl.mybatis.conf.DatabaseConfiguration;
import org.j2gl.mybatis.conf.PropertiesConfiguration;
import org.j2gl.mybatis.domain.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {
                PropertiesConfiguration.class,
                DatabaseConfiguration.class
        }
)
public class UserMapperIT extends AbstractTransactionalJUnit4SpringContextTests {

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
        user.setUser("john");
        user.setEmail("nose@nose.com");

        Integer rows = userMapper.insert(user);

        Assert.assertThat(rows, Is.is(2));
    }

}