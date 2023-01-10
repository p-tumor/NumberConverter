import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@#";
        System.out.println(chars.length());
        String[] charList = new String[chars.length()];
        for(int i = 0; i < chars.length();i++){
            charList[i] = chars.substring(i,i+1);
        }
        /*System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        int n = Integer.parseInt(number);

        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
        System.out.println("Number in decimal: "+nc.convertToDecimal());
        System.out.println("Number in Binary: "+nc.convertToAnyBase(2));
        System.out.println("Number in octal: "+nc.convertToAnyBase(8));

         */
    }
}

