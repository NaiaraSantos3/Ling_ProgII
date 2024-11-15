package naiarasantos.com.Dto;

import java.util.List;

import naiarasantos.com.Entity.Leilao;

public class BancoDto {
    private int idBanco;
    private String nomeBanco;
    private String cnpjBanco;
    private String codigoBanco;
    private List<Leilao> leilao;

    public BancoDto() {}

    public BancoDto(int idBanco, String nomeBanco, String cnpjBanco, String codigoBanco, 
    List<Leilao> leilao) {
        this.idBanco = idBanco;
        this.nomeBanco = nomeBanco;
        this.cnpjBanco = cnpjBanco;
        this.codigoBanco = codigoBanco;
        this.leilao = leilao;
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

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public List<Leilao> getLeilao (){
        return leilao;
    }

    public void setLeilao(List<Leilao> leilao){
        this.leilao = leilao;
    } 
}
