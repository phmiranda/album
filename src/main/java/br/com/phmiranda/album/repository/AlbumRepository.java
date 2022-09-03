/**
 * User: phmiranda
 * Project: album
 * Description: this class execute...!
 * Date: 22/07/2020
 */

package br.com.phmiranda.album.repository;

import br.com.phmiranda.album.domain.entity.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {
    Page<Album> findByNome(Pageable paginacao, String nome);
}
