package br.com.alurachallengejean.api.aluraflix.controller;

import br.com.alurachallengejean.api.aluraflix.entities.Category;
import br.com.alurachallengejean.api.aluraflix.entities.dto.CategoryDetailtedResponseDto;
import br.com.alurachallengejean.api.aluraflix.entities.dto.RegisterCategoryRequestDto;
import br.com.alurachallengejean.api.aluraflix.repositories.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid RegisterCategoryRequestDto categoryRequestDto, UriComponentsBuilder uriBuilder) {
        var category = new Category(categoryRequestDto);
        categoryRepository.save(category);
        var uri = uriBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(uri).body(new CategoryDetailtedResponseDto(category));
    }

}
