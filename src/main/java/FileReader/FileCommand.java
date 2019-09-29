package FileReader;

public class FileCommand {
    public static final String[] selectFileType(String fileName) throws Exception{
        String[] requestArray= new String[0];
        String fileType= fileName.substring(fileName.indexOf(".")+1);
        if(fileType.equals("csv")){
            CSVReader csvReader = new CSVReader();
            requestArray=csvReader.ReadCSV(fileName);
        }
        else if(fileType.equals("xml")){
            XMLReader xmlReader= new XMLReader();
            requestArray=xmlReader.ReadXML(fileName);
        }
        else{
            System.out.println("This file type is not supported in this version");
        }
        return requestArray;
    }
}
