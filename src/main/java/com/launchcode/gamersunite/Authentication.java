package com.launchcode.gamersunite;

import com.launchcode.gamersunite.controllers.MainController;
import com.launchcode.gamersunite.models.User;
import com.launchcode.gamersunite.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Authentication extends HandlerInterceptorAdapter {

    @Autowired
    UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        List<String> nonAuthPages = Arrays.asList("/", "/login","/register", "/users", "/posts/list");

        // Require sign-in for auth pages
        if (!nonAuthPages.contains(request.getRequestURI())) {

            boolean isLoggedIn = false;
            User user;
            Integer userId = (Integer) request.getSession().getAttribute(MainController.userSessionKey);

            if (userId != null) {
                user = userDao.findById(userId).get();

                if (user != null)
                    isLoggedIn = true;
            }

            // If user not logged in, redirect to login page
            if (!isLoggedIn) {
                response.sendRedirect("/login");
                return false;
            }
        }
        return true;
    }
}





