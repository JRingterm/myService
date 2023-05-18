package com.example.myservice.repository;

import com.example.myservice.entity.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional
public class TodoRepository {
    private final EntityManager em;

    public List<Todo> findAll() {
        return em.createQuery("select m from Todo m")
                .getResultList();
    }

    public Optional<Todo> findById(Long id) {
        List<Todo> result =  em.createQuery("select m from Todo m where m.id =:id", Todo.class)
                .setParameter("id", id)
                .getResultList();
        return result.stream().findFirst();
    }

    public Todo save(Todo todo) {
        em.persist(todo);
        return todo;
    }

    public void delete(Todo todo) {
        em.remove(todo);
    }

}
