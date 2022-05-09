package javaapplicationfila;

public class JavaApplicationFila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=====================EXEMPLO IMPLEMENTAÇÃO FILA ESTÁTICA=====================");
        filaEstatica();
        System.out.println("=====================EXEMPLO IMPLEMENTAÇÃO FILA DINÂMICA=====================");
        filaDinamica();
    }
    
    public static void filaEstatica(){
        Fila fila = new Fila(5);
        System.out.println("Vazio: "+fila.isEmpty());
        System.out.println("Cheio: "+fila.isFull());
        System.out.println("Fila: "+fila.show());
        
        for (int i = 0; i < 6; i++) {
            if (fila.enqueue(i)) {
                System.out.println("Valor "+i+" inserido com sucesso!");
            } else{
                System.out.println("Fila cheia!");
            }
        }
        System.out.println("Fila: "+fila.show());
        System.out.println("Início: "+fila.peek());
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Elemento removido: "+fila.dequeue());
            System.out.println("Fila: "+fila.show());
            System.out.println("Início: "+fila.peek());
        }
    }
    
    public static void filaDinamica(){
        FilaDinamica filaDinamica = new FilaDinamica();
        System.out.println("Vazio: "+filaDinamica.isEmpty());
        System.out.println("Fila: "+filaDinamica.show());
        
        for (int i = 10; i < 16; i++) {
            filaDinamica.enqueue(i);
        }
        
        System.out.println("Fila: "+filaDinamica.show());
        System.out.println("Início: "+filaDinamica.peek());
        for (int i = 10; i < 16; i++) {
            System.out.println("Elemento Removido: "+filaDinamica.dequeue());
            System.out.println("Fila: "+filaDinamica.show());
            System.out.println("Início: "+filaDinamica.peek());
        }
    }
    
}
