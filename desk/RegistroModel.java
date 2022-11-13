package br.com.cabidedamoda.controle.caixa.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Registro")
public class RegistroModel {

    public enum TipoFluxo {
        E,
        S
    }

    @Column(name = "data", nullable = false)
    private LocalDate data;

    public RegistroModel() {

    }

    public RegistroModel(LocalDate data, Integer fluxoId, Integer idDono, String nomeEntrada,
            TipoFluxo tipoFluxo, BigDecimal valor) {
        super();
        this.data = data;
        this.fluxoId = fluxoId;
        this.idDono = idDono;;
        this.nomeEntrada = nomeEntrada;
        this.tipoFluxo = tipoFluxo;
        this.valor = valor;
    }

    @Column(name = "fluxo_id", nullable = false)
    private Integer fluxoId;

    @Column(name = "id_dono", nullable = false)
    private Integer idDono;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UUID_REGISTRO", columnDefinition = "char(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID idRegistro;

    @Column(name = "nome_entrada", nullable = false, length = 150)
    private String nomeEntrada;

    @Column(name = "tipo_fluxo", columnDefinition = "ENUM('E', 'S')", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoFluxo tipoFluxo;

    @Column(name = "valor_entrada", nullable = false, precision = 6, scale = 2)
    private BigDecimal valor;

}
