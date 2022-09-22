package com.qf.dao;

import com.qf.pojo.User;

import java.util.List;

/*

 *@author:杨森垚
 *@version:
 *@Date:2022/9/22 21:01
 *@Package:
 *@Description:
 */
public interface UserDao {
    //查询所有
    public List<User> findAll();
    //删除
    public boolean delete(int id);
    //修改
    public int update(User user);
    //增加
    public void insert(User user);
}
