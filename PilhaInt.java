/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilha;

/**
 *
 * @author fmfr
 */
public class PilhaInt {
    private int size;
    private NoIntPilha top;

    public PilhaInt() {
        this.size = 0;
    }

    public boolean isEmpty(){
        if(top == null){
            return true;
        } else {
            return false;
        }
    }

    public int peek(){
        if(isEmpty()){
            return -404;
        } else {
            return top.valor;
        }
    }

    public int pop(){//LSE removerInicio
        size--;
        if(top != null){
            NoIntPilha aux = top;

            top = top.anterior;
            //aux.anterior = null;
            return aux.valor;
        } else {
            return -404;
        }

    }

    public NoIntPilha push(int v){//LSE adicionarFinal
        size++;
        NoIntPilha novo = new NoIntPilha(v);

        if(top == null){
            top = novo;
            top.anterior = null;
        } else {
            novo.anterior = top;
            top = novo;

        }

        return top;
    }

    public boolean contains(int s){//LSE jáNaLista
        int tam = size();
        NoIntPilha atual = top;

        if (atual.anterior != null) {
            for (int i = 0; i < tam; i++) {
                if (atual.valor == s) {
                    return true;
                }

                atual = atual.anterior;
            }
        }

        return false;
    }

    public static PilhaInt clone(PilhaInt pilha){//Código que mandei no WhatsApp
        PilhaInt pilhaInvertida = new PilhaInt();
        PilhaInt pilhaClonada = new PilhaInt();

        while (!pilha.isEmpty()){
            pilhaInvertida.push(pilha.pop());
        }

        while(!pilhaInvertida.isEmpty()){
            pilhaClonada.push(pilhaInvertida.peek());
            pilha.push(pilhaInvertida.pop());
        }

        return pilhaClonada;
    }

    public int size(){
        return size;
    }

    public void show() {
        if(top == null){
            System.out.println("pilha vazia!");
        } else{
            NoIntPilha atual = top;

            while (atual.anterior != null) {
                System.out.print(atual.valor + "; ");
                atual = atual.anterior;
            }

            System.out.print(atual.valor);

            //System.out.println();
        }

    }

}
