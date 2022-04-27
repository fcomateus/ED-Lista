/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filadupla;

import fila.*;

/**
 *
 * @author fmfr
 */
public class FilaDuplaString{
    private NoString primeiro;
    private NoString ultimo;
    public int tamanho;

    public FilaDuplaString() {
        primeiro = null;
        ultimo = null;
    }
    
    public String valorPrimeiro(){
        return primeiro.valor;
    }

//  public void add_1() {
//    No aux = primeiro;
//    while (aux != ultimo) {
//      aux.valor++;
//      aux = aux.proximo;
//    }
//    if (ultimo != null) ultimo.valor++;
//  }

// 1  ->  2  -> 3 -> 4 -> null

    public void adicionarFinal(String valor) {
        NoString novo = new NoString(valor);

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }
        tamanho++;

        //ultimo.proximo = primeiro; //circularidade
    }

    private void adicionarInicio(String valor) {
        NoString novo = new NoString(valor);

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            novo.proximo = primeiro;
            primeiro = novo;
        }

        //ultimo.proximo = primeiro;
    }

    public void removerInicio() {
        if (primeiro != null) {
            if (primeiro == ultimo) {
                primeiro = null;
                ultimo = null;
            } else {
                NoString aux = primeiro;
                primeiro = primeiro.proximo;
                aux.proximo = null;

                //ultimo.proximo = primeiro;
            }
           tamanho--; 
        }
        
    }
    
    public boolean vazia(){
        if(tamanho > 0){
            return false;
        } else {
            return true;
        }
    }

    private void removerFinal() {
        if (ultimo != null) {
            if (primeiro == ultimo) {
                primeiro = null;
                ultimo = null;

            } else {
                NoString atual = primeiro;

                while (atual.proximo != ultimo) {
                    atual = atual.proximo;
                }

                ultimo = atual;
                ultimo.proximo = null;
            }
        }

    }


    private void removerPosicao(int posicao) {
        int tam = tamanho();

        if (posicao < 0 || posicao >= tam) {
            System.out.println("Posicao (" + posicao + ") Invalida!!!");
            return;
        }

        if (posicao == (tam - 1)) {
            removerFinal();
        } else {
            if (posicao == 0) {
                removerInicio();
            } else {
                NoString atual = primeiro;
                for (int i = 0; i < posicao - 1; i++) {
                    atual = atual.proximo;
                }
                // atual = atual.proximo.proximo;
                NoString apagar = atual.proximo;
                atual.proximo = atual.proximo.proximo;
                apagar.proximo = null;
            }
        }
    }

    public void exibir() {
        if(primeiro == null){
            System.out.println("fila vazia!");
        } else{
            NoString atual = primeiro;

            while (atual.proximo != null) {
                System.out.print(atual.valor + " ");
                atual = atual.proximo;
            }

            System.out.print(atual.valor + " ");

            System.out.println();
        }

    }
    

    private int tamanho() {
        int cont = 0;
        NoString atual = primeiro;
        while (atual != null && atual != ultimo) {
            cont++;
            atual = atual.proximo;
        }

        if (atual != null) {
            cont++;
        }

        return cont;
    }

    private void adicionarPosicao(int pos, String valor) {
        int tam = tamanho();
        // posicao invalida...
        if (pos < 0 || pos > tam) {
            System.out.println("Posicao Invalida!!!");
            return;
        }
        if (pos == 0) {
            adicionarInicio(valor);
        } else if (pos == tamanho()) {
            adicionarFinal(valor);
        } else {
            NoString atual = primeiro;
            // inserir em poiscoes entre o inicio e o fim
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.proximo;
            }
            NoString novo = new NoString(valor);
            novo.proximo = atual.proximo;
            atual.proximo = novo;
        }
    }

    // Questao 1 - Lista 1 AV2 - semanal
    // Supondo que nao existe a referencia ultimo
    private String retornarUltimo() {
        NoString atual = primeiro;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }

        return atual.valor;
    }

    private String retornarPenultimo() {
        NoString atual = primeiro;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }

        return atual.valor;
    }

    private String retornarValorPosicao(int pos) {
        NoString atual = primeiro;
        int tamanho = tamanho();
        if (pos < 0 || pos >= tamanho) {
            System.out.println("Posicao invalida");
            return "posição inválida";
        }
        for (int i = 0; i < pos; i++) {
            atual = atual.proximo;
        }
        return atual.valor;
    }

    private NoString retornarItem(int pos) {
        NoString atual = primeiro;

        for (int i = 0; i < pos; i++) {
            atual = atual.proximo;
        }

        return atual;
    }

    private void alterarPosicao(int pos, String valor) {
        NoString atual = primeiro;
        int tamanho = tamanho();
        if (pos < 0 || pos >= tamanho) {
            System.out.println("Posicao invalida");

        }
        for (int i = 0; i < pos; i++) {
            atual = atual.proximo;
        }
        atual.valor = valor;
    }

    private void transformarLSENaoCircularCircular() {
        ultimo.proximo = primeiro;
    }

    public void inverterFila() {
        NoString anterior = null, atual = primeiro, prox = null;
        while (atual != null) {
            prox = atual.proximo;
            atual.proximo = anterior;
            anterior = atual;
            atual = prox;
        }
        ultimo = primeiro;
        primeiro = anterior;

    }


    public boolean jaNaFila(String valor) {
        int tam = tamanho();
        NoString atual = primeiro;

        if (primeiro != null) {
            for (int i = 0; i < tam; i++) {
                if (atual.valor == valor) {
                    return true;
                }

                atual = atual.proximo;
            }
        }

        return false;
    }


    private void removerRepetidos() {
        NoString aux = primeiro, aux2;
        while (aux != null && aux.proximo != null) { // Até o penúltimo
            aux2 = aux;
            while (aux2.proximo != null) {
                if ((aux.valor).equals(aux2.proximo.valor)) {
                    aux2.proximo = aux2.proximo.proximo;
                } else {
                    aux2 = aux2.proximo;
                }
            }
            aux = aux.proximo;
        }
    }

    private boolean temRepetidos() {
        NoString aux = primeiro, aux2;
        while (aux != null && aux.proximo != null) { // Até o penúltimo
            aux2 = aux;
            while (aux2.proximo != null) {
                if ((aux.valor).equals(aux2.proximo.valor)) {
                    return true;
                } else {
                    aux2 = aux2.proximo;
                }
            }
            aux = aux.proximo;
        }
        return false;
    }

    public void limpar(){
        primeiro = null;
        ultimo = null;
    }

    private void inserirAlfabeticamente(String valor) {
        if (primeiro == null || (valor.compareTo(primeiro.valor) < 0)) {
            adicionarInicio(valor);
        } else {
            NoString novoNo = new NoString(valor), aux = primeiro;
            while (aux.proximo != null) {
                if (valor.compareTo(aux.proximo.valor) < 0) {
                    novoNo.proximo = aux.proximo;
                    aux.proximo = novoNo;
                    return;
                }
                aux = aux.proximo;
            }
            adicionarFinal(valor);
        }
    }

}