package naiarasantos.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import java.time.LocalDate;

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

    public Cliente(int idCliente, String cpf, String nomeCliente, LocalDate dataNascimentoCliente ,String email,  String telefone) {
        this.idCliente = idCliente;
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

    public LocalDate getDataNascimentoCliente(){
        return dataNascimentoCliente;
    }

    public void setDataNascimentoCliente(LocalDate dataNascimentoCliente){
        this.dataNascimentoCliente = dataNascimentoCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
}
