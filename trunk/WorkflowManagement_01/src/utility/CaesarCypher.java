package utility;



import java.io.*;

public class CaesarCypher {
	public static String encrypt(String args) {
		final int MOVE_DOWN = 4;
		String plainText = args;
		char character;
		String encText = "";
//		System.out.print("Encrypted sentence is: ");

		for (int iteration = 0; iteration < plainText.length(); iteration++) {
			character = plainText.charAt(iteration); // get characters
			character = (char) (character + MOVE_DOWN); // perform shift
			encText = encText + character;
//			System.out.print(character);
		}

//		System.out.println();
		return encText;
	}

	public static String decrypt(String args) {
		final int MOVE_DOWN = -4;
		String plainText = args;
		char character;
		String decText = "";

//		System.out.print("Encrypted sentence is: ");

		for (int iteration = 0; iteration < plainText.length(); iteration++) {
			character = plainText.charAt(iteration); // get characters
			character = (char) (character + MOVE_DOWN); // perform shift
			decText = decText + character;
//			System.out.print(character);
		}

//		System.out.println();
		return decText;
	}

}