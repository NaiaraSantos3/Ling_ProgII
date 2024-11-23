package naiarasantos.com.Dto;

import naiarasantos.com.Entity.Banco;
import naiarasantos.com.Entity.Leilao;
import naiarasantos.com.Entity.Produto;

import java.time.LocalDate;
import java.util.List;

public class DetalhesLeilaoDTO {

    private List<String> produtos;
    private List<String> bancos;
    private Leilao leilao;
    private Integer quantidadeDeProdutos;

    public DetalhesLeilaoDTO(List<String> produtos, List<String> bancos, Leilao leilao, Integer quantidadeDeProdutos) {
        this.produtos = produtos;
        this.bancos = bancos;
        this.leilao = leilao;
        this.quantidadeDeProdutos = quantidadeDeProdutos;
    }

    public List<String> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<String> produtos) {
        this.produtos = produtos;
    }

    public List<String> getBancos() {
        return bancos;
    }

    public void setBancos(List<String> bancos) {
        this.bancos = bancos;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }

    public Integer getQuantidadeDeProdutos() {
        return quantidadeDeProdutos;
    }

    public void setQuantidadeDeProdutos(Integer quantidadeDeProdutos) {
        this.quantidadeDeProdutos = quantidadeDeProdutos;
    }
}
