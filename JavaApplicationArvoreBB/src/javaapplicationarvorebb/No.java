package javaapplicationarvorebb;

public class No {
    private int dado;
    private No dir, esq;
    
    public No(int dado){
        this.dado = dado;
        dir = esq = null;
    }
    
    public int getDado(){
        return dado;
    }
    
    public void setDado(int dado){
        this.dado = dado;
    }
    
    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }
}
