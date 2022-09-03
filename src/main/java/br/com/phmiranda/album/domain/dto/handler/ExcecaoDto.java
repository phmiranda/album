/**
 * Project: album
 * User History: nº 999
 * Description: N/A
 * User: Pedro
 */

package br.com.phmiranda.album.domain.dto.handler;

import lombok.Data;

@Data
public class ExcecaoDto {
    private String chave;
    private String valor;

    public ExcecaoDto(String chave, String valor) {
        this.chave = chave;
        this.valor = valor;
    }
}
