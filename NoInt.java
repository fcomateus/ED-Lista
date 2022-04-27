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
public class NoInt {
    public int valor;
    public NoInt proximo;

    public NoInt(int valor) {
        this.valor = valor;
        proximo = null;
    }

    @Override
    public String toString() {
        return "No{" + "valor=" + valor + '}';
    }

}
