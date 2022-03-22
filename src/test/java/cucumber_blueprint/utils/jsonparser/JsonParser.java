package cucumber_blueprint.utils.jsonparser;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class JsonParser {

    public static Map<String,Object> getRequest(String requestPath) {

        JsonReader getLocalJsonFile = null;

        try {
            getLocalJsonFile = new JsonReader(new FileReader(requestPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Type mapTokenType = new TypeToken<Map<String, Object>>() {
        }.getType();

        Map<String, Object> jsonMap = new Gson().fromJson(getLocalJsonFile, mapTokenType);

        return parseMap(jsonMap);
    }

    private static Map<String, Object> parseMap(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof Map) {
                parseMap((Map<String, Object>) entry.getValue());
            } else if (entry.getValue().toString().startsWith("$")) {
                map.replace(entry.getKey(), replaceValue((String) entry.getValue()));
            }
        }
        return map;
    }

    private static String replaceValue(String value) {

        Faker faker = new Faker();
        String newValue;

        switch (value) {
            case "$RANDOM_FIRST_NAME":
                newValue = faker.name().firstName();
                break;

            case "$RANDOM_LAST_NAME":
                newValue = faker.name().lastName();
                break;

            case "$COUNTRY":
                newValue = faker.address().country();
                break;

            case "$EMAIL":
                newValue = faker.internet().emailAddress();
                break;

            case "$PRICE":
                newValue = faker.commerce().price();

            case "$TODAY":
                LocalDate todayDate = LocalDate.now();
                newValue = todayDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                break;

            case "$TOMORROW":
                LocalDate tomorrowDate = LocalDate.now().plusDays(1);
                newValue = tomorrowDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                break;

            case "$YESTERDAY":
                LocalDate yesterdayDate = LocalDate.now().minusDays(1);
                newValue = yesterdayDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                break;

            case "$WEEKBEFORE":
                LocalDate weekBeforeDate = LocalDate.now().minusWeeks(1);
                newValue = weekBeforeDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                break;

            case "$WEEKAFTER":
                LocalDate weekAfterDate = LocalDate.now().plusWeeks(1);
                newValue = weekAfterDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                break;

            default:
                throw new IllegalArgumentException("Invalid command in JSON file.");
        }
        return newValue;
    }
}
