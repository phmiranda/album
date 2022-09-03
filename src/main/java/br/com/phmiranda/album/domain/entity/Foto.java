/**
 * User: phmiranda
 * Project: album
 * Description: this class execute...!
 * Date: 22/07/2020
 */

package br.com.phmiranda.album.domain.entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "fotos")
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "descricao", nullable = false, columnDefinition = "LONGTEXT")
    private String descricao;

    @Column(name = "endereco", nullable = false, columnDefinition = "LONGTEXT")
    private String endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id", nullable = false)
    private Album albumId;

}
