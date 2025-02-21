package com.manoelcampos.produtos;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Produto produto = new Produto.Builder(1, "7891234567890", "Notebook", "Dell", 4500.0, "Eletrônicos")
                .modelo("Inspiron 15") // opcional
                .dataUltimaAtualizacao(LocalDate.now()) // opcional
                .estoque(10) // opcional
                .urlFoto("https://ifto.edu.br/notebook.jpg") // opcional
                .build();

        System.out.println(produto);
    }
}

