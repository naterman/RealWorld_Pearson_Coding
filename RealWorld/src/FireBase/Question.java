
package firebase;

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
    "answer",
    "id",
    "linktoid",
    "question"
})
public class Question {

    @JsonProperty("answer")
    private String answer;
    @JsonProperty("id")
    private String id;
    @JsonProperty("linktoid")
    private String linktoid;
    @JsonProperty("question")
    private String question;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Question() {
    }

    /**
     * 
     * @param id
     * @param linktoid
     * @param answer
     * @param question
     */
    public Question(String answer, String id, String linktoid, String question) {
        this.answer = answer;
        this.id = id;
        this.linktoid = linktoid;
        this.question = question;
    }

    /**
     * 
     * @return
     *     The answer
     */
    @JsonProperty("answer")
    public String getAnswer() {
        return answer;
    }

    /**
     * 
     * @param answer
     *     The answer
     */
    @JsonProperty("answer")
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The linktoid
     */
    @JsonProperty("linktoid")
    public String getLinktoid() {
        return linktoid;
    }

    /**
     * 
     * @param linktoid
     *     The linktoid
     */
    @JsonProperty("linktoid")
    public void setLinktoid(String linktoid) {
        this.linktoid = linktoid;
    }

    /**
     * 
     * @return
     *     The question
     */
    @JsonProperty("question")
    public String getQuestion() {
        return question;
    }

    /**
     * 
     * @param question
     *     The question
     */
    @JsonProperty("question")
    public void setQuestion(String question) {
        this.question = question;
    }

}
