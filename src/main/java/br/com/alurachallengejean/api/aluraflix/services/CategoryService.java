package br.com.alurachallengejean.api.aluraflix.services;

import br.com.alurachallengejean.api.aluraflix.entities.Category;
import br.com.alurachallengejean.api.aluraflix.infra.exceptions.ExceptionHandlerValidation;
import br.com.alurachallengejean.api.aluraflix.repositories.CategoryRepository;
import br.com.alurachallengejean.api.aluraflix.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private VideoRepository videoRepository;

    public Category delete(Long id) {
        var hasVideosByCategory = videoRepository.existsByCategoryId(id);

        if (hasVideosByCategory)
            throw new ExceptionHandlerValidation("Categoria sendo utilizado em videos");

        Category category = categoryRepository.getReferenceById(id);
        category.setActive(false);

        return category;
    }

}
