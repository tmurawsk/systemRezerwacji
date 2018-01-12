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
	 * @param filename
	 */
	public ListaWykladowcow(String filename){
		try {
			Scanner in = new Scanner(new FileReader(filename));
			while(in.hasNext()){
				Wykladowca w = new Wykladowca();
				w.setIdentyfikator(in.nextInt());
				w.setUprawnienia(0);
				String s = in.nextLine();
				String imie = "", nazwisko = "";
				imie += s.charAt(0);
				boolean czyNazwisko = false;
				
				for(int i = 1; i < s.length(); i++){
					if(s.charAt(i) < 'Z')
						czyNazwisko = true;
					if(czyNazwisko)
						nazwisko += s.charAt(i);
					else
						imie += s.charAt(i);
				}
				
				w.setImie(imie);
				w.setNazwisko(nazwisko);
				listaWykladowcow.add(w);
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
	public static Wykladowca znajdzWykladowce(int id) {
		// begin-user-code
		for (Wykladowca w : listaWykladowcow)
			if (w.getIdentyfikator() == id)
				return w;
		return null;

		// end-user-code
	}
}