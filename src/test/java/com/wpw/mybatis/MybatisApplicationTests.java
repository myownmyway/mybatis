package com.wpw.mybatis;

import com.wpw.mybatis.entity.User;
import com.wpw.mybatis.mapper.UserMapper;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SpringBootTest
class MybatisApplicationTests {
    private static SqlSessionFactory sqlSessionFactory;
    private static InputStream inputStream;

    static {
        try {
            inputStream = Resources.getResourceAsStream("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    @Test
    @Ignore
    public void testSearchUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectUserById(1);
            System.out.println("user = " + user);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    @Ignore
    public void testSearchUserListByUserName() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.selectUserByName("test1");
            userList.stream().filter(Objects::nonNull).forEach(x -> {
                System.out.println("x = " + x);
            });
        } finally {
            sqlSession.close();
        }
    }

    @Test
    @Ignore
    public void update() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int update = userMapper.update(User.builder().build().setId(1).setUserName("ceShi").setUserAge(10).setUserAddress("hangzhou"));
            System.out.println("update = " + update);
            //默认不提交事务，需手动提交事务
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    @Ignore
    public void insert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int insert = userMapper.insert(User.builder().build().setUserName("zhangSan").setUserAge(10).setUserAddress("hangzhou"));
            System.out.println("insert = " + insert);
            //默认不提交事务，需要手动提交
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void delete() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.delete(7);
            //默认不自动提交事务，需要手动提交
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    void contextLoads() {
    }

}
