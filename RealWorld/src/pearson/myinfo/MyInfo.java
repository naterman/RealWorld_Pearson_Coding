package pearson.myinfo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

/**
 *
 * @author Nathan Smith
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "me"
})
public class MyInfo {

    @JsonProperty("me")
    private Me me;
    
    /**
     * No args constructor for use in serialization
     *
     */
    public MyInfo() {
    }

    /**
     *
     * @param me
     */
    public MyInfo(Me me) {
        this.me = me;
    }

    /**
     *
     * @return The me
     */
    @JsonProperty("me")
    public Me getMe() {
        return me;
    }

    /**
     *
     * @param me The me
     */
    @JsonProperty("me")
    public void setMe(Me me) {
        this.me = me;
    }

}
