package Observer;

import java.util.Observable;

public class Celular extends Observable {
    private String cor;
    private String nome;

    public Celular(String nome, String cor) {
        this.cor = cor;
        this.nome = nome;
    }

    public void atualizarEstoque() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        String retornarCelular = "celular " + nome + ", cor " + cor;
        return retornarCelular;
    }
}
