package br.ufpb.sisBanco_Imobiliario;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TabuleiroTest {

    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private ArrayList<Jogador> jogadores;
    private Dado dado;
    private Banco banco;
    private int duplaIgual;
    

    @Before
    public void setUp() {
        tabuleiro = new Tabuleiro();
        jogador1 = new Jogador("waldir","preto");
        jogador2 = new Jogador("Bruno","Branco");
        jogadores = new ArrayList<>();
        dado = new Dado();
        banco = new Banco();
        
        duplaIgual = 0;
    }
    
    @Test
    public void testRetornaCartaAtual() {
        assertEquals(tabuleiro.getcartaTabuleiro().get(0), tabuleiro.retornaCartaAtual(0));
    }

    @Test
    public void testAcoesDoSorteOuReves() {
        dado.setDado1(0);
        dado.setDado2(2);
        int soma = dado.somaDoLancamentoDado(dado.getDado1(), dado.getDado2());
        jogadores.add(jogador1);
        jogadores.add(jogador2);
        SorteOuReves s = (SorteOuReves) tabuleiro.getCartaSorteOuReves().get(soma-1);
        tabuleiro.acoesDoSorteOuReves(s, jogador1, jogadores, banco, dado, duplaIgual);
        assertEquals(1550,jogador1.getSaldo(),0.1);
    }
   
    @Test
    public void testAcoesDoSorteOuReves2() {
        dado.setDado1(6);
        dado.setDado2(1);
        int soma = dado.somaDoLancamentoDado(dado.getDado1(), dado.getDado2());
        jogadores.add(jogador1);
        jogadores.add(jogador2);
        SorteOuReves s = (SorteOuReves) tabuleiro.getCartaSorteOuReves().get(soma - 1);
        jogador1.aumentarPosicao(soma-1);
        tabuleiro.acoesDoSorteOuReves(s, jogador1, jogadores, banco, dado, duplaIgual);
        assertEquals(1700,jogador1.getSaldo(),0.1);
        
    }
    
    @Test
    public void testAcoesDoSorteOuReves3() {
        dado.setDado1(3);
        dado.setDado2(3);
        int soma = dado.somaDoLancamentoDado(dado.getDado1(), dado.getDado2());
        jogadores.add(jogador1);
        jogadores.add(jogador2);
        SorteOuReves s = (SorteOuReves) tabuleiro.getCartaSorteOuReves().get(soma - 1);
        jogador1.aumentarPosicao(soma-1);
        tabuleiro.acoesDoSorteOuReves(s, jogador1, jogadores, banco, dado, duplaIgual);
        assertEquals(30,jogador1.getPosicao(),0.1);
        
    }
    
    @Test
    public void testAcoesDoSorteOuReves4() {
        dado.setDado1(22);
        dado.setDado2(2);
        int soma = dado.somaDoLancamentoDado(dado.getDado1(), dado.getDado2());
        jogadores.add(jogador1);
        jogadores.add(jogador2);
        SorteOuReves s = (SorteOuReves) tabuleiro.getCartaSorteOuReves().get(soma - 1);
        jogador1.aumentarPosicao(soma-1);
        tabuleiro.acoesDoSorteOuReves(s, jogador1, jogadores, banco, dado, duplaIgual);
        assertEquals(1600,jogador1.getSaldo(),0.1);      
    }
    
    @Test
    public void prendeJogador() {
        Prisao p = (Prisao)tabuleiro.getcartaTabuleiro().get(30);
        tabuleiro.prendeJogador(p, jogador1);
        assertEquals(jogador1,tabuleiro.retornaJogadorPreso(jogador1));
    }
     
    @Test
    public void testRetornaJogadorPreso() {
        Prisao p = (Prisao)tabuleiro.getcartaTabuleiro().get(30);
        tabuleiro.prendeJogador(p, jogador1);
        assertEquals(jogador1, tabuleiro.retornaJogadorPreso(jogador1));
    }
    
    @Test
    public void tiraJogadorDaPrisao() {
        Prisao p = (Prisao)tabuleiro.getcartaTabuleiro().get(30);
        tabuleiro.tiraJogadorDaPrisao(jogador1);        
        assertEquals(null,tabuleiro.retornaJogadorPreso(jogador1));
    }

}
