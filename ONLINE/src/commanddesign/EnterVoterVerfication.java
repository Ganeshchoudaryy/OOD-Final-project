package commanddesign;
//We have concrete command classes EnterVoterVerfication implementing Order interface which will do actual command processing

import commanddesign.VoterVerification;

public class EnterVoterVerfication implements Order {
    private VoterVerification train;

   public EnterVoterVerfication(VoterVerification train){
      this.train = train;
   }

   public void execute() {
      train.enter();
   }
}    

