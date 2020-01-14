package br.ufpb.sisBanco_Imobiliario;

public class Dado {

    // Nome do método e das váriáveis alteradas (Devido aos testes, mas nada muda);
    private int dado1;
    private int dado2;

    //construtor do dado.
    public Dado() {
        this.dado1 = 0;
        this.dado2 = 0;

    }
    // Retorna a soma do lançamentos dos dois dados
    public int somaDoLancamentoDado(int dado1, int dado2) {
        return dado1+dado2;
    }
    // Gera dois dados com números aleatórios entre 1 e 6;
    public void lancarDado(){
        this.setDado1((int) (Math.random() * 6 + 1));
        this.setDado2((int) (Math.random() * 6 + 1));
    }
    //verifica se os dados são iguais.
    public boolean verificaIguais(int dado1, int dado2){
        return dado1 == dado2;
    }
    
    public int getDado1() {
        return dado1;
    }

    public int getDado2() {
        return dado2;
    }

    public void setDado1(int dado1) {
        this.dado1 = dado1;
    }

    public void setDado2(int dado2) {
        this.dado2 = dado2;
    }
    
    
}
