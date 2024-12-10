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
@DiscriminatorValue("ROTEADOR")
public class Roteador extends Produto {

    @Column(name = "frequencia_roteador")
    private String frequenciaRoteador;
    @Id
    private Long roteadorId;

    public Roteador() {}

    public Roteador(String nomeProduto, String descricaoProduto, Double valorInicialProduto,
                    Leilao leilao, boolean produtoVendido, String frequenciaRoteador) {
        super(nomeProduto, descricaoProduto, valorInicialProduto, leilao, produtoVendido);
        this.frequenciaRoteador = frequenciaRoteador;
    }

    @Override
    public ProdutoDto toProdutoDto() {
        ProdutoDto produtoDto = super.toProdutoDto();
        produtoDto.setTipoRoteador(this.frequenciaRoteador); // Adiciona o atributo específico ao DTO
        return produtoDto;
    }

}
