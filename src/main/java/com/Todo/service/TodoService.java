package com.Todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Todo.entity.Todo;
import com.Todo.repository.TodoRepository;

@Service
public class TodoService {
	
	    
	    @Autowired
	    private TodoRepository todoRepository;
	    
	    // Get all todos
	    public List<Todo> getAllTodos() {
	        return todoRepository.findAll();
	    }
	    
	    // Get pending todos only
	    public List<Todo> getPendingTodos() {
	        return todoRepository.findByIsCompletedFalse();
	    }
	    
	    // Get todo by ID
	    public Optional<Todo> getTodoById(Long id) {
	        return todoRepository.findById(id);
	    }
	    
	    // Create new todo
	    public Todo createTodo(Todo todo) {
	        return todoRepository.save(todo);
	    }
	    
	    // Update todo
	    public Todo updateTodo(Long id, Todo todoDetails) {
	        Optional<Todo> todo = todoRepository.findById(id);
	        
	        if (todo.isPresent()) {
	            Todo existingTodo = todo.get();
	            existingTodo.setTitle(todoDetails.getTitle());
	            existingTodo.setDescription(todoDetails.getDescription());
	            existingTodo.setDueDate(todoDetails.getDueDate());
	            existingTodo.setIsCompleted(todoDetails.getIsCompleted());
	            return todoRepository.save(existingTodo);
	        }
	        return null;
	    }
	    
	    // Delete todo
	    public void deleteTodo(Long id) {
	        todoRepository.deleteById(id);
	    }
	    
	    // Search todos
	    public List<Todo> searchTodos(String searchTerm) {
	        return todoRepository.searchByTitle(searchTerm);
	    }
	    
	    // Mark as complete
	    public Todo markComplete(Long id) {
	        Optional<Todo> todo = todoRepository.findById(id);
	        if (todo.isPresent()) {
	            Todo existingTodo = todo.get();
	            existingTodo.setIsCompleted(true);
	            return todoRepository.save(existingTodo);
	        }
	        return null;
	    }

}




