package kg.charginov.securityencrypt.service;

import java.util.Locale;

public class EncryptionService {

    public String encrypt(String text){
        String lettersLower = "абвгдеёжзийклмнңоөпрстуүфхцчшщъыьэюя";
        String lettersUpper = "АБВГДЕЖЗИЙКЛМНҢОӨПРСТУҮФХЦЧШЩЪЫЬЭЮЯ";
        StringBuilder arr = new StringBuilder();
        int step = 1;
        for (char i : text.toCharArray()) {
            if (i == ' ') {
                arr.append(' ');
            }else if(i == '\n'){
                arr.append("\n");
            }else {
                int indexLower = lettersLower.indexOf(i);
                int indexUpper = lettersUpper.indexOf(i);
                if(indexLower != -1){
                    if(indexLower == lettersLower.length()-1){
                        arr.append(lettersLower.charAt(0));
                    }else{
                        arr.append(lettersLower.charAt(indexLower + step));
                    }
                }else if(indexUpper != -1){
                    if(indexUpper == lettersUpper.length()-1){
                        arr.append(lettersUpper.charAt(0));
                    }else{
                        arr.append(lettersUpper.charAt(indexUpper + step));
                    }
                }
            }
        }
        return arr.toString();
    }

}
