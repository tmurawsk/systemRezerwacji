/**
 * 
 */

import java.util.LinkedList;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomson
 */
public class ListaWykladowcow {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private static LinkedList<Wykladowca> listaWykladowcow;

	/** 
	 * @return the listaWykladowcow
	 */
	public static LinkedList<Wykladowca> getListaWykladowcow() {
		// begin-user-code
		return listaWykladowcow;
		// end-user-code
	}

	/** 
	 * @param listaWykladowcow the listaWykladowcow to set
	 */
	public static void setListaWykladowcow(
			LinkedList<Wykladowca> listaWykladowcow) {
		// begin-user-code
		ListaWykladowcow.listaWykladowcow = listaWykladowcow;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static Wykladowca znajdzWykladowce(int id, String nazwisko, String imie) {
		// begin-user-code
		for (Wykladowca w : listaWykladowcow)
			if (w.getIdentyfikator() == id && w.getImie() == imie
					&& w.getNazwisko() == nazwisko)
				return w;
		return null;

		// end-user-code
	}
}