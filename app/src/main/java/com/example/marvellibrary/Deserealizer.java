package com.example.marvellibrary;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class Deserealizer implements JsonDeserializer<MarvelModelDeserealizer> {

    @Override
    public MarvelModelDeserealizer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        int code = json.getAsJsonObject().get("code").getAsInt();
        String status = json.getAsJsonObject().get("status").getAsString();
        String copyright = json.getAsJsonObject().get("copyright").getAsString();
        int total = json.getAsJsonObject().get("data").getAsJsonObject().get("total").getAsInt();
        String name = json.getAsJsonObject().get("data").getAsJsonObject().get("results").getAsJsonArray().get(0).getAsJsonObject().get("name").getAsString();

        MarvelModelDeserealizer marvel = new MarvelModelDeserealizer(code, status, copyright, total, name);
        return marvel;

    }
}
