package br.com.alurachallengejean.api.aluraflix.repositories;

import br.com.alurachallengejean.api.aluraflix.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
