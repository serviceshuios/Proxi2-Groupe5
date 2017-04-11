package metier;

/**
 * La classe d�finissant les placements boursiers
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class PlacementBourse extends Placement {
	public static String PARIS = "Paris";
	public static String NEWYORK = "New-York";
	public static String TOKYO = "Tokyo";
	
	/**
	 * La place boursi�re
	 */
	private String placeBoursiere;
	
	/**
	 * Le montant du placement.
	 */
	private double montantPlacement;

	/**
	 * Constructeur de la classe PlacementBourseService
	 */
	public PlacementBourse() {
		super();
	}
	
	/**
	 * Constructeur avec arguments de la classe PlacementBourse
	 * @param placeBoursiere : la place boursi�re
	 */
	public PlacementBourse(String placeBoursiere) {
		super();
		this.placeBoursiere = placeBoursiere;
	}
	
	/**
	 * Constructeur avec arguments de la classe PlacementBourse
	 * @param placeBoursiere : la place boursi�re
	 * @param montantPlacement : le montant du placement
	 */
	public PlacementBourse(String placeBoursiere, double montantPlacement) {
		super();
		this.placeBoursiere = placeBoursiere;
		this.montantPlacement = montantPlacement;
	}
	
	/**
	 * Getter de l'attribut placeBoursiere
	 * @return la place boursi�re
	 */
	public String getPlaceBoursiere() {
		return placeBoursiere;
	}

	/**
	 * Setter de l'attribut placeBoursiere
	 * @param placeBoursiere : la place boursi�re
	 */
	public void setPlaceBoursiere(String placeBoursiere) {
		this.placeBoursiere = placeBoursiere;
	}

	/**
	 * Getter de l'attribut montantPlacement
	 * @return le montant du placement
	 */
	public double getMontantPlacement() {
		return montantPlacement;
	}

	/**
	 * Setter de l'attribut montantPlacement
	 * @param montantPlacement : le montant du placement
	 */
	public void setMontantPlacement(double montantPlacement) {
		this.montantPlacement = montantPlacement;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlacementBourseService [Place Boursi�re = " + placeBoursiere + ", Montant du placement = " + montantPlacement + "]";
	}
}
