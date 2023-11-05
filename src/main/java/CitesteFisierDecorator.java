import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class CitesteFisierDecorator extends CitesteFisier {
    protected CitesteFisier citesteFisier;
    public CitesteFisierDecorator(CitesteFisier citesteFisier) {
        super(citesteFisier.fisiere);
        this.citesteFisier = citesteFisier;
    }

    public void parcurge() {
        citesteFisier.parcurge();
        citesteSiExecutaComanda(citesteFisier.fisiere[3]);
    }

    public void citesteSiExecutaComanda(String arg) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(arg)));
            String line = reader.readLine();

            while (line != null) {
                String[] splitLine = line.split(" ");
                ComandaFactory comandaFactory = new ComandaFactory();
                IComanda comanda = comandaFactory.creazaComanda(Integer.valueOf(splitLine[0]), splitLine[1]);
                if (comanda instanceof ComandaListeazaStreamer) {
                    Streamer streamer = Singleton.Instanta().streamerHashMap.get(Integer.valueOf(splitLine[0]));
                    ((ComandaListeazaStreamer) comanda).executa(streamer);
                } else if (comanda instanceof ComandaListeazaUser) {
                    User user = Singleton.Instanta().userHashMap.get(Integer.valueOf(splitLine[0]));
                    ((ComandaListeazaUser) comanda).executa(user);
                } else if (comanda instanceof ComandaAdaugaStream) {
                    Streamer streamer = Singleton.Instanta().streamerHashMap.get(Integer.valueOf(splitLine[0]));
                    StringBuilder name = new StringBuilder();
                    for (int i = 6; i < splitLine.length; i++)
                        name.append(splitLine[i]).append(" ");
                    streamer.setStream(StreamFactory.creeazaStreams(
                            Integer.valueOf(splitLine[2]),
                            Integer.valueOf(splitLine[3]),
                            Integer.valueOf(splitLine[4]),
                            0L,
                            streamer.getId(),
                            Long.valueOf(splitLine[5]),
                            Calendar.getInstance().getTimeInMillis(),
                            name.toString()));
                    ((ComandaAdaugaStream) comanda).executa(streamer);
                    streamer.setStream(null);
                } else if (comanda instanceof ComandaStergeStream) {
                    Streamer streamer = Singleton.Instanta().streamerHashMap.get(Integer.valueOf(splitLine[0]));
                    streamer.setDeleteStreamerId(streamer.getId());
                    ((ComandaStergeStream) comanda).executa(streamer);
                } else if (comanda instanceof ComandaAscultaStreamUser) {
                    User user = Singleton.Instanta().userHashMap.get(Integer.valueOf(splitLine[0]));
                    user.setAddStream(Integer.valueOf(splitLine[2]));
                    ((ComandaAscultaStreamUser) comanda).executa(user);
                } else if (comanda instanceof ComandaRecomandaPreferinteUser) {
                    User user = Singleton.Instanta().userHashMap.get(Integer.valueOf(splitLine[0]));
                    user.setTipStream(splitLine[2]);
                    ((ComandaRecomandaPreferinteUser) comanda).executa(user);
                } else if (comanda instanceof ComandaRecomandaSurprizaUser) {
                    User user = Singleton.Instanta().userHashMap.get(Integer.valueOf(splitLine[0]));
                    user.setTipStream(splitLine[2]);
                    ((ComandaRecomandaSurprizaUser) comanda).executa(user);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}