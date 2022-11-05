import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataGetter {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String[] getData(){
        String[] row = {};
        boolean IsIncorrectData = true;
        System.out.println("Введите данные в виде: \n" +
                "<Фамилия> <Имя> <Отчество> <дата рождения> <номер телефона> <пол (m/f)>\n" +
                "Например (обратите внимание на формат ввода\n" +
                "Иванов Иван Иванович 10.10.1990 12345678900 m\n" +
                "!!!Данные разделяйте пробелом!!!");
        try {
            row = reader.readLine().split(" ");
            if (row.length > 6) {
                return new String[]{"-1LCoD"};
            } else if (row.length < 6) {
                return new String[]{"-1MCoD"};
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return row;
    }

}
