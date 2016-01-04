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
    "courses"
})
public class MyCourses {

    @JsonProperty("courses")
    private List<Courses> courses = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     *
     */
    public MyCourses() {
    }

    /**
     *
     * @param courses
     */
    public MyCourses(List<Courses> courses) {
        this.courses = courses;
    }

    /**
     *
     * @return The courses
     */
    @JsonProperty("courses")
    public List<Courses> getCourses() {
        return courses;
    }

    /**
     *
     * @param courses The courses
     */
    @JsonProperty("courses")
    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

}
