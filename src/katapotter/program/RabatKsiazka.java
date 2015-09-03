package katapotter.program;

import java.math.BigDecimal;


public class RabatKsiazka {

    private final BigDecimal wartosc;

    public RabatKsiazka(String wielkoscRabatu) {
        this.wartosc = new BigDecimal(wielkoscRabatu);
    }

    public BigDecimal wartosc() {
        return wartosc;
    }
}
