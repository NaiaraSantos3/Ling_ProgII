package naiarasantos.com.Dto;

import java.time.LocalDateTime;

import naiarasantos.com.Entity.Cliente;
import naiarasantos.com.Entity.Leilao;
import naiarasantos.com.Entity.Produto;

public class LanceDto {
    private Integer idLance;
    private Double valorLance;
    private LocalDateTime dataHoraLance;
    private Cliente cliente;
    private Leilao leilao;
    private Produto produto;

    public LanceDto(){}
    
    public LanceDto(Integer idLance, Double valorLance, LocalDateTime dataHoraLance, 
                    Cliente Cliente, Leilao leilao, Produto produto) {
        this.idLance = idLance;
        this.valorLance = valorLance;
        this.dataHoraLance = dataHoraLance;
        this.cliente = Cliente;
        this.leilao = leilao;
        this.produto = produto;
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

    public Cliente getCliente() {
        return cliente;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCliente'");
    }
}
