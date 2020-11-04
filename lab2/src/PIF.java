import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PIF {

    private List<PIFElement> table;

    public PIF() {
        this.table = new ArrayList<>();
    }

    public void addToPIF(PIFElement pifElement) {
        this.table.add(pifElement);
    }

    @Override
    public String toString() {
        String string = "";
        string += "PIF \n";
        for (int index = 0; index < this.table.size(); index++) {
            string += this.table.get(index).getToken() + " | " + this.table.get(index).getPosition() + "\n";
        }
        return string;
    }
}
