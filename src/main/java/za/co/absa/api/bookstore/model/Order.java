package za.co.absa.api.bookstore.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import za.co.absa.api.bookstore.model.serializer.CustomJsonDateTimeDeserializer;
import za.co.absa.api.bookstore.model.serializer.CustomJsonDateTimeSerializer;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "_id",
        "oderTimeStamp",
        "isbn",
        "title",
        "author",
        "orderQuantity"
})
@Document("order")
public class Order {
    @Id
    @JsonProperty("_id")
    private ObjectId id;
    @JsonProperty("oderTimeStamp")
    @JsonSerialize(using = CustomJsonDateTimeSerializer.class)
    @JsonDeserialize(using = CustomJsonDateTimeDeserializer.class)
    private LocalDateTime oderTimeStamp;
    @NotNull
    @NotEmpty
    @Size(min = 10, max = 13)
    @JsonProperty("isbn")
    private String isbn;
    @JsonProperty("title")
    private String title;
    @JsonProperty("author")
    private String author;
    @NotNull
    @NotEmpty
    @Min(1)
    @Max(Integer.MAX_VALUE)
    @JsonProperty("orderQuantity")
    private int orderQuantity;
}
