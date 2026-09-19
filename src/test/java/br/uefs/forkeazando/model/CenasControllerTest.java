package br.uefs.forkeazando.controller;

import br.uefs.forkeazando.model.Cena;
import br.uefs.forkeazando.model.Escolha;
import br.uefs.forkeazando.model.Estado;
import br.uefs.forkeazando.model.Protagonista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CenasControllerTest {

    private Estado estado;
    private List<Cena> listaCenas;
    private FakeCenaView fakeView;

    @BeforeEach
    void setUp() {
        Protagonista protagonista = new Protagonista(null);
        estado = new Estado();
        estado.iniciar(protagonista);
        estado.setCenaAtualId(101);

        listaCenas = new ArrayList<>();
        fakeView = new FakeCenaView();

        Cena cenaMatricula = new Cena(101, "Cap. 1", "Narrador", "Texto da Matrícula...");
        Escolha escolherVeterano = new Escolha("Aceitar ajuda.", 102, "ajudou_veterano", null, 0, 0);
        cenaMatricula.adicionarEscolha(escolherVeterano);

        Cena cenaDestino = new Cena(102, "Cap. 1", "Veterano", "Obrigado pela ajuda.");

        listaCenas.add(cenaMatricula);
        listaCenas.add(cenaDestino);
    }

    @Test
    void deveAvancarCenaEConcederFlagAoEscolherOpcaoValida() {
        // Simula o input do usuário digitando "1" e apertando Enter
        Scanner scannerSimulado = new Scanner("1\n");

        CenasController controller = new CenasController(estado, listaCenas, fakeView, scannerSimulado);
        controller.iniciar();

        assertEquals(102, estado.getCenaAtualId());
        assertTrue(estado.getProtagonista().getFlagsDecisao().contains("ajudou_veterano"));
        assertTrue(fakeView.renderizouCena);
    }
}
