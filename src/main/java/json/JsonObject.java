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
        if (this.jsMap.containsKey(name)) {
            return this.jsMap.get(name).value;
        } else {
            return null;
        }
    }

    public boolean contains(String name) {
        return this.jsMap.containsKey(name);
    }

    public JsonObject projection(String... names) {
        JsonObject result = new JsonObject();

        for (String name: names) {
            if (this.jsMap.containsKey(name)) {
                result.add(this.jsMap.get(name));
            }
        }

        // ToDo
        return result;
    }
}
