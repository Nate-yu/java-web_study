package com.example.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Nate yu
 * @date 2020/11/4 - 18:42:23
 * @Description TODO
 */
public class HelloServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 得到输出流PrinterWriter对象，Servlet使用输出流来产生响应
        PrintWriter out = servletResponse.getWriter();

        // 使用输出流对象向客户端发送字符数据
        out.println("Hello");
    }
}
