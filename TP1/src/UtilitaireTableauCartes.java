
public class UtilitaireTableauCartes {

	public static final int MIN = 1;
	public static final int MAX = 5;
	public static final int DEPLACER_CARTE_MIN = 3;
	public static final int DEPLACER_CARTE_MAX = 10;
	
	public static Carte [] brasser(Carte [] carte) {
		
		int nbAleatoire = (int)(Math.random() * (MAX - MIN)) + MIN;
		Carte[] carteBrasser = carte;
		
		for (int i = 0; i < nbAleatoire; i++) {
			carteBrasser = melanger(carteBrasser);
			Carte [] carteMoitie1 = separer(carteBrasser, 1);
			Carte [] carteMoitie2 = separer(carteBrasser, 2);
			carte = fusionner(carteBrasser, carteMoitie1, carteMoitie2);
		}
		return carte;
	}
	
	private static Carte [] melanger(Carte [] carteBrasser) {
		
		int nbAleatoire = (int)(Math.random() * (MAX - MIN)) + MIN;
		
		for (int i = 0; i < nbAleatoire; i++) {
			
			int nbCarteAleatoire = (int) (Math.random() * (DEPLACER_CARTE_MAX - DEPLACER_CARTE_MIN)) + DEPLACER_CARTE_MIN;
			
			Carte [] carteDeplacer = new Carte [nbCarteAleatoire];
			carteBrasser = deplacerCarte(carteBrasser, carteDeplacer);
		}
		
		return carteBrasser;
	}
	
	private static Carte [] deplacerCarte(Carte [] carteBrasser, Carte [] carteDeplacer) {
		
		int limite = carteBrasser.length - carteDeplacer.length;
		carteDeplacer = cloner(carteBrasser, carteDeplacer, limite, 1);
		
		for (int i = limite - 1; i >= 0; i--) {
			
			carteBrasser[i+carteDeplacer.length] = carteBrasser[i];
		}
		
		for (int i = 0; i < carteDeplacer.length; i++) {
			
			carteBrasser[i] = carteDeplacer[i];
		}
		return carteBrasser;
	}
	
	private static Carte [] methodeCloner1(Carte [] carteBrasser, Carte[] carteDeplacer, int limite) {
		
		int compteur = 0;
		
		for (int i = carteBrasser.length - 1; i >= limite; i--) {
			
			carteDeplacer[compteur] = carteBrasser[i];
			compteur++;
		}
		
		return carteDeplacer;
	}
	
	private static Carte [] separer(Carte [] carteBrasser, int valeur) {
		int moitie = carteBrasser.length / 2;
		Carte [] carteMoitie = new Carte [moitie];
		return carteMoitie = cloner(carteBrasser, carteMoitie, moitie, valeur);
	}
	
	private static Carte [] cloner(Carte[] carteBrasser, Carte [] carteDeplacer, int limite, int valeur) {
		if (valeur == 1) {
			carteDeplacer = methodeCloner1(carteBrasser, carteDeplacer, limite);
		}
		else {
			carteDeplacer = methodeCloner2(carteBrasser, carteDeplacer, limite);
		}
		
		return carteDeplacer;
	}
	
	private static Carte [] methodeCloner2(Carte [] carteBrasser, Carte [] carteDeplacer, int limite) {
		
		for (int i = 0; i < limite; i++) {
			carteDeplacer[i] = carteBrasser[i];
		}
		
		return carteDeplacer;
	}
	
	private static Carte [] fusionner(Carte [] carteFusionner, Carte [] carteMoitie1, Carte [] carteMoitie2) {
		
		int iterateurCarteFusionner = 0;
		int iterateurCarteMoitie1 = 0;
		int iterateurCarteMoitie2 = 0;
		int alternance = 0;
		while (iterateurCarteFusionner < carteFusionner.length) {
			if (alternance % 2 == 0 && iterateurCarteMoitie1 < carteMoitie1.length) {
				carteFusionner[iterateurCarteFusionner] = carteMoitie1[iterateurCarteMoitie1];
				iterateurCarteMoitie1++;
			}
			else if (alternance % 2 != 0 && iterateurCarteMoitie2 < carteMoitie2.length) {
				carteFusionner[iterateurCarteFusionner] = carteMoitie2[iterateurCarteMoitie2];
				iterateurCarteMoitie2++;
			}
			iterateurCarteFusionner++;
			alternance++;
		}
		return carteFusionner;
	}
	
	public static boolean toutesLesCartesSontTournee(Carte [] carte) {
		boolean verification = true;
		for (int i = 0; i < carte.length; i++) {
			if (carte[i].visible == true) {
				verification = true;
			}
			else {
				return verification = false;
			}
		}
		return verification;
	}
}
