import java.io.BufferedReader;
import java.io.FileReader;

public class CSVReader {
    public String[] ReadCSV(String fileName) throws Exception{
        BufferedReader readCSV= new BufferedReader(new FileReader(fileName));
        String line;
        String[] requestArray= new String[0];
        while((line= readCSV.readLine())!= null){
            requestArray= line.split(",");
        }
        return  requestArray;
    }
}
