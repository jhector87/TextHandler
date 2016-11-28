/**
 * Created by jonathanhector on 17.11.16.
 */
public class TextDemo {

    public static void main(String[] args) throws Exception {
        Prompter  returnAmount = new Prompter();
        System.out.printf("Please type the file name: \n", returnAmount.mSearch);
        System.out.println("The letter counts are: \n");
        FileHandling charCount = new FileHandling();
        charCount.getLetterFrequencies();

    }

}


