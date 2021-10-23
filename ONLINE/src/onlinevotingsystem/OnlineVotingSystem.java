package onlinevotingsystem;

import iteratordesign.Iterator;
import factorydesign.VoterRecords;
import factorydesign.VoterRecordsFactory;
import observerdesign.VoteCasting;
import observerdesign.EnterVoteCastingObserver;
import commanddesign.EnterVoterVerfication;
import commanddesign.VoterVerificationInvoker;
import commanddesign.ViewVoterVerification;
import commanddesign.VoterVerification;
import java.io.IOException;

public class OnlineVotingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int swValue;
        int VoterVerificationValue;
        int VoteCastingValue;
        int VoterRecordsValue;
        int VoteCountingValue;
        int VoteGenerateValue;

        while(true){
//MAIN MENU DISPLAY
            System.out.println("*********************");
            System.out.println("ONLINE VOTING SYSTEM");
            System.out.println("Menu:");
            System.out.println("1. Voter Verification");
            System.out.println("2. Vote Casting");
            System.out.println("3. Voter Records");
            System.out.println("4. Vote Counting");
            System.out.println("5. Exit");
            
            swValue = Keyin.inInt("Select option: ");
            System.out.println("\n");
            
            switch (swValue) {
//CASE 1 IS VOTER VERIFICATION USING COMMAND DESIGN PATTERN   
//In this command design pattern we are encapsulating  a request as an object,
//which lets us parameterize other objects with different requests and support undoable operations.
//We have created an interface Order.java which is acting as a command                
//will use VoterVerification class to demonstrate command pattern.                
                case 1:
                    System.out.println("Enter 1 to View Voter Verification");
                    System.out.println("Enter 2 to Insert Voter Verification");
                    VoterVerificationValue = Keyin.inInt(" Select option: ");
                    System.out.println("\n");
                    
                    if(VoterVerificationValue==1){
//Create a command interface.                        
                        VoterVerification voter = new VoterVerification();                        
//Create a request class.                        
                        ViewVoterVerification viewVoterVerificationOrder = new ViewVoterVerification(voter);
//Creating a command invoker class.                         
                        VoterVerificationInvoker voterVerificationInvoker = new VoterVerificationInvoker();
                      
                        voterVerificationInvoker.takeOrder(viewVoterVerificationOrder);
                        voterVerificationInvoker.placeOrders();
                    }
                    else if(VoterVerificationValue==2){
//Create a command interface.
                        VoterVerification man = new VoterVerification();
//Create a request class.                        
                        EnterVoterVerfication enterVoterVerificationOrder = new EnterVoterVerfication(man);
//Creating a command invoker class.                      
                        VoterVerificationInvoker voterInvoker = new VoterVerificationInvoker();
                      
                        voterInvoker.takeOrder(enterVoterVerificationOrder);
                        voterInvoker.placeOrders();
                        break;
                    }
                    break;

//CASE 2 IS VoteCasting MODULE USING OBSERVER DESIGN PATTERN 
//Observer pattern uses three actor classes. VoteCasting, Observer and Client                    
                case 2:
                    System.out.println("Enter 1 to Cast Vote");
                    VoteCastingValue = Keyin.inInt(" Select option: ");
                    System.out.println("\n");
                    
                    VoteCasting votecasting = new VoteCasting();
                    
                
                     if(VoteCastingValue==1){
//Using ViewVoteCastingObserver and concrete observer objects.                         
                        new EnterVoteCastingObserver(votecasting);
//VoteCasting is an object having methods to attach and detach observers to a client object                        
                        votecasting.setState(1);
                        break;
                    }
                    
                    break;
                    
//CASE 3 IS VOTER RECORD USING FACTORY DESIGN PATTERN
//We will use VoterRecordsFactory to get a object. It will pass information (viewSchedule,enterSchedule) 
//to VoterRecordsFactory to get the type of object it needs.                    
                case 3:
                    System.out.println("Enter 1 to view Voter's Record");
                    VoterRecordsValue = Keyin.inInt(" Select option: ");
                    System.out.println("\n");
//Using the VoterRecordsFactory to get object of concrete class by passing an information such as type.                    
                    VoterRecordsFactory voterRecordsFactory = new VoterRecordsFactory();

                    if(VoterRecordsValue==1){
//get an object of ViewVoterRecords and call its viewEnterVoter method.
                        VoterRecords viewVoterRecord = voterRecordsFactory.getVoterRecords("viewVoterRecords");
                        viewVoterRecord.viewEnterVoter();
                    }
                 
                    break;
                    

                    
//CASE 4 IS Vote Counting USING ITERATOR DESIGN PATTERN
//We're creating an ITERATOR interface which narrates navigation method and a Container interface 
//which retruns the iterator. 
//Concrete classes implementing the Container interface will be responsible to implement Iterator interface and use it                                      
//Using the VoteCountingRepository to get iterator and print Types of seating class available.
                    case 4: 
                    VoteCountingRepository votecountingRepository = new VoteCountingRepository();
                    for(Iterator iter = votecountingRepository.getIterator(); iter.hasNext();){
                        String seat = (String)iter.next();
                        System.out.println(seat);
                    }
                    break;                   
                    
//CASE 5 IS EXITING PROGRAM 
                case 5:
                    System.out.println("Thank you for Visiting");
                    System.exit(0);
                    
//CASE DEFAULT IS PRINTING OUT THE INVALID SELECTION BY THE USER
                default:
                    System.out.println("Invalid selection");
                    break; // This break is not really necessary but its a formality
    }
   
    }
  }




// keyin methos is for input of character and numeric types only in main menu

class Keyin {

  //*******************************
  //   support methods
  //*******************************
  //Method to display the user's prompt string
  public static void printPrompt(String prompt) {
    System.out.print(prompt + " ");
    System.out.flush();
  }

  //Method to make sure no data is available in the
  //input stream
  public static void inputFlush() {
    int dummy;
    int bAvail;

    try {
      while ((System.in.available()) != 0)
        dummy = System.in.read();
    } catch (java.io.IOException e) {
      System.out.println("Input error");
    }
  }

  //********************************
  //  data input methods for
  //string, int, char, and double
  //********************************
  public static String inString(String prompt) {
    inputFlush();
    printPrompt(prompt);
    return inString();
  }

  public static String inString() {
    int aChar;
    String s = "";
    boolean finished = false;

    while (!finished) {
      try {
        aChar = System.in.read();
        if (aChar < 0 || (char) aChar == '\n')
          finished = true;
        else if ((char) aChar != '\r')
          s = s + (char) aChar; // Enter into string
      }

      catch (java.io.IOException e) {
        System.out.println("Input error");
        finished = true;
      }
    }
    return s;
  }

  public static int inInt(String prompt) {
    while (true) {
      inputFlush();
      printPrompt(prompt);
      try {
        return Integer.valueOf(inString().trim()).intValue();
      }

      catch (NumberFormatException e) {
        System.out.println("Invalid input. Not an integer");
      }
    }
  }

  public static char inChar(String prompt) {
    int aChar = 0;

    inputFlush();
    printPrompt(prompt);

    try {
      aChar = System.in.read();
    }

    catch (java.io.IOException e) {
      System.out.println("Input error");
    }
    inputFlush();
    return (char) aChar;
  }

  public static double inDouble(String prompt) {
    while (true) {
      inputFlush();
      printPrompt(prompt);
      try {
        return Double.valueOf(inString().trim()).doubleValue();
      }

      catch (NumberFormatException e) {
        System.out
            .println("Invalid input. Not a floating point number");
      }
    }
  }
}
        
    }
    

