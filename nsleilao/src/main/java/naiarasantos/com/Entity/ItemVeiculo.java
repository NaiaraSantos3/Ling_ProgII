package naiarasantos.com.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import naiarasantos.com.Dto.ItemVeiculoDto;

@Entity
public class ItemVeiculo extends Produto {
    @Id
    @GeneratedValue
    private int idVeiculo; // Definir um id próprio para o veículo ou usar o idProduto
    private String modeloVeiculo;
    private String fabricanteVeiculo;
    private int anoVeiculo;
    private String placaVeiculo;
    private String chassi;
    
    // Construtor da classe
    public ItemVeiculo(int idProduto, String nomeProduto, String tipoProduto, String descricaoProduto,
                       Double valorInicialProduto, String modeloVeiculo, String fabricanteVeiculo,
                       int anoVeiculo, String placaVeiculo, String chassi) {
        super(idProduto, nomeProduto, tipoProduto, descricaoProduto, valorInicialProduto); 
        this.modeloVeiculo = modeloVeiculo;
        this.fabricanteVeiculo = fabricanteVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.placaVeiculo = placaVeiculo;
        this.chassi = chassi;
    }

    // Getters e Setters
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

    // Método para converter para o DTO
    public ItemVeiculoDto toItemVeiculoDto() {
        return new ItemVeiculoDto(
            this.getIdProduto(), this.getNomeProduto(), this.getTipoProduto(), this.getDescricaoProduto(),
            this.getValorInicialProduto(), this.modeloVeiculo, this.fabricanteVeiculo, 
            this.anoVeiculo, this.placaVeiculo, this.chassi
        );
    }
}
