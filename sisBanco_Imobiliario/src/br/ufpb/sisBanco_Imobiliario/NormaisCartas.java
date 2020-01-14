package br.ufpb.sisBanco_Imobiliario;

public class NormaisCartas implements Cartas {

    private String nome;

    public NormaisCartas(String nome) {
        this.nome = nome;
    }

    //Método status da interface que retorna o nome da Carta.
    @Override
    public String status() {
        return this.getNome();
    }

    //Método que  retorna tudo que uma NormaisCartas tem na forma de uma String.
    @Override
    public String toString() {
        return this.nome + "\nNada aconteceu!";
    }

    public String getNome() {
        return nome;
    }

}
