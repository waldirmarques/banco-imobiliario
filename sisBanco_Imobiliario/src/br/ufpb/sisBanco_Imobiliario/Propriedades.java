package br.ufpb.sisBanco_Imobiliario;

public class Propriedades implements Cartas {

    private Jogador dono;
    private String nome;
    private String cor;
    private int preco;
    private int aluguelSemCasas;
    private int aluguelComUmaCasas;
    private int aluguelComDuasCasas;
    private int aluguelComTresCasas;
    private int aluguelComQuatroCasas;
    private int hotel;
    private int precoDaCasa;
    private int hipoteca;

    public Propriedades(String nome, String cor, int preco, int aluguelSemCasas, int aluguelComUmaCasas, int aluguelComDuasCasas, int aluguelComTresCasas, int aluguelComQuatroCasas, int hotel, int precoDaCasa, int hipoteca) {
        this.nome = nome;
        this.cor = cor;
        this.preco = preco;
        this.aluguelSemCasas = aluguelSemCasas;
        this.aluguelComUmaCasas = aluguelComUmaCasas;
        this.aluguelComDuasCasas = aluguelComDuasCasas;
        this.aluguelComTresCasas = aluguelComTresCasas;
        this.aluguelComQuatroCasas = aluguelComQuatroCasas;
        this.hotel = hotel;
        this.precoDaCasa = precoDaCasa;
        this.hipoteca = hipoteca;
        this.dono = null;
    }

    //Método status da interface que retorna o nome da Propriedade.
    @Override
    public String status() {
        return this.nome;
    }

    //Método que  retorna tudo que uma propriedade tem na forma de uma String.
    @Override
    public String toString() {
        return
                "------------------------------------\n" +
                this.nome +
                "\nCor = " + this.cor +
                "\nPreço = " + this.preco +
                "\nAluguel sem casas = " + this.aluguelSemCasas +
                "\nAluguel com uma casa = " + this.aluguelComUmaCasas +
                "\nAluguel com duas casas = " + this.aluguelComDuasCasas +
                "\nAluguel com três casas = " + this.aluguelComTresCasas +
                "\nAluguel com quatro casas = " + this.aluguelComQuatroCasas +
                "\nHotel = " + this.hotel +
                "\nPreco da Casa = " + this.precoDaCasa +
                "\nHipoteca = " + this.hipoteca +
                "\n------------------------------------\n";
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public int getPreco() {
        return preco;
    }

    public int getAluguelSemCasas() {
        return aluguelSemCasas;
    }

    public int getAluguelComUmaCasas() {
        return aluguelComUmaCasas;
    }

    public int getAluguelComDuasCasas() {
        return aluguelComDuasCasas;
    }

    public int getAluguelComTresCasas() {
        return aluguelComTresCasas;
    }

    public int getAluguelComQuatroCasas() {
        return aluguelComQuatroCasas;
    }

    public int getHotel() {
        return hotel;
    }

    public int getPrecoDaCasa() {
        return precoDaCasa;
    }

    public int getHipoteca() {
        return hipoteca;
    }

    public Jogador getDono() {
        return dono;
    }

    public void setDono(Jogador dono) {
        this.dono = dono;
    }

}
