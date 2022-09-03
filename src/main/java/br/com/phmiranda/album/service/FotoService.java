/*
 * Author: phmiranda
 * Project: album
 * Task Number: HUXXX
 * Description: N/A
 * Date: 14/01/2022
 */

package br.com.phmiranda.album.service;

import br.com.phmiranda.album.domain.dto.request.FotoRequest;
import br.com.phmiranda.album.domain.dto.response.FotoResponse;
import br.com.phmiranda.album.domain.entity.Foto;
import br.com.phmiranda.album.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FotoService {
    @Autowired
    FotoRepository fotoRepository;

    public Page<FotoResponse> index(Pageable paginacao) {
        Page<Foto> fotos = fotoRepository.findAll(paginacao);
        return FotoResponse.converter(fotos);
    }

    public void salvar(FotoRequest fotoRequest) {

    }

    public void atualizar(Long id) {

    }

    public void desativar(Long id) {
        // busca o objeto na base e mudar a situação para EXCLUIDO (exclusão lógica)
    }

    public void pesquisarId(Long id) {

    }
}
