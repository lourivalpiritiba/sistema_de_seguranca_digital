package com.seguranca_digital.sistema.domain;

import com.seguranca_digital.sistema.domain.enums.EnumStatusSistema;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SistemaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String sigla;
    private String url;
    private String email;
    private EnumStatusSistema status;

    public SistemaModel() {
    }

    public SistemaModel(Long id, String descricao, String sigla, String url, String email, EnumStatusSistema status) {
        super();
        this.id = id;
        this.descricao = descricao;
        this.sigla = sigla;
        this.url = url;
        this.email = email;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnumStatusSistema getStatus() {
        return status;
    }

    public void setStatus(EnumStatusSistema status) {
        this.status = status;
    }
}