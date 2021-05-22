package com.seguranca_digital.sistema.controller;

import java.util.List;
import javax.validation.Valid;

import com.seguranca_digital.sistema.domain.SistemaModel;
import com.seguranca_digital.sistema.dto.SistemaDTO;
import com.seguranca_digital.sistema.service.MapValidationErrorService;
import com.seguranca_digital.sistema.service.Messages;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    Messages messages;

    @PostMapping()
    public Object salvar(
            @Valid @RequestBody SistemaDTO sistemaDto,
            BindingResult result
    ) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationErrorService(result);
        if (errorMap != null){
            return errorMap;
        }else {
            SistemaModel sistema = service.fromDto(sistemaDto);
            service.salvar(sistema);
            return messages.get("msg.success");
        }
    }

    @GetMapping()
    public Object listar() {
        List<SistemaModel> sistemas = service.listar();
        if(sistemas.size() == 0){
            return messages.get("msg.error.db");
        }else{
            return ResponseEntity.ok().body(sistemas);
        }
    }

    @GetMapping(value = "/pesquisa")
    public Object pesquisar(
            @RequestParam(value = "descricao", defaultValue = "") String descricao,
            @RequestParam(value = "sigla", defaultValue = "") String sigla,
            @RequestParam(value = "email", defaultValue = "") String email
    ) {
        List<SistemaModel> sistemas = service.listar(descricao, sigla, email);
        if(sistemas.size() == 0){
            return messages.get("msg.error");
        }else{
            return ResponseEntity.ok().body(sistemas);
        }
    }
}