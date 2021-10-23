package factorydesign;
//Creating a VoterRecordsFactory to generate object of concrete class based on given information.

import factorydesign.ViewVoterRecords;

public class VoterRecordsFactory {
   //use getSchedule method to get object of manager 
   public VoterRecords getVoterRecords(String getRecords){
       if(getRecords == null){
           return null;
       }
       if(getRecords.equalsIgnoreCase("viewVoterRecords")){
           return new ViewVoterRecords();
       }
       return null;
   }    
}
