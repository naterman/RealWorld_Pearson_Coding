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
    "datasets",
    "headword",
    "id",
    "part_of_speech",
    "pronunciations",
    "senses",
    "url"
})
public class Result {

    @JsonProperty("datasets")
    private List<String> datasets = new ArrayList<>();
    @JsonProperty("headword")
    private String headword;
    @JsonProperty("id")
    private String id;
    @JsonProperty("part_of_speech")
    private String partOfSpeech;
    @JsonProperty("pronunciations")
    private List<Pronunciation> pronunciations = new ArrayList<>();
    @JsonProperty("senses")
    private List<Sense> senses = new ArrayList<>();
    @JsonProperty("url")
    private String url;

    /**
     * No args constructor for use in serialization
     *
     */
    public Result() {
    }

    /**
     *
     * @param id
     * @param pronunciations
     * @param datasets
     * @param headword
     * @param url
     * @param senses
     * @param partOfSpeech
     */
    public Result(List<String> datasets, String headword, String id, String partOfSpeech, List<Pronunciation> pronunciations, List<Sense> senses, String url) {
        this.datasets = datasets;
        this.headword = headword;
        this.id = id;
        this.partOfSpeech = partOfSpeech;
        this.pronunciations = pronunciations;
        this.senses = senses;
        this.url = url;
    }

    /**
     *
     * @return The datasets
     */
    @JsonProperty("datasets")
    public List<String> getDatasets() {
        return datasets;
    }

    /**
     *
     * @param datasets The datasets
     */
    @JsonProperty("datasets")
    public void setDatasets(List<String> datasets) {
        this.datasets = datasets;
    }

    /**
     *
     * @return The headword
     */
    @JsonProperty("headword")
    public String getHeadword() {
        return headword;
    }

    /**
     *
     * @param headword The headword
     */
    @JsonProperty("headword")
    public void setHeadword(String headword) {
        this.headword = headword;
    }

    /**
     *
     * @return The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     *
     * @param id The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return The partOfSpeech
     */
    @JsonProperty("part_of_speech")
    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    /**
     *
     * @param partOfSpeech The part_of_speech
     */
    @JsonProperty("part_of_speech")
    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    /**
     *
     * @return The pronunciations
     */
    @JsonProperty("pronunciations")
    public List<Pronunciation> getPronunciations() {
        return pronunciations;
    }

    /**
     *
     * @param pronunciations The pronunciations
     */
    @JsonProperty("pronunciations")
    public void setPronunciations(List<Pronunciation> pronunciations) {
        this.pronunciations = pronunciations;
    }

    /**
     *
     * @return The senses
     */
    @JsonProperty("senses")
    public List<Sense> getSenses() {
        return senses;
    }

    /**
     *
     * @param senses The senses
     */
    @JsonProperty("senses")
    public void setSenses(List<Sense> senses) {
        this.senses = senses;
    }

    /**
     *
     * @return The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

}
