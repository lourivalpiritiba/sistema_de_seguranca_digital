package com.seguranca_digital.sistema.service;

import java.util.List;

import com.seguranca_digital.sistema.domain.SistemaModel;
import com.seguranca_digital.sistema.domain.enums.EnumStatusSistema;
import com.seguranca_digital.sistema.dto.SistemaDTO;
import com.seguranca_digital.sistema.repository.SistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SistemaService {

    @Autowired
    private SistemaRepository sistemaRepository;

    public SistemaModel salvar(SistemaModel sistema) {
        sistema.setStatus(EnumStatusSistema.ATIVO);
        return sistemaRepository.save(sistema);
    }

    public List<SistemaModel> listar() {
        return sistemaRepository.findAll();
    }

    public List<SistemaModel> listar(String descricao, String sigla, String email) {
        return sistemaRepository.listar(
                descricao.toUpperCase(),
                sigla.toUpperCase(),
                email.toUpperCase()
        );
    }

    public SistemaModel fromDto(SistemaDTO objDto) {
        SistemaModel obj = new SistemaModel(null,
                objDto.getDescricao(),
                objDto.getSigla(),
                objDto.getUrl(),
                objDto.getEmail(),
                null);
        return obj;
    }
}