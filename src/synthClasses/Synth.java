package synthClasses;

import javax.sound.midi.*;

public class Synth {
	private Synthesizer synth;
	private MidiChannel[] channel;
	private Instrument[] instruments;
	private int bank = 0;
	private int program = 0;

	public Synth() throws MidiUnavailableException {
		synth = MidiSystem.getSynthesizer();
		synth.open();
		channel = synth.getChannels();
		instruments = synth.getAvailableInstruments();
	}

	public void play(int pitch, int velocity) throws InterruptedException {
		channel[0].noteOn(pitch, velocity);
		Thread.sleep(1000);
		channel[0].noteOff(pitch, velocity);
		Thread.sleep(100);
	}

	public void switchInstrument(int instr) {
		bank = instruments[instr].getPatch().getBank();
		program = instruments[instr].getPatch().getProgram();
		channel[0].programChange(bank, program);
	}

	public int countInstruments() {
		return instruments.length;
	}

	public void listInstruments() {
		int i = 0;
		System.out.println("No.\tInstrument\tBank #\tProgram #");
		for (Instrument instrList : instruments) {
			System.out.println("#" + i + "\t" + instrList.getName() + "\t" + instrList.getPatch().getBank() + "\t"
					+ instrList.getPatch().getProgram());
			i++;
		}
	}

	public void closeSynth() {
		synth.close();
	}

}
