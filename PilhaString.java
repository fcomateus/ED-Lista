/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilha;

/**
 *
 * @author fmfr
 */
public class PilhaString {
    private int size;
    private NoStringPilha top;

    public PilhaString() {
        this.size = 0;
    }

    public boolean isEmpty(){
        if(top == null){
            return true;
        } else {
            return false;
        }
    }

    public String peek(){
        if(isEmpty()){
            return null;
        } else {
            return top.valor;
        }
    }

    public String pop(){//LSE removerInicio
        size--;
        if(top != null){
            NoStringPilha aux = top;

            top = top.anterior;
            //aux.anterior = null;
            return aux.valor;
        } else {
            return null;
        }

    }

    public NoStringPilha push(String v){//LSE adicionarFinal
        size++;
        NoStringPilha novo = new NoStringPilha(v);

        if(top == null){
            top = novo;
            top.anterior = null;
        } else {
            novo.anterior = top;
            top = novo;

        }

        return top;
    }

    public boolean contains(String s){//LSE jáNaLista
        int tam = size();
        NoStringPilha atual = top;

        if (atual.anterior != null) {
            for (int i = 0; i < tam; i++) {
                if (atual.valor.equals(s)) {
                    return true;
                }

                atual = atual.anterior;
            }
        }

        return false;
    }

    public static PilhaString clone(PilhaString pilha){//Código que mandei no WhatsApp
        PilhaString pilhaInvertida = new PilhaString();
        PilhaString pilhaClonada = new PilhaString();

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
            NoStringPilha atual = top;

            while (atual.anterior != null) {
                System.out.print(atual.valor + "; ");
                atual = atual.anterior;
            }

            System.out.print(atual.valor);

            //System.out.println();
        }

    }

}