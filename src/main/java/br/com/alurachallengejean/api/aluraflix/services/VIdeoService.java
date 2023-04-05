package br.com.alurachallengejean.api.aluraflix.services;

import br.com.alurachallengejean.api.aluraflix.entities.Category;
import br.com.alurachallengejean.api.aluraflix.entities.Video;
import br.com.alurachallengejean.api.aluraflix.entities.dto.RegisterVideoRequestDto;
import br.com.alurachallengejean.api.aluraflix.repositories.CategoryRepository;
import br.com.alurachallengejean.api.aluraflix.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VIdeoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Video create(RegisterVideoRequestDto videoDto) {
        Category category;
        if (videoDto.idCategory() == null)
            category = categoryRepository.getReferenceById(1L);
        else
            category = categoryRepository.getReferenceById(videoDto.idCategory());

        Video video = new Video(videoDto);
        video.setCategory(category);
        videoRepository.save(video);

        return video;
    }

}
