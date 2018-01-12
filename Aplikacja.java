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
		System.out.println("Skladanie rezerwacji");
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("Podaj numer sali:");
			int numerSali = in.nextInt();
			Sala sala = ListaSal.znajdzSale(numerSali);
			while (sala == null) {
				System.out
						.println("Nie ma takiej sali. Wprowadz numer jeszcze raz lub (-1) by wyjsc:");
				numerSali = in.nextInt();
				if (numerSali == -1) {
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
				if (dzien == -1) {
					in.close();
					return;
				}
				miesiac = in.nextInt();
				if (miesiac == -1) {
					in.close();
					return;
				}
				rok = in.nextInt();
				if (rok == -1) {
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
				if (godzinaS == -1) {
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
				if (godzinaK == -1) {
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
						godzinaK, dzien, miesiac, rok,
						uzytkownik.getUprawnienia());
				System.out.println("Utworzono rezerwacje");
				break;
			}
			// end-user-code
		}// while
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

		while (rez == null) {
			System.out
					.println("Bledny numer rezerwacji. Wpisz jeszcze raz lub (-1) by wyjsc:");
			numer = in.nextInt();
			if (numer == -1) {
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
	public void zatwierdzRezerwacje(Wykladowca wykladowca) {
		// begin-user-code
		ListaRezerwacji.pokazRezerwacje(wykladowca);
		System.out.println("Prosze wpisac numer rezerwacji do zatwierdzenia:");
		Scanner in = new Scanner(System.in);
		int numer = in.nextInt();
		Rezerwacja rez = ListaRezerwacji.znajdzRezerwacje(numer);

		while (rez == null) {
			System.out
					.println("Bledny numer rezerwacji. Wpisz jeszcze raz lub (-1) by wyjsc:");
			numer = in.nextInt();
			if (numer == -1) {
				in.close();
				return;
			}
			rez = ListaRezerwacji.znajdzRezerwacje(numer);
		}
		ListaRezerwacji.zatwierdzRezerwacje(numer);
		System.out.println("Rezerwacja numer " + numer
				+ " zostala zatwierdzona.");

		in.close();
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 */
	public void zlozUwage(Wykladowca wykladowca) {
		// begin-user-code
		System.out.println("Skladanie uwagi");
		Scanner in = new Scanner(System.in);
		System.out.println("Podaj numer sali, ktorej dotyczy uwaga:");
		int numer = in.nextInt();
		Sala sala = ListaSal.znajdzSale(numer);

		while (sala == null) {
			System.out
					.println("Niepoprawny numer sali. Wprowadz jeszcze raz lub (-1) by wyjsc");
			numer = in.nextInt();
			if (numer == -1) {
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
	public void zatwierdzUwage(Sala sala) {
		// begin-user-code
		ListaUwag.pokazUwagi(sala);
		System.out.println("Prosze wpisac numer uwagi do zatwierdzenia:");
		Scanner in = new Scanner(System.in);
		int numer = in.nextInt();
		Uwaga u = ListaUwag.znajdzUwage(numer);

		while (u == null) {
			System.out
					.println("Bledny numer uwagi. Wpisz jeszcze raz lub (-1) by wyjsc:");
			numer = in.nextInt();
			if (numer == -1) {
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

		Scanner in = new Scanner(System.in);
		int uprawnienia;
		Aplikacja aplikacja = new Aplikacja();
		Wykladowca wykladowca = null;
		PaniZDziekanatu pani = null;
		Sala sala = null;
		ListaSal ls = new ListaSal("data/sale.txt");

		do {
			System.out.println("Kim jestes?");
			System.out.println("[0] Wykladowca\n[1] Pani z Dziekanatu\n[2] Wyjscie");
			uprawnienia = in.nextInt();
			if(uprawnienia == 2){
				uprawnienia = -1;
				break;
			}
			if(uprawnienia != 0 && uprawnienia != 1){
				System.out.println("Bledne dane.");
				continue;
			}
			
			System.out.println("Podaj identyfikator");
			int id = in.nextInt();
			int opcja;
			
			if(uprawnienia == 0){
				wykladowca = ListaWykladowcow.znajdzWykladowce(id);
				while(wykladowca == null){
					System.out.println("Nie ma takiego Wykladowcy. Podaj ID jeszcze raz lub (-1) by anulowac");
					id = in.nextInt();
					if(id == -1)
						break;
					wykladowca = ListaWykladowcow.znajdzWykladowce(id);
				}
				if(id == -1)
					continue;
				aplikacja.setUzytkownik(wykladowca);
				do{
					System.out.println("Co chcesz zrobic?");
					System.out.println("[0] Dodaj rezerwacje\n" +
									"[1] Anuluj rezerwacje\n" + 
									"[2] Pokaz rezerwacje\n" +
									"[3] Zloz uwage\n" +
									"[4] Wyloguj");
					opcja = in.nextInt();
					System.out.print("\033[H\033]2J");
					
					switch(opcja){
					case 0:
						aplikacja.zlozRezerwacje(wykladowca);
						break;
					case 1:
						aplikacja.anulujRezerwacje(wykladowca);
						break;
					case 2:
						aplikacja.pokazRezerwacje(wykladowca);
						break;
					case 3:
						aplikacja.zlozUwage(wykladowca);
						break;
					case 4:
						opcja = -1;
						break;
					default:
						System.out.println("Niepoprawna opcja.");
						break;
					}
				}while(opcja != -1);
			}
			else{
				pani = ListaPanZDziekanatu.znajdzPaniaZDziekanatu(id);
				while(pani == null){
					System.out.println("Nie ma takiej Pani z Dziekanatu. Podaj ID jeszcze raz lub (-1) by anulowac");
					id = in.nextInt();
					if(id == -1)
						break;
					pani = ListaPanZDziekanatu.znajdzPaniaZDziekanatu(id);
				}
				if(id == -1)
					continue;
				aplikacja.setUzytkownik(pani);
				
				do{
					System.out.println("Co chcesz zrobic?");
					System.out.println("[0] Dodaj rezerwacje\n" +
									"[1] Anuluj rezerwacje\n" + 
									"[2] Pokaz rezerwacje\n" +
									"[3] Zatwierdz rezerwacje\n" +
									"[4] Pokaz uwagi\n" +
									"[5] Zatwierdz uwage\n" +
									"[6] Wyloguj");
					opcja = in.nextInt();
					System.out.print("\033[H\033]2J");
					
					if(opcja >=0 && opcja <= 3){
						if(opcja == 0)
							System.out.println("Podaj ID wykladowcy:");
						else
							System.out.println("Podaj ID wykladowcy lub (-1) by wyswietlic wszystkie");
						
						id = in.nextInt();
						wykladowca = ListaWykladowcow.znajdzWykladowce(id);
						
						if(id != -1 || opcja == 0 || opcja > 3)
						{
							while(wykladowca == null){
								System.out.println("Nie ma takiego wykladowcy. Podaj jeszcze raz lub (-1) by wyjsc");
								id = in.nextInt();
								if(id == -1)
									break;
								wykladowca = ListaWykladowcow.znajdzWykladowce(id);
							}
							if(id == -1){
								System.out.print("\033[H\033]2J");
								continue;
							}
						}
					}
					
					if(opcja ==4 || opcja == 5){
						System.out.println("Podaj numer sali lub (-1) by wyswietlic wszystkie uwagi");
						id = in.nextInt();
						sala = ListaSal.znajdzSale(id);
						
						if(id != -1)
						{
							while(sala == null){
								System.out.println("Nie ma takiej sali. Podaj jeszcze raz lub (-1) by wyjsc");
								id = in.nextInt();
								if(id == -1)
									break;
								sala = ListaSal.znajdzSale(id);
							}
							if(id == -1){
								System.out.print("\033[H\033]2J");
								continue;
							}
						}
					}
					
					switch(opcja){
					case 0:
						aplikacja.zlozRezerwacje(wykladowca);
						break;
					case 1:
						aplikacja.anulujRezerwacje(wykladowca);
						break;
					case 2:
						aplikacja.pokazRezerwacje(wykladowca);
						break;
					case 3:
						aplikacja.zatwierdzRezerwacje(wykladowca);
						break;
					case 4:
						aplikacja.pokazUwagi(sala);
						break;
					case 5:
						aplikacja.zatwierdzUwage(sala);
						break;
					case 6:
						opcja = -1;
						break;
					default:
						System.out.println("Niepoprawna opcja.");
						break;
					}
				}while(opcja != -1);
			}
		} while (uprawnienia != 0 && uprawnienia != 1);

		in.close();
	}
}