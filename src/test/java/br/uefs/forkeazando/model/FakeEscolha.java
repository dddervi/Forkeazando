package br.uefs.forkeazando.model;

public class FakeEscolha extends Escolha {
    private final boolean forcarDisponibilidade;

    public FakeEscolha(String texto, int destinoId, boolean forcarDisponibilidade) {
        super(texto, destinoId, null, null, 0, 0);
        this.forcarDisponibilidade = forcarDisponibilidade;
    }

    @Override
    public boolean estaDisponivel(Protagonista p) {
        // Isola o teste respondendo fixamente o valor injetado no construtor
        return this.forcarDisponibilidade;
    }
}
