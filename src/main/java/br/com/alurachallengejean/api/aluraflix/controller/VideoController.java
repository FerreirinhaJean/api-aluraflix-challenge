package br.com.alurachallengejean.api.aluraflix.controller;


import br.com.alurachallengejean.api.aluraflix.entities.Video;
import br.com.alurachallengejean.api.aluraflix.entities.dto.GenericResultResponseDto;
import br.com.alurachallengejean.api.aluraflix.entities.dto.RegisterVideoRequestDto;
import br.com.alurachallengejean.api.aluraflix.entities.dto.UpdateVideoRequestDto;
import br.com.alurachallengejean.api.aluraflix.entities.dto.VideoDetailtedResponseDto;
import br.com.alurachallengejean.api.aluraflix.repositories.CategoryRepository;
import br.com.alurachallengejean.api.aluraflix.repositories.VideoRepository;
import br.com.alurachallengejean.api.aluraflix.services.VIdeoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/videos")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private VIdeoService vIdeoService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid RegisterVideoRequestDto videoDto, UriComponentsBuilder uriBuilder) {
        var video = vIdeoService.create(videoDto);
        var uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();

        return ResponseEntity.created(uri).body(new VideoDetailtedResponseDto(video));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        var video = videoRepository.getReferenceById(id);
        if (video.getActive())
            return ResponseEntity.ok(new VideoDetailtedResponseDto(video));

        return new ResponseEntity(new GenericResultResponseDto("Not found"), HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity findAll() {
        var videos = videoRepository.findAllByIsActiveTrue();
        var videosResponseDto = videos.stream().map(VideoDetailtedResponseDto::new).toList();
        return ResponseEntity.ok(videosResponseDto);
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var video = videoRepository.getReferenceById(id);
        video.setActive(false);

        return ResponseEntity.ok(new GenericResultResponseDto("successfully deleted"));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateVideoRequestDto videoRequestDto) {
        var video = videoRepository.getReferenceById(videoRequestDto.id());
        video.updateInfos(videoRequestDto);

        return ResponseEntity.ok(new VideoDetailtedResponseDto(video));
    }

}
