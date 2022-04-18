/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilha;

/**
 *
 * @author fmfr
 */
public class NoStringPilha {
    public String valor;
    public NoStringPilha anterior;

    public NoStringPilha(String valor) {
        this.valor = valor;
        anterior = null;
    }

    @Override
    public String toString() {
        return "No{" + "valor=" + valor + '}';
    }

}
