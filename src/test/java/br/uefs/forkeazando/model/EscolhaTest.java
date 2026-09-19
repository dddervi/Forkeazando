package br.uefs.forkeazando.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EscolhaTest {

    private Protagonista protagonistaTeste;

    @BeforeEach
    void setUp() {
        protagonistaTeste = new Protagonista(null); 
    }

    @Test
    void deveEstarDisponivelQuandoNaoHaRequisitos() {
        Escolha escolhaLivre = new Escolha("Ir para o Módulo 8", 201, null, null, 0, 0);
        assertTrue(escolhaLivre.estaDisponivel(protagonistaTeste));
    }

    @Test
    void deveBloquearSeOProtagonistaNaoTiverAFlagRequerida() {
        Escolha escolhaSecreta = new Escolha("Pedir favor ao Veterano", 105, null, "ajudou_veterano", 0, 0);
        assertFalse(escolhaSecreta.estaDisponivel(protagonistaTeste));
    }
}
