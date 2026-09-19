package br.uefs.forkeazando.controller;

import br.uefs.forkeazando.model.Cena;
import br.uefs.forkeazando.model.Escolha;
import br.uefs.forkeazando.view.CenaView;
import java.util.List;

public class FakeCenaView extends CenaView {
    public boolean renderizouCena = false;

    @Override
    public void renderizar(Cena cena) {
        this.renderizouCena = true; // Apenas anota que passou por aqui
    }

    @Override
    public void exibirEscolhas(List<Escolha> escolhas) {
        // Finge que exibiu no terminal
    }

    @Override
    public void mostrarMensagem(String mensagem) {
        // Finge que mostrou a mensagem de fim de capítulo
    }
}
