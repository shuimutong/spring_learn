package com.shuimutong.learn.mybatis.start;

import com.alibaba.fastjson.JSON;
import com.shuimutong.learn.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //4.执行Sql语句
        User user = session.selectOne("test.findUserById", 2);
        //5. 打印结果
        System.out.println(JSON.toJSONString(user));
        //6.释放资源
        session.close();
        in.close();
    }

    //根据用户名模糊查询用户列表
    public void testFindUserByUsername() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //4.执行Sql语句
        List<User> list = session.selectList("test.findUserByUsername", "王");
        //5. 打印结果
        for (User user:list) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }

    //添加用户
    public void testInsertUser() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.执行Sql语句
        User user = new User();
        user.setName("小强");
        user.setAge(2);
        int i = sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        //5. 打印结果
        // 刚保存用户，此时用户ID需要返回。执行完上面insert程序后，此时就能知道用户的ID是多少
        // 需要在User.xml文件中配置
        System.out.println("插入id:"+user.getId());//插入id:30

        //6.释放资源
        sqlSession.close();
        in.close();
    }
    //更新用户
    public void testUpdateUserById() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.执行Sql语句
        User user = new User();
        user.setId(27L);
        user.setName("小小");
        int i = sqlSession.insert("test.updateUserById", user);
        sqlSession.commit();
        //5. 打印结果
        System.out.println(user.getId());
        //6.释放资源
        sqlSession.close();
        in.close();
    }
    //删除用户
    public void testDeleteUserById() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.执行Sql语句
        int i = sqlSession.insert("test.deleteUserById", 32);
        sqlSession.commit();
        //5. 打印结果
        System.out.println(i);
        //6.释放资源
        sqlSession.close();
        in.close();
    }
}
