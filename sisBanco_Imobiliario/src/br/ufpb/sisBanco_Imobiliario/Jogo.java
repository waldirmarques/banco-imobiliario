package br.ufpb.sisBanco_Imobiliario;

import java.util.ArrayList;

public class Jogo {

    private ArrayList<Jogador> jogadores;

    //Construtor do jogo.
    public Jogo() {
        this.jogadores = new ArrayList<>();
    }

    //Cadastra um jogador na lista de Jogadores.
    public void cadastrarJogadores(Jogador jogador) {
        this.jogadores.add(jogador);
    }

    //Verifica se o número de jogadores solicitado é suportado pelo jogo.
    public boolean verificaNumeroDeJogadores(int numeroDeJogadores) {
        return numeroDeJogadores >= 2 && numeroDeJogadores <= 8;
    }

    //Verifica se a String cor é suportada pelo jogo.
    public boolean verificaPecaJogador(String cor) {
        return cor.equalsIgnoreCase("preto") || cor.equalsIgnoreCase("branco") || cor.equalsIgnoreCase("vermelho")
           || cor.equalsIgnoreCase("verde") || cor.equalsIgnoreCase("azul") || cor.equalsIgnoreCase("amarelo") || cor.equalsIgnoreCase("laranja") || cor.equalsIgnoreCase("rosa");

    }

    //Verifica se a String cor já foi escolhida por outro jogador.
    public boolean verificaPecaIguais(String cor) {
        for (Jogador i : this.jogadores) {
            if (i.getCor().equals(cor)) {
                return true;
            }
        }
        return false;
    }
    
    //Verifica se jogador tem uma carta de saída de sada livre da prisão.
    public Cartas verificaCartaSaidaLivrePrisao(Jogador jogador){
        for(Cartas c : jogador.getCartasJogador()){
            if(c instanceof SorteOuReves){
                SorteOuReves carta = (SorteOuReves) c;
                if(carta.getDescricao().equals("Utilize este cartão para se livrar da prisão.")){
                    return carta;                    
                }
            }
        }
        return null;
    }
    
    //Remove carta do sorte reves depois de usada
    public void removeCartaDepoisDeUsada(Jogador jogador, Cartas carta){
        jogador.getCartasJogador().remove(carta);
    }

    //Retorna toda a lista de jogadores.
    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }
}
