/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilha;

/**
 *
 * @author fmfr
 */
public class NoIntPilha {
    public int valor;
    public NoIntPilha anterior;

    public NoIntPilha(int valor) {
        this.valor = valor;
        anterior = null;
    }

    @Override
    public String toString() {
        return "No{" + "valor=" + valor + '}';
    }

}