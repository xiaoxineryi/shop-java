package com.xiaoxin.ac.Interceptors;

import com.xiaoxin.ac.Entity.User;
import com.xiaoxin.ac.Error.CustomerError;
import com.xiaoxin.ac.Service.UserService;
import com.xiaoxin.ac.Utils.RespUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String token = request.getHeader("Authorizatoin");
        /* 判断是否有该用户

        * * */
        User user = userService.findUserByToken(token);
        if(user !=null){
            request.getSession().setAttribute("user", user);
        }
        return true;

    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
