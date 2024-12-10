package naiarasantos.com.Dto;

import lombok.Getter;
import lombok.Setter;
import naiarasantos.com.Entity.Leilao;

@Getter
@Setter
public class ProdutoDto {

    private Integer idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private Double valorInicialProduto;
    private Leilao leilao;
    private boolean produtoVendido;


    private String tipoCarro;
    private String tipoMoto;
    private String tipoCaminhao;
    private String tipoUtilitario;
    private String configuracaoNotebook;
    private String tipoMonitor;
    private String tipoSwitch;
    private String tipoRoteador;
    private int entradasUSB;

    public ProdutoDto() {}

    public ProdutoDto(Integer idProduto, String nomeProduto, String descricaoProduto, Double valorInicialProduto,
                      Leilao leilao, boolean produtoVendido) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.valorInicialProduto = valorInicialProduto;
        this.leilao = leilao;
        this.produtoVendido = produtoVendido;
    }
}
