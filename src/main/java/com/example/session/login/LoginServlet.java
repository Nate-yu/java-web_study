package com.example.session.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Nate yu
 * @date 2020/11/10 - 19:57:05
 * @Description TODO 完成用户登录功能
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    /***
     * @Description TODO 未添加验证码的登录操作
     * @Param [request, response]
     */
    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter pw = response.getWriter();

        if (("nate").equals(username) && ("123").equals(password)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            request.getSession().setAttribute("user",user);
            response.sendRedirect("/java_web_study/IndexServlet");
        } else {
            pw.write("用户名或密码错误，登录失败");
        }
    }*/

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("check_code");
        String savedCode = (String) request.getSession().getAttribute("check_code");
        PrintWriter pw = response.getWriter();
        if (("nate").equals(username) && ("123").equals(password) && checkCode.equals(savedCode)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/java_web_study/IndexServlet");
        } else if (checkCode.equals(savedCode)) {
            pw.write("用户名或密码错误，登录失败");
        } else {
            pw.write("验证码错误");
        }
    }


        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
