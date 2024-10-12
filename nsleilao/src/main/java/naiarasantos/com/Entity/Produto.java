package naiarasantos.com.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import naiarasantos.com.Dto.ProdutoDto;
import jakarta.persistence.GeneratedValue;


@Entity
public class Produto {
    @Id
    @GeneratedValue
    private int idProduto;
    private String nomeProduto;
    private String tipoProduto;
    private String descricaoProduto;
    private Double valorInicialProduto;


    public Produto (int idProduto, String nomeProduto, String tipoProduto, String descricaoProduto, 
    Double valorInicialProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.tipoProduto = tipoProduto;
        this.descricaoProduto = descricaoProduto;
        this.valorInicialProduto = valorInicialProduto;
    }

    public int getIdProduto(){
        return idProduto;
    }

    public void setIdProduto(int idProduto){
        this.idProduto = idProduto;
    }

    public String getNomeProduto(){
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }

    public String getTipoProduto (){
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto){
        this.tipoProduto = tipoProduto;
    }

    public String getDescricaoProduto(){
        return descricaoProduto;
    }
    
    public void setDescricaoProduto(String descricaoProduto){
        this.descricaoProduto = descricaoProduto;

    }

    public Double getValorInicialProduto(){
        return valorInicialProduto;
    }      
    
    public void setValorInicialProduto(Double valorInicialProduto){
        this.valorInicialProduto = valorInicialProduto;
    }

    public ProdutoDto produtoDto(){
        ProdutoDto produtoDto = new ProdutoDto();
        produtoDto.setIdProduto(this.idProduto);
        produtoDto.setNomeProduto(this.nomeProduto);
        produtoDto.setTipoProduto(this.tipoProduto);
        produtoDto.setDescricaoProduto(this.descricaoProduto);
        produtoDto.setValorInicialProduto(this.valorInicialProduto);
        return produtoDto;
    }
    
}
