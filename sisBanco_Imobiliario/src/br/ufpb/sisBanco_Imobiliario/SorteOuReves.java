package br.ufpb.sisBanco_Imobiliario;

public class SorteOuReves implements Cartas {

    private String nome;
    private String descricao;
    private int pague;
    private int receba;

    public SorteOuReves(String nome) {
        this.nome = nome;
    }

    public SorteOuReves(String descricao, int pague, int receba) {
        this.descricao = descricao;
        this.pague = pague;
        this.receba = receba;
    }
    //Método status da interface que retorna o nome da Carta.
    @Override
    public String status() {
        return this.getNome();
    }

    //Método que  retorna tudo que uma SorteOuReves tem na forma de uma String.
    @Override
    public String toString() {
        return this.getNome();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPague() {
        return pague;
    }

    public int getReceba() {
        return receba;
    }


    
    

}
