package org.pendu;

public class Pendu {
    private String maskedWord;
    private String word;
    private int count = 10;

    public Pendu(String word) {
        this.word = word.toLowerCase();
        generateMaskedWord(word);
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

    public void generateMaskedWord(String word) {
        setMaskedWord("*".repeat(word.length()));
    }
    public void testChar (String ch) {
        String newMaskedWord = "";
        for (int i = 0; i < word.length(); i++) {
            if(Character.toString(word.charAt(i)).equalsIgnoreCase(ch)) {
                newMaskedWord += ch;
                continue;
            }
            if(getMaskedWord().charAt(i) == '*'){
                newMaskedWord += "*";
            }else{
                newMaskedWord += getMaskedWord().charAt(i);
            }
        }
        setMaskedWord(newMaskedWord);
        setCount(count - 1);
    }
    public boolean testWin(){
        return getWord().equalsIgnoreCase(getMaskedWord());
    }
}
