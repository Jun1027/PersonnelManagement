package jun.commons;

import lombok.extern.log4j.Log4j;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * 统一异常处理
 * Create by Jun on 2020-05-26
 */
@Component
@Log4j
public class MyException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) {
        e.printStackTrace();
        LocalDateTime now = LocalDateTime.now();
        log.error("【"+now+"】：程序出现错误！在【"+handler+"】出现异常，异常信息为：【"+e.getMessage()+"】");
        ModelAndView mv = new ModelAndView();
        if(e instanceof UnauthorizedException){
            mv.setViewName("unauthorized");
        }else if(e instanceof AuthorizationException){
            mv.setViewName("redirect:/login.jsp");
        }else{
            mv.setViewName("error");
        }
        return mv;
    }
}
