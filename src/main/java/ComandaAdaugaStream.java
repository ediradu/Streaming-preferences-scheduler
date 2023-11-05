public class ComandaAdaugaStream extends ComandaStreamer {
    @Override
    public void executa(Streamer streamer) {
        streamer.adaugaStream();
    }
}
