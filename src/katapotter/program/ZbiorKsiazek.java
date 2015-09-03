package katapotter.program;

import java.util.ArrayList;
import java.util.List;

public class ZbiorKsiazek {

	private final List<Ksiazka> ksiazki;

	public List<Ksiazka> ksiazki() {
		return ksiazki;
	}

	public boolean jestRowne(int size) {
		return ksiazki.size() == size;
	}

	public ZbiorKsiazek() {
		ksiazki = new ArrayList<>();
	}

	public void dodaj(Ksiazka ksiazka) {
		ksiazki.add(ksiazka);
	}

	public CenaKsiazki cena() {
		RabatKsiazka wielkoscRabatu = RabatyNaKsiazki.iloscKsiazek(ksiazki.size());
		return CenaKsiazki.cenaNormalna().ilosc(ksiazki.size()).zastosowacRabat(wielkoscRabatu);
	}

}
