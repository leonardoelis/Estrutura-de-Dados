package javaapplicationpilha;

public class PilhaDinamica{
    private No topo;

    public PilhaDinamica(){
        topo = null;
    }

    public boolean isEmpty(){
        return (topo == null);
    }

    public boolean push(int valor){
        No novo = new No(valor);
        novo.setProximo(topo);
        topo = novo;
        return true;
    }

    public int pop(){
        if(isEmpty()){
            return -1;
        }
        int aux = topo.getValor();
        topo = topo.getProximo();
        return aux;		
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return topo.getValor();
    }

    public String show(){
        String saida = "";
        No aux = topo;
        while(aux != null){
            saida = saida + aux.getValor() + " ";
            aux = aux.getProximo();
        }
        return saida;
    }
}