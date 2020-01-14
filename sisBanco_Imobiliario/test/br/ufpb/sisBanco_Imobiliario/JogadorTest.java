package br.ufpb.sisBanco_Imobiliario;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JogadorTest {

    private Jogador jogador;
    private Jogador jogador2;
    private Jogador jogador3;
    @Before
    public void setUp() {
        jogador = new Jogador("waldir", "preto");
        jogador2 = new Jogador("jhe", "branco");
        jogador3 = new Jogador("bruno", "branco");
        jogador3.setPosicao(10);
    }
    
    @Test
    public void aumentaPosicao(){
        jogador3.aumentarPosicao(30);
        assertEquals(0,jogador3.getPosicao(),0.1);
    }
    
    @Test
    public void aumentaPosicao2(){
        jogador3.aumentarPosicao(30);
        assertEquals(1700,jogador3.getSaldo(),0.1);
    }

}
