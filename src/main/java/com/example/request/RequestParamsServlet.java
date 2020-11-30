package com.example.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Nate yu
 * @date 2020/11/5 - 9:17:09
 * @Description TODO 获取请求参数
 */
@WebServlet("/requestParamsServlet")
public class RequestParamsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request对象的解码方式
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("用户名:" + name);
        System.out.println("密  码:" + password);
        // 获取参数名为“hobby”的值
        String[] hobbies = request.getParameterValues("hobby");
        System.out.print("爱好:");
        int i = 0;
        for (String hobby : hobbies) {
            ++i;
            if (i > 1) {
                System.out.print(hobby + ",");
            } else {
                System.out.println(hobby);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
