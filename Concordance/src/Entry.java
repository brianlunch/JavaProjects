public class Entry {
    int frequency;

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    String word;

    public int getFrequency() {
        return frequency;
    }

    public String getWord() {
        return word;
    }

    public Entry(int frequency, String word) {
        this.frequency = frequency;
        this.word = word;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "frequency=" + frequency +
                ", word='" + word + '\'' +
                '}';
    }
}
