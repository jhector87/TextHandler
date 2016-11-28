import java.io.*;

/**
 * Created by jonathanhector on 23.11.16.
 */
public class Prompter extends TextDemo {

    public String mSearch;


	public Prompter() throws Exception {
		promptResult();
	}

	//Checks if promtForSearch is true and return the file
	private void promptResult() throws Exception{
		FileHandling searchFile  = new FileHandling();
		if((searchFile.arrText != null) && (promptForSearch())){
			System.out.print(searchFile.arrText);
		}
	}

	private boolean promptForSearch() throws Exception {
        Console console = System.console();
        boolean isValidFile = false;
        while(!isValidFile){
	        System.out.println("Enter a file name with extension: \n");
	        String searchAsString = console.readLine();
            try {
                mSearch = searchAsString;
                isValidFile = true;
                FileHandling returnAmount = new FileHandling();
	            System.out.printf("File %s found,\n", returnAmount.getLetterFrequencies());
            } catch (IllegalArgumentException iae){
                console.printf("%s not found! Please try again.\n", iae.getMessage());
            }

        }
        return true;
    }
}
