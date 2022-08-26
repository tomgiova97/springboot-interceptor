package com.tomgiova.springinterceptor;

import com.tomgiova.springinterceptor.exceptions.TokenExpiredException;
import com.tomgiova.springinterceptor.exceptions.TokenNotValidException;
import com.tomgiova.springinterceptor.services.AuthenticationService;
import com.tomgiova.springinterceptor.utils.InterceptorUtils;
import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class RequestProcessingInterceptor implements HandlerInterceptor {

    private final List<Map<String,String>> unprotectedURIs;

    private final AuthenticationService authenticationService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("PreHandle method");
        String requestMethod = request.getMethod();
        String requestURI = request.getRequestURI();

        boolean isUriUnprotected = InterceptorUtils.isUriUnprotected(Collections.singletonMap(requestMethod,requestURI));
        if (!isUriUnprotected) {

            String authenticationToken = InterceptorUtils.extractBearerToken(request.getHeader("Authorization"));

            try {
                if (authenticationService.isAuthenticationTokenValid(authenticationToken)){
                    return true;
                }
                else {return false;}
            } catch (TokenExpiredException e) {
                response.setStatus(403);
            } catch (TokenNotValidException e) {
                response.setStatus(403);
            } catch (Exception e) {
                response.setStatus(500);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("PostHandle method");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion method");
    }
}
