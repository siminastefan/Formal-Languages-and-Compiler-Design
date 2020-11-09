import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FiniteAutomata {

    private List<String> states;
    private List<String> alphabet;
    private String initialState;
    private List<String> finalStates;
    private List<Transition> transitions;

    public FiniteAutomata() {
        states = new ArrayList<>();
        alphabet = new ArrayList<>();
        initialState = "";
        finalStates = new ArrayList<>();
        transitions = new ArrayList<>();
    }

    public void readFiniteAutomata() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\Facultate\\Anul 3\\FLCD\\lab1b-new\\Formal-Languages-and-Compiler-Design\\lab4\\fa.txt"));

        //reading the states
        String line = bufferedReader.readLine().strip();
        states.addAll(Arrays.asList(line.split(",")));

        //reading the alphabet
        line = bufferedReader.readLine().strip();
        alphabet.addAll(Arrays.asList(line.split(",")));

        //reading the initial state
        line = bufferedReader.readLine().strip();
        initialState = line;

        //reading the final states
        line = bufferedReader.readLine().strip();
        finalStates.addAll(Arrays.asList(line.split(",")));

        //reading the transition line after line
        line = bufferedReader.readLine();
        while (line != null) {
            String[] trans = line.split(",");
            Transition transition = new Transition(trans[0], trans[1], trans[2]);
            transitions.add(transition);
            line = bufferedReader.readLine();
        }
    }

    public List<String> getStates() {
        return states;
    }

    public List<String> getAlphabet() {
        return alphabet;
    }

    public String getInitialState() {
        return initialState;
    }

    public List<String> getFinalStates() {
        return finalStates;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public boolean verify(String sequence) {

        return false;
    }
}
