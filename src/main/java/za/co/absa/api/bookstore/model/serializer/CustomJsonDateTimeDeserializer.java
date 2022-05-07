package za.co.absa.api.bookstore.model.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CustomJsonDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException,
                                                                                       JsonProcessingException {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(SerializerConstants.DATE_TIME_FORMAT, Locale.forLanguageTag("en-ZA"));

        if (!p.getText().isEmpty())
            return LocalDateTime.parse(p.getText(), formatter);

        return null;
    }
}
