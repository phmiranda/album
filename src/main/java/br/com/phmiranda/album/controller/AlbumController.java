/*
 * Author: phmiranda
 * Project: album
 * Task Number: HUXXX
 * Description: N/A
 * Date: 14/01/2022
 */

package br.com.phmiranda.album.controller;

import br.com.phmiranda.album.domain.dto.request.AlbumRequest;
import br.com.phmiranda.album.domain.dto.response.AlbumResponse;
import br.com.phmiranda.album.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/albuns")
public class AlbumController {
    @Autowired
    AlbumService albumService;

    @GetMapping
    public Page<AlbumResponse> listar(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable paginacao) {
        return albumService.index(paginacao);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AlbumResponse> cadastrar(@RequestBody @Valid AlbumRequest albumRequest, UriComponentsBuilder uriComponentsBuilder) {
        return albumService.salvar(albumRequest, uriComponentsBuilder);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<AlbumResponse> atualizar(@PathVariable Long id, @RequestBody @Valid AlbumRequest albumRequest) {
        return albumService.atualizar(id, albumRequest);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        return albumService.desativar(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumResponse> pesquisarPorId(@PathVariable Long id) {
        return albumService.pesquisarId(id);
    }

    @GetMapping("/filtro-nome")
    public Page<AlbumResponse> pesquisarPorNome(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable paginacao, @RequestParam(required = false) String nome) {
        return albumService.pesquisarNome(paginacao, nome);
    }
}
