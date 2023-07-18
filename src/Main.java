import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] symbol = {"+", "-", "*", "/"};
        String[] regexSymbol = {"\\+", "-", "\\*", "/"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вырожениеж: ");
        String expression = scanner.nextLine();
        int arithmeticOperation = -1;
        for (int i = 0; i < symbol.length; i++) {
            if (expression.contains(symbol[i])) {
                arithmeticOperation = i;
                break;
            }
        }
        if (arithmeticOperation == -1) {
            System.out.println("Не корректный символ");

        }
        String[] data = expression.split(regexSymbol[arithmeticOperation]);
        if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
            int a, b;
            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman) {
                a =converter.romanToInt(data[0]);
                b =converter.romanToInt(data[1]);
            }else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }int result = 0;

            switch (symbol[arithmeticOperation]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
            }
            if (isRoman) {
                System.out.println(converter.intToRoman(result));
            } else {
                System.out.println(result);
            }
        } else {
            System.out.println("Не верный формат вырожения");
        }
    }


}




