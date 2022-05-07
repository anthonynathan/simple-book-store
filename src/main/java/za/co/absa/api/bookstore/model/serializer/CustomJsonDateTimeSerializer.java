package za.co.absa.api.bookstore.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CustomJsonDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(SerializerConstants.DATE_TIME_FORMAT, Locale.forLanguageTag("en-ZA"));
        gen.writeString(value.format(formatter));
    }
}
