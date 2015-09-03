package katapotter.program;

import java.util.ArrayList;
import java.util.List;

public class OrganizacjaKoszyka {

    private final List<ZbiorKsiazek> zbiorKsiazek;

    public OrganizacjaKoszyka() {
        zbiorKsiazek = new ArrayList<>();
    }

    public void dodaj(ZbiorKsiazek zbKsiazek) {
        zbiorKsiazek.add(zbKsiazek);
    }

    public CenaKsiazki cena() {
        CenaKsiazki cena = new CenaKsiazki();
        for (ZbiorKsiazek zbKsiazek : zbiorKsiazek) {
            cena = cena.dodaj(zbKsiazek.cena());
        }
        return cena;
    }

}