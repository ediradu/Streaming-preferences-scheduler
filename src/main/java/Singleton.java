import java.util.HashMap;

public class Singleton {
    private static Singleton instantaUnica;
    HashMap<Integer, Streamer> streamerHashMap;
    HashMap<Integer, Stream> streamHashMap;
    HashMap<Integer, User> userHashMap;

    private Singleton() {
        this.streamerHashMap = new HashMap<>();
        this.streamHashMap = new HashMap<>();
        this.userHashMap = new HashMap<>();
    }

    public static Singleton Instanta() {
        if (instantaUnica == null)
            instantaUnica = new Singleton();
        return instantaUnica;
    }
}