package com.example.session.chart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nate yu
 * @date 2020/11/10 - 16:12:17
 * @Description TODO
 */
@WebServlet("/purchaseServlet")
public class PurchaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得用户购买的商品
        String id = request.getParameter("id");
        if (id == null) {
            // 若id为null，重定向到ListBookServlet页面
            String url = "/java_web_study/listBookServlet";
            response.sendRedirect(url);
            return;
        }

        Book book = BookDB.getBook(id);
        // 创建或者获得用户的Session对象
        HttpSession session = request.getSession();
        // 从session对象中获得用户的购物车
        List<Book> cart = (List) session.getAttribute("cart");
        if (cart == null) {
            // 首次购买，为用户创建一个购物车（用list模拟）
            cart = new ArrayList<Book>();
            // 将购物车存入session对象
            session.setAttribute("cart",cart);
        }
        // 将商品放入购物车
        cart.add(book);
        // c创建Cookie存放Session的标识号
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60*30);
        cookie.setPath("/java_web_study");
        response.addCookie(cookie);

        // 重定向到购物车页面
        String url = "/java_web_study/cartServlet";
        response.sendRedirect(url);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
