package naiarasantos.com.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
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

    @OneToMany(fetch = FetchType.EAGER)
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
        clienteDto.setLance(this.lance);

        return clienteDto;
    }
}
