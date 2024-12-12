package naiarasantos.com.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import naiarasantos.com.Dto.ProdutoDto;

@Setter
@Getter
@Entity
@DiscriminatorValue("UTILITARIO")
public class Utilitario extends Produto {

    @Column(name = "tipo_utilitario")
    private String tipoUtilitario;
    @Id
    private Long utilitarioId;

    public Utilitario() {}

    public Utilitario(String nomeProduto, String descricaoProduto, Double valorInicialProduto,
                      Leilao leilao, boolean produtoVendido, String tipoUtilitario) {
        super(nomeProduto, descricaoProduto, valorInicialProduto, leilao, produtoVendido);
        this.tipoUtilitario = tipoUtilitario;
    }

    @Override
    public ProdutoDto toProdutoDto() {
        ProdutoDto produtoDto = super.toProdutoDto();
        produtoDto.setTipoUtilitario(this.tipoUtilitario);
        return produtoDto;
    }

}
