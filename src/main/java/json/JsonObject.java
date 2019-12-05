package json;

import java.util.HashMap;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private HashMap<String ,JsonPair> jsMap;

    public JsonObject(JsonPair... jsonPairs) {
        this.jsMap = new HashMap<>();
        for (JsonPair pair: jsonPairs) {
            this.add(pair);
        }
    }

    @Override
    public String toJson() {
        StringBuilder result = new StringBuilder("{");
        boolean isFirst = true;

        for (String key: jsMap.keySet()) {
            if (!isFirst) {
                result.append(", ");
            }
            result.append(jsMap.get(key).toString());
            isFirst = false;

        }

        result.append('}');
        return result.toString();
    }

    public void add(JsonPair jsonPair) {
        this.jsMap.put(jsonPair.key, jsonPair);
    }

    public Json find(String name) {
        // ToDo
        return null;
    }

    public JsonObject projection(String... names) {
        // ToDo
        return null;
    }
}
