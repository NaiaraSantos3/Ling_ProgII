package naiarasantos.com.Dto;

public class ItemInformaticaDto extends ProdutoDto {
    private String modeloInformatica; 
    private String marcaInformatica;
    private String numeroSerie;
    
    public ItemInformaticaDto(){}

    public ItemInformaticaDto(int idProduto, String nomeProduto, String tipoProduto, 
                            String descricaoProduto, Double valorInicialProduto, 
                            String modeloInformatica, String marcaInformatica, 
                            String numeroSerie) { 
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
}
