package br.ufpb.sisBanco_Imobiliario;

import java.util.ArrayList;

public class Jogador {

    private String nome;
    private String cor;
    private int saldo;
    private int posicao;
    private ArrayList<Cartas> cartasJogador;

    //Construtor de Jogador
    public Jogador(String nomeJogador, String corPeca) {
        this.nome = nomeJogador;
        this.cor = corPeca;
        this.saldo = 1500;
        this.posicao = 0;
        this.cartasJogador = new ArrayList<>();
    }

    //Método que apresenta o status do jogador.
    public void statusJogador() {
        try {
            String apresentacao = "Posição no tabuleiro:  " + this.posicao + " - " + cartasJogador.get(this.cartasJogador.size() - 1).status()
                    + "\nPossui R$ " + this.getSaldo() + "\nTítulos: \n";
            if (this.cartasJogador.size() > 0) {
                for (Cartas cartas : this.cartasJogador) {
                    if (cartas instanceof Propriedades) {
                        Propriedades p = (Propriedades) cartas;
                        apresentacao += "[" + p.getNome() + "]" + " propriedade " + p.getCor() + ", aluguel " + p.getAluguelSemCasas();
                        apresentacao += "\n";                   
                    }else if (cartas instanceof Companhia) {
                        Companhia c = (Companhia) cartas;
                        apresentacao += "[" + c.getNome() + "]" + " multiplicador " + c.getMultiplicador();
                        apresentacao += "\n";
                    }else if(cartas instanceof SorteOuReves){
                        SorteOuReves s = (SorteOuReves) cartas;
                        if(s.getDescricao().equals("Utilize este cartão para se livrar da prisão.")){
                            apresentacao += "[ Jogador ] Você tem uma carta de saída livre da prisão";
                            apresentacao += "\n";
                        }
                    }
                }
                System.out.println(apresentacao);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Você ainda não possui nenhum título, companhia ou propriedade. Tente realizar uma jogada!");
        }
    }

    //Método responsável por cadastrar cartas do jogador.
    public void cadastrarCartasDoJogador(Cartas carta) {
        this.cartasJogador.add(carta);
    }
    
    //Método que aumenta a posição do jogador conforme ele anda no tabuleiro

    public void aumentarPosicao(int posicao){
        if(this.getPosicao()+posicao > 0 && this.getPosicao()+posicao < 40)
            this.setPosicao(this.getPosicao()+posicao);
        else{
            this.setPosicao(((this.getPosicao())+posicao) - 40);
            Jogador.this.setSaldo(this.getSaldo()+200);
            //Credita 200 reais toda vez que o jogador passa ou chegar o ponto de partida.
        }
    }
    
    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {       
        this.posicao = posicao;   
    }

    public ArrayList<Cartas> getCartasJogador() {
        return cartasJogador;
    }

 
}
