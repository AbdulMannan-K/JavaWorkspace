public class DictionaryWord implements Comparable<DictionaryWord> {

        private String word;
        private String meaning;

        public DictionaryWord(String word, String meaning){
            setWord(word);
            setMeaning(meaning);
        }

    public void setWord(String word) {
        this.word = word;
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

    @Override
    public int compareTo(DictionaryWord o) {
        return Integer.compare(getWord().compareToIgnoreCase(o.getWord()), 0);
    }
}
