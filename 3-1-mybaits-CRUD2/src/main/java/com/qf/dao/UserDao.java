package com.qf.dao;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*

 *@author:杨森垚
 *@version:
 *@Date:2022/9/22 23:18
 *@Package:
 *@Description:
 */
public interface UserDao {
    //查询所有
    public List<User> findAll();
    //根据ID查询
    public User findById(int id);
    //根据条件查询
    public List<User> findByCondition(@Param("id") int id, @Param("sex") String sex);
    //
    public List<User> findByMap(Map<String, Object> map);
    //
    public List<User> findByBean(User user);
    //删除
    public boolean delete(int id);
    //更新
    public int update(User user);
    //添加
    public void insert(User user);
}
