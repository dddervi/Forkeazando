package br.uefs.forkeazando.controller;

import br.uefs.forkeazando.model.CaracteristicasProtagonista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TelaCaracteristicasControllerTest {

    private FakeTelaCaracteristicas fakeView;
    private TelaCaracteristicasController controller;

    @BeforeEach
    void setUp() {
        fakeView = new FakeTelaCaracteristicas();
        controller = new TelaCaracteristicasController(fakeView);
    }

    @Test
    void deveColetarRespostasDaViewEMontarCaracteristicasCorretamente() {
        fakeView.respostaPerfeccionista = true;
        fakeView.respostaSociavel = false;
        fakeView.respostaEstudoTeorico = true;
        fakeView.respostaSituacaoEconomica = CaracteristicasProtagonista.SituacaoEconomica.ESTAVEL;
        fakeView.respostaVidaSocial = CaracteristicasProtagonista.NivelVidaSocial.BALANCEADO;
        fakeView.respostaExperienciaEM = CaracteristicasProtagonista.ExperienciaEmocionalEnsinoMedio.POSITIVA;

        CaracteristicasProtagonista resultado = controller.iniciar();

        assertNotNull(resultado);
        assertTrue(resultado.isPerfeccionista());
        assertFalse(resultado.isSociavel());
        assertTrue(resultado.isEstudoTeorico());
        assertEquals(CaracteristicasProtagonista.SituacaoEconomica.ESTAVEL, resultado.getSituacaoEconomica());
        assertEquals(CaracteristicasProtagonista.NivelVidaSocial.BALANCEADO, resultado.getNivelVidaSocial());
        assertEquals(CaracteristicasProtagonista.ExperienciaEmocionalEnsinoMedio.POSITIVA, resultado.getExperienciaEmocionalEnsinoMedio());
    }
}
