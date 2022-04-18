package ldeString;

import java.util.Objects;

public class ListaDuplamenteEncadeadaString {

    static class No {

        public String valor;
        public No next;
        public No prev;

        No(String valor) {
            this.valor = valor;
            this.next = null;
            this.prev = null;
        }
    }

    private No inicio;
    private No fim;

    public ListaDuplamenteEncadeadaString() { this.inicio = null; this.fim = null; }

    public void inserirInicio(String valor) {
        No novoNo = new No(valor);
        novoNo.next = inicio;
        if (inicio != null) {
            inicio.prev = novoNo;
        } else {
            fim = novoNo;
        }
        inicio = novoNo;
    }

    public void inserirPos(int pos, String valor) { // indice 0
        if (pos <= 0) {
            inserirInicio(valor);
            return;
        }
        No aux = inicio, novoNo = new No(valor);
        while (aux != null) {
            if (pos == 0) {
                novoNo.prev = aux.prev;
                novoNo.next = aux;
                aux.prev.next = novoNo;
                aux.prev = novoNo;
                return;
            }
            pos--;
            aux = aux.next;
        }
        inserirFim(valor);
    }

    public void inserirOrdenado(String valor) {
        if (inicio == null || (valor.compareTo(inicio.valor) < 0)) {
            inserirInicio(valor);
        } else {
            int pos = 1;
            No aux = inicio.next;
            while (aux != null) {
                if (valor.compareTo(aux.valor) < 0) {
                    inserirPos(pos, valor);
                    return;
                }
                pos++;
                aux = aux.next;
            }
            inserirFim(valor);
        }
    }

    public void inserirFim(String valor) {
        if (fim == null) {
            inserirInicio(valor);
        } else {
            No novoNo = new No(valor);
            novoNo.prev = fim;
            fim.next = novoNo;
            fim = novoNo;
        }
    }

    public void removerInicio() {
        if (inicio != null && inicio == fim) {
            inicio = null;
            fim = null;
        } else if (inicio != null) {
            inicio = inicio.next;
            inicio.prev = null;
        }
    }

    public void removerPos(int pos) {
        if (pos <= 0) {
            removerInicio();
            return;
        }
        No aux = inicio;
        while (aux != null) {
            if (pos == 0) {
                if (aux == fim) {
                    removerFim();
                    return;
                } else {
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;
                    return;
                }
            }
            pos--;
            aux = aux.next;
        }
        System.out.println("Pos Invalida!");
    }

    public void removerRepetidos() {
        No aux = inicio, aux2;
        while (aux != null && aux.next != null) {
            aux2 = aux.next;
            while (aux2 != null) {
                if (Objects.equals(aux.valor, aux2.valor)) {
                    if (aux2 == fim) {
                        removerFim();
                    } else {
                        aux2.prev.next = aux2.next;
                        aux2.next.prev = aux2.prev;
                    }
                }
                aux2 = aux2.next;
            }
            aux = aux.next;
        }
    }

    public void removerFim() {
        if (fim != null && fim == inicio) {
            inicio = null;
            fim = null;
        } else if (fim != null) {
            fim = fim.prev;
            fim.next = null;
        }
    }

    public void imprimir() {
        No aux = inicio;
        while (aux != null) {
            System.out.printf("%s", aux.valor);
            aux = aux.next;
            if (aux != null) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public void imprimirPos(int pos) { // indice 0
        No aux = inicio;
        while (aux != null) {
            if (pos == 0) {
                System.out.println(aux.valor);
                return;
            }
            pos--;
            aux = aux.next;
        }
        System.out.println("Pos invalida!");
    }

    public void imprimirReversa() {
        No aux = fim;
        while (aux != null) {
            System.out.printf("%s", aux.valor);
            aux = aux.prev;
            if (aux != null) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public void getInicio() {
        if (this.inicio == null) {
            System.out.println("null");
        } else {
            System.out.println(this.inicio.valor);
        }
    }

    public void getFim() {
        if (this.fim == null) {
            System.out.println("null");
        } else {
            System.out.println(this.fim.valor);
        }
    }
}
