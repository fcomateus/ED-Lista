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