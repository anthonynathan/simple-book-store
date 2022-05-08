package za.co.absa.api.bookstore.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "isbn",
        "title",
        "author",
        "orderQuantity"
})
public class OrderDTO {
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
