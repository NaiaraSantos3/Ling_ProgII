package naiarasantos.com.Entity;

import java.util.List;

import jakarta.persistence.*;
import naiarasantos.com.Dto.ProdutoDto;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name = "tipo_produto", discriminatorType = DiscriminatorType.STRING) 
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

    @Column(name = "sub_categoria_produto")
    private SubCategoriaProduto subCategoriaProduto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_leilao")
    private Leilao leilao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "produto_lance",
    joinColumns = @JoinColumn (name = "id_produto"),
    inverseJoinColumns = @JoinColumn (name = "id_lance"))
    private List<Lance> lance;


    public Produto() {}

    public Produto(String nomeProduto, String descricaoProduto, Double valorInicialProduto,
                    SubCategoriaProduto subCategoriaProduto, Leilao leilao, List<Lance> lance) {
        this.nomeProduto = nomeProduto;
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


    public ProdutoDto toProdutoDto() {
            ProdutoDto produtoDto = new ProdutoDto();
            produtoDto.setIdProduto(this.idProduto);
            produtoDto.setNomeProduto(this.nomeProduto);
            produtoDto.setDescricaoProduto(this.descricaoProduto);
            produtoDto.setSubCategoriaProduto(this.subCategoriaProduto);
            produtoDto.setLeilao(this.leilao);
            produtoDto.setLance(this.lance);
            return produtoDto;
    }
}
