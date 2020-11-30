package com.example.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Nate yu
 * @date 2020/11/5 - 9:08:31
 * @Description TODO 控制防盗链
 */
@WebServlet("/downManagerServlet")
public class DownManagerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 获取referer头的值
        String referer = request.getHeader("referer");

        // 获取访问地址
        String sitePart = "http://" + request.getServerName();

        // 判断referer头是否为空，这个头的首地址是否以sitePart开始的
        if (referer != null && referer.startsWith(sitePart)) {
            // 处理正在下载的请求
            out.println("dealing download ...");
        } else {
            // 非法下载请求跳转到download.html页面
            RequestDispatcher rd = request.getRequestDispatcher("/download.html");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
