package synthClasses;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Options {
	private String statement;
	private Synth synth;
	private Scanner scan = new Scanner(System.in);

	public Options(Synth s) {
		synth = s;
		statement = "\nSelect an option\n\n" + "Play: Go to the synthesizer\n"
				+ "List: List the available instruments\n" + "Switch: Change your instrument\n"
				+ "Options: Display these choices again\n" + "Close: Close this program\n\n";
	}

	public void play() throws InterruptedException {
		PitchConverter converter = new PitchConverter();
		System.out.println("Type a pitch to hear it played\n" + "Type EXIT to return to the main menu");
		boolean keepPlaying = true;
		String entry;
		do {
			entry = scan.nextLine().toUpperCase();
			boolean exit = entry.equals("EXIT");

			if (exit) {
				keepPlaying = false;
			} else {
				int pitch = converter.convert(entry);

				if (pitch == 999) {
					System.out.println("Invalid Pitch");
				} else {
					synth.play(pitch, 50);
				}
			}
		} while (keepPlaying);
		display();
	}

	public void list() {
		synth.listInstruments();
		display();
	}

	public void change() throws InterruptedException {
		int instr = 0;
		boolean again = true;
		do {
			System.out.println("Type the instrument number you wish to play");
			try {
				instr = scan.nextInt();
				if (instr < synth.countInstruments() && instr >= 0) {
					synth.switchInstrument(instr);
					System.out.println("The instrument has been changed successfully");
					again = false;
				} else {
					System.out.println("That number is outside the range of instruments\n");
				}
			} catch (InputMismatchException exception) {
				System.out.println("That is not a valid instrument number\n");
				scan.nextLine();
			}
		} while (again);
		scan.nextLine();
		Thread.sleep(1000);
		display();
	}

	public void display() {
		System.out.print(statement);
	}
}
