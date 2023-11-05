enum TipStream {PiesaMuzicala, PodCast, AudioBook}

enum TipPiesaMuzicala {Pop, Latin, House, Dance, Trap}

enum TipPodcast {Documentary, Celebrities, Tech}

enum TipAudioBook {Fiction, PersonalDevelopment, Childer}

public class StreamFactory {
    public static Stream creeazaStreams(Integer tip, Integer id, Integer steamGenre, Long noOfStream, Integer streamerId, Long length, Long dateAdded, String name) {
        if (tip.equals(TipStream.PiesaMuzicala.ordinal() + 1)) {
            return new PiesaMuzicala(id, steamGenre, noOfStream, streamerId, length, dateAdded, name);
        } else if (tip.equals(TipStream.PodCast.ordinal() + 1)) {
            return new Podcast(id, steamGenre, noOfStream, streamerId, length, dateAdded, name);
        } else if (tip.equals(TipStream.AudioBook.ordinal() + 1)) {
            return new AudioBook(id, steamGenre, noOfStream, streamerId, length, dateAdded, name);
        } else {
            return null;
        }
    }
}

