public class Kendaraan {
    public enum Tipe {
        MOBIL, MOTOR
    }

    public Tipe tipe;
    public String platNomor;

    public Kendaraan(Tipe tipe, String platNomor) {
        this.tipe = tipe;
        this.platNomor = platNomor;
    }
}
