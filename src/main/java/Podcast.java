public class Podcast extends Stream {
    private TipPodcast tipPodcast;
    public Podcast(Integer id, Integer streamGenre, Long nooflistenings, Integer streamerId, Long length, Long dateAdded, String name) {
        super(id, nooflistenings, streamerId, length, dateAdded, name);
        parseazaStreamGenre(streamGenre);
    }
    @Override
    public void parseazaStreamGenre(Integer streamGenre) {
        if (streamGenre.equals(TipPodcast.Documentary.ordinal() + 1))
            this.tipPodcast = TipPodcast.Documentary;
        if (streamGenre.equals(TipPodcast.Celebrities.ordinal() + 1))
            this.tipPodcast = TipPodcast.Celebrities;
        if (streamGenre.equals(TipPodcast.Tech.ordinal() + 1))
            this.tipPodcast = TipPodcast.Tech;
    }
    public TipPodcast getTipPodcast() {
        return tipPodcast;
    }
}
