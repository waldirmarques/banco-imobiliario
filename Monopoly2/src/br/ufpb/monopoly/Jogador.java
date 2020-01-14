package br.ufpb.monopoly;

public class Jogador extends Banco{

    private String nome;
    private String corPeca;
    private Banco saldo;

    public Jogador(String nome, String corPeca, double saldo) {
        super(saldo);
        this.nome = nome;
        this.corPeca = corPeca;
    }

    @Override
    public double getSaldo() {
        return super .getSaldo();
    }

    public String getNome () {
        return this.nome;
    }
    public String getCorPeca() {
        return this.corPeca;
    }


    public void setNome (String nome) {
        this.nome = nome;
    }
    public void setCorPeca (String corPeca) {
        this.corPeca = corPeca;
    }



    //Método que seleciona uma cor de peca válida;

    public String selecionaPeca (String corPeca) {
        String [] cor = {"azul", "amarelo", "rosa", "verde", "branco", "preto", "laranja", "vermelho"};

        for (int i = 0; i < cor.length; i++) {
            if (this.corPeca.startsWith(cor[i])){
                return cor[i];
            }
        }
        return null;

    }


}
