package synthClasses;

import java.util.Scanner;
import javax.sound.midi.MidiUnavailableException;;

public class Launcher {

	public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		Synth synth = new Synth();
		Options options = new Options(synth);
		System.out.println("Welcome to TextSynth!");
		options.display();
		String response = scan.nextLine();
		do {
			switch (response.toUpperCase()) {
			case "PLAY":
				options.play();
				response = scan.nextLine(); 
				break;
			case "LIST":
				options.list();
				response = scan.nextLine();
				break;
			case "SWITCH":
				options.change();
				response = scan.nextLine();
				break;
			case "OPTIONS":
				options.display();
				response = scan.nextLine();
				break;
			case "CLOSE":
				run = false;
				System.out.println("Your session has ended\n\nGoodbye!");
				break;
			default:
				System.out.println("Please enter another option\n");
				response = scan.nextLine();
				break;
			}
		} while (run == true);

		synth.closeSynth();
		scan.close();
	}
}
