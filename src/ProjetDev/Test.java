package ProjetDev;

import static org.junit.jupiter.api.Assertions.*;

public class Test {

    @org.junit.jupiter.api.Test
    void testMatriculeNonNull() {
        String matricule = "0072838";
        assertNotNull(matricule, "Le matricule ne doit pas être nul");
    }

    @org.junit.jupiter.api.Test
    void testMoyenneSuccès() {
        Double moyenne = 15.0;
        assertTrue(moyenne >= 10, "L'étudiant doit avoir réussi");
    }

    @org.junit.jupiter.api.Test
    void testMoyenneFailure() {
        Double moyenne = 9.5;
        assertFalse(moyenne >= 10, "L'étudiant doit avoir reussi");
    }

    @org.junit.jupiter.api.Test
    void testNomEtPrenomConcatenation() {
        String nom = "N'GUESSAN";
        String prenom = "Raphaël";
        assertEquals("N'GUESSAN Raphaël", nom + " " + prenom);
    }
    
    private int getMatricule(String nom, String prenom) {
        // Requête en base de données
        if (nom.equals("N'GUESSAN") && prenom.equals("Raphaël")) {
            return 1;
        } else {
            return 0;
        }
    }

    @org.junit.jupiter.api.Test
    void testIntEtudiant() {
        String nom = "N'GUESSAN";
        String prenom = "Raphaël";
        int matriculeAttendu = 1;
        int matriculeObtenu = getMatricule(nom, prenom);

        assertEquals(matriculeAttendu, matriculeObtenu, "Le matricule de l'étudiant n'est pas égal à 1");
    }

}
	


