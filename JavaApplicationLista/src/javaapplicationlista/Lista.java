package javaapplicationlista;

public class Lista {

    private No firstNo;
    private No lastNo;
    private int tam;

    public Lista() {
        firstNo = lastNo = null;
        tam = 0;
    }

    public boolean isEmpty() {
        return (firstNo == null);
    }

    public void insertAtFront(int item) {
        if (isEmpty()) { // firstNode e lastNode são nulos
            firstNo = lastNo = new No(item);
        } else { // firstNode se refere ao novo No
            firstNo = new No(item, firstNo);
        }
        tam++;
    }

    public void insertAtBack(int item) {
        if (isEmpty()) {
            firstNo = lastNo = new No(item);
        } else {
            lastNo.setNext(new No(item));
            lastNo = lastNo.getNext();
        }
        tam++;
    }

    public int removeFromFront() {
        if (isEmpty()) {
            return -1; //flag para indicar Lista vazia
        }
        int removItem = firstNo.getDado();
        // atualiza referencias firstNode and lastNode
        if (firstNo == lastNo) { //último nó será removido
            firstNo = lastNo = null;
        } else {
            firstNo = firstNo.getNext();
        }
        tam--;
        return removItem;
    }

    public int removeFromBack() {
        if (isEmpty()) {
            return -1;
        }
        int removedItem = lastNo.getDado();
        if (firstNo == lastNo) {
            firstNo = lastNo = null;
        } else {
            No atual = firstNo;
            while (atual.getNext() != lastNo) {
                atual = atual.getNext();
            }
            lastNo = atual;
            atual.setNext(null);
        }
        tam--;
        return removedItem;
    }

    public No find(int item) {
        if (isEmpty()) {
            return null;
        }
        No atual = firstNo;
        while (atual != null) {
            if (atual.getDado() == item) {
                return (atual);
            }
            atual = atual.getNext();
        }
        return null;
    }

    public boolean remove(int item) {
        No atual, anterior;
        if (isEmpty()) {
            return false;
        }
        anterior = atual = firstNo;
        while (atual != null && atual.getDado() != item) {
            anterior = atual;
            atual = atual.getNext();
        }
        if (atual == null) //não achou
        {
            return false;
        }
        if (atual == firstNo) { //encontrou na 1a posição
            removeFromFront();
        } else if (atual == lastNo) { //encontrou na última posição
            removeFromBack();
        } else { //encontrou em outra posição
            anterior.setNext(atual.getNext());
            tam--;
        }
        return true;
    }

    public String print() {
        String saida = "";
        if (isEmpty()) {
            saida = "Lista Vazia";
        }
        No atual = firstNo;
        while (atual != null) {
            saida = saida + atual.getDado() + " ";
            atual = atual.getNext();
        }
        return saida;
    }
//    
//    public int qtdNo(){
//        int cont = 0;
//        if (isEmpty()) {
//            return cont;
//        } 
//        No novo = firstNo;
//        while (novo != null) {
//            cont++;
//            novo = novo.getNext();
//        }
//        return cont;
//    }

    public int getTam() {
        return tam;
    }

    public int findMaior() {
        if (isEmpty()) {
            return -1;
        }
        int num, maior = 0;
        No novo = firstNo;
        while (novo != null) {
            num = novo.getDado();
            if (num > maior) {
                maior = num;
            }
            novo = novo.getNext();
        }
        return maior;
    }

    public int removeAtPos(int pos) {
        if (pos < 1 || pos > tam || isEmpty()) {
            return -1;
        }
        if (pos == 1) {
            return removeFromFront();
        } else if (pos == tam) {
            return removeFromBack();
        } else {
            No anterior = firstNo;
            No atual = firstNo;
            int cont = 1;
            while (cont < pos) {
                anterior = atual;
                atual = atual.getNext();
                cont++;
            }
            anterior.setNext(atual.getNext());
            tam--;
            return atual.getDado();
        }
    }

    public boolean insertAtPos(int pos, int valor) {
        if (pos < 1 || pos > tam + 1) {
            return false;
        }
        if (isEmpty() || pos == 1) {
            insertAtFront(valor);
            return true;
        }
        if (pos == tam + 1) {
            insertAtBack(valor);
            return true;
        }
        No atual = firstNo;
        No anterior = null;
        int cont = 1;
        while (cont < pos) {
            anterior = atual;
            atual = atual.getNext();
            cont++;
        }
        anterior.setNext(new No(valor, atual));
        tam++;
        return true;
    }

    public boolean insertInOrder(int valor) {
        if (isEmpty()) {
            insertAtFront(valor);
            return true;
        }
        No atual = firstNo;
        No anterior = null;
        while (atual != null && atual.getDado() <= valor) {
            anterior = atual;
            atual = atual.getNext();
        }
        if (atual == firstNo) {
            insertAtFront(valor);
            return true;
        }
        if (atual == null) {
            insertAtBack(valor);
            return true;
        }
        anterior.setNext(new No(valor, atual));
        tam++;
        return true;
    }
}
