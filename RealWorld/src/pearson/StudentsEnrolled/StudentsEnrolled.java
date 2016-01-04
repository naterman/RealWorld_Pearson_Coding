package pearson.StudentsEnrolled;

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
    "students"
})
public class StudentsEnrolled {

    @JsonProperty("students")
    private List<Student> students = new ArrayList<>();

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
     * @return The students
     */
    @JsonProperty("students")
    public List<Student> getStudents() {
        return students;
    }

    /**
     *
     * @param students The students
     */
    @JsonProperty("students")
    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
