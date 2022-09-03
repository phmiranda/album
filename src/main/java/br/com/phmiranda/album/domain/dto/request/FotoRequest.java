/**
 * Project: album
 * User History: nº 999
 * Description: N/A
 * User: Pedro
 */

package br.com.phmiranda.album.domain.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class FotoRequest {
    @NotNull
    @NotBlank
    @NotEmpty
    private String nome;

    @NotNull
    @NotBlank
    @NotEmpty
    private String descricao;

    @NotNull
    @NotBlank
    @NotEmpty
    private String endereco;

    @NotNull
    @NotBlank
    @NotEmpty
    private Integer album_id;
}
