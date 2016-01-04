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
    "instructors",
    "teachingAssistants",
    "students",
    "id",
    "displayCourseCode",
    "title",
    "callNumbers",
    "links"
})
public class Course {

    @JsonProperty("instructors")
    private Instructors instructors;
    @JsonProperty("teachingAssistants")
    private TeachingAssistants teachingAssistants;
    @JsonProperty("students")
    private Students students;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("displayCourseCode")
    private String displayCourseCode;
    @JsonProperty("title")
    private String title;
    @JsonProperty("callNumbers")
    private List<String> callNumbers = new ArrayList<>();
    @JsonProperty("links")
    private List<Link____> links = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Course() {
    }

    /**
     *
     * @param id
     * @param title
     * @param students
     * @param teachingAssistants
     * @param links
     * @param instructors
     * @param callNumbers
     * @param displayCourseCode
     */
    public Course(Instructors instructors, TeachingAssistants teachingAssistants, Students students, Integer id, String displayCourseCode, String title, List<String> callNumbers, List<Link____> links) {
        this.instructors = instructors;
        this.teachingAssistants = teachingAssistants;
        this.students = students;
        this.id = id;
        this.displayCourseCode = displayCourseCode;
        this.title = title;
        this.callNumbers = callNumbers;
        this.links = links;
    }

    /**
     *
     * @return The instructors
     */
    @JsonProperty("instructors")
    public Instructors getInstructors() {
        return instructors;
    }

    /**
     *
     * @param instructors The instructors
     */
    @JsonProperty("instructors")
    public void setInstructors(Instructors instructors) {
        this.instructors = instructors;
    }

    /**
     *
     * @return The teachingAssistants
     */
    @JsonProperty("teachingAssistants")
    public TeachingAssistants getTeachingAssistants() {
        return teachingAssistants;
    }

    /**
     *
     * @param teachingAssistants The teachingAssistants
     */
    @JsonProperty("teachingAssistants")
    public void setTeachingAssistants(TeachingAssistants teachingAssistants) {
        this.teachingAssistants = teachingAssistants;
    }

    /**
     *
     * @return The students
     */
    @JsonProperty("students")
    public Students getStudents() {
        return students;
    }

    /**
     *
     * @param students The students
     */
    @JsonProperty("students")
    public void setStudents(Students students) {
        this.students = students;
    }

    /**
     *
     * @return The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return The displayCourseCode
     */
    @JsonProperty("displayCourseCode")
    public String getDisplayCourseCode() {
        return displayCourseCode;
    }

    /**
     *
     * @param displayCourseCode The displayCourseCode
     */
    @JsonProperty("displayCourseCode")
    public void setDisplayCourseCode(String displayCourseCode) {
        this.displayCourseCode = displayCourseCode;
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

    /**
     *
     * @return The callNumbers
     */
    @JsonProperty("callNumbers")
    public List<String> getCallNumbers() {
        return callNumbers;
    }

    /**
     *
     * @param callNumbers The callNumbers
     */
    @JsonProperty("callNumbers")
    public void setCallNumbers(List<String> callNumbers) {
        this.callNumbers = callNumbers;
    }

    /**
     *
     * @return The links
     */
    @JsonProperty("links")
    public List<Link____> getLinks() {
        return links;
    }

    /**
     *
     * @param links The links
     */
    @JsonProperty("links")
    public void setLinks(List<Link____> links) {
        this.links = links;
    }

}
