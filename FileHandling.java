import java.io.*;
import java.util.*;

/**
 * Created by jonathanhector on 23.11.16.
 */
public class FileHandling extends TextDemo {

	public String sTextRead;

	private static final int NUM_LETTERS = 26;
	private int[] mTextAmount;
	public ArrayList<String> arrText;

	public FileHandling() throws Exception {
		getLetterFrequencies();
	}

	private void readText() throws Exception {
		try {
			Scanner sc = new Scanner(new File("alice.txt"));
			arrText = new ArrayList<>();
			while (sc.hasNext()) {
				arrText.add(sc.next().trim());
				// trim takes off the white spaces
				String str = sc.next().trim();
				System.out.println(str);
			}
			sc.close();
		} catch (IllegalArgumentException iae) {
			System.err.printf("Sorry file not found. Please try again!\n");
			readText();
		}
	}

	private int[] sortText() {
		int[] sortedText = new int[NUM_LETTERS];
		if (sTextRead == null) {
			for (int i = 0; i < sTextRead.length(); i++) {
				if (Character.isLetter(sTextRead.charAt(i)))
					sortedText[sTextRead.charAt(i) - 'a']++;
			}
		}


		//does the bubble sort
		char[] charLetter = sTextRead.toCharArray();
		for (int k = 0; k < charLetter.length; k++) {
			for (int i = 0; i < charLetter.length - k; i++) {
				if (charLetter[i] > charLetter[i + 1]) {
					int temp = charLetter[i];
					charLetter[i] = charLetter[i + 1];
					charLetter[i + 1] = (char) temp;
				}
			}
		}
		return sortedText;
	}

	// gets the letter occurrences
	public Character getLetterFrequencies() throws Exception {
		int[] c = sortText();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int[] countArray = new int[26];
		for (int x : c) {
			for (int i = 0; i < alphabet.length(); i++) {
				if (alphabet.charAt(i) == x) {
					countArray[i]++;
				}
			}
		}

		java.util.HashMap<Integer, Character> countList = new java.util.HashMap<>();

		for (int i = 0; i < 26; i++) {
			countList.put(countArray[i], alphabet.charAt(i));
		}
		java.util.Arrays.sort(countArray);
		int max = countArray[25];
		return countList.get(max);

	}


	/*private boolean checkSort() {
		boolean letterFreqBoo = false;
		while (!(letterFreqBoo == readText().isEmpty())) {
			String[] sLetter;
			sLetter = new String[NUM_LETTERS];
				throw new IllegalArgumentException("Something went wrong in the process");
				if ( char[] charLetterFound !=sLetter.equals(Character)){
					CharArrayReader charReader = new CharArrayReader(charLetterFound);

					//transform the String Array to char Array
					int length = 0;
					for (int i = 0; i < sLetter.length; i++) {
						for (int j = 0; j < sLetter[i].length(); j++) {
							length++;
						}
					}

					char[] charactLetter = new char[length];
					int k = 0;
					for (int i = 0; i < sLetter.length; i++) {
						for (int j = 0; j < sLetter[i].length(); j++) {
							charactLetter[k] = charReader.toString().charAt(j);
							k++;
						}
					}
					for (int j = 0; j < charactLetter.length; j++) {
						System.out.print("char is: " + charactLetter[j]);
					}

				}


			}
			letterFreqBoo = true;
		}
*/

	}
