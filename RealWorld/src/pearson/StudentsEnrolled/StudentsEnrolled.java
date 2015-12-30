
package pearson.StudentsEnrolled;

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
    "students"
})
public class StudentsEnrolled {

    @JsonProperty("students")
    private List<Student> students = new ArrayList<Student>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public StudentsEnrolled() {
    }

    /**
     * 
     * @param students
     */
    public StudentsEnrolled(List<Student> students) {
        this.students = students;
    }

    /**
     * 
     * @return
     *     The students
     */
    @JsonProperty("students")
    public List<Student> getStudents() {
        return students;
    }

    /**
     * 
     * @param students
     *     The students
     */
    @JsonProperty("students")
    public void setStudents(List<Student> students) {
        this.students = students;
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
