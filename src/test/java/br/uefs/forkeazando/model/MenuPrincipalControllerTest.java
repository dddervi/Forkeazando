package br.uefs.forkeazando.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuPrincipalControllerTest {

    private FakeMenuPrincipal fakeView;
    private MenuPrincipalController controller;

    @BeforeEach
    void setUp() {
        fakeView = new FakeMenuPrincipal();
        controller = new MenuPrincipalController(fakeView);
    }

    @Test
    void deveRodarOMenuEProcessarOpcoesAteUsuarioSair() {
        fakeView.adicionarEntradaSimulada("3");
        fakeView.adicionarEntradaSimulada("0");

        controller.iniciar();

        assertTrue(fakeView.menuFoiExibido, "O menu principal deveria ter sido renderizado.");
        assertTrue(fakeView.instrucoesForamExibidas, "A tela de créditos/instruções deveria ter sido chamada.");
        assertTrue(fakeView.mensagemSaindoFoiExibida, "A mensagem de encerramento do jogo deveria ter sido exibida.");
    }
}
