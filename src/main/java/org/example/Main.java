package org.example;

import org.example.models.Cupom;

public class Main {
    public static void main(String[] args) {
        GeradorCupom geradorCupom = new GeradorCupom();

        Cupom cupomGerado = geradorCupom.gerar();;

        System.out.println(cupomGerado);

        ImpressorCupom impressorCupom = new ImpressorCupom();
        impressorCupom.imprimir(cupomGerado);

    }
}