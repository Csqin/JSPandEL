package it.cast.service.Imp;

import it.cast.dao.Imp.UserDaoImp;
import it.cast.dao.UserDao;
import it.cast.domain.PageBean;
import it.cast.domain.User;
import it.cast.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * 调用dao层方法操作数据库,得到List数据集合
 */
public class UserServletImp implements UserService{
    UserDao userDao=new UserDaoImp();
    @Override
    public List<User> findAll() {

        List<User> users = userDao.findAll();
        return users;
    }

    @Override
    public void delete( String id) {
        userDao.delete(id);
    }

    public User login(User user) {
        return userDao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void add(User user) {
         userDao.add(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User findById(String id) {
        return userDao.findById(Integer.parseInt(id));
    }

    @Override
    public void delSelect(String[] uids) {
        for (String uid : uids) {
            userDao.delete(uid);
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //创建PageBean对象
        PageBean<User> pageBean = new PageBean<User>();
        //每页显示条数
        pageBean.setRows(rows);
        //总记录数
        int total= userDao.findTotal(condition);
        pageBean.setTotalCount(total);
        //总条数
        int  totalPage=total % rows == 0  ?  total/rows :( total/rows) +1;
        pageBean.setTotalPage(totalPage);
        //优化—
        if (currentPage<=0)
        {
            currentPage=1;
        }
        if (currentPage>totalPage)
        {
            currentPage=totalPage;
        }
        //每页数据
        int start=(currentPage-1)*rows;//开始索引
        if (start<=0)
        {
            start=0;
        }
        List<User> user  =userDao.findTotalUser(start,rows,condition);
        pageBean.setList(user);
        //当前页码
        pageBean.setCurrentPage(currentPage);
        return pageBean;
    }
}
