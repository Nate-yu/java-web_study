package com.example.session.chart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * @author Nate yu
 * @date 2020/11/10 - 16:07:26
 * @Description TODO
 */
@WebServlet("/listBookServlet")
public class ListBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Collection<Book> books = BookDB.getAll();
        out.write("本站提供的图书有：<br>");
        for (Book book : books) {
            String url = "/java_web_study/purchaseServlet?id="+book.getId();
            // 利用URL重写实现Session跟踪
            HttpSession s = request.getSession();
            String newUrl = response.encodeURL(url);
            out.write(book.getName()+"<a href='"+newUrl+"'>点击购买</a><br/>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
