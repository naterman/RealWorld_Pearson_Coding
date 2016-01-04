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
    "id",
    "userName",
    "firstName",
    "lastName",
    "emailAddress",
    "clientString"
})
public class Me {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("emailAddress")
    private String emailAddress;
    @JsonProperty("clientString")
    private String clientString;
    
    /**
     * No args constructor for use in serialization
     *
     */
    public Me() {
    }

    /**
     *
     * @param id
     * @param clientString
     * @param lastName
     * @param emailAddress
     * @param userName
     * @param firstName
     */
    public Me(Integer id, String userName, String firstName, String lastName, String emailAddress, String clientString) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.clientString = clientString;
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
     * @return The userName
     */
    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName The userName
     */
    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return The firstName
     */
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName The firstName
     */
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return The lastName
     */
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName The lastName
     */
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return The emailAddress
     */
    @JsonProperty("emailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     *
     * @param emailAddress The emailAddress
     */
    @JsonProperty("emailAddress")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     *
     * @return The clientString
     */
    @JsonProperty("clientString")
    public String getClientString() {
        return clientString;
    }

    /**
     *
     * @param clientString The clientString
     */
    @JsonProperty("clientString")
    public void setClientString(String clientString) {
        this.clientString = clientString;
    }

}
