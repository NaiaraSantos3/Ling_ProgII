package naiarasantos.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
public class ItemVeiculo extends Produto{
    @Id
    @GeneratedValue
    private String modeloVeiculo;
    private String fabricanteVeiculo;
    private int anoVeiculo;
    private String placaVeiculo;
    private String chassi;  
    
    public ItemVeiculo (int idProduto, String nomeProduto, String tipoProduto, String descricaoProduto, 
    Double valorInicialProduto, String tipoVeiculo, String modeloVeiculo,String fabricanteVeiculo, 
    int anoVeiculo,String placaVeiculo,String chassi){
        super (idProduto, nomeProduto, tipoProduto, descricaoProduto, valorInicialProduto); 
        this.modeloVeiculo = modeloVeiculo;
        this.fabricanteVeiculo = fabricanteVeiculo;
        this.anoVeiculo = anoVeiculo; 
        this.placaVeiculo = placaVeiculo;
        this.chassi = chassi;
    }

    public String getModeloVeiculo(){
        return modeloVeiculo;
    }
    
    public void setModeloVeiculo(String modeloVeiculo){
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getFabricanteVeiculo(){
        return fabricanteVeiculo;
    }
    
    public void setFabricanteVeiculo(String fabricanteVeiculo){
        this.fabricanteVeiculo = fabricanteVeiculo;
    }
    
   public int getAnoVeiculo(){
        return anoVeiculo;
   }

   public void setAnoVeiculo(int anoVeiculo){
        this.anoVeiculo = anoVeiculo; 
   }

   public String getPlacaVeiculo(){
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo){
        this.placaVeiculo = placaVeiculo;
    }

    public String getChassi(){
        return chassi;
    }

    public void setChassi(String chassi){
        this.chassi = chassi;
    }

}