package com.seguranca_digital.sistema.dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import com.seguranca_digital.sistema.validation.ExtendedEmailValidator;
import org.hibernate.validator.constraints.Length;

public class SistemaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Dados obrigatórios não informados.")
    @Length(max = 100, message = "O campo deve ter até 100 caracteres")
    private String descricao;

    @NotBlank(message = "Dados obrigatórios não informados.")
    @Length(max = 10, message = "O campo deve ter até 10 caracteres")
    private String sigla;

    @Length(max = 50, message = "O campo deve ter até 50 caracteres")
    private String url;

    @NotBlank(message = "Dados obrigatórios não informados.")
    @Length(max = 100, message = "O campo deve ter até 100 caracteres")
    @ExtendedEmailValidator
    private String email;

    public SistemaDTO() { }

    public SistemaDTO(String descricao, String sigla, String url, String email) {
        super();
        this.descricao = descricao;
        this.sigla = sigla;
        this.url = url;
        this.email = email;
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

}