import java.util.ArrayList;

public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i, i + 1);
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
        for (int i = digits.length - 1; i > -1; i--) {
            int digitInDecimal = digits[i] * (int) Math.pow(base, exponent);
            digitsInDecimal.add(0, digitInDecimal);
            exponent++;
        }
        int sum = 0;
        for (int x : digitsInDecimal) {
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
        while ((toDecimal / 2.0) % 2 < 0.0) {
            digitsToBinary.add(0, toDecimal % 2);
            toDecimal /= 2;
        }
        String s = "";
        for (int x : digitsToBinary) {
            s += x;
        }
        return s;
    }

    public int[] convertToOctal() {
        return null;
    }

    public String convertToAnyBase(int base) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz=/";
        StringBuilder s = new StringBuilder("(");
        double toDecimal = convertToDecimal();
        while ((toDecimal / base) >= base) {
            toDecimal /= base;
            double temp = toDecimal;
            if(temp%1 > 0){
                double temp2 = (temp%1) * base;
                s.insert(0,base);
                System.out.println("this");
            }else {
                s.insert(0,temp%base);
                System.out.println("that");
            }
        }
        s.append(")").append(base);
        return s.toString();
    }
}

