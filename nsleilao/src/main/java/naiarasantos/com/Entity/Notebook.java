package naiarasantos.com.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import naiarasantos.com.Dto.ProdutoDto;

@Setter
@Getter
@Entity
@DiscriminatorValue("NOTEBOOK")
public class Notebook extends Produto {

    @Column(name = "configuracao_notebook")
    private String configuracaoNotebook;
    @Id
    private Long notebookId;

    public Notebook() {}

    public Notebook(String nomeProduto, String descricaoProduto, Double valorInicialProduto,
                    Leilao leilao, boolean produtoVendido, String configuracaoNotebook) {
        super(nomeProduto, descricaoProduto, valorInicialProduto, leilao, produtoVendido);
        this.configuracaoNotebook = configuracaoNotebook;
    }

    @Override
    public ProdutoDto toProdutoDto() {
        ProdutoDto produtoDto = super.toProdutoDto();
        produtoDto.setConfiguracaoNotebook(this.configuracaoNotebook); // Adiciona este campo no ProdutoDto
        return produtoDto;
    }

}
