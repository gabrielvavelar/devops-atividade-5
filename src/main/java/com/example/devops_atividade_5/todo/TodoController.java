package com.example.devops_atividade_5.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoRepository todoRepository;

    @PostMapping()
    public Todo saveTodo(@RequestBody Todo todo){
        return todoRepository.save(todo);
    }

    @GetMapping()
    public List<Todo> GetAllTodos(){
        return todoRepository.findAll();
    }
}
