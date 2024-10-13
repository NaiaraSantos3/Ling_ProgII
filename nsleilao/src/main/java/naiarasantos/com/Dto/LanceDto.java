package naiarasantos.com.Dto;

import java.time.LocalDateTime;

public class LanceDto {
    private int idLance;
    private Double valorLance;
    private LocalDateTime dataHoraLance;
    private String cpfCliente;  
    private int idLeilao;       
    private int idProduto;      

    public LanceDto(){}
    
    public LanceDto(int idLance, Double valorLance, LocalDateTime dataHoraLance, 
                    String cpfCliente, int idLeilao, int idProduto) {
        this.idLance = idLance;
        this.valorLance = valorLance;
        this.dataHoraLance = dataHoraLance;
        this.cpfCliente = cpfCliente;
        this.idLeilao = idLeilao;
        this.idProduto = idProduto;
    }

    public int getIdLance() {
        return idLance;
    }

    public void setIdLance(int idLance) {
        this.idLance = idLance;
    }

    public Double getValorLance() {
        return valorLance;
    }

    public void setValorLance(Double valorLance) {
        this.valorLance = valorLance;
    }

    public LocalDateTime getDataHoraLance() {
        return dataHoraLance;
    }

    public void setDataHoraLance(LocalDateTime dataHoraLance) {
        this.dataHoraLance = dataHoraLance;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public int getIdLeilao() {
        return idLeilao;
    }

    public void setIdLeilao(int idLeilao) {
        this.idLeilao = idLeilao;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
}
