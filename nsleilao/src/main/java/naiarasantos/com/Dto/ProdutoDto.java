package naiarasantos.com.Dto;

import java.util.List;

import naiarasantos.com.Entity.Lance;
import naiarasantos.com.Entity.Leilao;
import naiarasantos.com.Entity.SubCategoriaProduto;

public class ProdutoDto {

    private Integer idProduto;
    private String nomeProduto;
    private String tipoProduto;
    private String descricaoProduto;
    private Double valorInicialProduto;
    private SubCategoriaProduto subCategoriaProduto;
    private Leilao leilao;
    private List<Lance> lance;



    public ProdutoDto() {}
    
    public ProdutoDto(Integer idProduto, String nomeProduto, String tipoProduto, 
                        String descricaoProduto, Double valorInicialProduto, 
                        SubCategoriaProduto subCategoriaProduto, Leilao leilao, 
                        List<Lance> lance) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.tipoProduto = tipoProduto;
        this.descricaoProduto = descricaoProduto;
        this.valorInicialProduto = valorInicialProduto;
        this.subCategoriaProduto = subCategoriaProduto;
        this.leilao = leilao;
        this.lance = lance;
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

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
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

    public List<Lance> getLance (){
        return lance;
    }

    public void setLance(List<Lance> lance){
        this.lance = lance;
    }
}
