
package firebase;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "linktoid",
    "newscenario"
})
public class Trigger {

    @JsonProperty("linktoid")
    private String linktoid;
    @JsonProperty("newscenario")
    private String newscenario;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Trigger() {
    }

    /**
     * 
     * @param newscenario
     * @param linktoid
     */
    public Trigger(String linktoid, String newscenario) {
        this.linktoid = linktoid;
        this.newscenario = newscenario;
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
     *     The newscenario
     */
    @JsonProperty("newscenario")
    public String getNewscenario() {
        return newscenario;
    }

    /**
     * 
     * @param newscenario
     *     The newscenario
     */
    @JsonProperty("newscenario")
    public void setNewscenario(String newscenario) {
        this.newscenario = newscenario;
    }

}
