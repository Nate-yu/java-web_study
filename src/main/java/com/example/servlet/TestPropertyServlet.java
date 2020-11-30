package com.example.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * @author Nate yu
 * @date 2020/11/4 - 20:25:30
 * @Description TODO
 */
@WebServlet("/testPropertyServlet")
public class TestPropertyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ServletContext context = this.getServletContext();
        //获取文件绝对路径
        String path = context.getClass().getClassLoader().getResource("messages.properties")
                .getPath();
        FileInputStream in = new FileInputStream(path);
        Properties pros = new Properties();
        pros.load(in);
        out.println("Company=" + pros.getProperty("Name"));
        out.println("Address=" + pros.getProperty("Address"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
