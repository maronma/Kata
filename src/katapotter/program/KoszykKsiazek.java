package katapotter.program;

import java.util.LinkedHashMap;
import java.util.Map;

public class KoszykKsiazek {
	private final Map<Ksiazka, Integer> ksiazki;
	private int kopiujIloscKsiazek = 0;

	public KoszykKsiazek() {
		this.ksiazki = new LinkedHashMap<>();
	}

	private KoszykKsiazek(KoszykKsiazek koszyk) {
		this.ksiazki = new LinkedHashMap<>(koszyk.ksiazki);
		this.kopiujIloscKsiazek = koszyk.kopiujIloscKsiazek;
	}

	private int iloscKsiazek(Ksiazka ksiazka) {
		return ksiazki.get(ksiazka);
	}

	public void usun(Ksiazka ksiazka) {
		kopiujIloscKsiazek--;
		ksiazki.put(ksiazka, iloscKsiazek(ksiazka) - 1);
		if (iloscKsiazek(ksiazka) == 0) {
			ksiazki.remove(ksiazka);
		}
	}

	public void dodaj(Ksiazka ksiazka, int iloscKsiazek) {
		ksiazki.put(ksiazka, iloscKsiazek);
		kopiujIloscKsiazek += iloscKsiazek;
	}

	private void usunKsiazkeZb(ZbiorKsiazek zbiorKsiazek) {
		for (Ksiazka ksiazka : zbiorKsiazek.ksiazki()) {
			usun(ksiazka);
		}
	}

	public OrganizacjaKoszyka wezOrganizacje(int maxKsiazek) {
		OrganizacjaKoszyka organizacjaKoszyka = new OrganizacjaKoszyka();
		KoszykKsiazek koszyk = new KoszykKsiazek(this);
		while (koszyk.czyPusty()) {
			ZbiorKsiazek zbKsiazek = koszyk.wezZbKsiazek(maxKsiazek);
			organizacjaKoszyka.dodaj(zbKsiazek);
			koszyk.usunKsiazkeZb(zbKsiazek);
		}
		return organizacjaKoszyka;
	}

	private ZbiorKsiazek wezZbKsiazek(int maxKsiazek) {
		int ilosc = ksiazkaSetSize(maxKsiazek);
		ZbiorKsiazek zbKsiazek = new ZbiorKsiazek();
		for (Ksiazka ksiazka : ksiazki.keySet()) {
			if (zbKsiazek.jestRowne(ilosc)) {
				break;
			}
			zbKsiazek.dodaj(ksiazka);
		}
		return zbKsiazek;
	}

	private int ksiazkaSetSize(int maxIloscKsiazki) {
		if (ksiazki.size() >= maxIloscKsiazki) {
			return maxIloscKsiazki;
		} else {
			return ksiazki.size();
		}
	}

	private boolean czyPusty() {
		return ksiazki.size() > 0;
	}

	public CenaKsiazki wezNajlepszaCene() {
		CenaKsiazki najlepszaCena = new CenaKsiazki();
		for (int maxIloscKsiazek = 1; maxIloscKsiazek <= ksiazki.size(); maxIloscKsiazek++) {
			CenaKsiazki wartoscCena = wezOrganizacje(maxIloscKsiazek).cena();
			if (wartoscCena.jestLepszaNiz(najlepszaCena)) {
				najlepszaCena = wartoscCena;
			}
		}
		return najlepszaCena;
	}

}
