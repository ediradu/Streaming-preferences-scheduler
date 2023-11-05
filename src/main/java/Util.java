import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;

public class Util {
    public static String parseLength(String legnth) {
        Duration duration = Duration.ofSeconds(Long.parseLong(legnth));

        long hours = duration.toHours();
        long minutes = duration.minusHours(hours).toMinutes();
        long seconds = duration.minusHours(hours).minusMinutes(minutes).toSeconds();
        if (hours == 0) {
            String formatted = String.format("%02d:%02d", minutes, seconds);
            return formatted;
        } else {
            String formatted = String.format("%02d:%02d:%02d", hours, minutes, seconds);
            return formatted;
        }
    }

    public static String parseDate(Long date) {
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateTimeFormatter.format(Date.from(Instant.from(Instant.ofEpochSecond(date, -10L))));
        return formattedDate;
    }
    public static void jsonListare(List<JsonListare> jsonListareList) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(objectMapper.writeValueAsString(jsonListareList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
