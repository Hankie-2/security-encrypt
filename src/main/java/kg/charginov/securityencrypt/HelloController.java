package kg.charginov.securityencrypt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import kg.charginov.securityencrypt.service.EncryptionService;

import java.util.HashMap;
import java.util.Map;

public class HelloController {

    @FXML
    private TextArea letterЁ;

    @FXML
    private TextArea letterА;

    @FXML
    private TextArea letterБ;

    @FXML
    private TextArea letterВ;

    @FXML
    private TextArea letterГ;

    @FXML
    private TextArea letterД;

    @FXML
    private TextArea letterЕ;

    @FXML
    private TextArea letterЖ;

    @FXML
    private TextArea letterЗ;

    @FXML
    private TextArea letterИ;

    @FXML
    private TextArea letterЙ;

    @FXML
    private TextArea letterК;

    @FXML
    private TextArea letterЛ;

    @FXML
    private TextArea letterМ;

    @FXML
    private TextArea letterН;

    @FXML
    private TextArea letterО;

    @FXML
    private TextArea letterП;

    @FXML
    private TextArea letterР;

    @FXML
    private TextArea letterС;

    @FXML
    private TextArea letterТ;

    @FXML
    private TextArea letterУ;

    @FXML
    private TextArea letterФ;

    @FXML
    private TextArea letterХ;

    @FXML
    private TextArea letterЦ;

    @FXML
    private TextArea letterЧ;

    @FXML
    private TextArea letterШ;

    @FXML
    private TextArea letterЩ;

    @FXML
    private TextArea letterЪ;

    @FXML
    private TextArea letterЫ;

    @FXML
    private TextArea letterЬ;

    @FXML
    private TextArea letterЭ;

    @FXML
    private TextArea letterЮ;

    @FXML
    private TextArea letterЯ;

    @FXML
    private TextArea letterҢ;

    @FXML
    private TextArea letterҮ;

    @FXML
    private TextArea letterӨ;

    @FXML
    private TextArea requestText;

    @FXML
    private TextArea responseText;

    @FXML
    private Label wrongText;

    @FXML
    private RadioButton mode1RB;

    @FXML
    private RadioButton mode2RB;

    @FXML
    private RadioButton mode3RB;

    @FXML
    private RadioButton mode5RB;

    @FXML
    private RadioButton mode6RB;

    @FXML
    private RadioButton mode4RB;

    private final EncryptionService encryptionService = new EncryptionService();
    private HashMap<Character,Character> map = new HashMap<>();
    private HashMap<Character,Character> copiedMap = new HashMap<>();
    {
        map.put('а', null);
        map.put('б', null);
        map.put('в', null);
        map.put('г', null);
        map.put('д', null);
        map.put('е', null);
        map.put('ё', null);
        map.put('ж', null);
        map.put('з', null);
        map.put('и', null);
        map.put('й', null);
        map.put('к', null);
        map.put('л', null);
        map.put('м', null);
        map.put('н', null);
        map.put('ң', null);
        map.put('о', null);
        map.put('ө', null);
        map.put('п', null);
        map.put('р', null);
        map.put('с', null);
        map.put('т', null);
        map.put('у', null);
        map.put('ү', null);
        map.put('ф', null);
        map.put('х', null);
        map.put('ц', null);
        map.put('ч', null);
        map.put('ш', null);
        map.put('щ', null);
        map.put('ы', null);
        map.put('ъ', null);
        map.put('ь', null);
        map.put('э', null);
        map.put('ю', null);
        map.put('я', null);
    }

    @FXML
    void decryptButton2Clicked(ActionEvent event) {
        if(requestText.getText().isEmpty()){
            wrongText.setVisible(true);
        }else{
            getOrLettersFromFields();
            System.out.println("Copied map: " + copiedMap);
            System.out.println("Current map: " + map);
            if(!copiedMap.equals(map)){
                changeMapValues();
            }
            setValuesToLetters();
            responseText.setText(encryptionService.decrypt(requestText.getText(),map));
        }
    }

    @FXML
    void decryptButton1Clicked(ActionEvent event) {
        if(requestText.getText().isEmpty()){
            wrongText.setVisible(true);
        }else{
            String mode = "";
            if(mode1RB.isSelected()){
                mode = EncryptionService.BOOK_1;
            }else if(mode2RB.isSelected()){
                mode = EncryptionService.BOOK_2;
            }else if(mode3RB.isSelected()){
                mode = EncryptionService.BOOK_3;
            }else if(mode4RB.isSelected()){
                mode = EncryptionService.BOOK_4;
            }else if(mode5RB.isSelected()){
                mode = EncryptionService.BOOK_5;
            }else if(mode6RB.isSelected()){
                mode = EncryptionService.BOOK_6;
            }

            getOrLettersFromFields();
            String text = encryptionService.changeCharactersInText(requestText.getText(),map,mode);
            copiedMap.putAll(map);
            System.out.println("Copied map: " + copiedMap);
            responseText.setText(text);
            setValuesToLetters();
            System.out.println("decryptButton1Clicked: " + map);
        }
    }

    private void changeMapValues(){
        for(Character ch:copiedMap.keySet()){
            if(copiedMap.get(ch) != '_' && !copiedMap.get(ch).equals( map.get(ch))){
                char value = map.get(ch);
                System.out.println(value + " " + copiedMap.get(ch));
                for(Character ch2 : map.keySet()){
                    if(map.get(ch2).equals(value) && !ch.equals(ch2)){
                        System.out.println("Ключ: " + ch2);
                        map.put(ch2,copiedMap.get(ch));
                    }
                }
            }
        }
        copiedMap.putAll(map);
    }

    private void setValuesToLetters() {
        letterЁ.setText(String.valueOf(map.getOrDefault('ё', '_')));
        letterА.setText(String.valueOf(map.getOrDefault('а', '_')));
        letterБ.setText(String.valueOf(map.getOrDefault('б', '_')));
        letterВ.setText(String.valueOf(map.getOrDefault('в', '_')));
        letterГ.setText(String.valueOf(map.getOrDefault('г', '_')));
        letterД.setText(String.valueOf(map.getOrDefault('д', '_')));
        letterЕ.setText(String.valueOf(map.getOrDefault('е', '_')));
        letterЖ.setText(String.valueOf(map.getOrDefault('ж', '_')));
        letterЗ.setText(String.valueOf(map.getOrDefault('з', '_')));
        letterИ.setText(String.valueOf(map.getOrDefault('и', '_')));
        letterЙ.setText(String.valueOf(map.getOrDefault('й', '_')));
        letterК.setText(String.valueOf(map.getOrDefault('к', '_')));
        letterЛ.setText(String.valueOf(map.getOrDefault('л', '_')));
        letterМ.setText(String.valueOf(map.getOrDefault('м', '_')));
        letterН.setText(String.valueOf(map.getOrDefault('н', '_')));
        letterО.setText(String.valueOf(map.getOrDefault('о', '_')));
        letterП.setText(String.valueOf(map.getOrDefault('п', '_')));
        letterР.setText(String.valueOf(map.getOrDefault('р', '_')));
        letterС.setText(String.valueOf(map.getOrDefault('с', '_')));
        letterТ.setText(String.valueOf(map.getOrDefault('т', '_')));
        letterУ.setText(String.valueOf(map.getOrDefault('у', '_')));
        letterФ.setText(String.valueOf(map.getOrDefault('ф', '_')));
        letterХ.setText(String.valueOf(map.getOrDefault('х', '_')));
        letterЦ.setText(String.valueOf(map.getOrDefault('ц', '_')));
        letterЧ.setText(String.valueOf(map.getOrDefault('ч', '_')));
        letterШ.setText(String.valueOf(map.getOrDefault('ш', '_')));
        letterЩ.setText(String.valueOf(map.getOrDefault('щ', '_')));
        letterЫ.setText(String.valueOf(map.getOrDefault('ы', '_')));
        letterЪ.setText(String.valueOf(map.getOrDefault('ъ', '_')));
        letterЬ.setText(String.valueOf(map.getOrDefault('ь', '_')));
        letterЭ.setText(String.valueOf(map.getOrDefault('э', '_')));
        letterЮ.setText(String.valueOf(map.getOrDefault('ю', '_')));
        letterЯ.setText(String.valueOf(map.getOrDefault('я', '_')));
        letterҢ.setText(String.valueOf(map.getOrDefault('ң', '_')));
        letterҮ.setText(String.valueOf(map.getOrDefault('ү', '_')));
        letterӨ.setText(String.valueOf(map.getOrDefault('ө', '_')));
    }


    private void getOrLettersFromFields()
    {
        map.put('а', getLetterValue(letterА));
        map.put('б', getLetterValue(letterБ));
        map.put('в', getLetterValue(letterВ));
        map.put('г', getLetterValue(letterГ));
        map.put('д', getLetterValue(letterД));
        map.put('е', getLetterValue(letterЕ));
        map.put('ё', getLetterValue(letterЁ));
        map.put('ж', getLetterValue(letterЖ));
        map.put('з', getLetterValue(letterЗ));
        map.put('и', getLetterValue(letterИ));
        map.put('й', getLetterValue(letterЙ));
        map.put('к', getLetterValue(letterК));
        map.put('л', getLetterValue(letterЛ));
        map.put('м', getLetterValue(letterМ));
        map.put('н', getLetterValue(letterН));
        map.put('ң', getLetterValue(letterҢ));
        map.put('о', getLetterValue(letterО));
        map.put('ө', getLetterValue(letterӨ));
        map.put('п', getLetterValue(letterП));
        map.put('р', getLetterValue(letterР));
        map.put('с', getLetterValue(letterС));
        map.put('т', getLetterValue(letterТ));
        map.put('у', getLetterValue(letterУ));
        map.put('ү', getLetterValue(letterҮ));
        map.put('ф', getLetterValue(letterФ));
        map.put('х', getLetterValue(letterХ));
        map.put('ц', getLetterValue(letterЦ));
        map.put('ч', getLetterValue(letterЧ));
        map.put('ш', getLetterValue(letterШ));
        map.put('щ', getLetterValue(letterЩ));
        map.put('ы', getLetterValue(letterЫ));
        map.put('ъ', getLetterValue(letterЪ));
        map.put('ь', getLetterValue(letterЬ));
        map.put('э', getLetterValue(letterЭ));
        map.put('ю', getLetterValue(letterЮ));
        map.put('я', getLetterValue(letterЯ));
    }


    private Character getLetterValue(TextArea textArea) {
        String text = textArea.getText().trim();
        if (!text.isEmpty() && text.charAt(0) != 'n') {
            return text.charAt(0);
        }else{
            return '_';
        }
    }


}