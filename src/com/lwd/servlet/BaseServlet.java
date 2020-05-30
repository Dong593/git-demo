package com.lwd.servlet;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BaseServlet extends HttpServlet {

    protected void sendJson(Object obj,HttpServletResponse resp)throws ServletException, IOException {
        //创建输出流对象
        resp.setContentType("application/json;charset=utf-8");
        // 告诉浏览器，我这个谁都可以拿
        resp.setHeader("Access-Control-Allow-Origin","*");

        // 把数据封装为json格式
        String listJson = JSONObject.toJSONString(obj);

        PrintWriter pw = resp.getWriter();
        //输出数据
        pw.write(listJson);
        pw.flush();

        pw.close();



    }


}
