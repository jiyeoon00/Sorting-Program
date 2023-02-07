import java.util.Scanner;

public class Program {
    final int SORTING_NUMBERS_NUMBER = 1;
    final int SORTING_WORDS_NUMBER = 2;
    final int EXIT_NUMBER = 3;

    Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            executeProgram();
        }
    }

    private void executeProgram() {
        printPersonality();
        showInitialMenu();
        int selectionNumber = takeSelectionNumber();
        executeInitialMenu(selectionNumber);
    }

    public void printPersonality() {
        System.out.println("[ ID: 1916142 ]");
        System.out.println("[ Name: 신지연 ]");
        System.out.println();
    }

    private void showInitialMenu() {
        System.out.println(SORTING_NUMBERS_NUMBER +". Sort numbers");
        System.out.println(SORTING_WORDS_NUMBER +". Sort words");
        System.out.println(EXIT_NUMBER + ". Quit");
    }

    private int takeSelectionNumber() {
        System.out.print("> ");
        return scanner.nextInt();
    }

    private void executeInitialMenu(int SelectionNumber) {
        switch (SelectionNumber) {
            case SORTING_NUMBERS_NUMBER:
                new NumberSorting().sort();
                break;
            case SORTING_WORDS_NUMBER:
                new WordSorting().sort();
                break;
            case EXIT_NUMBER:
                System.exit(0);
                break;
        }
    }
}
