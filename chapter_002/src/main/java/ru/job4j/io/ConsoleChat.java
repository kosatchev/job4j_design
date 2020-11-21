package ru.job4j.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ConsoleChat {

	private final String path;
	private final String botAnswers;
	private static final String OUT = "закончить";
	private static final String STOP = "стоп";
	private static final String CONTINUE = "продолжить";
	private static final String HELLO = "Hi!";
	private static final String BYE = "Bye!";
	private boolean active = true;

	private List<String> phrases;

	public ConsoleChat(String path, String botAnswers) {
		this.path = path;
		this.botAnswers = botAnswers;
	}

	public static void main(String[] args) throws IOException {
		ConsoleChat cc = new ConsoleChat("ConsoleChatLog.txt", "ConsoleChatAnswers.txt");
		cc.run();
	}

	public void run() throws IOException {
		PrintWriter pw = new PrintWriter(path); //очистка лога
		pw.close();

		phrases = readPhrases(botAnswers);
		System.out.println(HELLO);
		writeDataInFile(path, HELLO);
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")))) {
			String input = in.readLine();
			writeDataInFile(path, input);
			while (!input.equals(OUT)) {
				if (input.equals(STOP)) {
					active = false;
				} else if (input.equals(CONTINUE)) {
					active = true;
					randomPhrase(path);
				} else {
					if (active) {
						randomPhrase(path);
					}
				}
				input = in.readLine();
				writeDataInFile(path, input);
			}
		}
		System.out.println(BYE);
		writeDataInFile(path, BYE);
	}

	public void randomPhrase(String path) {
		String out = phrases.get((int) Math.round((phrases.size() - 1) * Math.random()));
		System.out.println(out);
		writeDataInFile(path, out);
	}

	public void writeDataInFile(String path, String data) {
		try (BufferedWriter br = new BufferedWriter(new FileWriter(path, Charset.forName("UTF-8"), true))) {
			br.write(data + System.lineSeparator());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> readPhrases(String path) {
		ArrayList<String> phrases = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				phrases.add(line);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return phrases;
	}
}