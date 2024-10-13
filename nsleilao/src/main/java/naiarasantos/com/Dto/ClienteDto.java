package naiarasantos.com.Dto;

import java.time.LocalDate;

public class ClienteDto {
    private int idCliente;
    private String cpf;
    private String nomeCliente;
    private LocalDate dataNascimentoCliente;
    private String email;
    private String telefone;

    public ClienteDto() {}

    public ClienteDto(String cpf, String nomeCliente, LocalDate dataNascimentoCliente, 
    String email, String telefone) {
        this.cpf = cpf;
        this.nomeCliente = nomeCliente;
        this.dataNascimentoCliente = dataNascimentoCliente;
        this.email = email;
        this.telefone = telefone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
