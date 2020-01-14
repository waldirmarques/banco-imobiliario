package br.ufpb.sisBanco_Imobiliario;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DadoTest {
    Dado dado;
    int dado1;
    int dado2;
    
    @Before
    public void setUp() {
        dado = new Dado();
        dado1 = 5;
        dado2 = 10;
    }
    
    @Test
    public void testSomaDoLancamentoDado() {
        assertEquals(15,dado.somaDoLancamentoDado(dado1,dado2),0.1);
    }
    
    @Test
    public void verificaIguais() {
        assertEquals(false,dado.verificaIguais(dado1, dado2));
    }
    
}
