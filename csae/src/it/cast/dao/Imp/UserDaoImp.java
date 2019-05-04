package it.cast.dao.Imp;
import it.cast.dao.UserDao;
import it.cast.domain.User;
import it.cast.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImp implements UserDao {
    /**
     * 操作数据库
     * @return
     */
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        //查询所有用户信息
        String sql="select  id,name,gender,age,address,qq,email from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public void delete( String id) {
        int ids = Integer.parseInt(id);
        String sql="delete  from user where id = ? ";
     template.update(sql,ids);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        //1.定义sql
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        //2.执行sql
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?,gender = ? ,age = ? , address = ? , qq = ?, email = ? where id = ?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id=?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public int findTotal(Map<String, String[]> condition) {
        String sql="select count(*) from user where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        //获取map集合的key
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<>();
        //过滤currentPage，和rows,id,uid
        for (String key : keySet) {
            if ("currentPage".equals(key) || "rows".equals(key) || "id".equals(key) ||"uid".equals(key))
            {
                continue;
            }
            String value=condition.get(key)[0];
            if (value !=null && ! "".equals(value))
            {
                //sql语句动态添加
                sb.append(" and  "+key+"  like ?  " );
                //?参数的值
                params.add("%"+value+"%");
            }
        }
        //动态添加后的sql语句
        sql=sb.toString();
        //params.toArray(),参数的值的list集合
        return template.queryForObject(sql,Integer.class,params.toArray());//
    }

    @Override
    public List<User> findTotalUser(int start, int rows, Map<String, String[]> condition) {
        String sql="select * from user  WHERE 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        //获取map集合的key
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<>();
        //过滤currentPage，和rows
        for (String key : keySet) {
            if ("currentPage".equals(key) || "rows".equals(key) || "id".equals(key) ||"uid".equals(key))
            {
                continue;
            }
            String value=condition.get(key)[0];
            if (value != null &&   ! "".equals(value))
            {
                //sql语句动态添加
                sb.append(" and  "+key+"  like  ?  " );
                //?参数的值
                params.add("%"+value+"%");
            }
        }
        //limit语句添加
        sb.append(" limit ?,?");
        //limit参数添加
        params.add(start);
        params.add(rows);
        //动态添加后的sql语句
        sql=sb.toString();
        //params.toArray(),参数的值的list集合
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }


}
