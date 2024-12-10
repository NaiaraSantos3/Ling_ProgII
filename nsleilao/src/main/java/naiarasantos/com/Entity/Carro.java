package naiarasantos.com.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import naiarasantos.com.Dto.ProdutoDto;

@Setter
@Getter
@Entity
@DiscriminatorValue("CARRO")
public class Carro extends Produto {

    @Column(name = "tipo_carro")
    private String tipoCarro;
    @Id
    private Long carroId;

    public Carro() {}

    public Carro(String nomeProduto, String descricaoProduto, Double valorInicialProduto,
                 Leilao leilao,boolean produtoVendido, String tipoCarro) {
        super(nomeProduto, descricaoProduto, valorInicialProduto, leilao, produtoVendido);
        this.tipoCarro = tipoCarro;
    }

    @Override
    public ProdutoDto toProdutoDto() {
        ProdutoDto produtoDto = super.toProdutoDto();
        produtoDto.setTipoCarro(this.tipoCarro);
        return produtoDto;
    }

}
