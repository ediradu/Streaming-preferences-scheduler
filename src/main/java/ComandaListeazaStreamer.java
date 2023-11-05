public class ComandaListeazaStreamer extends ComandaStreamer {
    @Override
    public void executa(Streamer streamer) {
        streamer.listeazaStreamer();
    }
}
