package observerdesign;
//Create concrete observer classes
import java.io.FileOutputStream;
import java.util.Scanner;

public class EnterVoteCastingObserver extends VoteCastingObserver {
    public EnterVoteCastingObserver(VoteCasting coaches){
        this.votecasting = coaches;
        this.votecasting.attach(this);
    }

    @Override
    public void update() {
        try{
            Scanner sc=new Scanner(System.in);                          //object of Scanner class  
            String name1= "JoeBiden.txt";                                //variable name to store the file name  
            String name2= "DonaldTrump.txt"; 
            
           

            System.out.print("Enter Your Voter ID: ");         
            String VoterID=sc.nextLine()+"\n";                        //str stores the string which we have entered  
            byte[] voterid = VoterID.getBytes();                        //converts string into bytes  
             
            
            System.out.print("Enter Your Vote(1 for Joe Biden/2 for Donald Trump): ");         
            String Votes=sc.nextLine();    
            byte[] vote = Votes.getBytes();    
                             
          
                
              if ("1".equals(Votes)){
                 FileOutputStream fos1 = new FileOutputStream(name1, true);
                 
                  fos1.write(vote); 
                  fos1.write("\n".getBytes());
                  fos1.close();
              }
                
            
            if ("2".equals(Votes)){
                 FileOutputStream fos2 = new FileOutputStream(name2, true);
                 
                 
                 fos2.write(vote);
                 fos2.write("\n".getBytes());
                  
                  
                 fos2.close();
            }
            
            
            
            
            System.out.println("Vote Casted");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
