package naiarasantos.com.Dto;

import java.time.LocalDate;
import java.util.List;

import naiarasantos.com.Entity.Lance;

public class ClienteDto {
    private int idCliente;
    private String cpf;
    private String nomeCliente;
    private LocalDate dataNascimentoCliente;
    private List<Lance> lance;

    public ClienteDto() {}

    public ClienteDto(String cpf, String nomeCliente, LocalDate dataNascimentoCliente,
    List<Lance> lance) {
        this.cpf = cpf;
        this.nomeCliente = nomeCliente;
        this.lance = lance;

    }

    public int getidCliente(){
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
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

    public List<Lance> getLance (){
        return lance;
    }

    public void setLance(List<Lance> lance){
        this.lance = lance;
    }


}
