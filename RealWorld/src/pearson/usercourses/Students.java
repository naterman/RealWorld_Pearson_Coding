package pearson.usercourses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

/**
 *
 * @author Nathan Smith
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "links"
})
public class Students {

    @JsonProperty("links")
    private List<Link___> links = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Students() {
    }

    /**
     *
     * @param links
     */
    public Students(List<Link___> links) {
        this.links = links;
    }

    /**
     *
     * @return The links
     */
    @JsonProperty("links")
    public List<Link___> getLinks() {
        return links;
    }

    /**
     *
     * @param links The links
     */
    @JsonProperty("links")
    public void setLinks(List<Link___> links) {
        this.links = links;
    }

}
