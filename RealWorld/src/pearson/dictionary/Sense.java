package pearson.dictionary;

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
    "definition",
    "examples"
})
public class Sense {

    @JsonProperty("definition")
    private List<String> definition = new ArrayList<>();
    @JsonProperty("examples")
    private List<Example> examples = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Sense() {
    }

    /**
     *
     * @param definition
     * @param examples
     */
    public Sense(List<String> definition, List<Example> examples) {
        this.definition = definition;
        this.examples = examples;
    }

    /**
     *
     * @return The definition
     */
    @JsonProperty("definition")
    public List<String> getDefinition() {
        return definition;
    }

    /**
     *
     * @param definition The definition
     */
    @JsonProperty("definition")
    public void setDefinition(List<String> definition) {
        this.definition = definition;
    }

    /**
     *
     * @return The examples
     */
    @JsonProperty("examples")
    public List<Example> getExamples() {
        return examples;
    }

    /**
     *
     * @param examples The examples
     */
    @JsonProperty("examples")
    public void setExamples(List<Example> examples) {
        this.examples = examples;
    }

}
