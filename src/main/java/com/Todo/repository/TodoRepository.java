package com.Todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Todo.entity.Todo;

	@Repository
	public interface TodoRepository extends JpaRepository<Todo, Long> {
	    
	    List<Todo> findByIsCompletedFalse();
	    
	    List<Todo> findByTitleContainingIgnoreCase(String title);
	    
	    @Query("SELECT t FROM Todo t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
	    List<Todo> searchByTitle(@Param("searchTerm") String searchTerm);
	}


