package it.cast.service;

import it.cast.domain.PageBean;
import it.cast.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 查询全部findall
     * @return
     */
    List<User> findAll();

    /**
     * 删除指定id的用户信息
     * @param id
     */
    void delete(String id );

    /**
     * 管理员登录界面
     * @param user
     * @return
     */
        User login(User user);

    /**
     * 用户数据添加
     * @param user
     */
    void add(User user);

    /**
     * 用户数据更改
     * @param user
     */
    void update(User user);

    /**
     *用于修改信息的回显
     * @param id
     * @return
     */
    User findById(String id);

    /**
     *删除选中的用户信息
     * @param uids
     */
    void delSelect(String[] uids);

    /**
     * 分页查询功能
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
        PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
