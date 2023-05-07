package com.example.demo.Controllers.Todo;

import com.example.demo.models.Todo;
import com.example.demo.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetTodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping ("/get-todos")
    public ModelAndView getTodos(){
        ModelAndView modelAndView = new ModelAndView("getTodos");
        modelAndView.addObject("todoItems", todoService.getAllTodos());

        return modelAndView;

    }
}
