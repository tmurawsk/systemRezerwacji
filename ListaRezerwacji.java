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
	public static void stworzRezerwacje(Wykladowca wykladowca, int sala, int godzinaS, int godzinaK, int dzien, int miesiac, int rok, int status) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static void pokazRezerwacje() {
		// begin-user-code
		for(Rezerwacja r : listaRezerwacji)
			System.out.println(r.getNumer() + " " + r.getSala() + " " + r.getWykladowca().getImie() +
					" " + r.getWykladowca().getNazwisko() + " " + r.getGodzinaStart() + "-" + r.getGodzinaKoniec() + 
					" " + r.getStatus() + " " + r.getDzien() + "." + r.getMiesiac() + "." + r.getRok());
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void anulujRezerwacje() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void zatwierdzRezerwacje() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void archiwizujRezerwacje() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static boolean sprawdzDostepnosc(int sala, int godzinaS, int godzinaK, int dzien, int miesiac, int rok) {
		// begin-user-code
		for(Rezerwacja r : listaRezerwacji)
			if(r.getSala().getNumer() == sala && r.getDzien() == dzien && r.getMiesiac() == miesiac && r.getRok() == rok && (r.getGodzinaStart() < godzinaK || r.getGodzinaKoniec() > godzinaS))
				return false;
		return true;
		// end-user-code
	}
}