package com.example.demo.Controllers.Todo;

import com.example.demo.models.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ViewController {
    @GetMapping("/add-todo")
    public String showAddTodoForm(Todo todoItem) {
        return "addTodo"; // return the name of the HTML file without the extension
    }

    @GetMapping("/todos")
    public String showTodos() {
        return "getTodos"; // return the name of the HTML file without the extension
    }


        @GetMapping("/")
        public String defaultPage() {
            return "index"; // return the name of the HTML file without the extension
        }

}
