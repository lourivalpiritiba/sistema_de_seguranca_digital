package com.seguranca_digital.sistema.controller;

import java.util.List;
import javax.validation.Valid;

import com.seguranca_digital.sistema.domain.SistemaModel;
import com.seguranca_digital.sistema.dto.SistemaDTO;
import com.seguranca_digital.sistema.service.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.seguranca_digital.sistema.service.SistemaService;

@RestController
@RequestMapping("/api/sistema")
public class SistemaController {
    @Autowired
    private SistemaService service;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> salvar(
            @Valid @RequestBody SistemaDTO sistemaDto,
            BindingResult result
    ) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationErrorService(result);
        if (errorMap != null) return errorMap;

        SistemaModel sistema = service.fromDto(sistemaDto);
        sistema = service.salvar(sistema);

        return ResponseEntity.ok().body(sistema);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SistemaModel>> listar() {
        List<SistemaModel> sistemas = service.listar();
        return ResponseEntity.ok().body(sistemas);
    }

    @RequestMapping(value = "/pesquisa", method = RequestMethod.GET)
    public ResponseEntity<?> pesquisar(
            @RequestParam(value = "descricao", defaultValue = "") String descricao,
            @RequestParam(value = "sigla", defaultValue = "") String sigla,
            @RequestParam(value = "email", defaultValue = "") String email
    ) {

        List<SistemaModel> sistemas = service.listar(descricao, sigla, email);
        return ResponseEntity.ok().body(sistemas);
    }

    @RequestMapping(value = "/excluir{id}", method = RequestMethod.GET)
    public ResponseEntity<?> excluir(@PathVariable (value = "id") int id){
        service.excluir(id);
        return ResponseEntity.ok().build();
    }


}