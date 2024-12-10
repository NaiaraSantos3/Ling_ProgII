package naiarasantos.com.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import naiarasantos.com.Dto.ProdutoDto;

@Setter
@Getter
@Entity
@DiscriminatorValue("HUB")
public class Hub extends Produto {

    @Column(name = "entradas_usb")
    private int entradasUSB;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hubId;

    public Hub() {}

    public Hub(String nomeProduto, String descricaoProduto, Double valorInicialProduto,
               Leilao leilao, boolean produtoVendido, int entradasUSB) {
        super(nomeProduto, descricaoProduto, valorInicialProduto, leilao, produtoVendido);
        this.entradasUSB = entradasUSB;
    }

    @Override
    public ProdutoDto toProdutoDto() {
        ProdutoDto produtoDto = super.toProdutoDto();
        produtoDto.setEntradasUSB(this.entradasUSB);
        return produtoDto;
    }
}
