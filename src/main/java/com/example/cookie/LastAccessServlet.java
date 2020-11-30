package com.example.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Nate yu
 * @date 2020/11/10 - 15:27:01
 * @Description TODO 用于实现获取Cookie信息并将当前时间作为Cookie值发送给客户端
 */
@WebServlet("/lastAccessServlet")
public class LastAccessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 防止乱码
        response.setContentType("text/html;charset=utf-8");
        // 初始化上次访问时间
        String lastAccessTime = null;

        // 获取所有cookie并存入数组
        Cookie[] cookies = request.getCookies();
        // 遍历
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("lastAccess".equals(cookies[i].getName())) {
                // 如果cookie的名称为lastAccess,则获取该cookie的值
                lastAccessTime = cookies[i].getValue();
                break;
            }
        }


        // 判断用户是否是第一次访问
        if (lastAccessTime == null) {
            response.getWriter().print("您是首次访问本站！！！");
        } else {
            response.getWriter().print("您上次的访问时间是： " + lastAccessTime);
        }

        // 创建cookie，将当前时间作为cookie的值发送给客户端
        String currentTime = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss").format(new Date());
        Cookie cookie = new Cookie("lastAccess", currentTime);
        // 设置cookie存活时间
        cookie.setMaxAge(60*60);
        // 发送cookie
        response.addCookie(cookie);
        /*cookie添加失败可能是因为其中的value中存在空格或者逗号等非法字符*/
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
