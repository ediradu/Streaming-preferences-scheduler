import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

public abstract class Stream {
    protected Integer id;
    protected String name;
    protected Long nooflistenings;
    protected Integer streamerId;
    protected Long length;
    protected Long dateAdded;

    public Stream(Integer id, Long nooflistenings, Integer streamerId, Long length, Long dateAdded, String name) {
        this.id = id;
        this.name = name;
        this.nooflistenings = nooflistenings;
        this.streamerId = streamerId;
        this.length = length;
        this.dateAdded = dateAdded;
    }
    public Stream(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getNooflistenings() {
        return nooflistenings;
    }
    public void setNooflistenings(Long nooflistenings) {
        this.nooflistenings = nooflistenings;
    }
    public Integer getStreamerId() {
        return streamerId;
    }
    public Long getLength() {
        return length;
    }
    public void setLength(Long length) {
        this.length = length;
    }
    public Long getDateAdded() {
        return dateAdded;
    }
    public void setDateAdded(Long dateAdded) {
        this.dateAdded = dateAdded;
    }
    public abstract void parseazaStreamGenre(Integer streamGenre);

}
