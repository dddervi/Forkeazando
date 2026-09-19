package br.uefs.forkeazando.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProtagonistaTest {

    private CaracteristicasProtagonista caracteristicasDummy;
    private Protagonista protagonista;

    @BeforeEach
    void setUp() {
        // Objeto de características base para o construtor do protagonista
        caracteristicasDummy = new CaracteristicasProtagonista(
                true, true, false,
                CaracteristicasProtagonista.NivelVidaSocial.EQUILIBRADO,
                CaracteristicasProtagonista.ExperienciaEmocionalEnsinoMedio.POSITIVA,
                CaracteristicasProtagonista.SituacaoEconomica.CONFORTAVEL
        );
        // O construtor vai definir a vidaSocial inicial puxando getNivelSocialInicial() que para POSITIVA vale 5
        protagonista = new Protagonista(caracteristicasDummy);
    }

    @Test
    void deveInicializarComAtributosZeradosEVidaSocialMapeada() {
        assertEquals(0, protagonista.getScore());
        assertEquals(0, protagonista.getParticipacao());
        assertEquals(0, protagonista.getConfianca());
        assertEquals(5, protagonista.getVidaSocial(), 
                "A vida social inicial deve bater com o nível social inicial das características (5).");
    }

    @Test
    void deveAcumularAtributosDeTrajetoriaCorretamente() {
        protagonista.ganharScore(10);
        protagonista.ganharParticipacao(15);
        protagonista.ganharConfianca(20);
        protagonista.alterarVidaSocial(-2); 

        assertEquals(10, protagonista.getScore());
        assertEquals(15, protagonista.getParticipacao());
        assertEquals(20, protagonista.getConfianca());
        assertEquals(3, protagonista.getVidaSocial()); 
    }

    @Test
    void deveGerenciarHistoricoDeFlagsSemDuplicar() {
        protagonista.adicionarFlag("ajudou_veterano");
        assertTrue(protagonista.temFlag("ajudou_veterano"));
        assertEquals(1, protagonista.getHistoricoFlags().size());

        protagonista.adicionarFlag("ajudou_veterano");
        assertEquals(1, protagonista.getHistoricoFlags().size(), 
                "O histórico de flags não deve aceitar itens duplicados.");
        
        assertFalse(protagonista.temFlag("flag_inexistente"));
    }

    @Test
    void deveValidarAtingimentoDeRequisitosCorretamente() {
        protagonista.ganharScore(75);
        protagonista.ganharParticipacao(20);

        assertTrue(protagonistaatingiuRequisito(70, 15)); 
        assertTrue(protagonista.atingiuRequisito(70, 15));

        assertFalse(protagonista.atingiuRequisito(70, 30));

        assertFalse(protagonista.atingiuRequisito(90, 15));
    }
}
