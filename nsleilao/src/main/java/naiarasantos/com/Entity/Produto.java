package naiarasantos.com.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import naiarasantos.com.Dto.ProdutoDto;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
//@DiscriminatorColumn(name = "produto", discriminatorType = DiscriminatorType.STRING)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto")
    private Integer idProduto;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "descricao_produto")
    private String descricaoProduto;

    @Column(name = "valor_inicial_produto")
    private Double valorInicialProduto;

    @Enumerated(EnumType.STRING)
    @Column(name = "sub_categoria_produto",nullable = false, columnDefinition = "VARCHAR (255)")
    private SubCategoriaProduto subCategoriaProduto;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn
    @JsonBackReference
    private Leilao leilao;

    public Produto() {}

    public Produto(String nomeProduto, String descricaoProduto, Double valorInicialProduto,
                    SubCategoriaProduto subCategoriaProduto, Leilao leilao) {
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

    public SubCategoriaProduto getSubCategoriaProduto(){
        return subCategoriaProduto;
    }

    public Leilao getLeilao(){
        return leilao;
    }

    public void setLeilao(Leilao leilao){
        this.leilao = leilao;
    }


    public ProdutoDto toProdutoDto() {
            ProdutoDto produtoDto = new ProdutoDto();
            produtoDto.setIdProduto(this.idProduto);
            produtoDto.setNomeProduto(this.nomeProduto);
            produtoDto.setDescricaoProduto(this.descricaoProduto);
            produtoDto.setSubCategoriaProduto(this.subCategoriaProduto);
            produtoDto.setLeilao(this.leilao);
            return produtoDto;
    }
}
