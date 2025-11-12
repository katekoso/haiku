import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Random;

/**
 * Class Haiku creates a haiku by randomly combining words into 3 lines with 5,
 * 7 and 5
 * syllables. There are prewritten words and it's possible to add more.
 * 
 * @author Ekaterina Kosourikhina
 * @version 07.02.2025
 */
public class Haiku {
    public TreeMap<Integer, ArrayList<String>> words;
    public Random ran;

    /**
     * Constructor for objects of class Haiku. Initialises words to an empty
     * TreeMap and ran to a new Random object
     */
    public Haiku() {
        words = new TreeMap<>();
        ran = new Random();
    }

    public static void main(String[] args) {
        Haiku h = new Haiku();
        h.printHaiku();
    }

    /**
     * Populates words map with sample words
     */
    public void populate() {
        words.put(1, new ArrayList<>());
        words.put(2, new ArrayList<>());
        words.put(3, new ArrayList<>());
        words.put(4, new ArrayList<>());
        words.put(5, new ArrayList<>());
        words.put(6, new ArrayList<>());
        words.put(7, new ArrayList<>());

        words.get(1).add("creaks");
        words.get(1).add("song");
        words.get(1).add("vow");
        words.get(1).add("wild");
        words.get(1).add("wind");
        words.get(1).add("sign");
        words.get(2).add("tender");
        words.get(2).add("heavy");
        words.get(2).add("prayer");
        words.get(2).add("wanders");
        words.get(2).add("current");
        words.get(2).add("weary");
        words.get(2).add("conscious");
        words.get(2).add("patters");
        words.get(2).add("feather");
        words.get(2).add("torrent");
        words.get(2).add("downpour");
        words.get(3).add("luminous");
        words.get(3).add("radiant");
        words.get(3).add("solitude");
        words.get(3).add("nemesis");
        words.get(3).add("juxtaposed");
        words.get(3).add("apathy");
        words.get(3).add("lethargy");
        words.get(3).add("momentum");
        words.get(3).add("alienates");
        words.get(4).add("asphyxiates");
        words.get(4).add("cacophony");
        words.get(4).add("elysium");
        words.get(4).add("botanical");
        words.get(4).add("combination");
        words.get(4).add("ambitiously");
        words.get(4).add("ordinary");
        words.get(4).add("constellation");
        words.get(4).add("contaminates");
        words.get(4).add("accelerates");
        words.get(4).add("caterpillar");
        words.get(5).add("mechanically");
        words.get(5).add("discombobulates");
        words.get(5).add("serendipity");
        words.get(5).add("hilariously");
        words.get(5).add("simultaneous");
        words.get(5).add("apologetic");
        words.get(5).add("choreography");
        words.get(5).add("deteriorates");
        words.get(5).add("electricity");
        words.get(6).add("disassociation");
        words.get(6).add("excommunicated");
        words.get(6).add("voluminosity");
        words.get(6).add("personification");
        words.get(6).add("disassociation");
        words.get(6).add("humanitarian");
        words.get(6).add("interrogatory");
        words.get(6).add("experimentation");
        words.get(7).add("anthropomorphization");
        words.get(7).add("unimaginatively");
        words.get(7).add("sentimentalisation");
        words.get(7).add("oversimplification");
        words.get(7).add("incompatibility");
        words.get(7).add("unimaginatively");
        words.get(7).add("autobiographical");
        words.get(7).add("anachronistically");
    }

    /**
     * Prints the contents of words
     */
    public void printWords() {
        for (Integer syllables : words.keySet()) {
            System.out.print(syllables + " ->");
            for (String word : words.get(syllables)) {
                System.out.print(" " + word);
            }
            System.out.println();
        }
    }

    /**
     * If the list corresponding to the given number of syllables exists in words
     * and the given
     * word isn't already there, adds the word to the that list.
     * If the list doesn't exist, creates a map entry with the given number as the
     * key and adds
     * the word in the new list.
     * 
     * @param num  Number of syllables
     * @param word A word to be added to words
     */
    public void addWord(int num, String word) {
        String wordToAdd = word.trim().toLowerCase();

        if (num >= 1 && num <= 7) {
            if (!words.containsKey(num)) {
                words.put(num, new ArrayList<>());
                words.get(num).add(wordToAdd);
            } else if (!words.get(num).contains(wordToAdd)) {
                words.get(num).add(wordToAdd);
            }
        }
    }

    /**
     * Creates a line of a poem with a given number of syllables
     * 
     * @param syllables The number of syllables a line should have
     * 
     * @return The line with the correct number of syllables
     */
    public String makeLine(int syllables) {
        populate();

        int sylCount = 0;
        ArrayList<String> line = new ArrayList<>();
        ;

        while (sylCount < syllables) {
            int syllablesNext = ran.nextInt(syllables - sylCount) + 1;
            int ranWord = ran.nextInt(words.get(syllablesNext).size());
            String word = words.get(syllablesNext).get(ranWord);
            if (!line.contains(word)) {
                line.add(word);
                sylCount += syllablesNext;
            }
        }

        return String.join(" ", line);
    }

    /**
     * Prints three lines of a haiku, the first line has 5 syllables, the second has
     * 7 syllables
     * and the third has 5 syllables.
     */
    public void printHaiku() {
        System.out.println(makeLine(5));
        System.out.println(makeLine(7));
        System.out.println(makeLine(5));
    }
}