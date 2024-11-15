package naiarasantos.com.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import naiarasantos.com.Dto.LeilaoDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;

@Entity
public class Leilao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_leilao")
    private int idLeilao;

    @Column(name = "data_abertura_leilao")
    private LocalDate dataAberturaLeilao;
    
    @Column(name = "data_encerramento_leilao")
    private LocalDate dataEncerramentoLeilao;
    
    @Column(name = "data_visita_produto")
    private LocalDate dataVisitaProduto;
    
    @Column(name = "site_leilao")
    private String siteLeilao;
    
    @Column(name = "endereco_fisico_leilao")
    private String enderecoFisicoLeilao;
    
    @Column(name = "cidade_leilao")
    private String cidadeLeilao;
    
    @Column(name = "estado_leilao")
    private String estadoLeilao;
    
    @Column(name = "status_leilao")
    private String statusLeilao;

    @OneToMany(mappedBy = "produto")
    private List<Produto> produto = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="leilao_banco",
    joinColumns = @JoinColumn(name = "id_leilao"),
    inverseJoinColumns = @JoinColumn (name = "id_banco"))
    private List<Banco> banco;

    public Leilao() {}

    public Leilao(int idLeilao, LocalDate dataAberturaLeilao, LocalDate dataEncerramentoLeilao,
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
        leilaoDto.setProduto(this.produto);
        leilaoDto.setBanco(this.banco);
        return leilaoDto;
    }
}
