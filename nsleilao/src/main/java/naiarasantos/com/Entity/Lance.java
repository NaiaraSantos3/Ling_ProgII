package naiarasantos.com.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Lance {
    @Id
    @GeneratedValue
    private int idLance;
    private Double valorLance;
    private LocalDateTime dataHoraLance;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Leilao leilao;

    @ManyToOne
    private Produto produto;

    public Lance() {}

    public Lance(int idLance, Double valorLance, LocalDateTime dataHoraLance, Cliente cliente, Leilao leilao, Produto produto) {
        this.idLance = idLance;
        this.valorLance = valorLance;
        this.dataHoraLance = dataHoraLance;
        this.cliente = cliente;
        this.leilao = leilao;
        this.produto = produto;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
}
