import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class JsonListare {
    String id;
    String name;
    @JsonProperty("streamerName")
    String streamername;
    @JsonProperty("noOfListenings")
    String nooflistenings;
    String length;
    String dateAdded;

    public JsonListare(String id, String name, String streamername, String nooflistenings, String length, String dateAdded) {
        this.id = id;
        this.name = name;
        this.streamername = streamername;
        this.nooflistenings = nooflistenings;
        this.length = length;
        this.dateAdded = dateAdded;
    }

    public JsonListare() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStreamername() {
        return streamername;
    }
    public void setStreamername(String streamername) {
        this.streamername = streamername;
    }
    public String getNooflistenings() {
        return nooflistenings;
    }
    public void setNooflistenings(String nooflistenings) {
        this.nooflistenings = nooflistenings;
    }
    public String getLength() {
        return length;
    }
    public void setLength(String length) {
        this.length = length;
    }
    public String getDateAdded() {
        return dateAdded;
    }
    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
}
