/*
 * Author: phmiranda
 * Project: album
 * Task Number: HUXXX
 * Description: N/A
 * Date: 14/01/2022
 */

package br.com.phmiranda.album.domain.dto.response;

import br.com.phmiranda.album.domain.entity.Album;
import br.com.phmiranda.album.domain.entity.Foto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class FotoResponse {
    private Long id;
    private String descricao;
    private String endereco;
    private Album album_id;

    public FotoResponse(Foto foto) {
        this.id = foto.getId();
        this.descricao = foto.getDescricao();
        this.endereco = foto.getEndereco();
        this.album_id = foto.getAlbumId();
    }

    public static Page<FotoResponse> converter(Page<Foto> fotos) {
        return fotos.map(FotoResponse::new);
    }
}
