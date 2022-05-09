package javaapplicationfila;

public class FilaDinamica{
    private No inicio;
    private No fim;

    public FilaDinamica(){
        inicio = null;
        fim = null;
    }

    public boolean isEmpty(){
        return (inicio == null);
    }

    public boolean enqueue(int valor){
        No novo = new No(valor);
        if(inicio == null){
            inicio = novo;
        } else{
            fim.setProximo(novo);
        }
        fim = novo;
        return true;
    }

    public int dequeue(){
        if(isEmpty()){
            return -1;
        }
        int aux = inicio.getValor();
        inicio = inicio.getProximo();
        if(inicio == null){
            fim = null;
        }
        return aux;
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return inicio.getValor();
    }

    public String show(){
        String saida = "";
        No aux = inicio;
        while(aux != null){
            saida = saida + aux.getValor() + " ";
            aux = aux.getProximo();
        }
        return saida;	
    }
}
