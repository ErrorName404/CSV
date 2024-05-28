import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.IOException;

public class Files {
    public void write(){
        CsvWriter csvWriter = null;
        try{
            csvWriter = new CsvWriter("MyFile.csv");
            csvWriter.write("CLAVE");
            csvWriter.write("DESCRIPCION");
            csvWriter.write("PRECIO");
            csvWriter.endRecord();

            csvWriter.write("100");
            csvWriter.write("LECHE");
            csvWriter.write("13.50");
            csvWriter.endRecord();
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            if(csvWriter!=null)
                csvWriter.close();
        }
    }
    public void read(){
        CsvReader csvReader = null;
        try{
            csvReader = new CsvReader("MyFile.csv");
            csvReader.readHeaders();
            while(csvReader.readRecord()){
                System.out.println("CLAVE-------------------:"+csvReader.get("CLAVE"));
                System.out.println("DESCRIPCION-------------:"+csvReader.get("DESCRIPCION"));
                System.out.println("PRECIO------------------:"+csvReader.get("PRECIO"));

            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

