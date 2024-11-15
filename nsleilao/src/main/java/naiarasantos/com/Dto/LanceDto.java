package naiarasantos.com.Dto;

import java.time.LocalDateTime;

import naiarasantos.com.Entity.Cliente;

public class LanceDto {
    private Integer idLance;
    private Double valorLance;
    private LocalDateTime dataHoraLance;
    private String cpfCliente;  
    private Integer idLeilao;       
    private Integer idProduto;      

    public LanceDto(){}
    
    public LanceDto(Integer idLance, Double valorLance, LocalDateTime dataHoraLance, 
                    String cpfCliente, Integer idLeilao, Integer idProduto) {
        this.idLance = idLance;
        this.valorLance = valorLance;
        this.dataHoraLance = dataHoraLance;
        this.cpfCliente = cpfCliente;
        this.idLeilao = idLeilao;
        this.idProduto = idProduto;
    }

    public Integer getIdLance() {
        return idLance;
    }

    public void setIdLance(Integer idLance) {
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

    public Integer getIdLeilao() {
        return idLeilao;
    }

    public void setIdLeilao(Integer idLeilao) {
        this.idLeilao = idLeilao;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public void setCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCliente'");
    }
}
