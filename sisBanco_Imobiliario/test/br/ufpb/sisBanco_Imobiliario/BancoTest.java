package br.ufpb.sisBanco_Imobiliario;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BancoTest {
    
    private Banco banco;
    private Jogador jogador;
    private Jogador jogador2;
    
    @Before
    public void setUp() {
        banco = new Banco();
        jogador = new Jogador("waldir", "preto");
        jogador2 = new Jogador("jhe", "branco");
        
    }
   
    @Test
    public void testCreditarEmConta() {
        banco.creditarEmConta(jogador2, 200);
        assertEquals(1700, jogador2.getSaldo());
    }

    @Test
    public void testSacaDoSaldo() {
        banco.sacaDoSaldo(jogador,200);
        assertEquals(1300, jogador.getSaldo());
    }
}