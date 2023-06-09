package br.com.alurachallengejean.api.aluraflix.controller;

import br.com.alurachallengejean.api.aluraflix.entities.Category;
import br.com.alurachallengejean.api.aluraflix.entities.dto.CategoryDetailtedResponseDto;
import br.com.alurachallengejean.api.aluraflix.entities.dto.GenericResultResponseDto;
import br.com.alurachallengejean.api.aluraflix.entities.dto.RegisterCategoryRequestDto;
import br.com.alurachallengejean.api.aluraflix.entities.dto.UpdateCategoryRequestDto;
import br.com.alurachallengejean.api.aluraflix.repositories.CategoryRepository;
import br.com.alurachallengejean.api.aluraflix.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid RegisterCategoryRequestDto categoryRequestDto, UriComponentsBuilder uriBuilder) {
        var category = new Category(categoryRequestDto);
        categoryRepository.save(category);
        var uri = uriBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(uri).body(new CategoryDetailtedResponseDto(category));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        var category = categoryRepository.getReferenceById(id);
        if (category.getActive())
            return ResponseEntity.ok(new CategoryDetailtedResponseDto(category));

        return new ResponseEntity(new GenericResultResponseDto("Not found"), HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity findAll() {
        var categories = categoryRepository.findAllByIsActiveTrue();
        var categoriesDto = categories.stream().map(CategoryDetailtedResponseDto::new).toList();
        return ResponseEntity.ok(categoriesDto);
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var category = categoryService.delete(id);
//        var category = categoryRepository.getReferenceById(id);
//        category.setActive(false);
        return ResponseEntity.ok(new GenericResultResponseDto("successfully deleted"));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateCategoryRequestDto categoryRequestDto) {
        var category = categoryRepository.getReferenceById(categoryRequestDto.id());
        category.updateInfos(categoryRequestDto);
        return ResponseEntity.ok(new CategoryDetailtedResponseDto(category));
    }

}
