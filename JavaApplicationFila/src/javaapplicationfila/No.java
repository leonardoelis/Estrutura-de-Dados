package javaapplicationfila;

public class No {
    private int valor;
    private No proximo;

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
