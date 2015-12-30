
package pearson.CourseInstructors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "instructors"
})
public class CourseInstructors {

    @JsonProperty("instructors")
    private List<Instructor> instructors = new ArrayList<Instructor>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     * @return
     *     The instructors
     */
    @JsonProperty("instructors")
    public List<Instructor> getInstructors() {
        return instructors;
    }

    /**
     * 
     * @param instructors
     *     The instructors
     */
    @JsonProperty("instructors")
    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
