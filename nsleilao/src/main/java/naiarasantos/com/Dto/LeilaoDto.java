package naiarasantos.com.Dto;

import java.time.LocalDate;
import java.util.List;

import naiarasantos.com.Entity.Banco;
import naiarasantos.com.Entity.Produto;

public class LeilaoDto {

    private int idLeilao;
    private LocalDate dataAberturaLeilao;
    private LocalDate dataEncerramentoLeilao;
    private LocalDate dataVisitaProduto;
    private String siteLeilao;
    private String enderecoFisicoLeilao; 
    private String cidadeLeilao;
    private String estadoLeilao;
    private String statusLeilao;
    private List<Produto> produto;
    private List<Banco> banco;

    public LeilaoDto() {}

    public LeilaoDto(int idLeilao, LocalDate dataAberturaLeilao, LocalDate dataEncerramentoLeilao, 
                     LocalDate dataVisitaProduto, String siteLeilao, String enderecoFisicoLeilao, 
                     String cidadeLeilao, String estadoLeilao, String statusLeilao, List<Produto> produto, 
                     List<Banco> banco) {
        this.idLeilao = idLeilao;
        this.dataAberturaLeilao = dataAberturaLeilao;
        this.dataEncerramentoLeilao = dataEncerramentoLeilao;
        this.dataVisitaProduto = dataVisitaProduto;
        this.siteLeilao = siteLeilao;
        this.enderecoFisicoLeilao = enderecoFisicoLeilao;
        this.cidadeLeilao = cidadeLeilao;
        this.estadoLeilao = estadoLeilao;
        this.statusLeilao = statusLeilao;
        this.produto = produto;
        this.banco = banco;   
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
