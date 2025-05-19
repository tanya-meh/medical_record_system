package com.example.demo.data.repo;

import com.example.demo.data.entity.SickSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SickSheetRepository extends JpaRepository<SickSheet, Long> {
}
