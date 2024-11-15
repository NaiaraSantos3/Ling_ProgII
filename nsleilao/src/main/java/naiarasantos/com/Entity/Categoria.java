package naiarasantos.com.Entity;

public enum Categoria {
    VEICULO("veículo"),
    DISPOSITIVO_INFORMATICA("dispositivo de informártica");

    private String categoria;
    
    Categoria(String categoria){
        this.categoria = categoria;
    }

    public String getCategoria(){
        return categoria;
    }
    
}
