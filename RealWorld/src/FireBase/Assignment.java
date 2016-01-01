
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
    "duedate",
    "enable",
    "id",
    "info",
    "name",
})
public class Assignment {

    @JsonProperty("duedate")
    private String duedate;
    @JsonProperty("id")
    private String id;
    @JsonProperty("info")
    private String info;
    @JsonProperty("name")
    private String name;
    @JsonProperty("enable")
    private boolean enable;


    /**
     * No args constructor for use in serialization
     * 
     */
    public Assignment() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param duedate
     * @param info
     * @param enable
     */
    public Assignment(String duedate, String id, String info, String name, boolean enable) {
        this.duedate = duedate;
        this.id = id;
        this.info = info;
        this.name = name;
        this.enable = enable;
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
     * @return the enable
     */
    public boolean isEnable() {
        return enable;
    }

    /**
     * @param enable the enable to set
     */
    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
