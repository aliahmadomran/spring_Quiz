package com.example.quiz.repository;

import com.example.quiz.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepo extends JpaRepository<Sale,Long> {
}
