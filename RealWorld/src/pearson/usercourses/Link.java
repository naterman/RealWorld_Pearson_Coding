
package pearson.usercourses;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Nathan Smith
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "course",
    "href",
    "rel",
    "title"
})
public class Link {

    @JsonProperty("course")
    private Course course;
    @JsonProperty("href")
    private String href;
    @JsonProperty("rel")
    private String rel;
    @JsonProperty("title")
    private String title;
    
    /**
     * No arguments constructor for use in serialization
     * 
     */
    public Link() {
    }

    /**
     * 
     * @param course
     * @param rel
     * @param href
     */
    public Link(Course course, String href, String rel) {
        this.course = course;
        this.href = href;
        this.rel = rel;
    }

    /**
     * 
     * @return
     *     The course
     */
    @JsonProperty("course")
    public Course getCourse() {
        return course;
    }

    /**
     * 
     * @param course
     *     The course
     */
    @JsonProperty("course")
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * 
     * @return
     *     The href
     */
    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    /**
     * 
     * @param href
     *     The href
     */
    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * 
     * @return
     *     The rel
     */
    @JsonProperty("rel")
    public String getRel() {
        return rel;
    }

    /**
     * 
     * @param rel
     *     The rel
     */
    @JsonProperty("rel")
    public void setRel(String rel) {
        this.rel = rel;
    }

    /**
     * @return the title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

}
