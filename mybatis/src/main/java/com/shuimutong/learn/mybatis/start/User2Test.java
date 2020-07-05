package com.shuimutong.learn.mybatis.start;

import com.alibaba.fastjson.JSON;
import com.shuimutong.learn.mybatis.dao.User2Mapper;
import com.shuimutong.learn.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class User2Test {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        User2Mapper user2Mapper = session.getMapper(User2Mapper.class);
        User user = user2Mapper.getUser(2L);
        //5. 打印结果
        System.out.println("第1次查询：" + JSON.toJSONString(user));

        user2Mapper = session.getMapper(User2Mapper.class);
        user = user2Mapper.getUser2(1L);
        //5. 打印结果
        System.out.println("第2次查询：" + JSON.toJSONString(user));

        user2Mapper = session.getMapper(User2Mapper.class);
        user = user2Mapper.getUser3(1L);
        //5. 打印结果
        System.out.println("第3次查询：" + JSON.toJSONString(user));

        //6.释放资源
        session.close();
        in.close();
    }
}
