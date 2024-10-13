package naiarasantos.com.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import naiarasantos.com.Dto.ItemVeiculoDto;

@Entity
@DiscriminatorValue("VEICULO") 
public class ItemVeiculo extends Produto {

    private String modeloVeiculo;
    private String fabricanteVeiculo;
    private int anoVeiculo;
    private String placaVeiculo;
    private String chassi;

    public ItemVeiculo() {}

    public ItemVeiculo(String nomeProduto, String descricaoProduto, Double valorInicialProduto,
                       String modeloVeiculo, String fabricanteVeiculo, int anoVeiculo, 
                       String placaVeiculo, String chassi) {
        super(nomeProduto, descricaoProduto, valorInicialProduto); 
        this.modeloVeiculo = modeloVeiculo;
        this.fabricanteVeiculo = fabricanteVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.placaVeiculo = placaVeiculo;
        this.chassi = chassi;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getFabricanteVeiculo() {
        return fabricanteVeiculo;
    }

    public void setFabricanteVeiculo(String fabricanteVeiculo) {
        this.fabricanteVeiculo = fabricanteVeiculo;
    }

    public int getAnoVeiculo() {
        return anoVeiculo;
    }

    public void setAnoVeiculo(int anoVeiculo) {
        this.anoVeiculo = anoVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public ItemVeiculoDto toItemVeiculoDto() {

        throw new UnsupportedOperationException("Unimplemented method 'toItemVeiculoDto'");
    }
}
