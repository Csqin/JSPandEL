package it.cast.web.servlet;

import it.cast.domain.User;
import it.cast.service.Imp.UserServletImp;
import it.cast.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用userService的findAll方法获取所有用户信息
        UserService userService = new UserServletImp();
        List<User> users = userService.findAll();
        //将数据添加到request域中
        request.setAttribute("users",users);
        //页面转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
