
package pearson.usercourses;

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
    "courses"
})
public class MyCourses {

    @JsonProperty("courses")
    private List<Courses> courses = new ArrayList<Courses>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     * @return
     *     The courses
     */
    @JsonProperty("courses")
    public List<Courses> getCourses() {
        return courses;
    }

    /**
     * 
     * @param courses
     *     The courses
     */
    @JsonProperty("courses")
    public void setCourses(List<Courses> courses) {
        this.courses = courses;
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
