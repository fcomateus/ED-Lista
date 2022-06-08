/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arvorebinariagenerica;

/**
 *
 * @author fmfr
 */
public class Main {
    public static void main(String[] args) {
        ArvoreBinaria t = new ArvoreBinaria();
        ArvoreBinaria t2 = new ArvoreBinaria();
        t.root = t.Constroi(t.root, "CWH..KA..B..J.GU...");
        System.out.println("arvore 1:");
        t.PreOrdem(t.root);
        
//        t2.root = t.espelhar(t.root);
//        System.out.println("");
//        System.out.println("arvore 2:");
//        t2.PreOrdem(t2.root);
        System.out.println("Dado Buscado:"+t.buscar('A').Dado);
        
        
        System.out.println(t.irmao(t.root, t.buscar('A')));
        //System.out.println( t.irmao(t.root, t.buscar('A')) );
        

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //t.root = t.Constroi(t.root, "AB..C..");
        //t2.root = t.clonar(t.root);
        //t2.root = t.espelhar(t.root);
        
        //t.PreOrdem(t.root);
        //t.removerSubArvore('J');
        //t.PreOrdem(t.root);
        
//        t.PreOrdem(t.root);
//        System.out.println("");
//        t2.PreOrdem(t2.root);
        
        //System.out.println(t.predecessor('C').Dado);
        //System.out.println(t.sucessor('W').Dado);
        /*
        t.Criar_Raiz("A");
        t.Criar_Filho_Esquerdo(t.root, "B");
        t.Criar_Filho_Direito(t.root, "C");
        */
        //t.PreOrdem(t.root);
        //                              W           K   
        //System.out.println(t.irmao(t.root.esq, t.root.esq.esq).Dado);
        
        
    }
}
