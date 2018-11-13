/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itesm.classifier;

import twitter4j.*;
import twitter4j.auth.*;
import java.util.Scanner;
import java.io.File;


/**
 *
 * @author JC
 */
public class ITESMClassifier {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        String type;

        String positive = "positive", negative= "negative", neutral= "neutral";
        Twitter twitter = TwitterFactory.getSingleton();
        twitter.setOAuthConsumer("CF0q2KfpGcvMCpKtJmGZv8Q41", "2ZURkOHhiORgDNajCHxjboNCU8Cb8icpKaMLliqAR5Yfq3b7Ed");
        AccessToken accessToken = new AccessToken("284272944-hlgXbbfXBw3DaNULjghTrn0HVWKuk73kI56drnWq", "cY1esx4yTgRYAPvPc2e2htQ2eyjeOhwE5yUPtMnsLzBRr");
        twitter.setOAuthAccessToken(accessToken);
        Query query = new Query("Hello world");
        QueryResult result = twitter.search(query);
        
        for (Status status : result.getTweets()) {
            
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            type= classifyMessage(status.getText());
            
            System.out.println("Connotation: "+type);
            System.out.println(" ");
            System.out.println("Keyword: ");
            
        }
        
        
        

    }
    
    public static String classifyMessage(String message){
        
    }
    
    public static String[] readFile(String fileName)throws Exception {
        Scanner sc = new Scanner(new File(fileName));
		String content = "";
		
		while (sc.hasNext()) {
			content += sc.nextLine() + "\n";
		}
		
		return content.split("\n");
    }
    
    
}



