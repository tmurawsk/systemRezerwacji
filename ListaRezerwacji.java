/**
 * 
 */

import java.util.LinkedList;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomson
 */
public class ListaRezerwacji {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static int genNr = new Integer(1);

	/** 
	 * @return the genNr
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static int getGenNr() {
		// begin-user-code
		return genNr;
		// end-user-code
	}

	/** 
	 * @param genNr the genNr to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void setGenNr(int genNr) {
		// begin-user-code
		ListaRezerwacji.genNr = genNr;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private static LinkedList<Rezerwacja> listaRezerwacji;

	/** 
	 * @return the listaRezerwacji
	 */
	public static LinkedList<Rezerwacja> getListaRezerwacji() {
		// begin-user-code
		return listaRezerwacji;
		// end-user-code
	}

	/** 
	 * @param listaRezerwacji the listaRezerwacji to set
	 */
	public static void setListaRezerwacji(LinkedList<Rezerwacja> listaRezerwacji) {
		// begin-user-code
		ListaRezerwacji.listaRezerwacji = listaRezerwacji;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static void stworzRezerwacje(Wykladowca wykladowca, Sala sala, int godzinaS, int godzinaK, int dzien, int miesiac, int rok, int status) {
		// begin-user-code
		Rezerwacja rez = new Rezerwacja();
		rez.setNumer(genNr++);
		rez.setWykladowca(wykladowca);
		rez.setDzien(dzien);
		rez.setMiesiac(miesiac);
		rez.setRok(rok);
		rez.setGodzinaStart(godzinaS);
		rez.setGodzinaKoniec(godzinaK);
		rez.setStatus(status);
		rez.setSala(sala);
		
		listaRezerwacji.add(rez);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static void pokazRezerwacje(Wykladowca wykladowca) {
		// begin-user-code
		System.out.println("Numer\tSala\tWykladowca\t\tStart\tKoniec\tStatus\tData");
		for(Rezerwacja r : listaRezerwacji){
			if(wykladowca == null)
			System.out.println(r.getNumer() + " " + r.getSala() + " " + r.getWykladowca().getImie() +
					" " + r.getWykladowca().getNazwisko() + " " + r.getGodzinaStart() + "-" + r.getGodzinaKoniec() + 
					" " + r.getStatus() + " " + r.getDzien() + "." + r.getMiesiac() + "." + r.getRok());
			else if(r.getWykladowca().equals(r.getWykladowca()))
				System.out.println(r.getNumer() + " " + r.getSala() + " " + r.getWykladowca().getImie() +
						" " + r.getWykladowca().getNazwisko() + " " + r.getGodzinaStart() + "-" + r.getGodzinaKoniec() + 
						" " + r.getStatus() + " " + r.getDzien() + "." + r.getMiesiac() + "." + r.getRok());	
		}
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static void anulujRezerwacje(int numer) {
		// begin-user-code
		listaRezerwacji.remove(znajdzRezerwacje(numer));
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static void zatwierdzRezerwacje(int numer) {
		// begin-user-code
		znajdzRezerwacje(numer).setStatus(1);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static void archiwizujRezerwacje(int numer) {
		// begin-user-code
		znajdzRezerwacje(numer).setStatus(-1);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static boolean sprawdzDostepnosc(Sala sala, int godzinaS, int godzinaK, int dzien, int miesiac, int rok) {
		// begin-user-code
		for(Rezerwacja r : listaRezerwacji)
			if(r.getSala().getNumer() == sala.getNumer() && r.getDzien() == dzien && r.getMiesiac() == miesiac && r.getRok() == rok && (r.getGodzinaStart() < godzinaK || r.getGodzinaKoniec() > godzinaS))
				return false;
		return true;
		// end-user-code
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static Rezerwacja znajdzRezerwacje(int numer) {
		// begin-user-code
		for(Rezerwacja r : listaRezerwacji)
			if(r.getNumer() == numer)
				return r;
		return null;
		// end-user-code
	}
}