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
@DiscriminatorValue("MONITOR")
public class Monitor extends Produto {

    @Column(name = "resolucao_monitor")
    private String resolucaoMonitor;
    @Id
    private Long monitorId;

    public Monitor() {}

    public Monitor(String nomeProduto, String descricaoProduto, Double valorInicialProduto,
                   Leilao leilao, boolean produtoVendido, String resolucaoMonitor) {
        super(nomeProduto, descricaoProduto, valorInicialProduto, leilao, produtoVendido);
        this.resolucaoMonitor = resolucaoMonitor;
    }

    @Override
    public ProdutoDto toProdutoDto() {
        ProdutoDto produtoDto = super.toProdutoDto();
        produtoDto.setTipoMonitor(this.resolucaoMonitor);
        return produtoDto;
    }

}
