package pearson.CourseInstructors;

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
    "instructors"
})
public class CourseInstructors {

    @JsonProperty("instructors")
    private List<Instructor> instructors = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     *
     */
    public CourseInstructors() {
    }

    /**
     *
     * @param instructors
     */
    public CourseInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    /**
     *
     * @return The instructors
     */
    @JsonProperty("instructors")
    public List<Instructor> getInstructors() {
        return instructors;
    }

    /**
     *
     * @param instructors The instructors
     */
    @JsonProperty("instructors")
    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

}
