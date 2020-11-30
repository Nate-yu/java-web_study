package com.example.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Nate yu
 * @date 2020/11/5 - 8:50:16
 * @Description TODO 重定向
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 用HttpServletRequest对象的getParameter()方法获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 假设用户名和密码分别为：yubin和123
        if (("yubin").equals(username) &&("123").equals(password)) {
            // 如果用户名和密码正确，重定向到 welcome.html
            response.sendRedirect("/java_web_study/welcome.html");
        } else {
            // 如果用户名和密码错误，重定向到login.html
            response.sendRedirect("/java_web_study/login.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
