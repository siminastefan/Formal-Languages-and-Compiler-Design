import java.util.Map;

public class PIFElement {

    private String token;
    private Map.Entry<Integer, Integer> position;

    public PIFElement(String token, Map.Entry<Integer, Integer> position) {
        this.token = token;
        this.position = position;
    }

    public void setPosition(Map.Entry<Integer, Integer> position) {
        this.position = position;
    }

    public String getToken() {
        return token;
    }

    public Map.Entry<Integer, Integer> getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "PIFElement{" +
                "token='" + token + '\'' +
                ", position=" + position +
                '}';
    }
}
