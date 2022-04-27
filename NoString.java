/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fila;

/**
 *
 * @author fmfr
 */
public class NoString {
    public String valor;
    public NoString proximo;

    public NoString(String valor) {
        this.valor = valor;
        proximo = null;
    }

    @Override
    public String toString() {
        return "No{" + "valor=" + valor + '}';
    }

}