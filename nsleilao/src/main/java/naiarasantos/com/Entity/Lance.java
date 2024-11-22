package naiarasantos.com.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import naiarasantos.com.Dto.LanceDto;



@Entity
public class Lance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLance;
    private Double valorLance;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinTable(name = "lance_cliente", 
    joinColumns = @JoinColumn (name = "id_lance"),
    inverseJoinColumns = @JoinColumn (name = "id_cliente"))
    private Cliente cliente;


    @OneToOne (fetch = FetchType.EAGER)
    @JoinTable(name = "lance_produto",
    joinColumns = @JoinColumn (name = "id_lance"),
    inverseJoinColumns = @JoinColumn (name = "id_produto"))
    private Produto produto;

    public Lance() {}

    public Lance(Integer idLance, Double valorLance, 
                LocalDateTime localDateTime, Cliente cliente, Leilao leilao, Produto produto) {
        this.idLance = idLance;
        this.valorLance = valorLance;
        this.cliente = cliente;
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


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public LanceDto lanceDto(){
        LanceDto lanceDto = new LanceDto();
        lanceDto.setIdLance(this.idLance);
        lanceDto.setValorLance(this.valorLance);
        lanceDto.setCliente(this.cliente);
        lanceDto.setProduto(this.produto);
        return lanceDto;


    }

    public LocalDateTime getDataHoraLance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDataHoraLance'");
    }

    public LanceDto getLeilao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLeilao'");
    }

    public void setDataHoraLance(LocalDateTime dataHoraLance) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDataHoraLance'");
    }



}
