/**
 * Project: album
 * User History: nº 999
 * Description: N/A
 * User: Pedro
 */

package br.com.phmiranda.album.domain.dto.request;

import br.com.phmiranda.album.domain.entity.Album;
import br.com.phmiranda.album.domain.enums.Situacao;
import br.com.phmiranda.album.repository.AlbumRepository;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AlbumRequest {
    @NotNull
    @NotBlank
    @NotEmpty
    private String nome;

    @NotNull
    @NotBlank
    @NotEmpty
    private String descricao;
    private Situacao situacao;

    public Album converter() {
        return new Album(nome, descricao);
    }

    public Album atualizarRecurso(Long id, AlbumRepository albumRepository) {
        Album album = albumRepository.getReferenceById(id);
        album.setNome(this.nome);
        album.setDescricao(this.descricao);
        album.setSituacao(this.situacao);
        return album;
    }
}
