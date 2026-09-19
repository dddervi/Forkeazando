package br.uefs.forkeazando.controller;

import br.uefs.forkeazando.model.CaracteristicasProtagonista;
import br.uefs.forkeazando.view.TelaCaracteristicas;

public class FakeTelaCaracteristicas extends TelaCaracteristicas {
    public boolean respostaPerfeccionista;
    public boolean respostaSociavel;
    public boolean respostaEstudoTeorico;
    public CaracteristicasProtagonista.SituacaoEconomica respostaSituacaoEconomica;
    public CaracteristicasProtagonista.NivelVidaSocial respostaVidaSocial;
    public CaracteristicasProtagonista.ExperienciaEmocionalEnsinoMedio respostaExperienciaEM;

    @Override
    public boolean perguntarPersonalidade() {
        return this.respostaPerfeccionista;
    }

    @Override
    public boolean perguntarSociavel() {
        return this.respostaSociavel;
    }

    @Override
    public boolean perguntarTipoDeEstudo() {
        return this.respostaEstudoTeorico;
    }

    @Override
    public CaracteristicasProtagonista.SituacaoEconomica perguntarSituacaoEconomica() {
        return this.respostaSituacaoEconomica;
    }

    @Override
    public CaracteristicasProtagonista.NivelVidaSocial perguntarVidaSocial() {
        return this.respostaVidaSocial;
    }

    @Override
    public CaracteristicasProtagonista.ExperienciaEmocionalEnsinoMedio perguntarExperienciaEM() {
        return this.respostaExperienciaEM;
    }
}
