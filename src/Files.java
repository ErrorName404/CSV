import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.IOException;

public class Files {
    public void write(){
        CsvWriter csvWriter = null;
        Input input = new Input();
        int exit=0;
        try{
            csvWriter = new CsvWriter("MyFile.csv");
            csvWriter.write("ID");
            csvWriter.write("DESCRIPTION");
            csvWriter.write("PRICE");
            csvWriter.endRecord();

            do {
                csvWriter.write(input.readString("Please, input an ID"));
                csvWriter.write(input.readString("Please, input a description"));
                csvWriter.write(input.readString("Please, input a price"));
                csvWriter.endRecord();
                exit=input.readInt("Would you like to add another entry\n[0 - NO]\t[1 - yes]");
            }while (exit!=0);
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
                System.out.println("ID-------------------:"+csvReader.get("ID"));
                System.out.println("DESCRIPTION-------------:"+csvReader.get("DESCRIPTION"));
                System.out.println("PRICE------------------:"+csvReader.get("PRICE")+"\n");
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

