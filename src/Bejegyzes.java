import java.time.LocalDate;
import java.time.LocalDateTime;

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
        szerkesztve = LocalDateTime.now();
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
        return String.format("%s - %s - %s\n" +
                "Szerkesztve: \n" +
                        "%s"
                , szerzo, likeok, letrejott.toString(),
                szerkesztve.toString(),
                tartalom);
    }
}
