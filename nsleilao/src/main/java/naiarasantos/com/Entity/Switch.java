package naiarasantos.com.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import naiarasantos.com.Dto.ProdutoDto;

@Setter
@Getter
@Entity
@DiscriminatorValue("SWITCH")
public class Switch extends Produto {

    @Column(name = "numero_portas_switch")
    private Integer numeroPortas;
    @Setter
    @Id
    private Long switchId;

    public Switch() {}

    public Switch(String nomeProduto, String descricaoProduto, Double valorInicialProduto,
                  Leilao leilao, boolean produtoVendido, Integer numeroPortas) {
        super(nomeProduto, descricaoProduto, valorInicialProduto, leilao, produtoVendido);
        this.numeroPortas = numeroPortas;
    }

    @Override
    public ProdutoDto toProdutoDto() {
        ProdutoDto produtoDto = super.toProdutoDto();
        produtoDto.setTipoSwitch(this.numeroPortas != null ? numeroPortas + " portas" : null);
        return produtoDto;
    }

    public Long getSwitchId() {
        return switchId;
    }
}
