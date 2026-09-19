package br.uefs.forkeazando.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CaracteristicasProtagonistaTest {

    @Test
    void deveCalcularPontuacoesIniciaisCorretasBaseadasNosEnums() {
        // Combinacao especifica para testar os switchs
        CaracteristicasProtagonista caracteristicas = new CaracteristicasProtagonista(
                true, false, true,
                CaracteristicasProtagonista.NivelVidaSocial.AMIGUEIRO,
                CaracteristicasProtagonista.ExperienciaEmocionalEnsinoMedio.NEGATIVA,
                CaracteristicasProtagonista.SituacaoEconomica.ESTAVEL
        );

        assertEquals(1, caracteristicas.getNivelSocialInicial(), 
                "Experiência emocional negativa deveria retornar nível social inicial igual a 1.");

        assertEquals(5, caracteristicas.getSocialInicial(), 
                "Nível de vida social amigueiro deveria retornar social inicial igual a 5.");
    }

    @Test
    void deveManterOsValoresPassadosNoConstrutor() {
        CaracteristicasProtagonista caracteristicas = new CaracteristicasProtagonista(
                true, false, true,
                CaracteristicasProtagonista.NivelVidaSocial.EQUILIBRADO,
                CaracteristicasProtagonista.ExperienciaEmocionalEnsinoMedio.NEUTRA,
                CaracteristicasProtagonista.SituacaoEconomica.ELITE
        );

        assertTrue(caracteristicas.isPerfeccionista());
        assertFalse(caracteristicas.isSociavel());
        assertTrue(caracteristicas.isEstudoTeorico());
        assertEquals(CaracteristicasProtagonista.SituacaoEconomica.ELITE, caracteristicas.getSituacaoEconomica());
    }
}
