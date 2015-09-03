package katapotter.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import katapotter.program.OrganizacjaKsiazek;
import katapotter.program.CenaKsiazki;
import katapotter.program.Ksiazka;

public class NaliczanieRabatuTest {

	private OrganizacjaKsiazek organizacjaKsiazek;

	private CenaKsiazki obliczCene() {
		return organizacjaKsiazek.cena();
	}

	private CenaKsiazki price(String value) {
		return new CenaKsiazki(value);
	}

	@Before
	public void setUp() {
		organizacjaKsiazek = new OrganizacjaKsiazek();
	}

	@Test
	public void obliczCeneJednejKsiazki() {
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_1);

		assertThat(obliczCene(), is(price("8")));
	}

	@Test
	public void obliczCene2IdentycznychKsiazek() {
		organizacjaKsiazek.dodaj(2, Ksiazka.KSIAZKA_1);

		assertThat(obliczCene(), is(price("16")));
	}

	@Test
	public void obliczCene2Ksiazek1_1() {
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_1);
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_2);

		assertThat(obliczCene(), is(price("15.2")));
	}

	@Test
	public void obliczCene3Ksiazek1_1_1() {
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_1);
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_2);
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_3);

		assertThat(obliczCene(), is(price("21.6")));
	}

	@Test
	public void obliczCene2Ksiazek2_1() {
		organizacjaKsiazek.dodaj(2, Ksiazka.KSIAZKA_1);
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_2);

		assertThat(obliczCene(), is(price("23.2")));
	}

	@Test
	public void obliczCene4Ksiazek1_1_1_1() {
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_1);
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_2);
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_3);
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_4);

		assertThat(obliczCene(), is(price("25.6")));
	}

	@Test
	public void obliczCene4Ksiazek1_2_1_1() {
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_1);
		organizacjaKsiazek.dodaj(2, Ksiazka.KSIAZKA_2);
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_3);
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_4);

		assertThat(obliczCene(), is(price("33.6")));
	}

	@Test
	public void obliczCene5Ksiazek1_1_1_1_1() {
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_1);
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_2);
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_3);
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_4);
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_5);
		assertThat(obliczCene(), is(price("30")));
	}

	@Test
	public void calculate_price_2_2_2_1_1() {
		organizacjaKsiazek.dodaj(2, Ksiazka.KSIAZKA_1);
		organizacjaKsiazek.dodaj(2, Ksiazka.KSIAZKA_2);
		organizacjaKsiazek.dodaj(2, Ksiazka.KSIAZKA_3);
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_4);
		organizacjaKsiazek.dodaj(1, Ksiazka.KSIAZKA_5);

		assertThat(obliczCene(), is(price("51.2")));
	}

}
