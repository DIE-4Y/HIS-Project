package edu.nenu.hisserver.interceptor;

import com.alibaba.fastjson.JSONObject;
import edu.nenu.hisserver.pojo.Result;
import edu.nenu.hisserver.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

@Component
@Slf4j
@CrossOrigin
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取url地址
        String url = request.getRequestURI();
        log.info("请求的url: {}", url);

        // 打印所有请求头
//        log.info("请求头信息:");
//        Collections.list(request.getHeaderNames()).forEach(headerName -> {
//            String headerValue = request.getHeader(headerName);
//            log.info("{}: {}", headerName, headerValue);
//        });
        // 判断路径是否是登录
        if (url.contains("login")) {
            log.info("登录请求，放行");
            return true;
        }

        // 判断是否含有jwt令牌
        String jwt = request.getHeader("token");
        if (!StringUtils.hasLength(jwt)) {
            log.info("没有jwt令牌");
            Result error = Result.error("NOT_LOGIN");
            response.getWriter().write(JSONObject.toJSONString(error));
            return false;
        }

        // 解析令牌
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            log.info("令牌解析失败");
            Result error = Result.error("NOT_LOGIN");
            response.getWriter().write(JSONObject.toJSONString(error));
            return false;
        }
        // 解析成功
        return true;
    }
}
