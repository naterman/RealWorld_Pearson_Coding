
package pearson.myrole;

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
    "role"
})
public class MyRole {

    @JsonProperty("role")
    private Role role;
    
    /**
     * No args constructor for use in serialization
     * 
     */
    public MyRole() {
    }

    /**
     * 
     * @param role
     */
    public MyRole(Role role) {
        this.role = role;
    }

    /**
     * 
     * @return
     *     The role
     */
    @JsonProperty("role")
    public Role getRole() {
        return role;
    }

    /**
     * 
     * @param role
     *     The role
     */
    @JsonProperty("role")
    public void setRole(Role role) {
        this.role = role;
    }

}
