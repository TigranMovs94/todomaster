package com.example.demo.Controllers.User;

import com.example.demo.models.Todo;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model){
        model.addAttribute("user",new User());
        return "User/registration";

    }

    @GetMapping("/success")
    public String registrationSuccess(){
        return "User/registration_success";
    }


    @PostMapping("/add-user")
    public String createTodoItem(@Valid User user, BindingResult result, Model model){
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(user.getPassword());
        userService.createUser(user);
        return "redirect:/success";


    }





}
