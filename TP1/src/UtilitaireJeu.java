
public class UtilitaireJeu {
	public static void initialiserJeu(Carte [] jeuNeuf, Carte [] carteAffichees, GrilleGui gui, EtatJeu etat) {
		carteAffichees = UtilitaireTableauCartes.brasser(carteAffichees);
		carteAffichees = UtilitaireGrilleGui.afficherCarte(carteAffichees, gui);
		carteAffichees = UtilitaireGrilleGui.retournerCarte(carteAffichees, gui);
	}
}
