package com.example.myservice;

import com.example.myservice.entity.Todo;
import com.example.myservice.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyserviceApplicationTests {

	@Autowired
	private TodoRepository todoRepository;

	@Test
	void testJpa(){
		Todo todo1 = new Todo();
		todo1.setContent("밥먹기022");
		todo1.setCompleted(Boolean.TRUE);
		this.todoRepository.save(todo1);

		Todo todo2 = new Todo();
		todo2.setContent("스프링공부하기2");
		todo2.setCompleted(Boolean.TRUE);
		this.todoRepository.save(todo2);
	}

}
