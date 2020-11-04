import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SymbolTable {

    private List<List<String>> st;

    public SymbolTable() {
        this.st = new ArrayList<>();
        for (int index = 0; index < 255; index++) {
            this.st.add(new ArrayList<>());
        }
    }

    public Map.Entry<Integer, Integer> pos(String token) {

        int hash = hashFunction(token);
        List<String> values = this.st.get(hash);
        if (values.contains(token) == false) {
            values.add(token);
        }
        return Map.entry(hash, values.indexOf(token));
    }

    public int hashFunction(String token) {
        int sum = 0;

        for (int index = 0 ; index<token.length(); index++) {
            sum += token.charAt(index);
        }
        return sum % 256;
    }

    @Override
    public String toString() {
        String string = "";
        string += "ST \n";
        for (int index = 0; index < this.st.size(); index++) {
            if (this.st.get(index).size() != 0)
                string += index + " | " + this.st.get(index) + "\n";
        }
        return string;
    }
}
