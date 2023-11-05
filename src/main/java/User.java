import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

public class User {
    private Integer id;
    private String name;
    private List<Integer> streams;
    private Integer addStream;
    private TipStream tipStream;

    public User(Integer id, String name, List<Integer> streams) {
        this.id = id;
        this.name = name;
        this.streams = streams;
    }

    public User() {
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

    public void listeazaUser() {
        List<JsonListare> jsonListareArrayList = new ArrayList<>();
        for (Integer userStream : streams) {
            if (Singleton.Instanta().streamHashMap.containsKey(userStream)) {
                Stream stream = Singleton.Instanta().streamHashMap.get(userStream);
                if (Singleton.Instanta().streamerHashMap.containsKey(stream.getStreamerId())) {
                    Streamer streamer = Singleton.Instanta().streamerHashMap.get(stream.getStreamerId());
                    JsonListare jsonListare = new JsonListare(
                            stream.getId().toString(),
                            stream.getName(),
                            streamer.getName(),
                            stream.getNooflistenings().toString(),
                            Util.parseLength(stream.getLength().toString()),
                            Util.parseDate(stream.getDateAdded()));
                    jsonListareArrayList.add(jsonListare);
                }
            }
        }
        Util.jsonListare(jsonListareArrayList);
    }

    public void setAddStream(Integer integer) {
        this.addStream = integer;
    }

    public void ascultaStream() {
        this.streams.add(addStream);
        Singleton.Instanta().userHashMap.put(id, this);
        Stream stream = Singleton.Instanta().streamHashMap.get(this.addStream);
        stream.nooflistenings++;
        Singleton.Instanta().streamHashMap.put(stream.id, stream);
        this.addStream = null;
    }

    void setTipStream(String tipStream) {
        switch (tipStream) {
            case "SONG" :{ this.tipStream = TipStream.PiesaMuzicala; break;}
            case "PODCAST" :{ this.tipStream = TipStream.PodCast; break;}
            case "AUDIOBOOK" :{ this.tipStream = TipStream.AudioBook; break;}
        }
    }

    public void recomandaPreferinte() {
        // streamerii ascultati de user
        List<Integer> streamersIdAscultateList = new ArrayList<>();
        for (Integer integer : streams) {
            Stream stream = Singleton.Instanta().streamHashMap.get(integer);
            streamersIdAscultateList.add(stream.streamerId);
        }
        //Obtine toate streamurile  de la toti streamerii
        List<Stream> toateStreamurileDeLaTotiStreameriUrmatiDeUser = new ArrayList<>();
        for (Map.Entry<Integer, Stream> var : Singleton.Instanta().streamHashMap.entrySet()) {
            if (streamersIdAscultateList.contains(var.getValue().streamerId)) {
                toateStreamurileDeLaTotiStreameriUrmatiDeUser.add(var.getValue());
            }
        }
        //Obtine streamuri neasculate si tipul lor
        List<Stream> streamuriNeascultate = new ArrayList<>();
        for (Stream stream : toateStreamurileDeLaTotiStreameriUrmatiDeUser) {
            if (!streams.contains(stream.id))
                // Verifica tipul de stream
                if (this.tipStream == TipStream.PodCast) {
                    if (stream instanceof Podcast)
                        streamuriNeascultate.add(stream);
                } else if (this.tipStream == TipStream.PiesaMuzicala) {
                    if (stream instanceof PiesaMuzicala)
                        streamuriNeascultate.add(stream);
                } else if (this.tipStream == TipStream.AudioBook) {
                    if (stream instanceof AudioBook)
                        streamuriNeascultate.add(stream);
                }
        }
        // sortare descerscatoare dupa no of listetning
        streamuriNeascultate.sort(Comparator.comparing(Stream::getNooflistenings).reversed());
        List<JsonListare> jsonListaresList = new ArrayList<>();
        for (Stream stream : streamuriNeascultate) {
            JsonListare jsonListare = new JsonListare(
                    stream.getId().toString(),
                    stream.getName(),
                    Singleton.Instanta().streamerHashMap.get(stream.getStreamerId()).getName(),
                    stream.getNooflistenings().toString(),
                    Util.parseLength(stream.getLength().toString()),
                    Util.parseDate(stream.getDateAdded()));
            jsonListaresList.add(jsonListare);
        }
        if (jsonListaresList.size() > 5)
            Util.jsonListare((jsonListaresList.subList(0, 5)));
        else
            Util.jsonListare(jsonListaresList);
    }

    public void recomandaSurpriza() {
        // streamerii ascultati de user
        List<Integer> streamersIdAscultateList = new ArrayList<>();
        for (Integer integer : streams) {
            Stream stream = Singleton.Instanta().streamHashMap.get(integer);
            streamersIdAscultateList.add(stream.streamerId);
        }
        //Lista de streamers neascultati de user
        List<Stream> toateStreams = new ArrayList<>();
        for (Map.Entry<Integer, Stream> var : Singleton.Instanta().streamHashMap.entrySet()) {
            if (!streamersIdAscultateList.contains(var.getValue().streamerId)) {
                if (this.tipStream == TipStream.PodCast) {
                    if (var.getValue() instanceof Podcast)
                        toateStreams.add(var.getValue());
                } else if (this.tipStream == TipStream.PiesaMuzicala) {
                    if (var.getValue() instanceof PiesaMuzicala)
                        toateStreams.add(var.getValue());
                } else if (this.tipStream == TipStream.AudioBook) {
                    if (var.getValue() instanceof AudioBook)
                        toateStreams.add(var.getValue());
                }
            }
        }
        // sortare descerscatoare dupa no of listetning
        toateStreams.sort(Comparator.comparing(Stream::getNooflistenings).reversed());
        List<JsonListare> jsonListaresList = new ArrayList<>();
        for (Stream stream : toateStreams) {
            JsonListare jsonListare = new JsonListare(
                    stream.getId().toString(),
                    stream.getName(),
                    Singleton.Instanta().streamerHashMap.get(stream.getStreamerId()).getName(),
                    stream.getNooflistenings().toString(),
                    Util.parseLength(stream.getLength().toString()),
                    Util.parseDate(stream.getDateAdded()));
            jsonListaresList.add(jsonListare);
        }
        if (jsonListaresList.size() > 3)
            Util.jsonListare((jsonListaresList.subList(0, 4)));
        else
            Util.jsonListare(jsonListaresList);
    }
}
