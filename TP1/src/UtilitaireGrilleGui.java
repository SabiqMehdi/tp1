
public class UtilitaireGrilleGui {

	public static Carte[] afficherCarte(Carte[] carte, GrilleGui gui) {
		
		int a = 0;
		int b = 0;
		for (int i = 0; i < carte.length; i++) {
			if (a >= Constantes.CARTES_PAR_SORTES) {
				a = 0;
				b++;
			}
			if (carte[i].visible == true) {
				gui.setImage(b, a, carte[i].image);
			}
			else { 
				gui.setImage(b, a, null);
			}
			a++;
		}
		return carte;
	}
	
	public static Carte [] retournerCarte(Carte [] carte, GrilleGui gui) {
		int a = 0;
		int b = 0;
		for (int i = 0; i < carte.length; i++) {
			if (a >= Constantes.CARTES_PAR_SORTES) {
				a = 0;
				b++;
			}
			if (carte[i].visible == true) {
				gui.setImage(b,  a, null);
			}
			a++;
		}
		return carte;
	}
}
