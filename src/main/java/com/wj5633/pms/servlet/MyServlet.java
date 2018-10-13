package com.wj5633.pms.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wj
 * @create 2018-09-06 19:48
 **/

//@WebServlet("/my")
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = 3502218571859280475L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().print("my servlet");
    }
}
