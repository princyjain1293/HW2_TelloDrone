package FileReader;

import java.io.BufferedReader;
import java.io.FileReader;

public class CSVReader implements Reader{
    public String[] fileReader(String fileName) throws Exception{
        BufferedReader readCSV= new BufferedReader(new FileReader(fileName));
        String line;
        String[] requestArray= new String[0];
        while((line= readCSV.readLine())!= null){
            requestArray= line.split(",");
        }
        return  requestArray;
    }
}
