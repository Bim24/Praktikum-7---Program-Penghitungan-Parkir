import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kelas untuk sistem parkir
 */
public class SistemParkir {

    public ArrayList<Karcis> daftarKarcis;

    public SistemParkir() {
        daftarKarcis = new ArrayList<>();
        /*Scanner in = new Scanner(System.in);

        while (true) {
            String menu = """
                Menu:
                1. Kendaraan masuk
                2. Kendaraan keluar""";
            System.out.println(menu);
            int pilihan = Integer.parseInt(in.nextLine());

            // Kendaraan masuk
            if (pilihan == 1) {
                String menuTipe = """
                   Tipe kendaraan:
                   1. Motor
                   2. Mobil""";
                System.out.println(menuTipe);
                pilihan = Integer.parseInt(in.nextLine());
                Kendaraan.Tipe tipe;
                if (pilihan == 1)
                    tipe = Kendaraan.Tipe.MOTOR;
                else
                    tipe = Kendaraan.Tipe.MOBIL;
                System.out.println("Plat nomor:");
                String platNomor = in.nextLine();
                cekIn(tipe, platNomor);
            }
            //Kendaraan keluar
            else if (pilihan == 2) {
                System.out.println("Kode karcis:");
                biayaParkir(in.nextLine());
            }
        }*/
    }

    public Karcis cekIn(Kendaraan.Tipe tipe, String platNomor) {
        Kendaraan kendaraanMasuk = new Kendaraan(tipe, platNomor);
        Karcis karcis = new Karcis(kendaraanMasuk);
        //daftarKarcis.add(karcis);
        try {
            File fileKarcis = new File("karcis_" + karcis.kode + ".txt");
            fileKarcis.createNewFile();
            FileWriter fw = new FileWriter(fileKarcis);
            fw.write(karcis.masuk.toString());
            fw.write("\n" + kendaraanMasuk.tipe.toString());
            fw.close();
        } catch (IOException ignore) {}

        System.out.println("Dibuat karcis " + karcis.kode);

        return karcis;
    }

    public void biayaParkir(String kode) {
        try {
            File fileKarcis = new File("karcis_" + kode + ".txt");
            Scanner sc = new Scanner(fileKarcis);
            LocalDateTime masuk = LocalDateTime.parse(sc.nextLine());
            Kendaraan.Tipe tipe = Kendaraan.Tipe.valueOf(sc.nextLine().toUpperCase());
            Duration durasi = Duration.between(masuk, LocalDateTime.now());
            long jumlahJam = durasi.toSeconds();
            int perJam = 0;
            switch (tipe) {
                case MOBIL -> perJam = 5000;
                case MOTOR -> perJam = 2000;
                default -> perJam = 4000;
            }
            System.out.println("Biaya parkir: " + (int)jumlahJam * perJam);

        } catch (IOException ignore) {}
    }
}
