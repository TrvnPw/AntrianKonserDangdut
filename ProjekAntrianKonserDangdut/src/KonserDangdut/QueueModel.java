package KonserDangdut;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public class QueueModel {
    private Queue<AntrianItem> waitingQueue;
    private int nomorUrut;
    
    // Inner class untuk menyimpan data antrian
    public static class AntrianItem {
        private int nomor;
        private String nama;
        
        public AntrianItem(int nomor, String nama) {
            this.nomor = nomor;
            this.nama = nama;
        }
        
        public int getNomor() { return nomor; }
        public String getNama() { return nama; }
        
        @Override
        public String toString() {
            return "Nomor Antrian " + nomor + " - " + nama;
        }
    }
    
    public QueueModel() {
        this.waitingQueue = new LinkedList<>();
        this.nomorUrut = 0;
    }
    
    /**
     * Menambahkan antrian baru
     * @param nama nama penonton
     * @return nomor antrian yang diberikan
     */
    public int tambahAntrian(String nama) {
        nomorUrut++;
        AntrianItem item = new AntrianItem(nomorUrut, nama);
        waitingQueue.add(item);
        return nomorUrut;
    }
    
    /**
     * Memproses antrian (melayani antrian pertama)
     * @return AntrianItem yang dilayani, null jika antrian kosong
     */
    public AntrianItem prosesAntrian() {
        if (waitingQueue.isEmpty()) {
            return null;
        }
        return waitingQueue.poll();
    }
    
    /**
     * Melihat antrian selanjutnya tanpa menghapusnya
     * @return AntrianItem selanjutnya, null jika antrian kosong
     */
    public AntrianItem lihatAntrianSelanjutnya() {
        return waitingQueue.peek();
    }
    
    /**
     * Mendapatkan jumlah antrian yang menunggu
     * @return jumlah antrian
     */
    public int getJumlahAntrian() {
        return waitingQueue.size();
    }
    
    /**
     * Mendapatkan total nomor yang sudah dibuat
     * @return total nomor antrian
     */
    public int getTotalNomor() {
        return nomorUrut;
    }
    
    /**
     * Mengecek apakah antrian kosong
     * @return true jika kosong
     */
    public boolean isAntrianKosong() {
        return waitingQueue.isEmpty();
    }
    
    /**
     * Mendapatkan daftar semua antrian yang menunggu
     * @return List berisi semua antrian
     */
    public List<AntrianItem> getDaftarAntrian() {
        return new ArrayList<>(waitingQueue);
    }
    
    /**
     * Reset semua antrian
     */
    public void resetAntrian() {
        waitingQueue.clear();
        nomorUrut = 0;
    }
    
    /**
     * Mendapatkan informasi panggilan antrian
     * @return string panggilan antrian atau pesan kosong
     */
    public String getPanggilanAntrian() {
        AntrianItem next = lihatAntrianSelanjutnya();
        if (next != null) {
            return "Nomor Antrian " + next.getNomor();
        }
        return "-----";
    }
}
