import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Bejegyzes> bejegyzesek = new ArrayList<>();

        bejegyzesek.add(new Bejegyzes("Somogyi Botond", "asd asd asd asd asd as da "));
        bejegyzesek.add(new Bejegyzes("Teszt teszt", "asd asd asd asd asd as da "));
        beker(bejegyzesek);
        readIn(bejegyzesek);
        rndLike(bejegyzesek);
        changeSecContent(bejegyzesek);

        System.out.println("-------Rendezettlen-------\n");
        kiir(bejegyzesek);
        System.out.println("-------Rendezettlen-------\n");

        legnepszerubbPost(bejegyzesek);


        // ------------35nél több like------------
        {
            int count = 0;
            for (Bejegyzes b : bejegyzesek) {
                if (b.getLikeok() > 35){
                    count++;
                }
            }
            System.out.printf("%ddb bejegyzés van amin 35nél több like van.\n",count);
        }


        // ------------ 15nél kevesebb like------------
        {
            int count = 0;
            for (Bejegyzes b : bejegyzesek) {
                if (b.getLikeok() < 15){
                    count++;
                }
            }
            System.out.printf("%ddb bejegyzés van amin 15nél kevesebb like van.\n",count);
        }
        // ------------------------


        bejegyzesek = rendez(bejegyzesek);


        System.out.println("-------Rendezett-------\n");
        kiir(bejegyzesek);
        System.out.println("-------Rendezett-------\n");

        writeOut(bejegyzesek);
    }

    public static void beker(List<Bejegyzes> bejegyzesek) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Adja meg mennyi darab bejegyzést akar létrehozni: ");
        int input = sc.nextInt();
        sc.nextLine();
        if (input > 0) {
            for (int i = 0; i < input; i++) {
                System.out.print("Adja meg a szerzőt: ");

                String szerzo = sc.nextLine();
                System.out.println("Adja meg a tartalmat");
                String tartalom = sc.nextLine();
                bejegyzesek.add(new Bejegyzes(szerzo, tartalom));
            }

        } else if (input < 0) {
            System.out.println("Nem természetes számot adott meg!");
        }
    }

    public static void readIn(List<Bejegyzes> bejegyzesek) throws Exception {
        BufferedReader bf = new BufferedReader(new FileReader("bejegyzesek.csv"));
        String line;
        while ((line = bf.readLine()) != null) {
            String[] tmp = line.split(";");
            bejegyzesek.add(new Bejegyzes(tmp[0], tmp[1]));
        }

    }

    public static void rndLike(List<Bejegyzes> bejegyzesek) {
        Random rnd = new Random();
        int likeNumber = bejegyzesek.size() * 20;
        for (int i = 0; i < likeNumber; i++) {
            bejegyzesek.get(rnd.nextInt(bejegyzesek.size())).like();
        }
    }

    public static void changeSecContent(List<Bejegyzes> bejegyzesek) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adjon meg egy szöveget");

        String szoveg = sc.nextLine();
        bejegyzesek.get(1).setTartalom(szoveg);
    }

    public static void legnepszerubbPost(List<Bejegyzes> bejegyzesek) {
        Bejegyzes legnepszerubb = bejegyzesek.get(0);
        for (Bejegyzes b: bejegyzesek) {
            if (b.getLikeok() > legnepszerubb.getLikeok()){
                legnepszerubb = b;
            }
        }
        System.out.printf("A legnépszerűbb bejegyzésen: %ddb like van.\n", legnepszerubb.getLikeok());
    }

    public static List<Bejegyzes> rendez(List<Bejegyzes> bejegyzesek) {

        List<Bejegyzes> rendezett = new ArrayList<>();

        for (int i = 0; i < bejegyzesek.size(); i++) {
            Bejegyzes legnagyobb = bejegyzesek.get(i);
            for (int j = i; j < bejegyzesek.size(); j++) {
                if (legnagyobb.getLikeok()  < bejegyzesek.get(j).getLikeok()) {
                    legnagyobb = bejegyzesek.get(j);
                }
            }
            rendezett.add(legnagyobb);

        }
        return rendezett;
    }

    public static void writeOut(List<Bejegyzes> bejegyzesek) throws Exception {
        BufferedWriter bf = new BufferedWriter(new FileWriter("bejegyzesek_rendezett.txt", false));

        for (Bejegyzes b: bejegyzesek) {
            bf.write(b.toString()+"\n");
        }
        bf.close();
    }

    public static void kiir(List<Bejegyzes> bejegyzesek) {
        for (Bejegyzes b : bejegyzesek) {
            System.out.println(b.toString());

        }
    }
}