package com.chen.crm.web.filter;

import javax.servlet.*;
import java.io.IOException;

//设置post请求的字符集
public class EncodingFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //设置请求的字符集
        req.setCharacterEncoding("utf-8");
        //设置响应的字符集
        resp.setContentType("text/html;charset=utf-8");
        //放行
        chain.doFilter(req,resp);
    }
}
