package br.com.alurachallengejean.api.aluraflix.controller;


import br.com.alurachallengejean.api.aluraflix.entities.Video;
import br.com.alurachallengejean.api.aluraflix.entities.dto.RegisterVideoRequestDto;
import br.com.alurachallengejean.api.aluraflix.entities.dto.VideoDetailtedResponseDto;
import br.com.alurachallengejean.api.aluraflix.repositories.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
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

        return ResponseEntity.created(uri).body(new VideoDetailtedResponseDto(video));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        var video = videoRepository.getReferenceById(id);
        return ResponseEntity.ok(new VideoDetailtedResponseDto(video));
    }

    @GetMapping
    public ResponseEntity findAll() {
        var videos = videoRepository.findAll();
        var videosResponseDto = videos.stream().map(VideoDetailtedResponseDto::new).toList();
        return ResponseEntity.ok(videosResponseDto);
    }

}
