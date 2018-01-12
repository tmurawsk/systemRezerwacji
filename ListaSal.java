/**
 * 
 */

import java.util.LinkedList;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomson
 */
public class ListaSal {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private static LinkedList<Sala> listaSal;

	/** 
	 * @return the listaSal
	 */
	public static LinkedList<Sala> getListaSal() {
		// begin-user-code
		return listaSal;
		// end-user-code
	}

	/** 
	 * @param listaSal the listaSal to set
	 */
	public static void setListaSal(LinkedList<Sala> listaSal) {
		// begin-user-code
		ListaSal.listaSal = listaSal;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static Sala znajdzSale(int numer) {
		// begin-user-code
		for (Sala s : listaSal)
			if (s.getNumer() == numer)
				return s;
		return null;
		// end-user-code
	}
}