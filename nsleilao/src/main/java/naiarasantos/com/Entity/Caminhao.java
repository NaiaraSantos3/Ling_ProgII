package naiarasantos.com.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import naiarasantos.com.Dto.ProdutoDto;

@Setter
@Getter
@Entity
@DiscriminatorValue("CAMINHAO")
public class Caminhao extends Produto {

    @Column(name = "tipo_caminhao")
    private String tipoCaminhao;
    @Id
    private Long caminhaoId;

    public Caminhao() {}

    public Caminhao(String nomeProduto, String descricaoProduto, Double valorInicialProduto,
                    Leilao leilao, boolean produtoVendido, String tipoCaminhao) {

        super(nomeProduto, descricaoProduto, valorInicialProduto, leilao, produtoVendido);
        this.tipoCaminhao = tipoCaminhao;
    }

    @Override
    public ProdutoDto toProdutoDto() {
        ProdutoDto produtoDto = super.toProdutoDto();
        produtoDto.setTipoCaminhao(this.tipoCaminhao);
        return produtoDto;
    }

}
