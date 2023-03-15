package br.com.alurachallengejean.api.aluraflix.entities;

import br.com.alurachallengejean.api.aluraflix.entities.dto.RegisterVideoDto;
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

    public Video() {

    }

    public Video(RegisterVideoDto videoDto) {
        this.title = videoDto.title();
        this.description = videoDto.description();
        this.url = videoDto.url();
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
}
