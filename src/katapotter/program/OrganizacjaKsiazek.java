package katapotter.program;

public class OrganizacjaKsiazek {

	private final KoszykKsiazek koszyk;

	public OrganizacjaKsiazek() {
		koszyk = new KoszykKsiazek();
	}

	public void dodaj(int ilosc, Ksiazka ksiazka) {
		koszyk.dodaj(ksiazka, ilosc);
	}

	public CenaKsiazki cena() {
		return koszyk.wezNajlepszaCene();
	}

}
