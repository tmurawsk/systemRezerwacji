import java.util.Scanner;

/**
 * 
 */

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Tomson
 */
public class Aplikacja {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Uzytkownik uzytkownik;

	/**
	 * @return the uzytkownik
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Uzytkownik getUzytkownik() {
		// begin-user-code
		return uzytkownik;
		// end-user-code
	}

	/**
	 * @param uzytkownik
	 *            the uzytkownik to set
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setUzytkownik(Uzytkownik uzytkownik) {
		// begin-user-code
		this.uzytkownik = uzytkownik;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 */
	public void zlozRezerwacje(Wykladowca wykladowca) {
		// begin-user-code
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("Podaj numer sali:");
			int numerSali = in.nextInt();
			Sala sala = ListaSal.znajdzSale(numerSali);
			while (sala == null) {
				System.out
						.println("Nie ma takiej sali. Wprowadz numer jeszcze raz lub (-1) by wyjsc:");
				numerSali = in.nextInt();
				if (numerSali == -1)
				{
					in.close();
					return;
				}
				sala = ListaSal.znajdzSale(numerSali);
			}

			System.out.println("Podaj dzien, miesiac i rok (DD MM RRRR):");
			int dzien = in.nextInt();
			int miesiac = in.nextInt();
			int rok = in.nextInt();
			while (dzien < 1 || dzien > 31 || miesiac < 1 || miesiac > 12
					|| rok > 2019 || rok < 2017) {
				System.out
						.println("Zly format daty. Podaj jeszcze raz lub (-1) by wyjsc:");
				dzien = in.nextInt();
				if (dzien == -1)
				{
					in.close();
					return;
				}
				miesiac = in.nextInt();
				if (miesiac == -1)
				{
					in.close();
					return;
				}
				rok = in.nextInt();
				if (rok == -1)
				{
					in.close();
					return;
				}
			}

			System.out.println("Podaj godzine rozpoczecia rezerwacji (5-22):");
			int godzinaS = in.nextInt();
			while (godzinaS < 5 || godzinaS > 22) {
				System.out
						.println("Niepoprawna godzina. Podaj jeszcze raz lub (-1) by wyjsc:");
				godzinaS = in.nextInt();
				if (godzinaS == -1)
				{
					in.close();
					return;
				}
			}

			System.out.println("Podaj godzine zakonczenia rezerwacji (5-22):");
			int godzinaK = in.nextInt();
			while (godzinaK < 5 || godzinaK > 22 || godzinaK < godzinaS) {
				System.out
						.println("Niepoprawna godzina. Podaj jeszcze raz lub (-1) by wyjsc:");
				godzinaK = in.nextInt();
				if (godzinaK == -1)
				{
					in.close();
					return;
				}
			}

			if (!ListaRezerwacji.sprawdzDostepnosc(sala, godzinaS, godzinaK,
					dzien, miesiac, rok))
				System.out
						.println("Podana sala jest w danym terminie zarezerwowana. Prosimy wpisac inne dane.");
			else {
				ListaRezerwacji.stworzRezerwacje(wykladowca, sala, godzinaS,
						godzinaK, dzien, miesiac, rok, uzytkownik.getUprawnienia());
				System.out.println("Utworzono rezerwacje");
				break;
			}
			// end-user-code
		}//while
		in.close();
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 */
	public void pokazRezerwacje(Wykladowca wykladowca) {
		// begin-user-code
		ListaRezerwacji.pokazRezerwacje(wykladowca);
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 */
	public void anulujRezerwacje(Wykladowca wykladowca) {
		// begin-user-code
		ListaRezerwacji.pokazRezerwacje(wykladowca);
		System.out.println("Prosze wpisac numer rezerwacji do anulowania:");
		Scanner in = new Scanner(System.in);
		int numer = in.nextInt();
		Rezerwacja rez = ListaRezerwacji.znajdzRezerwacje(numer);
		
		while(rez == null){
			System.out.println("Bledny numer rezerwacji. Wpisz jeszcze raz lub (-1) by wyjsc:");
			numer = in.nextInt();
			if(numer == -1){
				in.close();
				return;
			}
			rez = ListaRezerwacji.znajdzRezerwacje(numer);
		}
		ListaRezerwacji.anulujRezerwacje(numer);
		
		in.close();
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 */
	public void zatwierdzRezerwacje() {
		// begin-user-code
		ListaRezerwacji.pokazRezerwacje(null);
		System.out.println("Prosze wpisac numer rezerwacji do zatwierdzenia:");
		Scanner in = new Scanner(System.in);
		int numer = in.nextInt();
		Rezerwacja rez = ListaRezerwacji.znajdzRezerwacje(numer);
		
		while(rez == null){
			System.out.println("Bledny numer rezerwacji. Wpisz jeszcze raz lub (-1) by wyjsc:");
			numer = in.nextInt();
			if(numer == -1){
				in.close();
				return;
			}
			rez = ListaRezerwacji.znajdzRezerwacje(numer);
		}
		ListaRezerwacji.zatwierdzRezerwacje(numer);
		System.out.println("Rezerwacja numer " + numer + " zostala zatwierdzona.");
		
		in.close();
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 */
	public void zlozUwage(Wykladowca wykladowca) {
		// begin-user-code
		Scanner in = new Scanner(System.in);
		System.out.println("Podaj numer sali, ktorej dotyczy uwaga:");
		int numer = in.nextInt();
		Sala sala = ListaSal.znajdzSale(numer);
		
		while(sala == null){
			System.out.println("Niepoprawny numer sali. Wprowadz jeszcze raz lub (-1) by wyjsc");
			numer = in.nextInt();
			if(numer == -1){
				in.close();
				return;
			}
			sala = ListaSal.znajdzSale(numer);
		}
		in.close();
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 */
	public void pokazUwagi(Sala sala) {
		// begin-user-code
		ListaUwag.pokazUwagi(sala);
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 */
	public void zatwierdzUwage() {
		// begin-user-code
		ListaUwag.pokazUwagi(null);
		System.out.println("Prosze wpisac numer uwagi do zatwierdzenia:");
		Scanner in = new Scanner(System.in);
		int numer = in.nextInt();
		Uwaga u = ListaUwag.znajdzUwage(numer);
		
		while(u == null){
			System.out.println("Bledny numer uwagi. Wpisz jeszcze raz lub (-1) by wyjsc:");
			numer = in.nextInt();
			if(numer == -1){
				in.close();
				return;
			}
			u = ListaUwag.znajdzUwage(numer);
		}
		ListaUwag.zatwierdzUwage(numer);
		System.out.println("Uwaga numer " + numer + " zostala zatwierdzona.");
		
		in.close();
		// end-user-code
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Witaj w systemie zarzadzania rezerwacjami!");

		Scanner input = new Scanner(System.in);
		int uprawnienia;

		do {
			System.out.println("Kim jestes?");
			uprawnienia = input.nextInt();
		} while (uprawnienia != 0 && uprawnienia != 1);

		input.close();
	}

}