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
    "status",
    "offset",
    "limit",
    "count",
    "total",
    "url",
    "results"
})
public class DictionaryResults {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("offset")
    private Integer offset;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("url")
    private String url;
    @JsonProperty("results")
    private List<Result> results = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     *
     */
    public DictionaryResults() {
    }

    /**
     *
     * @param total
     * @param limit
     * @param results
     * @param count
     * @param status
     * @param offset
     * @param url
     */
    public DictionaryResults(Integer status, Integer offset, Integer limit, Integer count, Integer total, String url, List<Result> results) {
        this.status = status;
        this.offset = offset;
        this.limit = limit;
        this.count = count;
        this.total = total;
        this.url = url;
        this.results = results;
    }

    /**
     *
     * @return The status
     */
    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status The status
     */
    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @return The offset
     */
    @JsonProperty("offset")
    public Integer getOffset() {
        return offset;
    }

    /**
     *
     * @param offset The offset
     */
    @JsonProperty("offset")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     *
     * @return The limit
     */
    @JsonProperty("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     *
     * @param limit The limit
     */
    @JsonProperty("limit")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     *
     * @return The count
     */
    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count The count
     */
    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     *
     * @return The total
     */
    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    /**
     *
     * @param total The total
     */
    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
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

    /**
     *
     * @return The results
     */
    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    /**
     *
     * @param results The results
     */
    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

}
