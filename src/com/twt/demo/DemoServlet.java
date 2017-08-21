package com.twt.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by tu on 2017/8/21.
 */
@WebServlet(name = "DemoServlet", urlPatterns={"/DemoServlet"},loadOnStartup=1)
public class DemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getContentType());
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String element = parameterNames.nextElement();
            System.out.println(String.format("name: %s,value: %s", element, request.getParameter(element)));
        }
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.write("<h1> ok!</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
