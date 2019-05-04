package it.cast.web.servlet;

import it.cast.domain.PageBean;
import it.cast.domain.User;
import it.cast.service.Imp.UserServletImp;
import it.cast.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
        //1.获取接收数据
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        //优化
        if(currentPage==null || "".equals(currentPage))
        {
            currentPage="1";
        }
        if(rows==null || "".equals(rows))
        {
            rows="5";
        }

        Map<String, String[]> condition = request.getParameterMap();
        //2.创建UserService查询
        UserService userService=new UserServletImp();
        PageBean<User>  pb=userService.findUserByPage(currentPage,rows,condition);
    //3.添加到request域中
        request.setAttribute("pb",pb);

        //存储查询条件，用与查询条件的回显
        request.setAttribute("condition",condition);

    //转发到list.jsp页面
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
