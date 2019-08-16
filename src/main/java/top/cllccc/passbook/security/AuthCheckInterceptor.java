package top.cllccc.passbook.security;


import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.cllccc.passbook.constant.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h1>权限拦截器</h1>
 */
@Component
public class AuthCheckInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
            throws Exception {
        String token = httpServletRequest.getHeader(Constants.TOKEN_STRING);

        if(StringUtils.isEmpty(token)){
            throw new Exception("Header 中缺少 " + Constants.TOKEN_STRING +"!");
        }

        if(!token.equals(Constants.TOKEN)){
            throw  new Exception("Header中 "+ Constants.TOKEN_STRING+"错误！");
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }


}