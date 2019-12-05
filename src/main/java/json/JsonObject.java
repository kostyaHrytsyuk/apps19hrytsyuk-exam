package json;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private Map<String ,JsonPair> jsMap;

    public JsonObject(JsonPair... jsonPairs) {
        this.jsMap = new HashMap<String, JsonPair>();
        for (JsonPair pair: jsonPairs) {
            this.add(pair);
        }
    }

    @Override
    public String toJson() {
        StringBuilder result = new StringBuilder("{");
        boolean isFirst = true;
        Iterator<Map.Entry<String, JsonPair>> iter = this.jsMap.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<String, JsonPair> json = iter.next();
            result.append(json.getValue().toString());
            if (iter.hasNext()) {
                result.append(", ");
            }
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
