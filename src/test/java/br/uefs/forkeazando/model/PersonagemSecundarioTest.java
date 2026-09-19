package br.uefs.forkeazando.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonagemSecundarioTest {

    private PersonagemSecundario npcTeste;

    @BeforeEach
    void setUp() {
        npcTeste = new PersonagemSecundario("Veterano", PersonagemSecundario.Interesse.ESTABILIDADE);
    }

    @Test
    void deveInicializarComOsValoresCorretos() {
        assertEquals("Veterano", npcTeste.getNome());
        assertEquals(PersonagemSecundario.Interesse.ESTABILIDADE, npcTeste.getInteresse());
        assertEquals(0.0f, npcTeste.getNivelRelacionamento(), 0.001);
    }

    @Test
    void deveAumentarONivelDeRelacionamentoAoPassarDeltaPositivo() {
        npcTeste.alterarRelacionamento(15);
        assertEquals(15.0f, npcTeste.getNivelRelacionamento(), 0.001);
    }
}
