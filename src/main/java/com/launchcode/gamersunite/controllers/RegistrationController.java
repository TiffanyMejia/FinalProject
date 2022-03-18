package com.launchcode.gamersunite.controllers;

import com.launchcode.gamersunite.models.User;
import com.launchcode.gamersunite.models.forms.Register;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegistrationController extends MainController {

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerDisplay(Model model) {
        model.addAttribute(new Register());
        model.addAttribute("heading", "Register");
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@ModelAttribute @Valid Register registerFormData, BindingResult bindingResult,
                           Errors errors, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            System.out.println("ERROR in user Form");
        }
        if (errors.hasErrors()) {
            model.addAttribute("heading", "Register");
            return "register";
        }
        if (!registerFormData.getPassword().equals(registerFormData.getConfirmPassword())) {
            errors.rejectValue("password", "password.invalid", "Passwords do not match");
            model.addAttribute("heading", "Register");
            return "register";
        }

        User existingUser = userDao.findByUsername(registerFormData.getUsername());

        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            model.addAttribute("heading", "Register");
            return "register";
        }
        redirectAttributes.addFlashAttribute("message","Thanks for signing up, you are now logged in");
        User user = new User(registerFormData.getUsername(), registerFormData.getPassword());
        userDao.save(user);
        setUserInSession(request.getSession(), user);

        return "redirect:/";

    }
}





