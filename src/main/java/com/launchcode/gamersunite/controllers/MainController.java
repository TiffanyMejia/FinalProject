package com.launchcode.gamersunite.controllers;

import com.launchcode.gamersunite.models.User;
import com.launchcode.gamersunite.models.data.PostDao;
import com.launchcode.gamersunite.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.View;

/**
 * Created by LaunchCode
 */

public abstract class MainController {
    @Autowired
    protected PostDao postDao;

    @Autowired
    protected UserDao userDao;



    public static final String userSessionKey = "user_id";

    @ModelAttribute("user")
    protected User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findById(userId).get();
    }

    protected void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getUid());
    }

    @ModelAttribute("userId")
    public Integer getUserIdFromSession(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute(userSessionKey);
    }



}