package FileReader;

public class FileCommand {
    public static final String[] selectFileType(String fileName) throws Exception{
        Reader reader = null;
        String[] requestArray= new String[0];
        String fileType= fileName.substring(fileName.indexOf(".")+1);
        if(fileType.equals("csv")){
            reader= new CSVReader();
        }
        else if(fileType.equals("xml")){
            reader= new XMLReader();
        }

        
        return reader.FileReader(fileName);
    }
}
