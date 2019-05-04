package it.cast.dao;

import it.cast.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 数据库操作接口
 */
public interface UserDao {

            List<User> findAll();

            void delete(String id);

            User findUserByUsernameAndPassword(String username, String password);

            void add(User user);

            void update(User user);

            User findById(int integer);

            int findTotal(Map<String, String[]> condition);

            List<User> findTotalUser(int start, int rows, Map<String, String[]> condition);
}
