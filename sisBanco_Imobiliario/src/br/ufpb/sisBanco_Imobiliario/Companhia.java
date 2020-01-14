package br.ufpb.sisBanco_Imobiliario;

public class Companhia implements Cartas {

    private Jogador dono;
    private String nome;
    private int preco;
    private int hipoteca;
    private int multiplicador;

    public Companhia(String nome, int preco, int hipoteca, int multiplicador) {
        this.nome = nome;
        this.preco = preco;
        this.hipoteca = hipoteca;
        this.multiplicador = multiplicador;
        this.dono = null;
    }

    //Método status da interface que retorna o nome da companhia.
    @Override
    public String status() {
        return this.getNome();
    }

    //Método que  retorna tudo que uma companhtoia tem na forma de uma String.
    @Override
    public String toString() {
        return this.getNome() + " \nPreço = " + this.getPreco() + " \nHipoteca = " + this.getHipoteca() + " \nMultiplicador = " + this.getMultiplicador();
    }

    public String getNome() {
        return nome;
    }

    public int getPreco() {
        return preco;
    }

    public int getHipoteca() {
        return hipoteca;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public Jogador getDono() {
        return dono;
    }

    public void setDono(Jogador dono) {
        this.dono = dono;
    }
}
