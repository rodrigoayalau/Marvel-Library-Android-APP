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
        String description = json.getAsJsonObject().get("data").getAsJsonObject().get("results").getAsJsonArray().get(0).getAsJsonObject().get("description").getAsString();
        String path = json.getAsJsonObject().get("data").getAsJsonObject().get("results").getAsJsonArray().get(0).getAsJsonObject().get("thumbnail").getAsJsonObject().get("path").getAsString();
        String extension = json.getAsJsonObject().get("data").getAsJsonObject().get("results").getAsJsonArray().get(0).getAsJsonObject().get("thumbnail").getAsJsonObject().get("extension").getAsString();;

        MarvelModelDeserealizer marvel = new MarvelModelDeserealizer(code, status, copyright, total, name, description, path, extension);
        return marvel;

    }
}
