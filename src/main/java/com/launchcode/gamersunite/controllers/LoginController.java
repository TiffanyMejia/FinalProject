package com.launchcode.gamersunite.controllers;
import com.launchcode.gamersunite.models.User;
import com.launchcode.gamersunite.models.forms.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class LoginController extends MainController {
        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String index(Model model) {
                model.addAttribute("heading", "View Posts By Category:");
                return "index";
        }

        @RequestMapping(value = "/login", method = RequestMethod.GET)
        public String login(Model model) {
                model.addAttribute(new Login());
                model.addAttribute("heading", "Log In");
                return "login";
        }

        @RequestMapping(value = "/login", method = RequestMethod.POST)
        public String login(@ModelAttribute @Valid Login form, Errors errors, HttpServletRequest request, Model model) {

                if (errors.hasErrors()) {
                        model.addAttribute("heading", "Log In");
                        return "login";
                }

                User user = userDao.findByUsername(form.getUsername());
                String password = form.getPassword();

                if (user == null) {
                        errors.rejectValue("username", "user.invalid", "The given username does not exist");
                        model.addAttribute("heading", "Log In");
                        return "login";
                }

                if (!user.isMatchingPassword(password)) {
                        errors.rejectValue("password", "password.invalid", "Invalid password");
                        model.addAttribute("heading", "Log In");
                        return "login";
                }

                setUserInSession(request.getSession(), user);

                return "redirect:/";
        }

@RequestMapping(value= "/users", method = RequestMethod.GET)
public String displayUsers(Model model) {
        model.addAttribute("users",userDao.findAll());
        model.addAttribute("heading","All Users");
        return "users";
}
@RequestMapping(value = "/logout", method = RequestMethod.GET)
public String logout(HttpServletRequest request, RedirectAttributes redirectAttributes){
        request.getSession().invalidate();
        redirectAttributes.addFlashAttribute("logout", "You have been logged out");
        return "redirect:/";
        }
        }