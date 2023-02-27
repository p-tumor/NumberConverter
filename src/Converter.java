import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;

public class Converter {
    private final Scanner s = new Scanner(System.in);
    public void menu(){
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.println("""
                1. Input your own number in base 10 and base to convert to.
                2. Choose between bases 2,8, and 10 and get conversions.
                3. Exit.""");
        int choice = 0;
        for(boolean isVal = false; !isVal;){
            System.out.print("Input: ");
            String temp = s.nextLine();
            try{
                choice = Integer.parseInt(temp);
                if(choice == 1 || choice == 2 || choice == 3) isVal = true;
                else System.out.print("Invalid. ");
            }catch(Exception e){
                System.out.print("Invalid. ");
            }
        }
        if(choice == 1) ownChoice();
        else if(choice == 2) basic();
        else exit(-1);
    }
   private void ownChoice(){
        int number = 0;
        for(boolean isVal = false; !isVal;){
            System.out.print("Enter your base 10 number: ");
            String temp = s.nextLine();
            try{
                number = Integer.parseInt(temp);
                isVal = true;
            }catch(Exception e){System.out.print("Invalid. ");}
        }
        int base = 0;
        for(boolean isVal = false; !isVal;){
            System.out.print("Enter the base you would like to convert to(up to 64): ");
            String temp = s.nextLine();
            try{
                base = Integer.parseInt(temp);
                if(!(base > 0 && base < 65)){
                    System.out.print("Invalid. ");
                }
                isVal = base > 0 && base < 65;
            }catch(Exception e){System.out.print("Invalid. ");}
        }
        NumberConverter nc = new NumberConverter(number, 10);
        System.out.println("\n\nDigit array: " + Arrays.toString(nc.getDigits()));
        System.out.println("Number: " + nc.displayOriginalNumber());
        System.out.println("Number in decimal: "+nc.convertToAnyBase(base));
    }
    private void basic(){
        int base = 0;
        for(boolean isVal = false; !isVal;) {
            System.out.print("Enter the base of your number (2, 8 or 10): ");
            String temp = s.nextLine();
            try{
                base = Integer.parseInt(temp);
                if(base == 2 || base == 8 || base == 10) isVal = true;
                else System.out.print("Invalid. ");
            }catch(Exception e){
                System.out.print("Invalid. ");
            }
        }
        int n = 0;
        for(boolean isVal = false; !isVal;) {
            System.out.print("Enter your number: ");
            String temp = s.nextLine();
            try{
                n = Integer.parseInt(temp);
                int count = 0;
                for(int i = 0; i < temp.length(); i++){
                    if(Integer.parseInt(temp.substring(i,i+1)) < base) {
                        count++;
                    }
                }
                if (count == temp.length()) isVal = true;
                else System.out.print("Invalid. ");
            }catch(Exception e){
                System.out.print("Invalid. ");
            }
        }
        s.close();
        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number in decimal: " + nc.convertToDecimal());
        System.out.println("Number in binary: " + nc.convertToAnyBase(2));
        System.out.println("Number in octal: " + nc.convertToAnyBase(8));
        System.out.println("Number in hexadecimal: " + nc.convertToAnyBase(16));
    }
}