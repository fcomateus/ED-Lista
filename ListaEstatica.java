/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafios.replit;
class ListaEstatica {

    private int[] v;
    private int tamanho;

    public ListaEstatica(int n) {
        v = new int[n];
        tamanho = 0;
    }

    public void adicionarFinal(int valor) {
        if (tamanho < v.length) {
            v[tamanho] = valor;
            tamanho++;
        } else {
            System.out.println("Lista cheia!");
        }
    }

    public void adicionarPosicao(int pos, int valor) {
        if (pos < v.length) {
            for (int i = tamanho; i > pos; i--) {
                v[i] = v[i - 1];
            }

            v[pos] = valor;
            tamanho++;
        } else {
            System.out.println("Posicao informada nao existe.");
        }
    }

    public void adicionarInicio(int valor) {
        adicionarPosicao(valor, 0);
    }

    public void removerFinal() {
        if (tamanho == 0) {
            System.out.println("Lista vazia!");
        } else {
            tamanho--;
        }
    }

    public void removerPosicao(int pos) {
        if (tamanho == 0) {
            System.out.println("Lista vazia!");
        } else if (pos < 0 || pos >= tamanho) {
            System.out.println("Posicao invalida!");
        } else {
            for (int i = pos; i < tamanho - 1; i++) {
                v[i] = v[i + 1];
            }
            tamanho--;
        }
    }

    public void removerInicio() {
        removerPosicao(0);
    }
    
    public void removerValor(int valor){
        for(int i = 0; i < tamanho; i++){
            if(v[i] == valor){
                removerPosicao(i);
            }
        }
    }

    public int indiceDoValor(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (valor == v[i]) {
                return i;
            }
        }

        return -1;
    }

    public boolean vazia() {
        if (tamanho == 0) {
            return true;
        }

        return false;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(v[i] + " ");
        }

        System.out.println();
    }

    /// Questao 1.
    //1) Fazer um metodo detro da classe ListaEstatica para retornar o elemento do meio da lista (suponha que existe meio - tamanho impar);
    public int retornarElementoMeio() {
        return v[tamanho / 2];
    }
    //Questao 2
    //2) Fazer um metodo para trocar o primeiro com iltimo elemento da lista (ultimos serao os primeiros);

    public void trocarPrimeiroUltimo() {
        int aux = v[0];
        v[0] = v[tamanho - 1];
        v[tamanho - 1] = aux;
    }

    //Questao 3
    // 3) Implementar o metodo get(int pos) -> retorna o elemento da lista da posicao pos;
    public int retornarElemento(int pos) {
        return v[pos];
    }
    //Questao 4
    //4) Implementar um metodo na classe ListaEstatica para invertar a lista. Exemplo {13, 17, 45, 50, 25} ===> {25,50,45,17,13};

    public void inverterLista() {
        // TODO: Tarefa de classe
        for (int i = 0; i < Math.floor(tamanho / 2); i++) {
            int aux = retornarElemento(i);
            v[i] = v[tamanho - (i + 1)];
            v[tamanho - (i + 1)] = aux;
        }
    }

    public void eliminarRepetidos() {
        // TODO: Tarefa de classe
        //Eliminar elementos eliminarRepetidos
        //Ex: {1, 2, 3, 1, 4, 5, 1, 2} => retornar {1, 2, 3, 4, 5}
        for (int i = 0; i < getTamanho() - 1; i++) {
            for (int j = i + 1; j < getTamanho(); j++) {
                if (v[i] == v[j]) {
                    removerPosicao(j);
                    j--;
                }
            }
        }
    }

    public void redefinirElemento(int pos, int valor) {
        if (pos <= getTamanho() && pos >=0) {
            v[pos] = valor;
        } else{
            System.out.println("Posição inválida!");
        }

    }
  
    public void ordenarCrescente() {
        for (int i = 0; i < getTamanho(); i++) {
            for (int j = 0; j < getTamanho() - 1; j++) {
                if (retornarElemento(j) > retornarElemento(j + 1)) {
                    int aux = retornarElemento(j + 1);
                    redefinirElemento(j + 1, retornarElemento(j));
                    redefinirElemento(j, aux);
                }
            }
        }
    }

    public void ordenarDecrescente() {
        for (int i = 0; i < getTamanho(); i++) {
            for (int j = 0; j < getTamanho() - 1; j++) {
                if (retornarElemento(j) < retornarElemento(j + 1)) {
                    int aux = retornarElemento(j + 1);
                    redefinirElemento(j + 1, retornarElemento(j));
                    redefinirElemento(j, aux);
                }
            }
        }
    }
    
    public boolean contem(int valor){
        for(int i = 0; i < getTamanho(); i++){
            if(v[i] == valor){
                return true;
            }
        }
        
        return false;
    }
    
    
  
}

