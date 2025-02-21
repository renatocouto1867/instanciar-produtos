package com.manoelcampos.produtos;

import java.time.LocalDate;

/**
 * Produto da loja.
 * @author Manoel Campos da Silva Filho
 */
public class Produto {
    private long id;
    private String codigoEan;
    private String descricao;
    private String marca;
    private String modelo;
    private double preco;
    private LocalDate dataCadastro;
    private LocalDate dataUltimaAtualizacao;
    private int estoque;
    private String categoria;
    private String urlFoto;

    //Construtor privado para se obrigatorio o uso do builder
    private Produto(Builder builder) {
        this.id = builder.id;
        this.codigoEan = builder.codigoEan;
        this.descricao = builder.descricao;
        this.marca = builder.marca;
        this.modelo = builder.modelo;
        this.preco = builder.preco;
        this.dataCadastro = builder.dataCadastro;
        this.dataUltimaAtualizacao = builder.dataUltimaAtualizacao;
        this.estoque = builder.estoque;
        this.categoria = builder.categoria;
        this.urlFoto = builder.urlFoto;
    }

    public long getId() { return id; }
    public String getCodigoEan() { return codigoEan; }
    public String getDescricao() { return descricao; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public double getPreco() { return preco; }
    public LocalDate getDataCadastro() { return dataCadastro; }
    public LocalDate getDataUltimaAtualizacao() { return dataUltimaAtualizacao; }
    public int getEstoque() { return estoque; }
    public String getCategoria() { return categoria; }
    public String getUrlFoto() { return urlFoto; }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", codigoEan='" + codigoEan + '\'' +
                ", descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", preco=" + preco +
                ", dataCadastro=" + dataCadastro +
                ", dataUltimaAtualizacao=" + dataUltimaAtualizacao +
                ", estoque=" + estoque +
                ", categoria='" + categoria + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                '}';
    }

    // Builder
    public static class Builder {
        private final long id; // obrigatório
        private final String codigoEan; // obrigatório
        private final String descricao; // obrigatório
        private final String marca; // obrigatório
        private String modelo;
        private final double preco; // obrigatório
        private final LocalDate dataCadastro = LocalDate.now();
        private LocalDate dataUltimaAtualizacao;
        private int estoque = 0;
        private final String categoria; // obrigatório
        private String urlFoto;


        public Builder(long id, String codigoEan, String descricao, String marca, double preco, String categoria) {
            if (codigoEan == null || descricao == null || marca == null || categoria == null) {
                throw new IllegalArgumentException("Atributos obrigatórios não podem ser nulos.");
            }
            if (preco <= 0) {
                throw new IllegalArgumentException("O preço deve ser maior que zero.");
            }

            this.id = id;
            this.codigoEan = codigoEan;
            this.descricao = descricao;
            this.marca = marca;
            this.preco = preco;
            this.categoria = categoria;
        }

        public Builder modelo(String modelo) {
            if (modelo != null && marca == null) {
                throw new IllegalArgumentException("Não pode informar modelo sem marca.");
            }
            this.modelo = modelo;
            return this;
        }

        public Builder dataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
            if (dataUltimaAtualizacao != null && dataUltimaAtualizacao.isBefore(dataCadastro)) {
                throw new IllegalArgumentException("Data de última atualização não pode ser anterior à data de cadastro.");
            }
            this.dataUltimaAtualizacao = dataUltimaAtualizacao;
            return this;
        }

        public Builder estoque(int estoque) {
            if (estoque < 0) {
                throw new IllegalArgumentException("O estoque não pode ser negativo.");
            }
            this.estoque = estoque;
            return this;
        }

        public Builder urlFoto(String urlFoto) {
            this.urlFoto = urlFoto;
            return this;
        }

        public Produto build() {
            return new Produto(this);
        }
    }
}
