package br.com.alurachallengejean.api.aluraflix.entities;

import br.com.alurachallengejean.api.aluraflix.entities.dto.RegisterVideoRequestDto;
import jakarta.persistence.*;

@Entity(name = "Video")
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String url;
    @Column(name = "is_active")
    private Boolean isActive;

    public Video() {

    }

    public Video(RegisterVideoRequestDto videoDto) {
        this.title = videoDto.title();
        this.description = videoDto.description();
        this.url = videoDto.url();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
