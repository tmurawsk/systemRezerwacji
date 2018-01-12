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
	 * @param filename
	 */
	public ListaSal(String filename){
		try {
			Scanner in = new Scanner(new FileReader(filename));
			while(in.hasNext()){
				Sala sala = new Sala();
				sala.setNumer(in.nextInt());
				
				listaSal.add(sala);
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
	public static Sala znajdzSale(int numer) {
		// begin-user-code
		for (Sala s : listaSal)
			if (s.getNumer() == numer)
				return s;
		return null;
		// end-user-code
	}
}