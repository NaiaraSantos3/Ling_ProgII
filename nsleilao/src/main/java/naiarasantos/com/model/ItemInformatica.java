package naiarasantos.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ItemInformatica extends Produto {
    @Id
    @GeneratedValue
    private String modeloInformatica; 
    private String marcaInformatica;
    private String numeroSerie;
    
    public ItemInformatica (int idProduto, String nomeProduto, String tipoProduto, String descricaoProduto, 
    Double valorInicialProduto, String modeloInformatica, String marcaInformatica, String numeroSerie){ // Removido o parâmetro tipoInformatica
        super(idProduto, nomeProduto, tipoProduto, descricaoProduto, valorInicialProduto);
        this.modeloInformatica = modeloInformatica;
        this.marcaInformatica = marcaInformatica;
        this.numeroSerie = numeroSerie;
    }

    public String getModeloInformatica(){
        return modeloInformatica;
    }

    public void setModeloInformatica(String modeloInformatica){
        this.modeloInformatica = modeloInformatica;
    }
    
    public String getMarcaInformatica(){
        return marcaInformatica;
    }

    public void setMarcaInformatica(String marcaInformatica){
        this.marcaInformatica = marcaInformatica;
    }
    
    public String getNumeroSerie(){
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie){
        this.numeroSerie = numeroSerie;
    }
}
