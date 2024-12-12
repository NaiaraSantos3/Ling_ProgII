package naiarasantos.com.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import naiarasantos.com.Dto.ProdutoDto;
import naiarasantos.com.Entity.Leilao;

@Entity
@Table(name = "produto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_produto", discriminatorType = DiscriminatorType.STRING)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer idProduto;

    @Column(name = "nome_produto", nullable = false, length = 100)
    private String nomeProduto;

    @Column(name = "descricao_produto")
    private String descricaoProduto;

    @Column(name = "valor_inicial_produto", nullable = false)
    private Double valorInicialProduto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_leilao", nullable = false)
    @JsonBackReference
    private Leilao leilao;

    @Column(name = "produto_vendido", nullable = false)
    private boolean produtoVendido;

    public Produto() {
    }

    public Produto(String nomeProduto, String descricaoProduto, Double valorInicialProduto,
                   Leilao leilao, boolean produtoVendido) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.valorInicialProduto = valorInicialProduto;
        this.leilao = leilao;
        this.produtoVendido = produtoVendido;
    }


    public ProdutoDto toProdutoDto() {
        ProdutoDto produtoDto = new ProdutoDto();
        produtoDto.setIdProduto(this.idProduto);
        produtoDto.setNomeProduto(this.nomeProduto);
        produtoDto.setDescricaoProduto(this.descricaoProduto);
        produtoDto.setLeilao(this.leilao);
        produtoDto.setValorInicialProduto(this.valorInicialProduto);
        produtoDto.setProdutoVendido(this.produtoVendido);
        return produtoDto;
    }
}
