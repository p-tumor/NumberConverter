import java.util.ArrayList;

public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int convertToDecimal() {
        ArrayList<Integer> digitsInDecimal = new ArrayList<>();
        int exponent = 0;
        for(int i = digits.length-1; i > -1; i--){
            int digitInDecimal = digits[i]* (int)Math.pow(base, exponent);
            digitsInDecimal.add(0,digitInDecimal);
            exponent++;
        }
        int sum = 0;
        for(int x: digitsInDecimal){
            sum += x;
        }
        return sum;
    }

    public String convertToBinary() {
        int toDecimal = convertToDecimal();
        /*String numberAsString = Integer.toString(toDecimal);
        int[] digitsTemp = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digitsTemp[i] = d;
        }

         */
        ArrayList<Integer> digitsToBinary = new ArrayList<>();
        while((toDecimal/2.0)%2 < 0.0){
            digitsToBinary.add(0,toDecimal%2);
            toDecimal /= 2;
        }
        String s = "";
        for(int x: digitsToBinary){
            s += x;
        }
        return s;
    }

    public int[] convertToOctal() {
        return null;
    }

    public String convertToAnyBase(int base){
        String charList = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*|?{}";
        int toDecimal = convertToDecimal();
        ArrayList<Integer> digitsToOtherBase = new ArrayList<>();
        while((toDecimal/(double)base)%base > 0.0){
            digitsToOtherBase.add(0,toDecimal%base);
            toDecimal /= base;
        }
        String s = "(";
        for(int x: digitsToOtherBase){
            s += x;
        }
        s += ")"+base;
        return s;
    }
}

