import javax.swing.JOptionPane;

public class UtilitaireStats {
	
	public static boolean afficherStatistique(Stats stat) {
		
		JOptionPane.showMessageDialog(null, "Nombre d'essai(s) actuel: " + stat.nbEssaieActuel + " carte(s)" + '\n' 
		+ "La plus grande sequence: " + stat.grandeSequence + " carte(s)" + '\n' +
		"Nombre de réussite(s) actuel: " + stat.nbEssaieActuel + " partie(s) consécutive(s)" + '\n' +
		"Nombre d'essai(s) en moyenne par partie: " + stat.nbEssaiesTotal);
		return true;
	}
}
