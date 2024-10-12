package naiarasantos.com.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import naiarasantos.com.Dto.ItemInformaticaDto;

@Entity
public class ItemInformatica extends Produto {
    @Id
    @GeneratedValue
    private int idInformatica; 
    private String modeloInformatica; 
    private String marcaInformatica;
    private String numeroSerie;
    
    public ItemInformatica(int idProduto, String nomeProduto, String tipoProduto, String descricaoProduto, 
                           Double valorInicialProduto, String modeloInformatica, String marcaInformatica, String numeroSerie) {
        super(idProduto, nomeProduto, tipoProduto, descricaoProduto, valorInicialProduto);
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
        return new ItemInformaticaDto(
            this.getIdProduto(), this.getNomeProduto(), this.getTipoProduto(), this.getDescricaoProduto(),
            this.getValorInicialProduto(), this.modeloInformatica, this.marcaInformatica, this.numeroSerie
        );
    }
}
