/*
 * Author: phmiranda
 * Project: album
 * Task Number: HUXXX
 * Description: N/A
 * Date: 14/01/2022
 */

package br.com.phmiranda.album.domain.dto.response;

import br.com.phmiranda.album.domain.entity.Album;
import br.com.phmiranda.album.domain.enums.Situacao;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class AlbumResponse {
    private Long id;
    private String nome;
    private String descricao;
    private Situacao situacao;

    public AlbumResponse(Album album) {
        this.id = album.getId();
        this.nome = album.getNome();
        this.descricao = album.getDescricao();
        this.situacao = album.getSituacao();
    }

    public static Page<AlbumResponse> converter(Page<Album> albuns) {
        return albuns.map(AlbumResponse::new);
    }
}
