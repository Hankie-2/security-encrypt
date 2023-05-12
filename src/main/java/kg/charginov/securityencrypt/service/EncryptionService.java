package kg.charginov.securityencrypt.service;

import java.io.*;
import java.util.*;

public class EncryptionService {

    private StringBuilder answer = new StringBuilder();

    HashMap<Character, Integer> mapFreqOfInputText;
    HashMap<Character, Integer> mapFreqOfKyrgyzDictionary;

    List<Character> listFreqOfInputText;
    List<Character> listFreqOfKyrgyzDictionary;

    public static final String BOOK_6 = "C:\\Users\\User\\Desktop\\University\\Machine Learning Course\\manas.txt";
    public static final String BOOK_5 = "C:\\Users\\User\\Desktop\\University\\Machine Learning Course\\kyrgyz-text.txt";
    public static final String BOOK_4 = "C:\\Users\\User\\Desktop\\University\\Machine Learning Course\\book-4.txt";
    public static final String BOOK_3 = "C:\\Users\\User\\Desktop\\University\\Machine Learning Course\\book-3.txt";
    public static final String BOOK_2 = "C:\\Users\\User\\Desktop\\University\\Machine Learning Course\\book-2.txt";
    public static final String BOOK_1 = "C:\\Users\\User\\Desktop\\University\\IntellijIDEA\\SecurityEncrypt\\src\\main\\java\\kg\\charginov\\securityencrypt\\file\\kyrgyz_text.txt";

    public String decrypt(String text,HashMap<Character,Character> map){
        text = text.toLowerCase(Locale.ROOT);
        answer.setLength(0);
        for(char ch:text.toCharArray()){
            if(ch != '\n'){
                if(map.get(ch) != null){
                    answer.append(map.get(ch));
                }else{
                    answer.append(ch);
                }
            }else{
                answer.append("\n");
            }
        }
        return answer.toString();
    }

    public String changeCharactersInText(String text,HashMap<Character,Character> map,String filePath){
        answer.setLength(0);
        countFreqOfKyrgyzDictionary(filePath);
        countFreqOfInput(text);
        System.out.println();
        System.out.println("Frequency of Kyrgyz Text: " + listFreqOfKyrgyzDictionary + " " + listFreqOfKyrgyzDictionary.size());
        System.out.println("Frequency of Input Text:  " + listFreqOfInputText + " " + listFreqOfInputText.size());

        for(int i = 0;i<listFreqOfInputText.size();i++){
            if(i>=listFreqOfKyrgyzDictionary.size()) break;
            map.put(listFreqOfInputText.get(i),listFreqOfKyrgyzDictionary.get(i));
        }
        for(char character:text.toCharArray()) {
            if (character != '\n') {
                Character ch = Character.toLowerCase(character);
                int index = listFreqOfInputText.indexOf(ch);
                if (index >= 0 && index < listFreqOfKyrgyzDictionary.size()) {
                    character = listFreqOfKyrgyzDictionary.get(index);
                }
            }
            answer.append(character);
        }
        return answer.toString();
    }

    private void countFreqOfKyrgyzDictionary(String filePath){
        mapFreqOfKyrgyzDictionary = new HashMap<>();

        File file = new File(filePath);

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase(Locale.ROOT);
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if(isKyrgyzLetter(ch)) continue;
                    mapFreqOfKyrgyzDictionary.put(ch, mapFreqOfKyrgyzDictionary.getOrDefault(ch,0)+1);
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        listFreqOfKyrgyzDictionary = mapToList(mapFreqOfKyrgyzDictionary);
        System.out.println(mapFreqOfKyrgyzDictionary);
    }

    private void countFreqOfInput(String text){
        mapFreqOfInputText = new HashMap<>();
        text = text.toLowerCase(Locale.ROOT);
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if(isKyrgyzLetter(ch)) continue;
            mapFreqOfInputText.put(ch, mapFreqOfInputText.getOrDefault(ch,0)+1);
        }
        listFreqOfInputText = mapToList(mapFreqOfInputText);
        System.out.println(mapFreqOfInputText);
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