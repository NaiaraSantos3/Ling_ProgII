package naiarasantos.com.Dto;

public class BancoDto {
    private int idBanco;
    private String nomeBanco;
    private String cnpjBanco;
    private String codigoBanco;

    public BancoDto() {}

    public BancoDto(int idBanco, String nomeBanco, String cnpjBanco, String codigoBanco) {
        this.idBanco = idBanco;
        this.nomeBanco = nomeBanco;
        this.cnpjBanco = cnpjBanco;
        this.codigoBanco = codigoBanco;
    }

    // Getters e Setters
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
}
