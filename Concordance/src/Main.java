import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        int freq;
        Entry entry;
        boolean found = false;
        ArrayList  <Entry> concordance = new ArrayList();
        Reader fileReader=null;
        try {
            fileReader = new FileReader("C:\\Users\\brian\\IdeaProjects\\Concordance\\src\\Page");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine()) != null) {
        	System.out.print("gg");
            String wordArray[] = line.split("  | , | . ");
            for (int i = 0; i < wordArray.length; i++) {
                found = false;
                String word = wordArray[0];
                for (int j = 0; j < concordance.size(); j++) {
                    if (concordance.get(j).getWord().equalsIgnoreCase(word)) {
                        freq = concordance.get(j).getFrequency();
                        concordance.get(j).setFrequency(freq + 1);
                        found = true;
                    }
                    if (!found) {
                        entry = new Entry(1, word);
                        concordance.add(entry);
                    }
                }
            }
        }
        for(int i=0;i<concordance.size();i++) System.out.println(concordance.get(i) + "\n" + "ye");
        

    }
}
