package factorydesign;
//Create concrete classes implementing the same interface.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewVoterRecords implements VoterRecords{
   public void viewEnterVoter() {
       ArrayList<String> lines = null;
        try {
            lines = new ArrayList<>(Files.readAllLines(Paths.get("voterVerificationData.txt"))); // Handle a potential exception
        }
        catch (IOException ex) {
           
        }
        for(int i = 0; i<lines.size();i++){
        System.out.println("Voter's Name             : "+lines.get(i));
        System.out.println("Voter's ID Number        : "+lines.get(i+1));
        System.out.println("Voter's Vote Location    : "+lines.get(i+2));
        System.out.println("Voter's Father's Name    : "+lines.get(i+3));
        System.out.println("Voter's Mother's Name    : "+lines.get(i+4));
        i=i+4;
        System.out.println("\n");
        }
   }    
}
