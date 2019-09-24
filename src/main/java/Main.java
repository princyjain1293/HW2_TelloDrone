
import java.util.Scanner;



public class Main{
    public static void main(String[] args) throws Exception{
        Scanner telloInput= new Scanner(System.in);

        //Read IP Address from User
        System.out.println("Enter the IP Address");
        String ipAddress= telloInput.next();

        // Read Port Number from user
        System.out.println("Enter the port of the drone");
        int dronePort= telloInput.nextInt();
//        System.out.println("Enter the name of the file");
//        String fileName = telloInput.next();
//        int noOfCommands= telloInput.nextInt();
//        String[] arr= new String[noOfCommands];
//        System.out.println("Enter the commands");
//        for (int i=0;i<=noOfCommands;i++){
//
//            arr[i]= telloInput.next();
//        }
//        String result= null;
//        if(arr.length>0){
//            StringBuilder sb= new StringBuilder();
//            for (String s: arr){
//                sb.append(s).append(",");
//            }
//            result= sb.deleteCharAt(sb.length() -1).toString();
//        }
//        FileWriter csvWriter= new FileWriter(fileName);
//        csvWriter.append(result);


        System.out.println("Enter the name of the file from which you want to load the Mission (Note: Kindly include the extension of the same)");
        String fileName= telloInput.next();

        //String fileType=fileName.substring(fileName.indexOf(".")+1);


        Flier flier = new Flier();
        flier.SelectFileType(ipAddress,dronePort,fileName);

       // String[] requestArray= new String[0];
//        Mission mission= new Mission();
//        requestArray=mission.SelectFileType(fileName,fileType);

//        System.out.println("Enter the number of commands");
//        int noOfCommands= telloInput.nextInt();

        //System.out.println("Enter the set of commands in comma(,) separated list");
        //String setOfCommands= telloInput.next();

        // Write csv file
//        FileWriter csvWriter = new FileWriter(fileName);
//        for(int i=0; i<noOfCommands;i++) {
//            String setOfCommands =telloInput.next();
//
//            csvWriter.append(setOfCommands);
//            csvWriter.append(",");
//        }
//        csvWriter.flush();
//        csvWriter.close();
        // Read the type of mission
//        System.out.println("Select your Mission for the day...");
//        System.out.println("Press 1 for Simple Mission \n"+"Press 2 for Supersonic Mission \n"+"Press 3 for Bouncy Mission");
//        int selectedMission = telloInput.nextInt();
//
//
//        Flier flier = new Flier();
//        flier.SelectMission(ipAddress,dronePort,selectedMission);

    }
}