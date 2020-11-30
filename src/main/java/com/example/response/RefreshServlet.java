package com.example.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Nate yu
 * @date 2020/11/5 - 8:41:56
 * @Description TODO 定时刷新界面
 */
@WebServlet("/refreshServlet")
public class RefreshServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*// 2秒后刷新并跳转到博客首页
        response.setHeader("Refresh", "2;URL=https://nate-yu.github.io/");*/
        // 每隔3秒定时刷新当前页面
        response.setHeader("Refresh","3");
        // 输出当前时间
        response.getWriter().println(new java.util.Date());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
