package br.com.alurachallengejean.api.aluraflix.controller;


import br.com.alurachallengejean.api.aluraflix.entities.Video;
import br.com.alurachallengejean.api.aluraflix.entities.dto.RegisterVideoRequestDto;
import br.com.alurachallengejean.api.aluraflix.entities.dto.RegisterVideoResponseDto;
import br.com.alurachallengejean.api.aluraflix.repositories.VideoRepository;
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
@RequestMapping(value = "/videos")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid RegisterVideoRequestDto videoDto, UriComponentsBuilder uriBuilder) {
        var video = new Video(videoDto);
        videoRepository.save(video);
        var uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();

        return ResponseEntity.created(uri).body(new RegisterVideoResponseDto(video));
    }

}
