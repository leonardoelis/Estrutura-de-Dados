package javaapplicationfila;

public class Fila{
    private int dados[];
    private int fim;

    public Fila(int tam){
        dados = new int[tam];
        fim = -1;
    }

    public boolean isEmpty(){
        return (fim == -1);
    }

    public boolean isFull(){
        return (fim == dados.length - 1);
    }

    public boolean enqueue(int valor){
        if(isFull()){
            return false;
        }
        fim++;
        dados[fim] = valor;
        return true;
    }

    public int dequeue(){
        if(isEmpty()){
            return -1;
        }
        int aux = dados[0];
        for(int i = 0; i < fim; i++){
            dados[i] = dados[i + 1];
        }
        fim--;
        return aux;	
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return dados[0];
    }

    public String show(){
        String saida = "";
        for(int i = 0; i <= fim; i++){
            saida = saida + dados[i] + " ";
        }
        return saida;
    }
}