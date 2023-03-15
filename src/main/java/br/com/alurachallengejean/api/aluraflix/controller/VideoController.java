package br.com.alurachallengejean.api.aluraflix.controller;


import br.com.alurachallengejean.api.aluraflix.entities.Video;
import br.com.alurachallengejean.api.aluraflix.entities.dto.RegisterVideoDto;
import br.com.alurachallengejean.api.aluraflix.repositories.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/videos")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid RegisterVideoDto videoDto) {
        var video = new Video(videoDto);
        videoRepository.save(video);
    }

}
