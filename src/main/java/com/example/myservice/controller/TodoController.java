package com.example.myservice.controller;

import com.example.myservice.entity.Todo;
import com.example.myservice.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@Slf4j
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/todo")
    @ResponseBody
    public List<Todo> list(){
        return this.todoService.getList();
    }

    @GetMapping("/todo/{id}")
    @ResponseBody
    public String retreive(@PathVariable("id") Long id){
        //@PathVariable 어노테이션으로 클라이언트의 요청 url에서 파라미터를 가져올 수 있다.
        todoService.getListById(id);
        return "complete_retreive";
    }

    @PostMapping("/todo")
    @ResponseBody
    public String create(@RequestBody Todo todo){
        //@RequestBody 어노테이션을 통해 HTTP요청의 Body에 들어있는 값을 To.do 클래스로 매핑할 수 있다.
        todoService.createData(todo);
        return "complete_create";
    }

    @DeleteMapping("/todo/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") Long id){
        todoService.deleteData(id);
    }
}
