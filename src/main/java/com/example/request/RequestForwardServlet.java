package com.example.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Nate yu
 * @date 2020/11/5 - 9:34:47
 * @Description TODO
 */
@WebServlet("/requestForwardServlet")
public class RequestForwardServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 将数据存储到request对象中
        request.setAttribute("school","湖南工业大学");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/resultServlet");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
