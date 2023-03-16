package br.com.alurachallengejean.api.aluraflix.repositories;

import br.com.alurachallengejean.api.aluraflix.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByIsActiveTrue();
}
