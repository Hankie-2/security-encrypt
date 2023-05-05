package kg.charginov.securityencrypt.service;

import java.io.*;
import java.util.*;

public class EncryptionService {
    private final StringBuilder answer = new StringBuilder();
    public String encrypt(String text){
        countFreqOfOutput();
        countFreqOfInput(text);

        changeCharactersInText(text);
        System.out.println(freqListOfKyrgyzAlphabet);
        System.out.println(freqListOfDecryptedText);
        return answer.toString();
    }

     List<Character> freqListOfDecryptedText;
     List<Character> freqListOfKyrgyzAlphabet;

    private void changeCharactersInText(String text){
        for(char character:text.toCharArray()) {
            if (character != '\n') {
                Character ch = Character.toLowerCase(character);
                int index = freqListOfDecryptedText.indexOf(ch);
                if (index >= 0 && index < freqListOfKyrgyzAlphabet.size()) {
                    character = freqListOfKyrgyzAlphabet.get(index);
                }
            }
            answer.append(character);
        }
    }

    private void countFreqOfOutput(){
        HashMap<Character, Integer> freqOfExample = new HashMap<>();

        File file = new File("C:\\Users\\User\\Desktop\\University\\IntellijIDEA\\SecurityEncrypt\\src\\main\\java\\kg\\charginov\\securityencrypt\\file\\kyrgyz_text.txt");

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase(Locale.ROOT);
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if(isKyrgyzLetter(ch)) continue;
                    freqOfExample.put(ch, freqOfExample.getOrDefault(ch,0)+1);
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        freqListOfKyrgyzAlphabet = mapToList(freqOfExample);

    }

    private void countFreqOfInput(String text){
        HashMap<Character, Integer> freqOfInput = new HashMap<>();
        text = text.toLowerCase(Locale.ROOT);
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if(isKyrgyzLetter(ch)) continue;
            freqOfInput.put(ch, freqOfInput.getOrDefault(ch,0)+1);
        }

        freqListOfDecryptedText = mapToList(freqOfInput);

    }

    private boolean isKyrgyzLetter(char ch) {
        return (ch < 'А' || ch > 'Я') && (ch < 'а' || ch > 'я') && (ch != 'Ү' && ch != 'ү') && (ch != 'Ө' && ch != 'ө') && (ch != 'Ң' && ch != 'ң');
    }

    private List<Character> mapToList(Map<Character,Integer> map){
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey).toList();
    }

}
