package javaapplicationpilha;

public class JavaApplicationPilha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=====================EXEMPLO IMPLEMENTAÇÃO PILHA ESTÁTICA=====================");
        pilhaEstatica();
        System.out.println("=====================EXEMPLO IMPLEMENTAÇÃO PILHA DINÂMICA=====================");
        pilhaDinamica();
    }
    
    public static void pilhaDinamica(){
        PilhaDinamica pilhaDinamica = new PilhaDinamica();
        System.out.println("Vazio: "+pilhaDinamica.isEmpty());
        System.out.println("Pilha: "+pilhaDinamica.show());
        
        for (int i = 10; i < 16; i++) {
            pilhaDinamica.push(i);
        }
        
        System.out.println("Pilha: "+pilhaDinamica.show());
        System.out.println("Topo: "+pilhaDinamica.peek());
        for (int i = 10; i < 16; i++) {
            System.out.println("Elemento removido: "+pilhaDinamica.pop());
            System.out.println("Pilha: "+pilhaDinamica.show());
            System.out.println("Topo: "+pilhaDinamica.peek());
        }
    }
    
    public static void pilhaEstatica(){
        Pilha pilha = new Pilha(5);
        System.out.println("Vazio: "+pilha.isEmpty());
        System.out.println("Cheio: "+pilha.isFull());
        
        for (int i = 0; i < 6; i++) {
            if (pilha.push(i)) {
                System.out.println("Valor "+i+" inserido com sucesso!");
            } else{
                System.out.println("Pilha cheia");
            }
        }
        System.out.println("Vazio: "+pilha.isEmpty());
        System.out.println("Cheio: "+pilha.isFull());
        System.out.println("Topo: "+pilha.peek());
        for (int i = 0; i < 6; i++) {
            System.out.println("Tamanho da pilha: "+pilha.size());
            System.out.println("Elemento retirado: "+pilha.pop());
        }
    }
}
