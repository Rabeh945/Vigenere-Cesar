package SI_Projet;

import java.util.ArrayList;

public class Functions {
    char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    String specialChars = "\"_|.,@!#$%^&*()-+*/;:`~'<>?\u061F[]}{";
    int i, j = 0;

    public String cesar(String text, int cle) {
        String result = "";
        int k;
        for (i = 0; i <= text.length() - 1; i++) {
            jloop:
            for (j = 0; j <= alphabet.length - 1; j++) {
                k = j + cle;
                while (k > 25) {
                    k -= alphabet.length;
                }
                if (alphabet[j] == text.charAt(i)) {
                    result += alphabet[k];
                    break;
                }
                if (text.charAt(i) == Character.toUpperCase(alphabet[j])) {
                    result += Character.toUpperCase(alphabet[k]);
                    break;
                }
                if (Character.isWhitespace(text.charAt(i))) {
                    result += " ";
                    break;
                }

                if (Character.isDigit(text.charAt(i))) {
                    result += text.charAt(i);
                    break;
                }
                for (int y = 0; y <= specialChars.length() - 1; y++) {
                    if (specialChars.charAt(y) == text.charAt(i)) {
                        result += specialChars.charAt(y);
                        break jloop;

                    }
                }

            }

        }
        return result;
    }

    public String cesarD(String text, int cle) {
        int k;
        String result = "";
        for (i = 0; i <= text.length() - 1; i++) {
            jloop:
            for (j = 0; j <= alphabet.length - 1; j++) {
                k = j - cle;
                while (k < 0) {
                    k += alphabet.length;
                }
                if (alphabet[j] == text.charAt(i)) {
                    result += alphabet[k];
                    break;
                }
                if (text.charAt(i) == Character.toUpperCase(alphabet[j])) {
                    result += Character.toUpperCase(alphabet[k]);
                    break;
                }
                if (Character.isWhitespace(text.charAt(i))) {
                    result += " ";
                    break;
                }

                if (Character.isDigit(text.charAt(i))) {
                    result += text.charAt(i);
                    break;
                }
                for (int y = 0; y <= specialChars.length() - 1; y++) {
                    if (specialChars.charAt(y) == text.charAt(i)) {
                        result += specialChars.charAt(y);
                        break jloop;

                    }
                }

            }
        }
        return result;
    }

    public ArrayList<String> getTextPositions(String text) {
        ArrayList<String> result = new ArrayList<String>();
        for (i = 0; i <= text.length() - 1; i++) {
            for (j = 0; j <= alphabet.length - 1; j++) {
                if (text.charAt(i) == alphabet[j] || text.charAt(i) == Character.toUpperCase(alphabet[j])) {
                    result.add(String.valueOf(j));
                    break;
                }
                if (Character.isWhitespace(text.charAt(i))) {
                    result.add(" ");
                    break;
                }
                if (String.valueOf(text.charAt(i)).matches("[^A-Za-z0-9]")) {
                    result.add(String.valueOf(text.charAt(i)));
                    break;
                }
                if (Character.isDigit(text.charAt(i))) {
                    result.add(String.valueOf(text.charAt(i)));
                    break;
                }
            }
        }
        return result;
    }

    public ArrayList<String> getClePositions(String cle) {
        ArrayList<String> result = new ArrayList<String>();
        for (i = 0; i <= cle.length() - 1; i++) {
            for (j = 0; j <= alphabet.length - 1; j++) {
                if (cle.charAt(i) == alphabet[j] || cle.charAt(i) == Character.toUpperCase(alphabet[j])) {
                    result.add(String.valueOf(j));
                    break;
                }

            }
        }
        return result;
    }

    public boolean check(ArrayList<String> text, ArrayList<String> cle) {

        return text.size() <= cle.size();
    }

    public String Vigenere(String text, String cle) {
        String result = "";
        int k, i = 0;
        int s = 0;
        int len = cle.length();
        do {
            if (i == len) {
                i = 0;
            }
            cle += cle.charAt(i);
            i++;
        } while (!check(getTextPositions(text), getClePositions(cle)));
        System.out.println(cle);
        for (i = 0; i <= text.length() - 1; i++) {

            if (!getTextPositions(text).get(i).isBlank()) {
                k = Integer.parseInt((getTextPositions(text).get(i))) + Integer.parseInt(getClePositions(cle).get(s));
                System.out.println(getTextPositions(text) + " " + getClePositions(cle));
                while (k > 25) {
                    k -= alphabet.length;
                }
                //System.out.println(getTextPositions(text).get(i) +" + " + getClePositions(cle).get(i));


                if (Character.isUpperCase(text.charAt(i))) {
                    result += Character.toUpperCase(alphabet[k]);
                } else {
                    result += alphabet[k];
                }
                s++;
            } else {
                result += " ";
            }
        }
        return result;
    }

    public String VigenereD(String text, String cle) {
        String result = "";
        int k, i = 0;
        int s = 0;
        int len = cle.length();

        do {
            //System.out.println(cle.length());
            if (i == len) {
                i = 0;
            }
            cle += cle.charAt(i);
            i++;
        } while (getClePositions(cle).size() <= text.length());

        for (i = 0; i <= getTextPositions(text).size() - 1; i++) {
            if (Character.isAlphabetic(text.charAt(i))) {
                k = Integer.parseInt((getTextPositions(text).get(i))) - Integer.parseInt(getClePositions(cle).get(s));
                while (k < 0) {
                    k += alphabet.length;
                }
                //System.out.println(k);
                if (Character.isUpperCase(text.charAt(i))) {
                    result += Character.toUpperCase(alphabet[k]);
                } else {
                    result += alphabet[k];
                }

                s++;
            } else if (getTextPositions(text).get(i).matches("[0-9]")) {
                result += getTextPositions(text).get(i);
            } else if (!getTextPositions(text).get(i).matches("[A-Za-z0-9]")) {
                result += getTextPositions(text).get(i);
            } else if (getTextPositions(text).get(i) == " ") {
                result += getTextPositions(text).get(i);
            }

        }
        return result;
    }

    public String Vigenere2(String text, String cle) {
        String result = "";
        int k, i = 0;
        int s = 0, z = 0;
        int len = cle.length();

        do {
            //System.out.println(cle.length());
            if (i == len) {
                i = 0;
            }
            cle += cle.charAt(i);
            i++;
        } while (getClePositions(cle).size() <= text.length());

        for (i = 0; i <= getTextPositions(text).size() - 1; i++) {
            if (Character.isAlphabetic(text.charAt(i))) {

                k = Integer.parseInt((getTextPositions(text).get(i))) + Integer.parseInt(getClePositions(cle).get(s));
                while (k > 25) {
                    k -= alphabet.length;
                }


                if (Character.isUpperCase(text.charAt(i))) {
                    result += Character.toUpperCase(alphabet[k]);
                } else {
                    result += alphabet[k];
                }
                s++;

            }
            if (Character.isDigit(text.charAt(i))) {
                result += getTextPositions(text).get(i);
            } else if (getTextPositions(text).get(i).matches("\\s")) {
                result += " ";
            } else if (getTextPositions(text).get(i).matches("[^A-Za-z0-9]")) {
                result += getTextPositions(text).get(i);
            }
        }
            return result;
    }

}
