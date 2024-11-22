package naiarasantos.com.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import naiarasantos.com.Dto.BancoDto;

@Entity
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idBanco;

    private String nomeBanco;

    @Column(unique = true)
    private String cnpjBanco;

    private String codigoBanco; 

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "banco_leilao",
    joinColumns = @JoinColumn(name = "id_banco"),
    inverseJoinColumns = @JoinColumn(name = "id_leilao"))
    private List<Leilao> leilao;
    
    public Banco() {}

    public Banco(Integer idBanco, String nomeBanco, String cnpjBanco, String codigoBanco, List<Leilao> leilao) {
        this.idBanco = idBanco; 
        this.nomeBanco = nomeBanco;
        this.cnpjBanco = cnpjBanco;
        this.codigoBanco = codigoBanco;
        this.leilao = leilao;
    }

    public int getIdBanco() {
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

    public String getCodigoBanco(){
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco){
        this.codigoBanco = codigoBanco;
    }

    public List<Leilao> getLeilao (){
        return leilao;
    }

    public void setLeilao(List<Leilao> leilao){
        this.leilao = leilao;
    }

    public BancoDto bancoDto() {
        BancoDto bancoDto = new BancoDto();
        bancoDto.setIdBanco(this.idBanco);
        bancoDto.setNomeBanco(this.nomeBanco);
        bancoDto.setCnpjBanco(this.cnpjBanco);
        bancoDto.setCodigoBanco(this.codigoBanco);
        bancoDto.setLeilao(this.leilao);
        return bancoDto;
    }
}
