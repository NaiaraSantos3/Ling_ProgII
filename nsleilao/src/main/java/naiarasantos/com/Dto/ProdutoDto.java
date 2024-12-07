package naiarasantos.com.Dto;

import java.util.List;

import naiarasantos.com.Entity.Lance;
import naiarasantos.com.Entity.Leilao;
import naiarasantos.com.Entity.SubCategoriaProduto;

public class ProdutoDto {

    private Integer idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private Double valorInicialProduto;
    private SubCategoriaProduto subCategoriaProduto;
    private Leilao leilao;

    public ProdutoDto() {}
    
    public ProdutoDto(Integer idProduto, String nomeProduto,
                        String descricaoProduto, Double valorInicialProduto, 
                        SubCategoriaProduto subCategoriaProduto, Leilao leilao) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.valorInicialProduto = valorInicialProduto;
        this.subCategoriaProduto = subCategoriaProduto;
        this.leilao = leilao;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Double getValorInicialProduto() {
        return valorInicialProduto;
    }

    public void setValorInicialProduto(Double valorInicialProduto) {
        this.valorInicialProduto = valorInicialProduto;
    }
    public SubCategoriaProduto getSubCategoriaProduto(){
        return subCategoriaProduto;
    }

    public void setSubCategoriaProduto(SubCategoriaProduto subCategoriaProduto){
        this.subCategoriaProduto = subCategoriaProduto;
    }

    public Leilao getLeilao(){
        return leilao;
    }

    public void setLeilao(Leilao leilao){
        this.leilao = leilao;
    }
}
