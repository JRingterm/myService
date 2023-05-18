package com.example.myservice.service;

import com.example.myservice.ResourceNotFoundException;
import com.example.myservice.entity.Todo;
import com.example.myservice.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    //모두 가져오기
    public List<Todo> getList(){
        return this.todoRepository.findAll();
    }
    //id로 찾기
    public Todo getListById(Long id){
        return todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo", "id", id));
    }
    //생성
    public Todo createData(Todo todo){
        return todoRepository.save(todo);
    }
    //id로 삭제
    public void deleteData(Long id){
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo", "id", id));
        todoRepository.delete(todo);
    }
}
