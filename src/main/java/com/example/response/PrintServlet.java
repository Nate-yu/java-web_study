package com.example.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Nate yu
 * @date 2020/11/5 - 8:27:37
 * @Description TODO 打印数据
 */
@WebServlet("/printServlet")
public class PrintServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = "Hello";
        /*// 获取字节流输出对象
        ServletOutputStream out = response.getOutputStream();
        // 输出信息
        out.write(data.getBytes());*/

        // 使用getWrite()方法发送消息体
        PrintWriter print = response.getWriter();
        print.write(data);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
