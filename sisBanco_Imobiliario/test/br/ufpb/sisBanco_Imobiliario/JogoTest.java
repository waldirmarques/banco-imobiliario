package br.ufpb.sisBanco_Imobiliario;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JogoTest {

    private Jogo jogo;

    @Before
    public void setUp() {
        jogo = new Jogo();
        Jogador jogador1 = new Jogador("Waldir", "branco");
        Jogador jogador2 = new Jogador("Bruno", "amarelo");
        jogo.getJogadores().add(jogador1);
        jogo.getJogadores().add(jogador2);
    }

    @Test
    public void testVerificaNumeroDeJogadores() {
        assertTrue(jogo.verificaNumeroDeJogadores(3));
    }

    @Test
    public void testVerificaPecaJogador() {
        assertTrue(jogo.verificaPecaIguais("amarelo"));
    }

    @Test
    public void testVerificaPecaIguais() {
        assertTrue(jogo.verificaPecaJogador("branco"));
    }

}
