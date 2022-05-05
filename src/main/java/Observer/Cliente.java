package Observer;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void listaDesejados(Celular celular) {
        celular.addObserver(this);
    }

    public void update(Observable celular, Object arg1) {
        this.ultimaNotificacao = "Olá " + this.nome +
                ", o " + celular.toString() +
                ", está disponível!";
    }
}
