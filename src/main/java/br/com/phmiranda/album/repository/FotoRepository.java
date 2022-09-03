/**
 * User: phmiranda
 * Project: album
 * Description: this class execute...!
 * Date: 22/07/2020
 */

package br.com.phmiranda.album.repository;

import br.com.phmiranda.album.domain.entity.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {

}
