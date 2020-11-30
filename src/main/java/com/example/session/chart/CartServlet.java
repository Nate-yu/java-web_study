package com.example.session.chart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Nate yu
 * @date 2020/11/10 - 16:20:48
 * @Description TODO
 */
@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<Book> cart = null;
        // 标记用户是否买过商品
        boolean purFlag = true;
        // 获得用户session
        HttpSession session = request.getSession(false);
        // 如果session为null，purFlag置为false
        if (session == null) {
            purFlag = false;
        } else {
            // 获得用户购物车
            cart = (List) session.getAttribute("cart");
            // 如果用户的购物车为null，purFlag置为false
            if (cart == null) {
                purFlag = false;
            }
        }

        // 如果purFlag为false，表明用户没有购买图书，重定向到ListServlet页面
        if (!purFlag) {
            out.write("对不起！您还没有购买任何商品！<br/>");
        } else {
            // 否则显示用户购买图书的信息
            out.write("您购买的图书有：<br/>");
            double price = 0;
            for (Book book : cart) {
                out.write(book.getName()+"<br/>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
