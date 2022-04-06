package lseStrings;

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