package katapotter.program;

import java.math.BigDecimal;

public class CenaKsiazki {

	private BigDecimal wartosc;

	public CenaKsiazki() {
		wartosc = new BigDecimal("0");
	}

	public CenaKsiazki(String wartosc) {
		this.wartosc = new BigDecimal(wartosc);
	}

	public static CenaKsiazki cenaNormalna() {
		return new CenaKsiazki("8");
	}

	public CenaKsiazki dodaj(CenaKsiazki cena) {
		return wezCeneKsiazki(wartosc.add(cena.wartosc));
	}

	public boolean jestLepszaNiz(CenaKsiazki cena) {
		return cena.rownaZero() || jestNizszaNiz(cena);
	}

	private boolean jestNizszaNiz(CenaKsiazki cena) {
		return wartosc.compareTo(cena.wartosc) < 0;
	}

	public CenaKsiazki ilosc(int wartosc) {
		return wezCeneKsiazki(this.wartosc.multiply(new BigDecimal(wartosc))); // mnozenie
	}

	private boolean rownaZero() {
		return wartosc.equals(BigDecimal.ZERO);
	}

	public CenaKsiazki zastosowacRabat(RabatKsiazka rabat) {
		return wezCeneKsiazki(this.wartosc.multiply(rabat.wartosc()));
	}

	private CenaKsiazki wezCeneKsiazki(BigDecimal wartosc) {
		CenaKsiazki cenaKsiazki = new CenaKsiazki();
		cenaKsiazki.wartosc = wartosc;
		return cenaKsiazki;
	}

	@Override
	public boolean equals(Object obiekt) {
		CenaKsiazki cenaKsiazki = (CenaKsiazki) obiekt;
		if (wartosc != null ? wartosc.floatValue() != cenaKsiazki.wartosc.floatValue() : cenaKsiazki.wartosc != null) {
			return false;
		} else {
			return true;
		}
	}
}
