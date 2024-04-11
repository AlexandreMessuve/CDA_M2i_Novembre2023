package org.pendu;

public class Pendu {
    private String maskedWord;
    private String word;
    private String letterTested = "";
    private int count = 10;

    public Pendu(String word) {
        this.word = word.toLowerCase();
        generateMaskedWord();
    }
    public String getMaskedWord() {
        return maskedWord;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setMaskedWord(String maskedWord) {
        this.maskedWord = maskedWord;
    }

    private void generateMaskedWord() {
        String maskedWord = "";
        for (char letter : word.toCharArray()) {
            if(letterTested.contains(Character.toString(letter))) {
                maskedWord += letter;
            }
            else{
                maskedWord += "*";
            }
        }
        setMaskedWord(maskedWord);
    }
    public String testChar (String letter) {
        if(letterTested.contains(letter)) {
            return "Lettre déjà testé";
        }
        letterTested += letter;
        setCount(count - 1);
        if(word.contains(letter)){
            generateMaskedWord();
            return "La lettre est dans le mot !";
        }
        return  "La lettre n'est pas dans le mot !";
    }
    public boolean testWin(){
        return getWord().equalsIgnoreCase(getMaskedWord());
    }
}
