package br.ufpb.monopoly;

public class Dado {

    private int dado1;
    private int dado2;

    public Dado(){
        this.dado1 = (int) (Math.random() * 6 + 1);
        this.dado2 = (int) (Math.random() * 6 + 1);

    }

    public int lancamentoDado(){
        return this.getDado1() + this.getDado2();
    }
    public int getDado1() {
        return dado1;
    }
    public int getDado2() {
        return dado2;
    }



}
