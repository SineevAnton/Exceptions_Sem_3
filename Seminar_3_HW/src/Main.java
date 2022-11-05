import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DataGetter dataGetter = new DataGetter();
        boolean IsIncorrectData = true;
        String[] data = {};
        Parser parser = new Parser();
        ReadWriteUpdate rwu = new ReadWriteUpdate();

        Map<String,String> errors = new HashMap<String,String>();
        errors.put("-1LCoD","Вы ввели больше данных, чем требуется.");
        errors.put("-1MCoD","Вы ввели меньше данных, чем требуется.");
        errors.put("-1EinNI","Ошибка ввода имени.");
        errors.put("-1EinSI","Ошибка ввода фамилии.");
        errors.put("-1EinPI","Ошибка ввода отчества.");
        errors.put("-1DFE","Ошибка формата даты.");
        errors.put("-1FNE","Ошибка формата номера.");
        errors.put("-1SE","Ошибка ввода пола.");


        System.out.println("Hello!");
        while (IsIncorrectData) {
            data = dataGetter.getData();
            if (errors.containsKey(data[0])) {
                System.out.println(errors.get(data[0]));
            } else {
                IsIncorrectData = false;
            }
        }

        String result = parser.parse(data);
        if (errors.containsKey(result)) {
            System.out.println(errors.get(result));
        } else {
            rwu.writeFile(data[0] + ".txt", result);
        }
        rwu.readFile(data[0] + ".txt");
    }
}