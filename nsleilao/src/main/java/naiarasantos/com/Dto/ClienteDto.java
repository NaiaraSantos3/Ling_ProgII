package naiarasantos.com.Dto;

import naiarasantos.com.Entity.Lance;

import java.time.LocalDate;
import java.util.List;

public class ClienteDto {
    private Integer idCliente;
    private String cpf;
    private String nomeCliente;
    private LocalDate dataNascimentoCliente;
    private List<Lance> lance;

    // Construtor que aceita todos os campos
    public ClienteDto(Integer idCliente, String cpf, String nomeCliente, LocalDate dataNascimentoCliente, List<Lance> lance) {
        this.idCliente = idCliente;
        this.cpf = cpf;
        this.nomeCliente = nomeCliente;
        this.dataNascimentoCliente = dataNascimentoCliente;
        this.lance = lance;
    }

    // Getters e Setters
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDate getDataNascimentoCliente() {
        return dataNascimentoCliente;
    }

    public void setDataNascimentoCliente(LocalDate dataNascimentoCliente) {
        this.dataNascimentoCliente = dataNascimentoCliente;
    }

    public List<Lance> getLance() {
        return lance;
    }

    public void setLance(List<Lance> lance) {
        this.lance = lance;
    }
}
