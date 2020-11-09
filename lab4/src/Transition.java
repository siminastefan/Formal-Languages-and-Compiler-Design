public class Transition {

    private String initialState;
    private String literal;
    private String nextState;

    public Transition(String initialState, String literal, String nextState) {
        this.initialState = initialState;
        this.literal = literal;
        this.nextState = nextState;
    }

    @Override
    public String toString() {
        return "Transition{" +
                "initialState='" + initialState + '\'' +
                ", literal='" + literal + '\'' +
                ", nextState='" + nextState + '\'' +
                '}';
    }

    public String getInitialState() {
        return initialState;
    }

    public String getLiteral() {
        return literal;
    }

    public String getNextState() {
        return nextState;
    }
}
