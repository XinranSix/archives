package com.lemon.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.lemon.reggie.common.BaseContext;
import com.lemon.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否完成登录
 */
@Slf4j
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    // 路径匹配器
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    /**
     * 请求拦截器
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 1. 获取本次请求的 URI
        String requestURI = request.getRequestURI();
        log.info("拦截到请求：{}", requestURI);
        // 2. 检查是否已登录
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/sendMsg",
                "/user/login",
                "/doc.html",
                "/webjars/**",
                "/swagger-resources",
                "/v2/api-docs"
        };
        boolean check = check(urls, requestURI);
        // 3. 如果不需要做处理，则直接放行
        if (check) {
            // 放行
            log.info("本次请求{}不需要处理", requestURI);
            filterChain.doFilter(servletRequest, response);
            return;
        }
        // 4-1. 判断登录状态，如果已登录，则直接放行
        if (request.getSession().getAttribute("employee") != null) {
            // 已登录，放行
            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);
            long id = Thread.currentThread().getId();
            filterChain.doFilter(servletRequest, response);
            return;
        }

        // 4-2. 判断登录状态，如果已登录，则直接放行
        if (request.getSession().getAttribute("user") != null) {
            // 已登录，放行
            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);
            long id = Thread.currentThread().getId();
            filterChain.doFilter(servletRequest, response);
            return;
        }
        log.info("用户未登录");
        //5. 代码执行到此处说明未登录，通过输出流的方式向客户端页面响应数据
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
    }

    /**
     * 路径匹配，检查本次请求是否可以放行
     *
     * @param urls       放行白名单
     * @param requestURI 当前访问路径
     * @return 是否放行
     */
    public boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) {
                return true;
            }
        }
        return false;
    }
}
