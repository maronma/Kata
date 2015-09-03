package katapotter.program;

public class RabatyNaKsiazki {

	private static final RabatKsiazka[] wielkoscRabatu = { new RabatKsiazka("0"), new RabatKsiazka("1"),
			new RabatKsiazka("0.95"), new RabatKsiazka("0.9"), new RabatKsiazka("0.8"), new RabatKsiazka("0.75") };

	public static RabatKsiazka iloscKsiazek(int iloscKsiazek) {
		return wielkoscRabatu[iloscKsiazek];
	}
}