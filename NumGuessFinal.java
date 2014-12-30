import java.util.*;

public class NumGuessFinal {
	static int randomAnswerEasy = (int) (Math.random() * 10 + 1); // Picks an
																	// easy
																	// number
																	// ranging
																	// from 1 -
																	// 10
	static int randomAnswerHard = (int) (Math.random() * 50 + 1); // Picks a
																	// more
																	// difficult
																	// number
																	// ranging
																	// from 1-50
	boolean hinta = false;
	boolean hintb = false;
	boolean failsafe = false;

	@SuppressWarnings("resource")
	public String gamePlay() {
		Scanner in = new Scanner(System.in);

		System.out.println("Pick a level: 1 (Easy), 2 (Hard)");
		System.out.println();
		String level = in.nextLine();
		System.out.println();
		while (level.equals("") ^ "1".equals(level) ^ !"2".equals(level)) {
			System.out.println("Please enter a valid level number");
			String retry = in.nextLine();
			level = retry;
		}
		if (level.equals("1")) {

			System.out
					.println("Try and guess the mystery number by picking a number from 1 to 10!");
			System.out.println();
			int guess;
			boolean y = true;
			int j = 0;
			while (y) {
				System.out.print("Your Guess: ");
				guess = in.nextInt();
				System.out.println();
				if (guess != randomAnswerEasy) {
					if (guess > 10 || guess < 1) {
						System.out
								.println("This number is invalid. Please pick a number in the range of 1 - 10");
						continue;
					}
					j++;
					System.out.println("Try again!");
					System.out.println("Attempt: #" + j);
					System.out.println();

				}

				if (guess == randomAnswerEasy) {
					y = false;
					return "Nice Job! You win! It took you " + (j + 1)
							+ " tries";

				} else {
					if (j % 2 == 0) {
						System.out
								.println("Come on you can do better than that! Try again!");
					} else if (j % 2 == 1) {

						System.out.println("Guess again! Try number");
						System.out.println();
					}

				}

			}

		} else if (level.equals("2")) {

			System.out
					.println("Try and guess the mystery number by picking a number from 1 to 50!");
			System.out.println();
			int guess;
			boolean y = true;
			int j = 1;
			while (y) {
				System.out.println("Your Guess:");
				guess = in.nextInt();
				if (guess != randomAnswerHard) {
					if (guess > 50 || guess < 1) {
						System.out
								.println("This number is invalid. Please pick a number in the range of 1 - 50");
						continue;
					}
					j++;
					System.out.println("Try again!");
					System.out.println("Attempt: #" + j);
					System.out.println();
				}

				if (guess == randomAnswerHard) {
					y = false;
					return "Nice Job! You win! It took you " + j + " tries";

				} else {
					if (j == 1) {
						System.out
								.println("Come on you can do better than that! Try again!");
					} else if (j == 2) {

						System.out.println("Guess again! Try number");
					} else if (j % 5 == 0) {
						hinta = false;
						System.out.println("Would you like a hint? [Y, N]");
						while (hinta == false) {
							String ques = in.next();
							System.out.println();
							if (ques.equals("Y") || ques.equals("y")) {
								hinta = true;
								System.out
										.println("Hint: The answer is between "
												+ (randomAnswerHard - (int) (Math
														.random() * 5 + 1))
												+ " and "
												+ (randomAnswerHard
														+ (int) Math.random()
														* 5 + 1));
								continue;
							} else if (ques.equals("N") || ques.equals("n")) {
								hinta = true;
								continue;
							} else {
								System.out.println("Please select Y or N");
								System.out.println();

							}
						}
					}

				}

			}

		}

		return null;
	}

	public static void main(String[] args) {
		NumGuessFinal test = new NumGuessFinal();
		String a = test.gamePlay();
		System.out.println(a);

	}

}
