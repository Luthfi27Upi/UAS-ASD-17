public class TransaksiRental {
    private int kodeTransaksi;
    private int lamaPinjam;
    private String namaPeminjam;
    private double totalBiaya;
    private String noTNKB;

    public TransaksiRental(int kodeTransaksi, int lamaPinjam, String namaPeminjam, double totalBiaya, String noTNKB) {
        this.kodeTransaksi = kodeTransaksi;
        this.lamaPinjam = lamaPinjam;
        this.namaPeminjam = namaPeminjam;
        this.totalBiaya = totalBiaya;
        this.noTNKB = noTNKB;
    }

    public int getKodeTransaksi() {
        return kodeTransaksi;
    }

    public int getLamaPinjam() {
        return lamaPinjam;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public String getNoTNKB() {
        return noTNKB;
    }

    public String toString() {
        return "TransaksiRental{" +
                "kodeTransaksi=" + kodeTransaksi +
                ", lamaPinjam=" + lamaPinjam +
                ", namaPeminjam='" + namaPeminjam + '\'' +
                ", totalBiaya=" + totalBiaya +
                ", noTNKB='" + noTNKB + '\'' +
                '}';
    }
}
