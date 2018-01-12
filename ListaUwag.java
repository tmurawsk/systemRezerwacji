/**
 * 
 */

import java.util.LinkedList;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Tomson
 */
public class ListaUwag {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 */
	private static int genNr = new Integer(1);

	/**
	 * @return the genNr
	 */
	public static int getGenNr() {
		// begin-user-code
		return genNr;
		// end-user-code
	}

	/**
	 * @param genNr
	 *            the genNr to set
	 */
	public static void setGenNr(int genNr) {
		// begin-user-code
		ListaUwag.genNr = genNr;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 */
	private static LinkedList<Uwaga> listaUwag;

	/**
	 * @return the listaUwag
	 */
	public static LinkedList<Uwaga> getListaUwag() {
		// begin-user-code
		return listaUwag;
		// end-user-code
	}

	/**
	 * @param listaUwag
	 *            the listaUwag to set
	 */
	public static void setListaUwag(LinkedList<Uwaga> listaUwag) {
		// begin-user-code
		ListaUwag.listaUwag = listaUwag;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 */
	public static void zlozUwage(Wykladowca wykladowca, Sala sala, String opis) {
		// begin-user-code
		Uwaga u = new Uwaga();
		u.setNumer(genNr++);
		u.setWykladowca(wykladowca);
		u.setSala(sala);
		u.setOpis(opis);
		u.setStatus(0);
		listaUwag.add(u);
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 */
	public static void pokazUwagi(Sala sala) {
		// begin-user-code
		System.out.println("Numer\tSala\tStatus\tWykladowca\t\tOpis");
		for (Uwaga u : listaUwag) {
			if (sala == null)
				System.out.println(u.getNumer() + " " + u.getSala().getNumer()
						+ " " + u.getStatus() + " "
						+ u.getWykladowca().getImie() + " "
						+ u.getWykladowca().getNazwisko() + " " + u.getOpis());
			else if (u.getSala().equals(sala))
				System.out.println(u.getNumer() + " " + u.getSala().getNumer()
						+ " " + u.getStatus() + " "
						+ u.getWykladowca().getImie() + " "
						+ u.getWykladowca().getNazwisko() + " " + u.getOpis());
		}
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 */
	public static void zatwierdzUwage(int numer) {
		// begin-user-code
		znajdzUwage(numer).setStatus(1);
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 */
	public static Uwaga znajdzUwage(int numer) {
		// begin-user-code
		for (Uwaga u : listaUwag)
			if (u.getNumer() == numer)
				return u;
		return null;
		// end-user-code
	}
}