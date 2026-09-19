package br.uefs.forkeazando.controller;

import br.uefs.forkeazando.view.MenuPrincipal;
import java.util.ArrayList;
import java.util.List;

public class FakeMenuPrincipal extends MenuPrincipal {
    private final List<String> respostasProgramadas = new ArrayList<>();
    private int indiceAtual = 0;

    public boolean menuFoiExibido = false;
    public boolean instrucoesForamExibidas = false;
    public boolean mensagemSaindoFoiExibida = false;

    public void adicionarEntradaSimulada(String entrada) {
        this.respostasProgramadas.add(entrada);
    }

    @Override
    public void mostrarMenu() {
        this.menuFoiExibido = true;
    }

    @Override
    public String lerOpcoes() {
        if (indiceAtual < respostasProgramadas.size()) {
            String resposta = respostasProgramadas.get(indiceAtual);
            indiceAtual++;
            return resposta;
        }
        return "0"; 
    }

    @Override
    public void mostrarInstrucoes() {
        this.instrucoesForamExibidas = true;
    }

    @Override
    public void mostrarMensagem(String mensagem) {
        if (mensagem.contains("Saindo")) {
            this.mensagemSaindoFoiExibida = true;
        }
    }
}
