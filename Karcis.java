import java.time.LocalDateTime;
import java.util.Random;

public class Karcis {
    public String kode;
    public LocalDateTime masuk;
    public Kendaraan kendaraan;

    public Karcis(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
        this.masuk = LocalDateTime.now();
        Random random = new Random();
        this.kode = Integer.toString(random.nextInt(999999));
    }
}
