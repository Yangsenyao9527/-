package com.qf;

import com.qf.dao.UserDao;
import com.qf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/*

 *@author:杨森垚
 *@version:
 *@Date:2022/9/22 10:50
 *@Package:
 *@Description:
 */
public class TestMybaitsCURD {


    SqlSessionFactory sqlSessionFactory;
    SqlSession session;

    @Before
    public void init() throws Exception {

        //加载 核心配置文件的 输入流对象
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //创建SqlSessionFactoryBuilder 来构建 sqlSessionFactory 对象
        //使用了构建这模式创建 sqlSessionFactory
         sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);

        //获取sqlSession 对象(相当于jdbc 中的connection 对象)
        session = sqlSessionFactory.openSession();
    }

    @Test
    public void findAll(){

        //获取接口代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @After
    public void close(){
        session.close();
    }
}
