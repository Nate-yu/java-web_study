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
 * @date 2020/11/5 - 9:37:02
 * @Description TODO
 */
@WebServlet("/resultServlet")
public class ResultServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 获取PrintWriter对象用于输出信息
        PrintWriter out = response.getWriter();
        // 获取request请求对象中保存的数据
        String school = (String) request.getAttribute("school");
        if (school != null) {
            out.println("学校名称：" + school + "<br>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
