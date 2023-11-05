import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CitesteFisier implements ICitesteFisier {
    String[] fisiere;

    public CitesteFisier(String[] fisiere) {
        this.fisiere = fisiere;
    }

    @Override
    public void parcurge() {
        //Crearea listerlor de obiecte
        Singleton.Instanta().streamerHashMap = readStreamers(fisiere[0]);
        Singleton.Instanta().streamHashMap = readStreams(fisiere[1]);
        Singleton.Instanta().userHashMap = readUsers(fisiere[2]);
    }

    private HashMap<Integer, Streamer> readStreamers(String file) {
        HashMap<Integer, Streamer> authorsStreamHashMap = new HashMap<>();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);
            CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(inputStream))
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                authorsStreamHashMap.put(Integer.valueOf(row[1]), new Streamer(Integer.valueOf(row[0]), Integer.valueOf(row[1]), row[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorsStreamHashMap;
    }

    private HashMap<Integer, Stream> readStreams(String file) {
        HashMap<Integer, Stream> dataStreamHashMap = new HashMap<>();
        try {
            // Creare obiect de tip file reader cu fisierul CSV ca parametru
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);
            // Creare obiect de tip CSVReader si sarim peste prima linie
            CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(inputStream))
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                dataStreamHashMap.put(Integer.valueOf(row[1]),
                        StreamFactory.creeazaStreams(
                                Integer.valueOf(row[0]),
                                Integer.valueOf(row[1]),
                                Integer.valueOf(row[2]),
                                Long.valueOf(row[3]),
                                Integer.valueOf(row[4]),
                                Long.valueOf(row[5]),
                                Long.valueOf(row[6]),
                                row[7]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataStreamHashMap;
    }
    private HashMap<Integer, User> readUsers(String file) {
        HashMap<Integer, User> userHashMap = new HashMap<>();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);
            CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(inputStream))
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                String[] splits = row[2].split(" ");
                List<Integer> streams = new ArrayList<>();
                for (String split : splits)
                    streams.add(Integer.valueOf(split));
                userHashMap.put(Integer.valueOf(row[0]), new User(Integer.valueOf(row[0]), row[1], streams));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userHashMap;
    }
}
