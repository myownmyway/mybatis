package com.wpw.mybatis.mapper;

import com.wpw.mybatis.entity.User;

import java.util.List;

/**
 * @author wpw
 */
public interface UserMapper {
    /**
     * 根据用户id查找用户信息
     *
     * @param id 用户id
     * @return user
     */
    User selectUserById(Integer id);

    /**
     * 根据用户名称查询用户列表信息
     *
     * @param userName 用户名称
     * @return userList列表
     */
    List<User> selectUserByName(String userName);

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 自增主键
     */
    int insert(User user);

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return 主键
     */
    int update(User user);

    /**
     * 删除用户信息
     *
     * @param id 用户id
     */
    void delete(Integer id);
}
