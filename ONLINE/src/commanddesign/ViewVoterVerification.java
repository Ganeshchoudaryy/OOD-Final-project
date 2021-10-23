package commanddesign;
//We have concrete command classes ViewVoterVerification implementing Order interface which will do actual command processing
import commanddesign.VoterVerification;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewVoterVerification implements Order {
    private VoterVerification voterverification;

   public ViewVoterVerification(VoterVerification voterverification){
      this.voterverification = voterverification;
   }

    public void execute() {
        try {
            voterverification.view();
        } catch (IOException ex) {
            Logger.getLogger(ViewVoterVerification.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}    

