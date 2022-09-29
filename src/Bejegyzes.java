import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Bejegyzes {
    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        likeok = 0;
        letrejott = LocalDateTime.now();
        szerkesztve = letrejott;
    }

    // -------------GETTEREK-------------

    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public int getLikeok() {
        return likeok;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }


    // -------------SETTEREK-------------


    public void setTartalom(String tartalom) {
        szerkesztve = LocalDateTime.now();
        this.tartalom = tartalom;
    }

    public void setLikeok(int likeok) {
        this.likeok = likeok;
    }

    // -------------METÓDUSOK-------------

    public void like() {
        likeok++;
    }

    @Override
    public String toString() {
        String szoveg = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss");
        if (letrejott.toString().equals(szerkesztve.toString())){
            szoveg = String.format("%s - %s - %s\n" +
                    "%s", szerzo, likeok, letrejott.format(dtf), tartalom);
        }else {
            szoveg = String.format("%s - %s - %s\n" +
                    "Szerkesztve: %s\n" +
                    "%s", szerzo, likeok, letrejott.format(dtf),szerkesztve.format(dtf), tartalom);
        }
        return szoveg;
    }
}
