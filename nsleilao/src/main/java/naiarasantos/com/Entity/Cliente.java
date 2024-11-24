package naiarasantos.com.Entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import naiarasantos.com.Dto.ClienteDto;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCliente;

    private String cpf;

    private String nomeCliente;

    @Column (name = "data_nascimento_cliente")
    private LocalDate dataNascimentoCliente;

    @OneToMany(fetch = FetchType.EAGER, mappedBy ="cliente",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Lance> lance;


    public Cliente() {}

    public Cliente(String cpf, String nomeCliente, LocalDate dataNascimentoCliente,
                    List<Lance> lance) {
        this.cpf = cpf;
        this.nomeCliente = nomeCliente;
        this.dataNascimentoCliente = dataNascimentoCliente;
        this.lance = lance;

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

    public List<Lance> getLance (){
        return lance;
    }

    public void setLance(List<Lance> lance){
        this.lance = lance;
    }

    public ClienteDto clienteDto() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setIdCliente(this.idCliente);
        clienteDto.setCpf(this.cpf);
        clienteDto.setNomeCliente(this.nomeCliente);
        clienteDto.setDataNascimentoCliente(this.dataNascimentoCliente);

        return clienteDto;
    }
}
