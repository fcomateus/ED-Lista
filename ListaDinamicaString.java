package lseStrings;

import java.util.Arrays;

public class ListaDinamicaString{
    public NoString primeiro;
    public NoString ultimo;

    public ListaDinamicaString() {
        primeiro = null;
        ultimo = null;
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

        //ultimo.proximo = primeiro; //circularidade
    }

    public void adicionarInicio(String valor) {
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
        }
    }

    public void removerFinal() {
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
            System.out.println("lista vazia!");
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

    public int tamanho() {
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

    public void adicionarPosicao(int pos, String valor) {
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
    public String retornarUltimo() {
        NoString atual = primeiro;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }

        return atual.valor;
    }

    public String retornarPenultimo() {
        NoString atual = primeiro;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }

        return atual.valor;
    }

    public String retornarValorPosicao(int pos) {
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

    public NoString retornarItem(int pos) {
        NoString atual = primeiro;

        for (int i = 0; i < pos; i++) {
            atual = atual.proximo;
        }

        return atual;
    }

    public void alterarPosicao(int pos, String valor) {
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

    public void transformarLSENaoCircularCircular() {
        ultimo.proximo = primeiro;
    }

    public void inverterLista() {
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


    public boolean jaNaLista(String valor) {
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

//  public boolean temRepetido() { //CHECAR
//    if (primeiro != null) {
//      int tam = tamanho();
//      NoString atual1 = primeiro;
//      NoString atual2 = primeiro;
//
//      ListaDinamicaString repetidos = new ListaDinamicaString();
//
//      for (int i = 0; i < tam; i++) {
//        atual1 = atual1.proximo;
//
//        for (int j = 0; j < tam; j++) {
//          atual2 = atual2.proximo;
//
//          if (atual1.valor == atual2.valor && !atual1.equals(atual2)) {
//
//            if (!repetidos.jaNaLista(atual1.valor)) {
//              repetidos.adicionarInicio(atual1.valor);
//            }
//
//          }
//        }
//      }
//
//      if (repetidos.tamanho() > 0) {
//        return true;
//      } else {
//        return false;
//      }
//    } else {
//      return false;
//    }
//  }

//  public void itensRepetidos() {
//    if (primeiro != null) {
//      int tam = tamanho();
//      NoString atual1 = primeiro;
//      NoString atual2 = primeiro;
//
//      ListaDinamicaString repetidos = new ListaDinamicaString();
//
//      for (int i = 0; i < tam; i++) {
//        atual1 = atual1.proximo;
//
//        for (int j = 0; j < tam; j++) {
//          atual2 = atual2.proximo;
//
//          if (atual1.valor == atual2.valor && !atual1.equals(atual2)) {
//
//            if (!repetidos.jaNaLista(atual1.valor)) {
//              repetidos.adicionarInicio(atual1.valor);
//            }
//
//          }
//        }
//      }
//
//      if (repetidos.tamanho() > 0) {
//        repetidos.exibir();
//      } else {
//        System.out.println("Nao tem itens repetidos");
//      }
//    } else {
//      System.out.println("Nao tem itens repetidos");
//    }
//  }

    public void removerRepetidos() {
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
    
     public boolean temRepetidos() {
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

    public void inserirAlfabeticamente(String valor) {
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

//    private void ordenarAlfabeticamente() {
//        String nomes[] = new String[tamanho()];
//        for (int i = 0; i < tamanho(); i++) {
//            nomes[i] = retornarValorPosicao(i);
//        }
//        Arrays.sort(nomes);
//        limpar();
//        for (int i = 0; i < nomes.length; i++) {
//            adicionarFinal(nomes[i]);
//        }
//
//    }


    public ListaDinamicaString ordenarAlfabeticamente2(ListaDinamicaString list) {
        ListaDinamicaString listaOrdenada = new ListaDinamicaString();

        NoString atual = list.primeiro;

        while (atual.proximo != null) {
            listaOrdenada.inserirAlfabeticamente(atual.valor);
            atual = atual.proximo;
        }

        listaOrdenada.inserirAlfabeticamente(atual.valor);

        return listaOrdenada;

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