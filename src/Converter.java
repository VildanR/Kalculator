import java.util.TreeMap;

public class Converter {
    TreeMap<Character, Integer> romanKey = new TreeMap<>();
    TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();

    public Converter() {
        romanKey.put('I', 1);
        romanKey.put('V', 5);
        romanKey.put('X', 10);
        romanKey.put('L', 50);
        romanKey.put('C', 100);

        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(1, "I");
    }

    public boolean isRoman(String number) {
        return romanKey.containsKey(number.charAt(0));
    }

    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int endSymbol = s.length() - 1;
        int result = romanKey.get(arr[endSymbol]);
        int arabian;
        for (int i = endSymbol - 1; i >= 0; i--) {
            arabian = romanKey.get(arr[i]);
            if (arabian < romanKey.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }


        }
        return result;
    }


    public String intToRoman(int number) {
        String roman = "";
        int arabianKey;
        do {
            arabianKey = arabianKeyMap.floorKey(number);
            roman = roman + arabianKeyMap.get(arabianKey);
            number = number - arabianKey;
        } while (number != 0);
        return roman;
    }

}

