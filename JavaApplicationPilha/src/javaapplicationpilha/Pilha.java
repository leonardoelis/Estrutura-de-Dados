package javaapplicationpilha;

public class Pilha{
    private int dados[];
    private int topo;

    public Pilha(int tam){
        dados = new int[tam];
        topo = -1;
    }

    public boolean isEmpty(){
        return(topo == -1);
    }

    public boolean isFull(){
        return (topo == dados.length - 1);
    }

    public boolean push(int valor){
        if(isFull()){
            return false;
        }
        topo++;
        dados[topo] = valor;
        return true;
    }

    public int pop(){
        if(isEmpty()){
            return -1;
        }
        int aux = dados[topo];
        topo--;
        return aux;
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return dados[topo];
    }

    public int size(){
        return topo + 1;
    }
}