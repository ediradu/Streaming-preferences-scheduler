import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Streamer {
    private Integer streamerType;
    private Integer id;
    private String name;
    private Stream stream;
    private Integer streamStergeId;
    public Streamer(Integer streamerType, Integer id, String name) {
        this.streamerType = streamerType;
        this.id = id;
        this.name = name;
    }

    public Streamer() {
    }

    public Integer getStreamerType() {
        return streamerType;
    }

    public void setStreamerType(Integer streamerType) {
        this.streamerType = streamerType;
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

    public void listeazaStreamer(){
        List<JsonListare> jsonListares = new ArrayList<>();
        for(Map.Entry< Integer, Stream> var : Singleton.Instanta().streamHashMap.entrySet()){
            if(id.equals(var.getValue().getStreamerId())){
                JsonListare jsonListare = new JsonListare(
                        var.getValue().getId().toString(),
                        var.getValue().getName(),
                        name,
                        var.getValue().getNooflistenings().toString(),
                        Util.parseLength(var.getValue().getLength().toString()),
                        Util.parseDate(var.getValue().getDateAdded()));
                jsonListares.add(jsonListare);
            }
        }
        Util.jsonListare(jsonListares);
    }

    public void setStream(Stream stream){
        this.stream = stream;
    }

    public void adaugaStream(){
        Singleton.Instanta().streamHashMap.put(this.stream.id,stream);
    }

    public void stergeStream(){
        Singleton.Instanta().streamHashMap.remove(this.streamStergeId);
    }
    public void setDeleteStreamerId(Integer id){
        this.streamStergeId=id;
    }
}
