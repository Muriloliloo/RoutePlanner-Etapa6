package routeplanner.regra;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculoOcupacaoTest {

    @Test
    public void deveCalcularCinquentaPorCento() {

        CalculoOcupacao calculo = new CalculoOcupacao();

        double resultado = calculo.calcularPercentual(50, 100);

        assertEquals(50.0, resultado, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRecusarCapacidadeZero() {

        CalculoOcupacao calculo = new CalculoOcupacao();

        calculo.calcularPercentual(10, 0);
    }
}
