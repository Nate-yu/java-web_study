package com.example.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Nate yu
 * @date 2020/11/5 - 9:42:16
 * @Description TODO
 */
@WebServlet("/includedServlet")
public class IncludedServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应时使用的字符编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("中国" + "<br>");
        out.println("URI:" + request.getRequestURI() + "<br>");
        out.println("QueryString:" + request.getQueryString() + "<br>");
        out.println("parameter p1:" + request.getParameter("p1") + "<br>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
