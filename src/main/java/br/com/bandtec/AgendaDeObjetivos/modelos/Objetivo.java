package br.com.bandtec.AgendaDeObjetivos.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "objetivos")
public class Objetivo {

    @Id
    @GeneratedValue
    private long id;

    @JsonProperty
    private String titulo;

    @JsonProperty
    private String descricao;

    @Embedded
    private Prioridade prioridade;

    @Column(name = "data_maxima_para_execucao")
    @JsonProperty
    private LocalDate dataMaximaParaExecucao;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private  Usuario usuario;

    public Objetivo() {}

    public Objetivo(String titulo, String descricao, LocalDate dataMaximaParaExecucao) {
        super();
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.dataMaximaParaExecucao = dataMaximaParaExecucao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public LocalDate getdata_maxima_para_execucao() {
        return dataMaximaParaExecucao;
    }

    public void setdata_maxima_para_execucao(LocalDate dataMaximaParaExecucao) {
        this.dataMaximaParaExecucao = dataMaximaParaExecucao;
    }

    @Override
    public String toString() {
        return "Objetivo [titulo=" + titulo + ", descricao=" + descricao + ", dataMaximaParaExecucao="
                + dataMaximaParaExecucao + "]";
    }

    public boolean ate(LocalDate data) {
        return dataMaximaParaExecucao.isBefore(data) || dataMaximaParaExecucao.isEqual(data);
    }

	/*
	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDate getDataMaximaParaExecucao() {
		return dataMaximaParaExecucao;
	}*/
}
