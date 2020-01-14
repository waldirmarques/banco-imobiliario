package br.ufpb.monopoly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DadoTest {

    Dado dado;

    @BeforeEach
    void setUp() {

    }
    // Testando o lancamento inicial dos dados;
    //Exibe apenas o random e a soma do random;

    @Test
    void lancamentoDado() {
        Dado dado = new Dado();

        System.out.println(dado.getDado1());
        System.out.println(dado.getDado2());
        System.out.println(dado.lancamentoDado());

        assertTrue (dado.getDado1() > 1 && dado.getDado1() <=6 );
        assertTrue(dado.getDado2() > 1 && dado.getDado2() <=6 );
        //assertTrue(dado.lancamentoDado() < 12);
        assertFalse (dado.lancamentoDado() > 12);

    }

}