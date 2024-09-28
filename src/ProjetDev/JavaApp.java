package ProjetDev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class  JavaApp extends Application {
	static String url = "jdbc:mysql://ls-0f19f4268096a452a869b6f8467bc299c51da519.cz6cgwgke8xd.eu-west-3.rds.amazonaws.com:3306/db0072838"; // URL de connexion
	static String utilisateur = "user0072838"; // Remplacez par votre nom d'utilisateur
	static String motDePasse = "Yf3IgyBsOPa34WR"; // Remplacez par votre mot de passe
	static Connection connexion;
	static Statement statement;
	static ResultSet resultset;
    static Label label1;
    static Label label;
    static TextField inputField;
    static Button button;
    static Button button1;
    static Button button2;
    static Label label2;
    static HBox layout2;
    static VBox layout;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        label = new Label("ENTRER VOTRE MATRICULE SVP!:");
        label1 = new Label();
        label2 = new Label();
        inputField = new TextField();
        button = new Button("VALIDER");
        button2 = new Button("DETAILS");
        button1 = new Button("FERMER");
        layout2 = new HBox();
        layout = new VBox();
       

        // Action on button click (example: print input to console)
        button.setOnAction(event -> {
           /* String name = inputField.getText();*/
        	 
        	Connection(inputField.getText());
        	
        		
        });
        
        
        button1.setOnAction(event -> {
        	
        	primaryStage.close();
        	
        });
       
       
        
        // Create a layout to organize elements
        
        layout.getChildren().addAll(label, inputField, layout2, label1, label2);
        layout2.getChildren().addAll(button,button2,button1);
        layout.setAlignment(Pos.CENTER);
        layout2.setAlignment(Pos.CENTER);
        layout.setSpacing(50);
        layout2.setSpacing(20);

        // Create a scene and set its content                 
        Scene scene = new Scene(layout, 400, 600);

        // Set the scene and title for the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fenetre Application");
        primaryStage.show();
    }
    
    
    public static void Connection(String matricule) {
    	
    	
    	
    	try {
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			if (connexion != null) {
                
                statement = connexion.createStatement(); 
                String result = ("SELECT * FROM etudiant WHERE matetudiant =  " + matricule);
                resultset = statement.executeQuery(result);
                
                
        	if (resultset.next()) {
        	int idetudiant = resultset.getInt("idetudiant");
    			String matetudiant = resultset.getString("matetudiant");
        			String firstName = resultset.getString("nometudiant");
        			String lastName = resultset.getString("prenometudiant");
        			String datenaiss = resultset.getString("datenaissanceetudiant");
        			String nomecole = resultset.getString("nomecoleetudiant");
        			String decision = resultset.getString("decisionetudiant");
        			Double moyentudiant = resultset.getDouble("moyetudiant");
        			
        			if(matricule.equals(matetudiant)){
        				
        				label1.setText(decision);
        				
        				
        			}
        			
        		
        			button2.setOnAction(event -> {
        	        	
        				label2.setText( "Numero : " + idetudiant +"\n"+ "Matricule : " + matetudiant +"\n"+ "Nom : " + firstName +"\n"+"Prenoms : " + lastName +"\n"+ "Date de naissance : " +datenaiss +"\n"+"Nom ecole : " + nomecole +"\n"+"Decision : " + decision +"\n"+"Moyenne : " + moyentudiant +"\n");
        	        	
        	        });
        	        	
        			
        			}
                
            } else {
                System.out.println("Échec de la connexion.");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }
    }
    


