package ProjetDev;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDataBase{
	static Connection connexion;

	public static void main(String[] args) {
		String url = "jdbc:mysql://ls-0f19f4268096a452a869b6f8467bc299c51da519.cz6cgwgke8xd.eu-west-3.rds.amazonaws.com:3306/db0072838"; // URL de connexion
		String utilisateur = "user0072838"; // Remplacez par votre nom d'utilisateur
		String motDePasse = "Yf3IgyBsOPa34WR"; // Remplacez par votre mot de passe

		try {
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			if (connexion != null) {
                System.out.println("Connexion à la base de données db0072838 réussie !");
                Statement statement = connexion.createStatement(); 
                String result = ("SELECT * FROM etudiant WHERE matetudiant = 0072838 ");
                ResultSet resultset = statement.executeQuery(result);
                
                
        	if (resultset.next()) {
        		//recuperation des éléments de la base de donnée
        	int idetudiant = resultset.getInt("idetudiant");
    			String matetudiant = resultset.getString("matetudiant");
        			String firstName = resultset.getString("nometudiant");
        			String lastName = resultset.getString("prenometudiant");
        			String datenaiss = resultset.getString("datenaissanceetudiant");
        			String nomecole = resultset.getString("nomecoleetudiant");
        			String decision = resultset.getString("decisionetudiant");
        			Double moyentudiant = resultset.getDouble("moyetudiant");
        			System.out.println(idetudiant + " " + matetudiant + " " + firstName + " " + lastName + " " + datenaiss + " " + nomecole + " " + decision + " " + moyentudiant);}
                
            } else {
                System.out.println("Échec de la connexion.");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
