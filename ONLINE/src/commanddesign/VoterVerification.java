package commanddesign;
//VoterVerification uses command pattern to identify which object will execute which command based on the type of command

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VoterVerification {

    public void view() throws IOException {
        try{
        ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get("voterVerificationData.txt"))); // Handle a potential exception       
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Your Father's Name: ");
        String fatherword = input.next();
        System.out.println("Enter Your Mother's Name: ");
        String motherword = input.next();
        boolean isFound = false;
       
        for (int i = 0; i < lines.size(); i++) {
            String father = lines.get(i + 3);
            String mother = lines.get(i + 4);

            if (father.equalsIgnoreCase(fatherword) && mother.equalsIgnoreCase(motherword)) {
                System.out.println("Voter's Name         : " + lines.get(i));
                System.out.println("Voter's ID Number    : " + lines.get(i + 1));
                System.out.println("Voter's Vote Location: " + lines.get(i + 2));
                System.out.println("Voter's Father Name  : " + lines.get(i + 3));
                System.out.println("Voter's Mother Name  : " + lines.get(i + 4));
                System.out.println();
                System.out.println();
                isFound = true;
                break;
            }
            i = i + 4;

        }
        if(isFound == false){
            System.out.println("Invalid Details");
            view();
        }
        }
        catch(Exception e){
        }
    }

    public void enter() {
        try {
            Scanner sc = new Scanner(System.in);                          //object of Scanner class  
            String name = "voterVerificationData.txt";                   //variable name to store the file name  
            FileOutputStream fos = new FileOutputStream(name, true);    //true for append mode  

            System.out.print("Enter Your Name: ");
            String TrainRoute = sc.nextLine() + "\n";                       //str stores the string which we have entered  
            byte[] troute = TrainRoute.getBytes();                      //converts string into bytes  
            fos.write(troute);

            System.out.print("Enter Your Identity Number: ");
            String identityNumber = sc.nextLine() + "\n";                    //str stores the string which we have entered  
            byte[] inumber = identityNumber.getBytes();                  //converts string into bytes  
            fos.write(inumber);

            System.out.print("Enter Your Vote's Location: ");
            String VoteLocation = sc.nextLine() + "\n";                      //str stores the string which we have entered  
            byte[] vlocation = VoteLocation.getBytes();                  //converts string into bytes  
            fos.write(vlocation);

            System.out.print("Enter Your Father's Name: ");
            String FathersName = sc.nextLine() + "\n";                      //str stores the string which we have entered  
            byte[] fathersname = FathersName.getBytes();                  //converts string into bytes  
            fos.write(fathersname);

            System.out.print("Enter Your Mother's Name: ");
            String MothersName = sc.nextLine() + "\n";                      //str stores the string which we have entered  
            byte[] mothersname = MothersName.getBytes();                  //converts string into bytes  
            fos.write(mothersname);

            fos.close();                                                 //close the file  
            System.out.println("file saved.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
