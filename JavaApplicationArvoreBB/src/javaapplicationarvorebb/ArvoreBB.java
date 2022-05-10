package javaapplicationarvorebb;

import java.util.Stack;

public class ArvoreBB {

    private No raiz;

    public ArvoreBB() {
        raiz = null;
    }
    
    public boolean isEmpty(){
        if (raiz == null) {
            return true;
        }
        return false;
    } 
    
    public boolean insere(int dado) {
        No novo = new No(dado);
        if (raiz == null) {
            raiz = novo;
            return true;
        }
        No atual = raiz;
        No pai;
        while (true) {
            if (atual.getDado() == dado) {
                return false;
            }
            pai = atual;
            if (pai.getDado() > dado) {
                atual = atual.getEsq();
                if (atual == null) {
                    pai.setEsq(novo);
                    return true;
                }
            } else {
                atual = atual.getDir();
                if (atual == null) {
                    pai.setDir(novo);
                    return true;
                }
            }
        }
    }
    
    public boolean remove(int dado){
        if (isEmpty()) {
            return false;
        }
        
        No atual = raiz;
        No pai;
        do{
            pai = atual;
            if (dado < atual.getDado()) {
                atual = atual.getEsq();
            } else if (dado > atual.getDado()) {
                atual = atual.getDir();
            }
        } while(atual != null && atual.getDado() != dado);
        
        if (atual == null) {
            return false;
        }
        
        // o nó a ser removido tem dois filhos (esquerda e direita)
        if (atual.getEsq() != null && atual.getDir() != null) {
            // No auxiliar para fazer a troca na árvore
            No aux = atual;
            // Procura pelo menor nó da subárvore direita do nó a ser removido
            // Ou seja, o nó imediatamente maior que o nó a ser removido
            pai = atual;
            atual = atual.getDir();
            while (atual.getEsq() != null){
                pai = atual;
                atual = atual.getEsq();
            }
            // Faz a troca do valor do nó a ser removido pelo nó imediatamente maior
            aux.setDado(atual.getDado());
        }
        
        if (atual.getEsq() != null && atual.getDir() == null) {
            // Verifica se o nó a ser trocado de posição(se entrou no if ln 59) ou o nó a ser removido só tem filhos a esquerda
            if (pai.getEsq() == atual) {
                // Se o nó atual é filho esquerdo de seu pai, o filho esquerdo do atual é "puxado" para ser o filho esquerdo do pai
                pai.setEsq(atual.getEsq());
            } else{
                // Se o nó atual é filho direito de seu pai, o filho esquerdo do atual é "puxado" para ser o filho direito do pai
                pai.setDir(atual.getEsq());
            }
        } else if (atual.getEsq() == null && atual.getDir() != null) {
            // Verifica se o nó a ser trocado de posição(se entrou no if ln 59) ou o nó a ser removido só tem filhos a direita
            if (pai.getEsq() == atual) {
                // Se o nó atual é filho esquerdo de seu pai, o filho direito do atual é "puxado" para ser o filho esquerdo do pai
                pai.setEsq(atual.getDir());
            } else{
                // Se o nó atual é filho direito de seu pai, o filho direito do atual é "puxado" para ser o filho direito do pai
                pai.setDir(atual.getDir());
            }
        } else{
            // Esse nó é folha
            if (pai.getEsq() == atual) {
                // Se o nó atual é filho esquerdo de seu pai, seta o filho esquerdo do pai como null
                pai.setEsq(null);
            } else{
                // Se o nó atual é filho direito de seu pai, seta o filho direito do pai como null
                pai.setDir(null);
            }
        }
        return true;
    }

    public int busca(int dado){
        if (isEmpty()) {
            return -1;
        }
        
        No atual = raiz;
        No pai;
        do{
            pai = atual;
            if (dado < atual.getDado()) {
                atual = atual.getEsq();
            } else if (dado > atual.getDado()) {
                atual = atual.getDir();
            }
        } while(atual != null && atual.getDado() != dado);
        
        if (atual == null) {
            return -1;
        }
        return atual.getDado();
    }
    
    public void preOrdem() {
        if (isEmpty()) {
            return;
        }

        Stack pilha = new Stack();

        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No atual = (No) pilha.pop();
            System.out.print(atual.getDado() + " ");
            if (atual.getDir() != null) {
                pilha.push(atual.getDir());
            }
            if (atual.getEsq() != null) {
                pilha.push(atual.getEsq());
            }
        }
        System.out.println("");
    }

    public void EmOrdem() {
        if (isEmpty()) {
            return;
        }

        Stack pilha = new Stack();

        No atual = raiz;

        while (atual != null) { //percore todos os nós à esquerda até a folha
            pilha.push(atual);
            atual = atual.getEsq();
        }

        while (!pilha.isEmpty()) {
            atual = (No) pilha.pop();
            System.out.print(atual.getDado() + " ");

            if (atual.getDir() != null) {   //se tiver um nó à direita 
                atual = atual.getDir(); //vai para a direita

                while (atual != null) { //percorre todos os nós à esquerda até a folha 
                    pilha.push(atual);
                    atual = atual.getEsq();
                }
            }
        }
        System.out.println("");
    }

    public void posOrdem() {

        Stack pilha1 = new Stack();
        Stack pilha2 = new Stack();

        if (isEmpty()) {
            return;
        }

        pilha1.push(raiz);

        while (!pilha1.isEmpty()) {
            // Tira da pilha 1 e coloca na pilha 2
            No atual = (No) pilha1.pop();
            pilha2.push(atual);

            // empilha os filhos esquerdo e direito na pilha 1
            if (atual.getEsq() != null) {
                pilha1.push(atual.getEsq());
            }
            if (atual.getDir() != null) {
                pilha1.push(atual.getDir());
            }
        }

        while (!pilha2.isEmpty()) {
            No temp = (No) pilha2.pop();
            System.out.print(temp.getDado() + " ");
        }
    }

    /* 
    / Exibe os elementos da árvore utilizando pilhas como auxiliar
    / Considera que os elementos tem 2 dígitos no máximo
     */
    public void exibeArvore() {
        Stack pilhaGlobal = new Stack();
        pilhaGlobal.push(raiz);
        int nEspacos = 32;
        boolean linhaEstaVazia = false;

        System.out.println(
                "......................................................");
        while (!linhaEstaVazia) {
            Stack pilhaInterna = new Stack();
            linhaEstaVazia = true;

            for (int j = 0; j < nEspacos; j++) {
                System.out.print(' ');
            }

            while (!pilhaGlobal.isEmpty()) {
                No atual = (No) pilhaGlobal.pop();
                if (atual != null) {
                    System.out.print(atual.getDado());
                    pilhaInterna.push(atual.getEsq());
                    pilhaInterna.push(atual.getDir());

                    if (atual.getEsq() != null || atual.getDir() != null) {
                        linhaEstaVazia = false;
                    }
                } else {
                    System.out.print("--");
                    pilhaInterna.push(null);
                    pilhaInterna.push(null);
                }
                for (int j = 0; j < nEspacos * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }  // end while !pilhaGlobal.isEmpty
            System.out.println();
            nEspacos /= 2;
            while (!pilhaInterna.isEmpty()) {
                pilhaGlobal.push(pilhaInterna.pop());
            }
        }  // end while !linhaEstaVazia 
        System.out.println(
                "......................................................");
    }  // end exibeArvore()

}
