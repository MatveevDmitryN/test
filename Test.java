import java.util.Scanner;
public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение:");

        String input = scanner.nextLine();

        try {
            String result = calculate(input);
            if (result.length() > 40) {
                result = result.substring(0, 40) + "...";
            }
            System.out.println("Результат: \"" + result + "\"");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calculate(String input) throws Exception {
        input = input.trim();


        if (input.contains("+")) {
            String[] parts = input.split("\\+");
            String firstString = getStringFromInput(parts[0]);
            String secondString = getStringFromInput(parts[1]);
            return firstString + secondString;
        } else if (input.contains("-")) {
            String[] parts = input.split("\\-");
            String firstString = getStringFromInput(parts[0]);
            String secondString = getStringFromInput(parts[1]);
            return firstString.replace(secondString, "");
        } else if (input.contains("*")) {
            String[] parts = input.split("\\*");
            String firstString = getStringFromInput(parts[0]);
            int multiplier = Integer.parseInt(parts[1].trim());
            if (multiplier < 1 || multiplier > 10) {
                throw new Exception("Число должно быть от 1 до 10.");
            }
            return firstString.repeat(multiplier);
        } else if (input.contains("/")) {
            String[] parts = input.split("/");
            String firstString = getStringFromInput(parts[0]);
            int divisor = Integer.parseInt(parts[1].trim());
            if (divisor < 1 || divisor > 10) {
                throw new Exception("Число должно быть от 1 до 10.");
            }
            return firstString.substring(0, firstString.length() / divisor);
        } else {
            throw new Exception("Некорректная операция.");
        }
    }


    public static String getStringFromInput(String input) throws Exception {
        input = input.trim();
        if (input.startsWith("\"") && input.endsWith("\"")) {
            String result = input.substring(1, input.length() - 1);
            if (result.length() > 10) {
                throw new Exception("Строка слишком длинная.");
            }
            return result;
        } else {
            throw new Exception("Некорректный формат строки.");
        }
    }
}