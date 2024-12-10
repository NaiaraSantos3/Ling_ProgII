package naiarasantos.com.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import naiarasantos.com.Dto.ProdutoDto;

@Setter
@Getter
@Entity
@DiscriminatorValue("MOTO")
public class Moto extends Produto {

    @Column(name = "tipo_moto")
    private String tipoMoto;
    @Setter
    @Id
    private Long motoId;

    public Moto() {}

    public Moto(String nomeProduto, String descricaoProduto, Double valorInicialProduto,
                Leilao leilao, boolean produtoVendido, String tipoMoto) {
        super(nomeProduto, descricaoProduto, valorInicialProduto, leilao, produtoVendido);
        this.tipoMoto = tipoMoto;
    }

    @Override
    public ProdutoDto toProdutoDto() {
        ProdutoDto produtoDto = super.toProdutoDto();
        produtoDto.setTipoMoto(this.tipoMoto);
        return produtoDto;
    }

    public Long getMotoId() {
        return motoId;
    }
}
