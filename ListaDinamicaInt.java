package lsemaikol;

import java.util.Arrays;

/**
 *
 * @author fmfr
 */
public class ListaDinamicaInt {
    public NoInt primeiro;
    public NoInt ultimo;

    public ListaDinamicaInt() {
        primeiro = null;
        ultimo = null;
    }

    public void add_1() {
        NoInt aux = primeiro;
        while (aux != ultimo) {
            aux.valor++;
            aux = aux.proximo;
        }
        if (ultimo != null) ultimo.valor++;
    }

// 1  ->  2  -> 3 -> 4 -> null

    public void adicionarFinal(int valor) {
        NoInt novo = new NoInt(valor);

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }

        //ultimo.proximo = primeiro; //circularidade
    }

    public void adicionarInicio(int valor) {
        NoInt novo = new NoInt(valor);

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
                NoInt aux = primeiro;
                primeiro = primeiro.proximo;
                aux.proximo = null;

                //ultimo.proximo = primeiro;
            }
        }
    }

    public void removerFinal() { //CHECAR
        if (ultimo != null) {
            if (primeiro == ultimo) {
                primeiro = null;
                ultimo = null;

            } else {
                NoInt atual = primeiro;

                while (atual.proximo != ultimo) {
                    atual = atual.proximo;
                }

                ultimo = atual;
                ultimo.proximo = null;
            }
        }

    }


    public void removerPosicao(int posicao) {
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
                NoInt atual = primeiro;
                for (int i = 0; i < posicao - 1; i++) {
                    atual = atual.proximo;
                }
                // atual = atual.proximo.proximo;
                NoInt apagar = atual.proximo;
                atual.proximo = atual.proximo.proximo;
                apagar.proximo = null;
            }
        }
    }

    public void exibir() {
        if (primeiro == null) {
            System.out.println("lista vazia");
        } else {
            NoInt atual = primeiro;

            while (atual.proximo != null) {
                System.out.print(atual.valor + " ");
                atual = atual.proximo;
            }

            System.out.print(atual.valor + " ");

            System.out.println();
        }

    }

    public int tamanho() {
        int cont = 0;
        NoInt atual = primeiro;
        while (atual != null && atual != ultimo) {
            cont++;
            atual = atual.proximo;
        }

        if (atual != null) {
            cont++;
        }

        return cont;
    }

    public void adicionarPosicao(int pos, int valor) {
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
            NoInt atual = primeiro;
            // inserir em poiscoes entre o inicio e o fim
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.proximo;
            }
            NoInt novo = new NoInt(valor);
            novo.proximo = atual.proximo;
            atual.proximo = novo;
        }
    }

    // Questao 1 - Lista 1 AV2 - semanal
    // Supondo que nao existe a referencia ultimo
    public int retornarUltimo() {
        NoInt atual = primeiro;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }

        return atual.valor;
    }

    public int retornarPenultimo() {
        NoInt atual = primeiro;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }

        return atual.valor;
    }

    public int retornarValorPosicao(int pos) {
        NoInt atual = primeiro;
        int tamanho = tamanho();
        if (pos < 0 || pos >= tamanho) {
            System.out.println("Posicao invalida");
            return -1;
        }
        for (int i = 0; i < pos; i++) {
            atual = atual.proximo;
        }
        return atual.valor;
    }

    public NoInt retornarItem(int pos) {
        NoInt atual = primeiro;

        for (int i = 0; i < pos; i++) {
            atual = atual.proximo;
        }

        return atual;
    }

    public void alterarPosicao(int pos, int valor) {
        NoInt atual = primeiro;
        int tamanho = tamanho();
        if (pos < 0 || pos >= tamanho) {
            System.out.println("Posicao invalida");

        }
        for (int i = 0; i < pos; i++) {
            atual = atual.proximo;
        }
        atual.valor = valor;
    }

    public void transformarLSENaoCircularCircular() {
        ultimo.proximo = primeiro;
    }

    public void inverterLista() {
        NoInt anterior = null, atual = primeiro, prox = null;
        while (atual != null) {
            prox = atual.proximo;
            atual.proximo = anterior;
            anterior = atual;
            atual = prox;
        }
        ultimo = primeiro;
        primeiro = anterior;

    }


    public boolean jaNaLista(int valor) {
        int tam = tamanho();
        NoInt atual = primeiro;

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

//    public boolean temRepetido() { //CHECAR
//        if (primeiro != null) {
//            int tam = tamanho();
//            NoInt atual1 = primeiro;
//            NoInt atual2 = primeiro;
//
//            ListaDinamicaInt repetidos = new ListaDinamicaInt();
//
//            for (int i = 0; i < tam; i++) {
//                atual1 = atual1.proximo;
//
//                for (int j = 0; j < tam; j++) {
//                    atual2 = atual2.proximo;
//
//                    if (atual1.valor == atual2.valor && !atual1.equals(atual2)) {
//
//                        if (!repetidos.jaNaLista(atual1.valor)) {
//                            repetidos.adicionarInicio(atual1.valor);
//                        }
//
//                    }
//                }
//            }
//
//            if (repetidos.tamanho() > 0) {
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//        }
//    }

//    public void itensRepetidos() { 
//        if (primeiro != null) {
//            int tam = tamanho();
//            NoInt atual1 = primeiro;
//            NoInt atual2 = primeiro;
//
//            ListaDinamicaInt repetidos = new ListaDinamicaInt();
//
//            for (int i = 0; i < tam; i++) {
//                atual1 = atual1.proximo;
//
//                for (int j = 0; j < tam; j++) {
//                    atual2 = atual2.proximo;
//
//                    if (atual1.valor == atual2.valor && !atual1.equals(atual2)) {
//
//                        if (!repetidos.jaNaLista(atual1.valor)) {
//                            repetidos.adicionarInicio(atual1.valor);
//                        }
//
//                    }
//                }
//            }
//
//            if (repetidos.tamanho() > 0) {
//                repetidos.exibir();
//            } else {
//                System.out.println("Nao tem itens repetidos");
//            }
//        } else {
//            System.out.println("Nao tem itens repetidos");
//        }
//    }

    public void limpar() {
        primeiro = null;
        ultimo = null;
    }

//    private void ordenarCrescente() {
//        int nomes[] = new int[tamanho()];
//        for (int i = 0; i < tamanho(); i++) {
//            nomes[i] = retornarValorPosicao(i);
//        }
//        Arrays.sort(nomes);
//        limpar();
//        for (int i = 0; i < nomes.length; i++) {
//            adicionarFinal(nomes[i]);
//        }
//    }

    
    public void inserirCrescente(int valor) {
        if (primeiro == null || primeiro.valor > valor) {
            adicionarInicio(valor);
        } else {
            NoInt novoNo = new NoInt(valor), aux = primeiro;
            while (aux.proximo != null) {
                if (valor < aux.proximo.valor) {
                    novoNo.proximo = aux.proximo;
                    aux.proximo = novoNo;
                    return;
                }
                aux = aux.proximo;
            }
            adicionarFinal(valor);
        }
    }

    public ListaDinamicaInt ordenarCrescente2(ListaDinamicaInt list) {
        ListaDinamicaInt listaOrdenada = new ListaDinamicaInt();

        NoInt atual = list.primeiro;

        while (atual.proximo != null) {
            listaOrdenada.inserirCrescente(atual.valor);
            atual = atual.proximo;
        }

        listaOrdenada.inserirCrescente(atual.valor);

        return listaOrdenada;

    }



    public void removerRepetidos() {
        NoInt aux = primeiro, aux2;
        while (aux != null && aux.proximo != null) { // Até o penúltimo
            aux2 = aux;
            while (aux2.proximo != null) {
                if ((aux.valor)==(aux2.proximo.valor)) {
                    aux2.proximo = aux2.proximo.proximo;
                } else {
                    aux2 = aux2.proximo;
                }
            }
            aux = aux.proximo;
        }
    }
    
     public boolean temRepetidos() {
        NoInt aux = primeiro, aux2;
        while (aux != null && aux.proximo != null) { // Até o penúltimo
            aux2 = aux;
            while (aux2.proximo != null) {
                if ((aux.valor)==(aux2.proximo.valor)) {
                    return true;
                } else {
                    aux2 = aux2.proximo;
                }
            }
            aux = aux.proximo;
        }
        return false;
    }
    // exercicio 1 - transforma essa LSE nao circular em circular
    // public void transformarLSENaoCircularCircular() {
    // ultimo.proximo = primeiro;
    // }

    // Lista Tarefas para transformar esse codigo em uma LSE
    // transformarLSENaoCircularCircular
    ///// LSE Nao Circular ====> LSE Circular ???

    // 1) metodo tamanho: while ( *atual != null *)
    // 2) retornarUltimo() ? => (while(atual.proximo != null))
    // 3) retornaPenultimo()? => (atual.proximo != null)
    // 4)
}