public class BarangRental {
    private int tahun;
    private double biayaSewa;
    private String noTNKB;
    private String namaKendaraan;
    private String jenisKendaraan;

    public BarangRental(int tahun, double biayaSewa, String noTNKB, String namaKendaraan, String jenisKendaraan) {
        this.tahun = tahun;
        this.biayaSewa = biayaSewa;
        this.noTNKB = noTNKB;
        this.namaKendaraan = namaKendaraan;
        this.jenisKendaraan = jenisKendaraan;
    }

    public int getTahun() {
        return tahun;
    }

    public double getBiayaSewa() {
        return biayaSewa;
    }

    public String getNoTNKB() {
        return noTNKB;
    }

    public String getNamaKendaraan() {
        return namaKendaraan;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public String toString() {
        return "BarangRental{" +
                "tahun=" + tahun +
                ", biayaSewa=" + biayaSewa +
                ", noTNKB='" + noTNKB + '\'' +
                ", namaKendaraan='" + namaKendaraan + '\'' +
                ", jenisKendaraan='" + jenisKendaraan + '\'' +
                '}';
    }
}
