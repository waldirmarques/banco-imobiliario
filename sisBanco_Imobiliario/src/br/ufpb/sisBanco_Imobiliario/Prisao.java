package br.ufpb.sisBanco_Imobiliario;

import java.util.ArrayList;

public class Prisao implements Cartas {

    private String nome;
    private ArrayList<Jogador> preso;

    public Prisao(String nome) {
        this.nome = nome;
        this.preso = new ArrayList<>();
    }

    @Override
    public String status() {
        return this.nome;
    }

    @Override
    public String toString() {
        return this.getNome() + "\nNada Aconteceu!";
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Jogador> getPreso() {
        return preso;
    }

}
