package javaapplicationlista;

public class JavaApplicationLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista lista = new Lista();
        
        System.out.println("Quantidades de Nós: " +lista.getTam());
        
        lista.insertAtFront(40);
        System.out.println(lista.print());
        System.out.println("Quantidades de Nós: " +lista.getTam());
        
        lista.insertAtFront(20);
        System.out.println(lista.print());
        System.out.println("Quantidades de Nós: " +lista.getTam());
        
        lista.insertAtBack(10);
        System.out.println(lista.print());
        System.out.println("Quantidades de Nós: " +lista.getTam());
        
        System.out.println(lista.insertAtPos(5, 200));
        System.out.println(lista.print());
        
        int removedItem = lista.removeFromFront();
        System.out.println("Removido: " +removedItem);
        System.out.println(lista.print());
        
        removedItem = lista.removeFromFront();
        System.out.println("Removido: " +removedItem);
        System.out.println(lista.print());
        
        removedItem = lista.removeFromBack();
        System.out.println("Removido: " +removedItem);
        System.out.println(lista.print());

        System.out.println(lista.remove(40));
        System.out.println(lista.print());
        System.out.println("Quantidades de Nós: " +lista.getTam());
        
        System.out.println(lista.remove(22));
        System.out.println(lista.print());
        System.out.println("Quantidades de Nós: " +lista.getTam());
        
        System.out.println(lista.remove(10));
        System.out.println(lista.print());
        System.out.println("Quantidades de Nós: " +lista.getTam());
        
        System.out.println(lista.remove(20));
        System.out.println(lista.print());
        System.out.println("Quantidades de Nós: " +lista.getTam());

        lista.insertAtFront(40);
        lista.insertAtFront(20);
        lista.insertAtBack(50);
        System.out.println(lista.findMaior());
    }
    
}
