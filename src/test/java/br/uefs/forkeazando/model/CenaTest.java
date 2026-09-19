package br.uefs.forkeazando.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CenaTest {

    private Cena cenaTeste;
    private Protagonista protagonistaTeste;

    @BeforeEach
    void setUp() {
        cenaTeste = new Cena(101, "Capítulo 1", "Narrador", "Texto de teste.");
        protagonistaTeste = new Protagonista(null); 
    }

    @Test
    void deveRetornarApenasAsEscolhasQueEstaoDisponiveisParaOProtagonista() {
        Escolha escolhaDisponivel = new FakeEscolha("Opção Aberta", 102, true);
        Escolha escolhaBloqueada = new FakeEscolha("Opção Trancada", 103, false);

        cenaTeste.adicionarEscolha(escolhaDisponivel);
        cenaTeste.adicionarEscolha(escolhaBloqueada);

        List<Escolha> resultado = cenaTeste.getEscolhasDisposniveis(protagonistaTeste);

        assertEquals(1, resultado.size());
        assertEquals("Opção Aberta", resultado.get(0).getTextoAlternativa());
        assertFalse(resultado.contains(escolhaBloqueada));
    }

    @Test
    void deveRetornarListaVaziaSeNenhumaEscolhaEstiverDisponivel() {
        Escolha escolhaTrancada = new FakeEscolha("Trancada", 104, false);
        cenaTeste.adicionarEscolha(escolhaTrancada);

        List<Escolha> resultado = cenaTeste.getEscolhasDisposniveis(protagonistaTeste);

        assertTrue(resultado.isEmpty());
    }
}
