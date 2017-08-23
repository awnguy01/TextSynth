package synthClasses;

public class PitchConverter {
	public PitchConverter() {

	}

	public int convert(String pitch) {
		switch (pitch.toUpperCase()) {
		case "C":
			return 60;
		case "C#":
			return 61;
		case "DB":
			return 61;
		case "D":
			return 62;
		case "D#":
			return 63;
		case "EB":
			return 63;
		case "E":
			return 64;
		case "F":
			return 65;
		case "F#":
			return 66;
		case "GB":
			return 66;
		case "G":
			return 67;
		case "G#":
			return 68;
		case "AB":
			return 68;
		case "A":
			return 69;
		case "A#":
			return 70;
		case "BB":
			return 70;
		case "B":
			return 71;
		default:
			return 999;
		}
	}
}
