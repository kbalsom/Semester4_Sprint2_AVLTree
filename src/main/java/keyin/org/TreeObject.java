package keyin.org;
import org.json.simple.JSONObject;

public class TreeObject {


    public JSONObject toJson(Node node) {
        if (node == null) {
            return null;
        }

        JSONObject json = new JSONObject();
        json.put("value", node.key);

        json.put("left", toJson(node.left));
        json.put("right", toJson(node.right));

        return json;
    }
}
