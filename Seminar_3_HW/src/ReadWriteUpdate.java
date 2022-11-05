import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteUpdate {

    public void writeFile(String fileName, String text) {
        try(FileWriter writer = new FileWriter(fileName, true))
        {
            writer.write(text);
            writer.flush();
            writer.close();
        }
        catch(IOException ex){
            System.out.println("Файл не найден.");
            ex.printStackTrace();
        }
    }

    public void readFile(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
            reader.close();
        } catch (IOException ex) {
            System.out.println("Файл не найден.");
            ex.printStackTrace();
        }
    }

}
