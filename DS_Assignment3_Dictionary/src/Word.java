public class Word implements Comparable<Word> {
    private String word;
    private String meaning;

    public Word(String word, String meaning){
        this.word= word;
        this.meaning = meaning;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getWord() {
        return word;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public int compareTo(Word o) {
        if(getWord().compareToIgnoreCase(o.getWord())>0) return 1;
        else if(getWord().compareToIgnoreCase(o.getWord())<0) return -1;
        return 0;
    }
}
