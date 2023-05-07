package com.example.demo.Controllers.Todo;

import com.example.demo.models.Todo;
import com.example.demo.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.lang.module.ModuleFinder;
import java.util.Optional;

@Controller
public class TodoFormController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/todo")
    public String createTodoItem(@Valid Todo todoItem, BindingResult result, Model model){
        Todo item = new Todo();
        item.setTitle(todoItem.getTitle());
        item.setCompleted(todoItem.isCompleted());
        todoService.createTodo(item);
        return "redirect:/get-todos";


    }

    @GetMapping ("/delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id,Model model) {
       Todo todoItem = todoService
               .getTodoById(id)
               .orElseThrow(()-> new IllegalArgumentException("Todo not found"));
       todoService.deleteTodo(todoItem.getId());
       return "redirect:/get-todos";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Todo todoItem = todoService
                .getTodoById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        model.addAttribute("todo", todoItem);
        return "editTodo";
    }

    @PostMapping("/editTodo/{id}")
    public String updateTodoItem(@PathVariable("id") Long id, @Valid Todo todoItem, BindingResult result, Model model) {

        Todo item = todoService
                .getTodoById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));


        item.setTitle(todoItem.getTitle());

        todoService.createTodo(item);

        return "redirect:/get-todos";
    }


    @GetMapping("/editStatus/{id}")
    public String updateItemStatus(@PathVariable("id") Long id, @Valid Todo todoItem, BindingResult result, Model model) {

        Todo item = todoService
                .getTodoById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));


        item.setCompleted(true);

        todoService.updateTodo(id,item);

        return "redirect:/get-todos";
    }

    @GetMapping("/incomplete/{id}")
    public String makeIncomplete(@PathVariable("id") Long id, @Valid Todo todoItem, BindingResult result, Model model) {

        Todo item = todoService
                .getTodoById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));


        item.setCompleted(false);

        todoService.updateTodo(id,item);

        return "redirect:/get-todos";
    }


}
