package javaapplicationlista;

public class No {

    private int dado;
    private No nextNo;

    public No(int valor) {
        dado = valor;
        nextNo = null;
    }

    public No(int valor, No no) {
        dado = valor;
        nextNo = no;
    }

    public int getDado() {
        return dado; // retorna dado armazenado no No
    }

    public No getNext() {
        return nextNo;
    }

    public void setNext(No prox) {
        nextNo = prox;
    }
} // fim da classe

