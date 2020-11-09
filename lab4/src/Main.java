import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final FiniteAutomata finiteAutomata = new FiniteAutomata();

    public static void displayMenu() {
        String menu = "";
        menu += "\t [0] Exit \n";
        menu += "\t [1] Display the set of states \n";
        menu += "\t [2] Display the alphabet \n";
        menu += "\t [3] Display the transitions \n";
        menu += "\t [4] Display the set of final states \n";
        menu += "\t [5] Verify if a sequence is accepted by the FA\n\n";
        menu += "\t Choose an option: ";
        System.out.println(menu);
    }

    public static void main(String[] args) {
        try {

            finiteAutomata.readFiniteAutomata();

            WHILE_LABEL : while (true) {
                displayMenu();
                Scanner scanner = new Scanner(System.in);
                int option = scanner.nextInt();

                switch (option) {
                    case 0:
                        System.out.println("Bye bye...");
                        break WHILE_LABEL;
                    case 1:
                        displayStates();
                        break;
                    case 2:
                        displayAlphabet();
                        break;
                    case 3:
                        displayTransitions();
                        break;
                    case 4:
                        displayFinalStates();
                        break;
                    case 5:
                        verifySequence();
                        break;
                    default:
                        System.out.println("Try again");
                        break;
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void verifySequence() {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();
        boolean answer = finiteAutomata.verify(sequence);
        if (answer) {
            System.out.println("The given sequence is accepted by the FA.");
        } else {
            System.out.println("The given sequence is not accepted by the Fa.");
        }
    }

    private static void displayFinalStates() {
        List<String> finalStates = finiteAutomata.getFinalStates();
        System.out.println("Final states:\n");
        for (String state: finalStates) {
            System.out.println(state);
        }

    }

    private static void displayTransitions() {
        List<Transition> transitions = finiteAutomata.getTransitions();
        System.out.println("States:\n");
        for (Transition transition: transitions) {
            System.out.println(transition);
        }
    }

    private static void displayAlphabet() {
        List<String> alphabet = finiteAutomata.getAlphabet();
        System.out.println("Alphabet\n");
        for (String a: alphabet) {
            System.out.println(a);
        }
    }

    private static void displayStates() {
        List<String> states = finiteAutomata.getStates();
        System.out.println("States:\n");
        for (String state: states) {
            System.out.println(state);
        }
    }

}
