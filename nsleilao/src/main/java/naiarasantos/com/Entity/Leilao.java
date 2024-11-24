package naiarasantos.com.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import naiarasantos.com.Dto.LeilaoDto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Leilao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_leilao")
    private Integer idLeilao;

    @Column(name = "data_abertura_leilao")
    private LocalDateTime dataAberturaLeilao;

    @Column(name = "data_encerramento_leilao")
    private LocalDateTime dataEncerramentoLeilao;

    @Column(name = "data_visita_produto")
    private LocalDateTime dataVisitaProduto;

    @Column(name = "site_leilao")
    private String siteLeilao;

    @Column(name = "endereco_fisico_leilao")
    private String enderecoFisicoLeilao;

    @Column(name = "cidade_leilao")
    private String cidadeLeilao;

    @Column(name = "estado_leilao")
    private String estadoLeilao;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "leilao",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Produto> produto = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="leilao_banco",
    joinColumns = @JoinColumn(name = "id_leilao"),
    inverseJoinColumns = @JoinColumn (name = "id_banco"))
    @JsonManagedReference
    private List<Banco> banco = new ArrayList<>();

    public Leilao() {}

    public Leilao(Integer idLeilao, LocalDateTime dataAberturaLeilao, LocalDateTime dataEncerramentoLeilao,
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
        leilaoDto.setProduto(this.produto);
        leilaoDto.setBanco(this.banco);
        return leilaoDto;
    }
}
