package javaapplicationarvorebb;

public class JavaApplicationArvoreBB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArvoreBB arvore = new ArvoreBB();
        System.out.println(arvore.insere(6));
        System.out.println(arvore.insere(4));
        System.out.println(arvore.insere(9));
        System.out.println(arvore.insere(3));
        System.out.println(arvore.insere(5));
        System.out.println(arvore.insere(8));
        System.out.println(arvore.insere(10));
        System.out.println(arvore.insere(2));
        System.out.println(arvore.insere(7));
        
        arvore.exibeArvore();
        arvore.remove(6);
        arvore.exibeArvore();
        System.out.println(arvore.busca(3));
        
        ArvoreBB arvore2 = new ArvoreBB();
        System.out.println(arvore2.insere(8));
        System.out.println(arvore2.insere(3));
        System.out.println(arvore2.insere(10));
        System.out.println(arvore2.insere(1));
        System.out.println(arvore2.insere(6));
        System.out.println(arvore2.insere(14));
        System.out.println(arvore2.insere(4));
        System.out.println(arvore2.insere(7));
        System.out.println(arvore2.insere(13));
        arvore2.exibeArvore();
        arvore2.preOrdem();
        arvore2.EmOrdem();
        arvore2.posOrdem();
    }
    
}
