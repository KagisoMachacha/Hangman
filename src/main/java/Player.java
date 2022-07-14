import java.io.InputStream;
import java.util.Scanner;

public class Player {
    private int chances = 5;
    private boolean quit  = false;
    private final Scanner scanner;

    public Player(InputStream in) {
        this.scanner = new Scanner(in);
    }
    public Player() {
        this.scanner = new Scanner(System.in);
    }
    public int getChances() {
        return chances;
    }
    public boolean hasNoChances() {
        return this.getChances() == 0;
    }
    public void lostChance() {
        if (!this.hasNoChances()) {
            this.chances--;
        }
    }
    public String getWordsFile() {
        String filename = scanner.nextLine();
        return filename.isBlank() ? "flowers.txt" : filename;
    }
    public String getGuess(InputStream in) {
        String text = scanner.nextLine();
        this.quit = text.equalsIgnoreCase("quit")
                || text.equalsIgnoreCase("exit");
        return text;
    }

    public String getGuess() {
        String text = scanner.nextLine();
        this.quit = text.equalsIgnoreCase("quit")
                || text.equalsIgnoreCase("exit");
        return text;
    }

    public boolean wantsToQuit() {
        return this.quit;
    }
}

