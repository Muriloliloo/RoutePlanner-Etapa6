package routeplanner.regra;

public class CalculoOcupacao {

    public double calcularPercentual(int quantidadeUtilizada, int capacidade) {

        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }

        if (quantidadeUtilizada < 0) {
            throw new IllegalArgumentException("A quantidade utilizada nao pode ser negativa.");
        }

        return (quantidadeUtilizada * 100.0) / capacidade;
    }
}
