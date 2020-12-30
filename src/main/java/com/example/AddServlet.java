package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Nate yu
 * @date 2020/12/30 - 下午 10:19
 * @Description TODO
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        for(int i = 1;i < 10; i++) {
            for(int j = 1; j < i+1; j++) {
                writer.write(i+"+"+j+"="+(i+j)+" ");
            }
            writer.println();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
