package pearson.usercourses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.annotation.Generated;

/**
 *
 * @author Nathan Smith
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "href",
    "rel",
    "title"
})
public class Link___ {

    @JsonProperty("href")
    private String href;
    @JsonProperty("rel")
    private String rel;
    @JsonProperty("title")
    private String title;

    /**
     * No args constructor for use in serialization
     *
     */
    public Link___() {
    }

    /**
     *
     * @param title
     * @param rel
     * @param href
     */
    public Link___(String href, String rel, String title) {
        this.href = href;
        this.rel = rel;
        this.title = title;
    }

    /**
     *
     * @return The href
     */
    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    /**
     *
     * @param href The href
     */
    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    /**
     *
     * @return The rel
     */
    @JsonProperty("rel")
    public String getRel() {
        return rel;
    }

    /**
     *
     * @param rel The rel
     */
    @JsonProperty("rel")
    public void setRel(String rel) {
        this.rel = rel;
    }

    /**
     *
     * @return The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

}
