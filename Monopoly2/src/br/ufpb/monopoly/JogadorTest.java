package br.ufpb.monopoly;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;

class JogadorTest extends BancoTest{
    Jogador j1, j2, j3, j4, j5, j6, j7, j8, j9, j10;


    @Before
    void setUp() {
        j1 = new Jogador("Jhe", "azul", 1500);
        j2 = new Jogador("AA", "amaelo", 1500);
        j3 = new Jogador("KKK", "rosa", 1500);
        j4 = new Jogador("BB", "vermelho", 1500);
        j5 = new Jogador("GGG", "verde", 1500);
        j6 = new Jogador("LL", "amarelo", 1500);
        j7 = new Jogador("@@", "laranja", 1500);
        j8 = new Jogador("Je", "preto", 1500);
        j9 = new Jogador("JK", "branco", 1500);
        j10 = new Jogador("LKO", "jfs", 1500);
    }

    //Testando se o jogador seleciona entrada de cores válidas;

    @Test
    public void selecionaPeca() {
        assertEquals("azul",j1.selecionaPeca(j1.getCorPeca()));
        assertEquals(null, j2.selecionaPeca(j2.getCorPeca()));
        assertEquals("rosa", j3.selecionaPeca(j3.getCorPeca()));
        assertEquals("vermelho", j4.selecionaPeca(j4.getCorPeca()));
        assertEquals("verde", j5.selecionaPeca(j5.getCorPeca()));
        assertEquals("amarelo", j6.selecionaPeca(j6.getCorPeca()));
        assertEquals("laranja", j7.selecionaPeca(j7.getCorPeca()));
        assertEquals("preto", j8.selecionaPeca(j8.getCorPeca()));
        assertEquals("branco", j9.selecionaPeca(j9.getCorPeca()));
        assertEquals(null, j10.selecionaPeca(j10.getCorPeca()));

    }
    @Test
    void sacaDoSaldo() {
        assertEquals(1400, j1.getSaldo()-100);
        assertEquals(1300, j2.getSaldo()-200);
        assertEquals(1260, j3.getSaldo()-240);
        assertEquals(1370, j4.getSaldo()-130);
        assertEquals(1390, j5.getSaldo()-110);
        assertNotEquals(1500, j6.getSaldo()-120);
        assertNotEquals(1380, j7.getSaldo()-130);
        assertNotEquals(1200, j8.getSaldo()-200);
        assertNotEquals(1200, j9.getSaldo()-200);
        assertNotEquals(-1, j10.getSaldo()-1600);
    }

    @Test
    void creditaSaldo() {
        assertEquals(1600, j1.getSaldo()+100);
        assertEquals(1700, j2.getSaldo()+200);
        assertEquals(1740, j3.getSaldo()+240);
        assertEquals(1630, j4.getSaldo()+130);
        assertEquals(3000, j5.getSaldo()+1500);
        assertNotEquals(1500, j6.getSaldo()+120);
        assertNotEquals(1380, j7.getSaldo()+130);
        assertNotEquals(1200, j8.getSaldo()+200);
        assertNotEquals(1200, j9.getSaldo()+200);
        assertNotEquals(1200, j10.getSaldo()+200);
    }
}