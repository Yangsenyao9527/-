import com.qf.dao.UserDao;
import com.qf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

 *@author:杨森垚
 *@version:
 *@Date:2022/9/22 23:23
 *@Package:
 *@Description:
 */
public class TestMyBatisCRUD {
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;

    @Before
    public void init() throws Exception {
        //加载输入流对象
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactoryBuild 来 构建SqlSessionFactory 对象
        sqlSessionFactory= new SqlSessionFactoryBuilder().build(is);
    }
//    查询所有
    @Test
    public void testFindAll(){
        sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

//    根据ID 查询
    @Test
    public void testFindById(){
        sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user=userDao.findById(2);
        System.out.println(user);
    }

//根据条件查询 (多参数)
    @Test
    public void testFindByCondition() {
        sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findByCondition(2,"女");
        for (User user : users) {
            System.out.println(user);
        }
    }

//    根据条件查询(Map 集合)
    @Test
    public void testFindByMap(){
        sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        Map<String,Object> map=new HashMap<>();
        map.put("id",5);
        map.put("sex","女");

        List<User> users = userDao.findByMap(map);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByBean(){
        sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user=new User();
        user.setId(2);
        user.setSex("女");
        user.setName("尹");
        List<User> users = userDao.findByBean(user);
        for (User u : users) {
            System.out.println(u);
        }
    }
    @Test
    public void testDelete() {
        sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        boolean delete = userDao.delete(10);
        System.out.println(delete);

        sqlSession.commit();
    }

    @Test
    public void testUpdate() {
        sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setId(9);
        user.setName("蔡徐坤");
        user.setPassword("000000");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setRegistTime(new Date());


        int update = userDao.update(user);
        System.out.println("更新了"+update+"条记录");

        sqlSession.commit();
    }

    @Test
    public void testInsert() {
        sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setName("周杰伦");
        user.setPassword("0123456");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setRegistTime(new Date());

        userDao.insert(user);

        sqlSession.commit();

        System.out.println(user.getId());
    }

    @After
    public void close(){
        sqlSession.close();
    }
}
