import java.util.HashMap;

public class Parser {
    public String parse(String[] data) {
        StringBuilder sb = new StringBuilder();
        // Не могу не оставить здесь пару слов:
        // С одной стороны такой способ проверки и возврата
        // Подводит нас к тому, что если даже ошибки будут в каждом поле
        // Выводить бодет по одной ошибке и, соответствеено, по одной пользователь
        // И будет это исправлять...
        // Моджно, конечно, все ошибки поместить в коллекцию и при выводе пробегать по ней
        // Но я предпочитаю думать что алгоритм будет использоваться для, положим, какой-то формы
        // на сайте и для каждого поля ввода будет подтянута проверка своей ошибки
        if (!stringChecker(data[0])) {return "-1EinNI";}
        if (!stringChecker(data[1])) {return "-1EinSI";}
        if (!stringChecker(data[2])) {return "-1EinPI";}
        if (dateChecker(data[3])) {return "-1DFE";}
        if (phoneChecker(data[4])) {return "-1FNE";}
        if (sexChecker(data[5])) {return "-1SE";}

        for (int i = 0; i < data.length; i++) {
            if (i == 5) {
                sb.append(data[i] + "\n");
            } else {
                sb.append(data[i] + " ");
            }
        }
        return sb.toString();
    }

    public boolean stringChecker(final String string) {
        boolean IsCorrect = true;

        if (string == null || string.isEmpty()) {
            return false;
        }

        char[] characters = string.toCharArray();
        for (char character : characters) {
            if (Character.isDigit(character)) {
                IsCorrect = false;
                break;
            }
        }

        return IsCorrect;
    }

    public boolean dateChecker(String dateStr) {
        int dd, mm, yyyy;
        try {
            dd = Integer.parseInt(dateStr.substring(0,2));
            mm = Integer.parseInt(dateStr.substring(3,5));
            yyyy = Integer.parseInt(dateStr.substring(6,10));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка типа");
            return true;
        }
        HashMap<Integer, Integer> months = new HashMap<Integer, Integer>() {{
            put(1, 31);
            put(2, 29);
            put(3, 31);
            put(4, 30);
            put(5, 31);
            put(6, 30);
            put(7, 31);
            put(8, 31);
            put(9, 30);
            put(10, 31);
            put(11, 30);
            put(12, 31);
        }};
        if (dateStr.length() != 10) {
            System.out.println("Ошибка длины");
            return true;
        } else if (dateStr.charAt(2) != '.' || dateStr.charAt(5) != '.') {
            System.out.println("Ошибка символа");
            return true;
        } else if (mm <= 0 || mm > 12) {
            System.out.println("Ошибка месяца.");
            return true;
        } else if (dd <= 0 || dd > months.get(mm)) {
            System.out.println("Ошибка дня.");
            return true;
        } else if (yyyy < 1900 || yyyy > 2022) {
            System.out.println("Ошибка года. (Введите год больше 1900 и меньше текущего года)");
            return true;
        }

        return false;
    }

    public boolean phoneChecker(String phoneNumber){
        try {
            long phoneNum = Long.parseLong(phoneNumber);
            if (phoneNum < 0) {
                throw new RuntimeException();
            }
        } catch (NumberFormatException e) {
            return true;
        } catch (RuntimeException e) {
            return true;
        }
        return false;
    }

    public boolean sexChecker(String sex) {
        if (sex.equals("f") || sex.equals("F") || sex.equals("m") || sex.equals("M")) {
            return false;
        }
        return true;
    }


}
