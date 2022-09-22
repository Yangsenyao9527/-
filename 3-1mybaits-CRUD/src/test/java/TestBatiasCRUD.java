import com.qf.dao.UserDao;
import com.qf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/*

 *@author:杨森垚
 *@version:
 *@Date:2022/9/22 20:48
 *@Package:
 *@Description:
 */
public class TestBatiasCRUD {
    //创建sqlSessionFactoryBuild  用来构建 sqlSessionFactory 对象
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        //加载核心输入流配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //构建sqlSessionFactory对象
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
    }

    //查询所有 测试
    @Test
    public void testFindAll(){
        sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
//    删除测试
    @Test
    public void testDelete(){
        sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        boolean delete = userDao.delete(6);
        System.out.println(delete);
        //手动提交事务
        sqlSession.commit();
    }
//修改 测试
    @Test
    public void testUpdate(){
        sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user=new User();
        user.setId(1);
        user.setName("杨森垚");
        user.setPassword("123456");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setRegistTime(new Date());

        int update = userDao.update(user);
        System.out.println("更新了"+update+"条记录");
        //手动提交事务
        sqlSession.commit();
    }

//    新增测试
    @Test
    public void testInsert(){
        sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user=new User();

        user.setName("李四");
        user.setPassword("123456");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setRegistTime(new Date());

         userDao.insert(user);

        //手动提交事务
        sqlSession.commit();

        System.out.println(user.getId());
    }

    @After
    public void close(){
        sqlSession.close();
    }
}
