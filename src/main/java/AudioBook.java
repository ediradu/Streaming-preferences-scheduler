public class AudioBook extends Stream {
    private TipAudioBook tipAudioBook;
    public AudioBook(Integer id, Integer streamGenre, Long nooflistenings, Integer streamerId, Long length, Long dateAdded, String name) {
        super(id, nooflistenings, streamerId, length, dateAdded, name);
        parseazaStreamGenre(streamGenre);
    }

    @Override
    public void parseazaStreamGenre(Integer streamGenre) {
        if (streamGenre.equals(TipAudioBook.Fiction.ordinal() + 1))
            this.tipAudioBook = TipAudioBook.Fiction;
        if (streamGenre.equals(TipAudioBook.PersonalDevelopment.ordinal() + 1))
            this.tipAudioBook = TipAudioBook.PersonalDevelopment;
        if (streamGenre.equals(TipAudioBook.Childer.ordinal() + 1)) {
            this.tipAudioBook = TipAudioBook.Childer;
        }
    }

    public TipAudioBook getTipAudioBook() {
        return tipAudioBook;
    }
}
