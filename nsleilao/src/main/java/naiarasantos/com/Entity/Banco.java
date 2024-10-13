package naiarasantos.com.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import naiarasantos.com.Dto.BancoDto;

@Entity
public class Banco {
    @Id
    @GeneratedValue
    private int idBanco; 
    private String nomeBanco;
    private String cnpjBanco;
    private String codigoBanco; 

    public Banco() {}

    public Banco(int idBanco, String nomeBanco, String cnpjBanco, String codigoBanco) {
        this.idBanco = idBanco; 
        this.nomeBanco = nomeBanco;
        this.cnpjBanco = cnpjBanco;
        this.codigoBanco = codigoBanco;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getCnpjBanco() {
        return cnpjBanco;
    }

    public void setCnpjBanco(String cnpjBanco) {
        this.cnpjBanco = cnpjBanco;
    }

    public String getCodigoBanco(){
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco){
        this.codigoBanco = codigoBanco;
    }

    // Método para converter para DTO
    public BancoDto bancoDto() {
        BancoDto bancoDto = new BancoDto();
        bancoDto.setIdBanco(this.idBanco);
        bancoDto.setNomeBanco(this.nomeBanco);
        bancoDto.setCnpjBanco(this.cnpjBanco);
        bancoDto.setCodigoBanco(this.codigoBanco);
        return bancoDto;
    }
}
