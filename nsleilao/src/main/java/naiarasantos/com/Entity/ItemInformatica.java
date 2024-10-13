package naiarasantos.com.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import naiarasantos.com.Dto.ItemInformaticaDto;

@Entity
@DiscriminatorValue("INFORMATICA") 
public class ItemInformatica extends Produto {

    private String modeloInformatica;
    private String marcaInformatica;
    private String numeroSerie;

    public ItemInformatica() {}

    public ItemInformatica(String nomeProduto, String descricaoProduto, Double valorInicialProduto,
                           String modeloInformatica, String marcaInformatica, String numeroSerie) {
        super(nomeProduto, descricaoProduto, valorInicialProduto); 
        this.modeloInformatica = modeloInformatica;
        this.marcaInformatica = marcaInformatica;
        this.numeroSerie = numeroSerie;
    }

    public String getModeloInformatica() {
        return modeloInformatica;
    }

    public void setModeloInformatica(String modeloInformatica) {
        this.modeloInformatica = modeloInformatica;
    }

    public String getMarcaInformatica() {
        return marcaInformatica;
    }

    public void setMarcaInformatica(String marcaInformatica) {
        this.marcaInformatica = marcaInformatica;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public ItemInformaticaDto toItemInformaticatoDto() {
       
        throw new UnsupportedOperationException("Método 'toItemInformaticatoDto' não implementado");
    }
}
