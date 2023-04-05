package br.com.alurachallengejean.api.aluraflix.repositories;

import br.com.alurachallengejean.api.aluraflix.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findAllByIsActiveTrue();

    boolean existsByCategoryId(Long id);
}
