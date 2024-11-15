package naiarasantos.com.Entity;

public enum SubCategoriaProduto {
    
    CARRO(Categoria.VEICULO,"Carro de Passeio"),
    MOTO(Categoria.VEICULO,"Motocicleta"),
    CAMINHAO(Categoria.VEICULO, "Caminhão"),
    UTILITARIO(Categoria.VEICULO, "Utilitário"),
    NOTEBOOK(Categoria.DISPOSITIVO_INFORMATICA, "Notebook"),
    MONITOR(Categoria.DISPOSITIVO_INFORMATICA, "Monitor"),
    HUB(Categoria.DISPOSITIVO_INFORMATICA, "HUB"),
    SWITCH(Categoria.DISPOSITIVO_INFORMATICA,"Switch"),
    ROTEADOR(Categoria.DISPOSITIVO_INFORMATICA,"Roteador");

    private Categoria categoria;
    private String subCategoriaProduto;

    SubCategoriaProduto( Categoria categoria, String subCategoriaProduto) {
        this.categoria = categoria;
        this.subCategoriaProduto = subCategoriaProduto;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    public String getSubCategoriaProduto(){
        return subCategoriaProduto;
    }
}
