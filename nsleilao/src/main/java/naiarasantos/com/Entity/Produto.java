package naiarasantos.com.Entity;

import jakarta.persistence.*;
import naiarasantos.com.Dto.ProdutoDto;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name = "tipo_produto", discriminatorType = DiscriminatorType.STRING) 
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduto;

    private String nomeProduto;
    private String descricaoProduto;
    private Double valorInicialProduto;

    public Produto() {}

    public Produto(String nomeProduto, String descricaoProduto, Double valorInicialProduto) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.valorInicialProduto = valorInicialProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
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

    public ProdutoDto toProdutoDto() {
        return new ProdutoDto(
            this.idProduto,
            this.nomeProduto,
            this.descricaoProduto,
            descricaoProduto, this.valorInicialProduto
        );
    }
}
