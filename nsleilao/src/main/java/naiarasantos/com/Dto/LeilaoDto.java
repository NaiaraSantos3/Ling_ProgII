package naiarasantos.com.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import naiarasantos.com.Entity.Banco;
import naiarasantos.com.Entity.Produto;

public class LeilaoDto {

    private Integer idLeilao;
    private LocalDateTime dataAberturaLeilao;
    private LocalDateTime dataEncerramentoLeilao;
    private LocalDateTime dataVisitaProduto;
    private String siteLeilao;
    private String enderecoFisicoLeilao; 
    private String cidadeLeilao;
    private String estadoLeilao;
    private List<Produto> produto;
    private List<Banco> banco;

    public LeilaoDto() {}

    public LeilaoDto(Integer idLeilao, LocalDateTime dataAberturaLeilao, LocalDateTime dataEncerramentoLeilao,
                     LocalDateTime dataVisitaProduto, String siteLeilao, String enderecoFisicoLeilao,
                     String cidadeLeilao, String estadoLeilao, List<Produto> produto,
                     List<Banco> banco) {
        this.idLeilao = idLeilao;
        this.dataAberturaLeilao = dataAberturaLeilao;
        this.dataEncerramentoLeilao = dataEncerramentoLeilao;
        this.dataVisitaProduto = dataVisitaProduto;
        this.siteLeilao = siteLeilao;
        this.enderecoFisicoLeilao = enderecoFisicoLeilao;
        this.cidadeLeilao = cidadeLeilao;
        this.estadoLeilao = estadoLeilao;
        this.produto = produto;
        this.banco = banco;   
    }

    public Integer getIdLeilao() {
        return idLeilao;
    }

    public void setIdLeilao(Integer idLeilao) {
        this.idLeilao = idLeilao;
    }

    public LocalDateTime getDataAberturaLeilao() {
        return dataAberturaLeilao;
    }

    public void setDataAberturaLeilao(LocalDateTime dataAberturaLeilao) {
        this.dataAberturaLeilao = dataAberturaLeilao;
    }

    public LocalDateTime getDataEncerramentoLeilao() {
        return dataEncerramentoLeilao;
    }

    public void setDataEncerramentoLeilao(LocalDateTime dataEncerramentoLeilao) {
        this.dataEncerramentoLeilao = dataEncerramentoLeilao;
    }

    public LocalDateTime getDataVisitaProduto() {
        return dataVisitaProduto;
    }

    public void setDataVisitaProduto(LocalDateTime dataVisitaProduto) {
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

    public List<Produto> getProduto(){
        return produto;
    }

    public void setProduto (List<Produto> produto){
        this.produto = produto;
    }

    public List<Banco> getBanco(){
        return banco;
    }

    public void setBanco(List<Banco>banco){
        this.banco = banco;
    }
}
