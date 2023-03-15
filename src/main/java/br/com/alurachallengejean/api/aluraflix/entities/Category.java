package br.com.alurachallengejean.api.aluraflix.entities;

import br.com.alurachallengejean.api.aluraflix.entities.dto.RegisterCategoryRequestDto;
import jakarta.persistence.*;

@Entity(name = "Category")
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String color;
    @Column(name = "is_active")
    private Boolean isActive;

    public Category() {

    }

    public Category(RegisterCategoryRequestDto categoryRequestDto) {
        this.title = categoryRequestDto.title();
        this.color = categoryRequestDto.color();
        this.isActive = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
