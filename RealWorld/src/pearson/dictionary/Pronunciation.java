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
    "audio",
    "ipa"
})
public class Pronunciation {

    @JsonProperty("audio")
    private List<Audio> audio = new ArrayList<>();
    @JsonProperty("ipa")
    private String ipa;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pronunciation() {
    }

    /**
     *
     * @param ipa
     * @param audio
     */
    public Pronunciation(List<Audio> audio, String ipa) {
        this.audio = audio;
        this.ipa = ipa;
    }

    /**
     *
     * @return The audio
     */
    @JsonProperty("audio")
    public List<Audio> getAudio() {
        return audio;
    }

    /**
     *
     * @param audio The audio
     */
    @JsonProperty("audio")
    public void setAudio(List<Audio> audio) {
        this.audio = audio;
    }

    /**
     *
     * @return The ipa
     */
    @JsonProperty("ipa")
    public String getIpa() {
        return ipa;
    }

    /**
     *
     * @param ipa The ipa
     */
    @JsonProperty("ipa")
    public void setIpa(String ipa) {
        this.ipa = ipa;
    }

}
