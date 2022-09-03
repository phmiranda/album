/**
 * User: phmiranda
 * Project: album
 * Description: this class execute...!
 * Date: 22/07/2020
 */

package br.com.phmiranda.album.domain.entity;

import br.com.phmiranda.album.domain.enums.Situacao;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "albuns")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "descricao", nullable = false, columnDefinition = "LONGTEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao", nullable = false, columnDefinition = "ENUM")
    private Situacao situacao = Situacao.PENDENTE;

    public Album(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Album() {

    }
}
