package naiarasantos.com.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import naiarasantos.com.Dto.LeilaoDto;
import java.time.LocalDate;

@Entity
public class Leilao {
    @Id
    @GeneratedValue
    private int idLeilao;
    private LocalDate dataAberturaLeilao;
    private LocalDate dataEncerramentoLeilao;
    private LocalDate dataVisitaProduto;
    private String siteLeilao;
    private String enderecoFisicoLeilao;
    private String cidadeLeilao;
    private String estadoLeilao;
    private String statusLeilao;


    public Leilao() {}

    public Leilao(int idLeilao, LocalDate dataAberturaLeilao, LocalDate dataEncerramentoLeilao,
                  LocalDate dataVisitaProduto, String siteLeilao, String enderecoFisicoLeilao, 
                  String cidadeLeilao, String estadoLeilao, String statusLeilao) {
        this.idLeilao = idLeilao;
        this.dataAberturaLeilao = dataAberturaLeilao;
        this.dataEncerramentoLeilao = dataEncerramentoLeilao;
        this.dataVisitaProduto = dataVisitaProduto;
        this.siteLeilao = siteLeilao;
        this.enderecoFisicoLeilao = enderecoFisicoLeilao;
        this.cidadeLeilao = cidadeLeilao;
        this.estadoLeilao = estadoLeilao;
        this.statusLeilao = statusLeilao;
    }

    public int getIdLeilao() {
        return idLeilao;
    }

    public void setIdLeilao(int idLeilao) {
        this.idLeilao = idLeilao;
    }

    public LocalDate getDataAberturaLeilao() {
        return dataAberturaLeilao;
    }

    public void setDataAberturaLeilao(LocalDate dataAberturaLeilao) {
        this.dataAberturaLeilao = dataAberturaLeilao;
    }

    public LocalDate getDataEncerramentoLeilao() {
        return dataEncerramentoLeilao;
    }

    public void setDataEncerramentoLeilao(LocalDate dataEncerramentoLeilao) {
        this.dataEncerramentoLeilao = dataEncerramentoLeilao;
    }

    public LocalDate getDataVisitaProduto() {
        return dataVisitaProduto;
    }

    public void setDataVisitaProduto(LocalDate dataVisitaProduto) {
        this.dataVisitaProduto = dataVisitaProduto;
    }

    public String getSiteLeilao() {
        return siteLeilao;
    }

    public void setSiteLeilao(String siteLeilao) {
        this.siteLeilao = siteLeilao;
    }

    public String getEnderecoFisicoLeilao() {
        return enderecoFisicoLeilao;
    }

    public void setEnderecoFisicoLeilao(String enderecoFisicoLeilao) {
        this.enderecoFisicoLeilao = enderecoFisicoLeilao;
    }

    public String getCidadeLeilao() {
        return cidadeLeilao;
    }

    public void setCidadeLeilao(String cidadeLeilao) {
        this.cidadeLeilao = cidadeLeilao;
    }

    public String getEstadoLeilao() {
        return estadoLeilao;
    }

    public void setEstadoLeilao(String estadoLeilao) {
        this.estadoLeilao = estadoLeilao;
    }

    public String getStatusLeilao() {
        return statusLeilao;
    }

    public void setStatusLeilao(String statusLeilao) {
        this.statusLeilao = statusLeilao;
    }

  
    public LeilaoDto leilaoDto() {
        LeilaoDto leilaoDto = new LeilaoDto();
        leilaoDto.setIdLeilao(this.idLeilao);
        leilaoDto.setDataAberturaLeilao(this.dataAberturaLeilao);
        leilaoDto.setDataEncerramentoLeilao(this.dataEncerramentoLeilao);
        leilaoDto.setDataVisitaProduto(this.dataVisitaProduto);
        leilaoDto.setSiteLeilao(this.siteLeilao);
        leilaoDto.setEnderecoFisicoLeilao(this.enderecoFisicoLeilao);
        leilaoDto.setCidadeLeilao(this.cidadeLeilao);
        leilaoDto.setEstadoLeilao(this.estadoLeilao);
        leilaoDto.setStatusLeilao(this.statusLeilao);
        return leilaoDto;
    }
}
