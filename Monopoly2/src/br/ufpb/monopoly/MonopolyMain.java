package br.ufpb.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyMain {
    public static void main(String[] args) {
        Dado dado = new Dado();

        System.out.println(dado.getDado1());
        System.out.println(dado.getDado2());
        System.out.println(dado.lancamentoDado());

        List<Jogador> jogadores = new ArrayList<>();

        Jogador j1;
        
        j1 = new Jogador("Jhe", "verde",1500);
        
        //Jogador j2 = new Jogador("Jhe");
        System.out.println(j1.sacaDoSaldo(100));
        System.out.println(j1.sacaDoSaldo(100));
        System.out.println(j1.getSaldo());



    }


}
