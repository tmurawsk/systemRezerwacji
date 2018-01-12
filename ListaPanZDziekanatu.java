/**
 * 
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

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
	 * @param filename
	 */
	public ListaPanZDziekanatu(String filename){
		try {
			Scanner in = new Scanner(new FileReader(filename));
			while(in.hasNext()){
				PaniZDziekanatu pani = new PaniZDziekanatu();
				pani.setIdentyfikator(in.nextInt());
				pani.setUprawnienia(1);
				
				listaPanZDziekanatu.add(pani);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("NIE ZNALEZIONO PLIKU " + filename);
			e.printStackTrace();
		}
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static PaniZDziekanatu znajdzPaniaZDziekanatu(int id) {
		// begin-user-code
		for (PaniZDziekanatu pzd : listaPanZDziekanatu)
			if (id == pzd.getIdentyfikator())
				return pzd;
		return null;
		// end-user-code
	}
}