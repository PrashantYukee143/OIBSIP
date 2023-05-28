package com.prashant.GuessingGame;

import java.util.Scanner;

public class NumberChecker {

	public void game() {
		int count = 0, score = 0, rounds;
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"*************************************** WELCOME TO THE GUESSING GAME ***************************************");

		System.out.println("Enter the number of rounds you want to play(not more than 30): ");
		rounds = sc.nextInt();
			if (rounds < 1 || rounds > 30) {
				System.out.println("Round should be Within the limits");
			} else {
				System.out.println("The number should be guessed betweem 1 to 100 within");
				for (count = 0; count < rounds; count++) {
					int num = (int) (Math.random() * (99) + 1);

					System.out.println("Guess the Number: ");
					int guess = sc.nextInt();

					if (guess == num) {
						System.out.println("Congrats! Correct guess");
						score++;
					} else if (guess > num) {
						System.out.println("The guessed number is larger than the actual number");
						System.out.println("The correct number is: " + num);
					} else if (guess < num) {
						System.out.println("The guessed number is smaller than the actual number");
						System.out.println("The correct number is: " + num);
					} else {
						System.out.println("Enter the number between the range");
					}
				}
				System.out.println();
				System.out.println("******************* THANK YOU FOR USING *******************");
				System.out.println();
				System.out.println("Your total score is " + score + " out of " + rounds);
				System.out.println();
				System.out.println("Your percentage is " + ((double) score / rounds) * 100 + " %");
				sc.close();
			}
	}
}
