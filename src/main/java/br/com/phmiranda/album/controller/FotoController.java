/*
 * Author: phmiranda
 * Project: album
 * Task Number: HUXXX
 * Description: N/A
 * Date: 14/01/2022
 */

package br.com.phmiranda.album.controller;

import br.com.phmiranda.album.domain.dto.response.FotoResponse;
import br.com.phmiranda.album.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fotos")
public class FotoController {
    @Autowired
    FotoService fotoService;

    @GetMapping
    public Page<FotoResponse> listar(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable paginacao) {
        return fotoService.index(paginacao);
    }
}
