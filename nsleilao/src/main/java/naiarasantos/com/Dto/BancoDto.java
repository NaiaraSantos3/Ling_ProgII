package naiarasantos.com.Dto;

import java.util.List;

import naiarasantos.com.Entity.Leilao;

public class BancoDto {
    private Integer idBanco;
    private String nomeBanco;
    private String cnpjBanco;
    private String codigoBanco;
    private List<Leilao> leilao;

    public BancoDto() {}

    public BancoDto(Integer idBanco, String nomeBanco, String cnpjBanco, String codigoBanco, 
    List<Leilao> leilao) {
        this.idBanco = idBanco;
        this.nomeBanco = nomeBanco;
        this.cnpjBanco = cnpjBanco;
        this.codigoBanco = codigoBanco;
        this.leilao = leilao;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
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
