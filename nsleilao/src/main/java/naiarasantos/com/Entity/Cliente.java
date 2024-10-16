package naiarasantos.com.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import naiarasantos.com.Dto.ClienteDto;

@Entity
public class Cliente {
    @Id
    @GeneratedValue
    private int idCliente;
    private String cpf;
    private String nomeCliente;
    private LocalDate dataNascimentoCliente;
    private String email;
    private String telefone;

    public Cliente() {}

    public Cliente(String cpf, String nomeCliente, LocalDate dataNascimentoCliente,
                    String email, String telefone) {
        this.cpf = cpf;
        this.nomeCliente = nomeCliente;
        this.dataNascimentoCliente = dataNascimentoCliente;
        this.email = email;
        this.telefone = telefone;
    }

    public int getIdCliente() {
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

    public ClienteDto clienteDto() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setIdCliente(idCliente);
        clienteDto.setCpf(this.cpf);
        clienteDto.setNomeCliente(this.nomeCliente);
        clienteDto.setDataNascimentoCliente(this.dataNascimentoCliente);
        clienteDto.setEmail(this.email);
        clienteDto.setTelefone(this.telefone);
        return clienteDto;
    }
}
