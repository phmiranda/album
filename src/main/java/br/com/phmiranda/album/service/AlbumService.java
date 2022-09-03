/*
 * Author: phmiranda
 * Project: album
 * Task Number: HUXXX
 * Description: N/A
 * Date: 14/01/2022
 */

package br.com.phmiranda.album.service;

import br.com.phmiranda.album.domain.dto.request.AlbumRequest;
import br.com.phmiranda.album.domain.dto.response.AlbumResponse;
import br.com.phmiranda.album.domain.entity.Album;
import br.com.phmiranda.album.domain.enums.Situacao;
import br.com.phmiranda.album.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    public Page<AlbumResponse> index(Pageable paginacao) {
        Page<Album> albuns = albumRepository.findAll(paginacao);
        return AlbumResponse.converter(albuns);
    }

    public ResponseEntity<AlbumResponse> salvar(AlbumRequest albumRequest, UriComponentsBuilder uriComponentsBuilder) {
        Album album = albumRequest.converter();
        albumRepository.save(album);
        URI uri = uriComponentsBuilder.path("/albuns/{id}").buildAndExpand(album.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlbumResponse(album));
    }

    public ResponseEntity<AlbumResponse> atualizar(Long id, AlbumRequest albumRequest) {
        Optional<Album> optional = Optional.ofNullable(albumRequest.atualizarRecurso(id, albumRepository));
        if (optional.isPresent()) {
            return ResponseEntity.ok(new AlbumResponse(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> desativar(Long id) {
        Optional<Album> optional = albumRepository.findById(id);

        // faz a exclusão lógica
        if (optional.isPresent() && optional.get().getSituacao() != Situacao.EXCLUIDO) {
            AlbumRequest albumRequest = new AlbumRequest();
            albumRequest.setNome(optional.get().getNome());
            albumRequest.setDescricao(optional.get().getDescricao());
            albumRequest.setSituacao(Situacao.EXCLUIDO);
            albumRequest.atualizarRecurso(id, albumRepository);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<AlbumResponse> pesquisarId(Long id) {
        Optional<Album> optional = albumRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(new AlbumResponse(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public Page<AlbumResponse> pesquisarNome(Pageable paginacao, String nome) {
        Page<Album> albuns = albumRepository.findByNome(paginacao, nome);
        return AlbumResponse.converter(albuns);
    }
}
