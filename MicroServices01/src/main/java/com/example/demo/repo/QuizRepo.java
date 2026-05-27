package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.QuizModel;

public interface QuizRepo extends JpaRepository<QuizModel, Long>{

}
