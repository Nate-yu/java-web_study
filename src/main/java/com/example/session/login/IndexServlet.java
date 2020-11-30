package com.example.session.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author Nate yu
 * @date 2020/11/10 - 19:49:03
 * @Description TODO 显示网站首界面
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决乱码问题
        response.setContentType("text/html;charset=utf-8");
        // 创建或者获取保存用户信息的Session对象
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.getWriter().print("您还没有登录，请<a href='/java_web_study/session_login.html'>登录</a>");
        } else {
            response.getWriter().print("您已登录，欢迎你，" + user.getUsername() + "！");
            response.getWriter().print("<a href='/java_web_study/LogoutServlet'>退出</a>");
            // 创建Cookie存放Session的标识号
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(60 * 30);
            cookie.setPath("/java_web_study");
            response.addCookie(cookie);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
