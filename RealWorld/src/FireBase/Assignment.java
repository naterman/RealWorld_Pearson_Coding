
package firebase;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

/**
 *
 * @author Nathan Smith
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "duedate",
    "id",
    "info",
    "name",
    "scenario"
})
public class Assignment implements Serializable {

    @JsonProperty("duedate")
    private String duedate;
    @JsonProperty("id")
    private String id;
    @JsonProperty("info")
    private String info;
    @JsonProperty("name")
    private String name;
    @JsonProperty("scenario")
    private String scenario;
    @JsonIgnore
    private static final long serialVersionUID = 1;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Assignment() {
    }

    /**
     * 
     * @param id
     * @param scenario
     * @param name
     * @param duedate
     * @param info
     */
    public Assignment(String duedate, String id, String info, String name, String scenario) {
        this.duedate = duedate;
        this.id = id;
        this.info = info;
        this.name = name;
        this.scenario = scenario;
    }

    /**
     * 
     * @return
     *     The duedate
     */
    @JsonProperty("duedate")
    public String getDuedate() {
        return duedate;
    }

    /**
     * 
     * @param duedate
     *     The duedate
     */
    @JsonProperty("duedate")
    public void setDuedate(String duedate) {
        this.duedate = duedate;
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
     *     The info
     */
    @JsonProperty("info")
    public String getInfo() {
        return info;
    }

    /**
     * 
     * @param info
     *     The info
     */
    @JsonProperty("info")
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The scenario
     */
    @JsonProperty("scenario")
    public String getScenario() {
        return scenario;
    }

    /**
     * 
     * @param scenario
     *     The scenario
     */
    @JsonProperty("scenario")
    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

}
