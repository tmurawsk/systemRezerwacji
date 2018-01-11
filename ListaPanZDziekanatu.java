/**
 * 
 */

import java.util.LinkedList;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Tomson
 */
public class ListaPanZDziekanatu {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private static LinkedList<PaniZDziekanatu> listaPanZDziekanatu;

	/** 
	 * @return the listaPanZDziekanatu
	 */
	public static LinkedList<PaniZDziekanatu> getListaPanZDziekanatu() {
		// begin-user-code
		return listaPanZDziekanatu;
		// end-user-code
	}

	/** 
	 * @param listaPanZDziekanatu the listaPanZDziekanatu to set
	 */
	public static void setListaPanZDziekanatu(
			LinkedList<PaniZDziekanatu> listaPanZDziekanatu) {
		// begin-user-code
		ListaPanZDziekanatu.listaPanZDziekanatu = listaPanZDziekanatu;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static boolean czyIstnieje(int id) {
		// begin-user-code
		for (PaniZDziekanatu pzd : listaPanZDziekanatu)
			if (id == pzd.getIdentyfikator())
				return true;
		return false;
		// end-user-code
	}
}