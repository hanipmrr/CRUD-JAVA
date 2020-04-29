
public class Data {
    private String nama;
    private int nim;
    private String alamat;
    private String no_telp;

    public Data(String nama, int nim, String alamat, String no_telp){
        this.nama = nama;
        this.nim = nim;
        this.alamat = alamat;
        this.no_telp = no_telp;
    }

    public String getNama() {
        return nama;
    }

    public int getNim() {
        return nim;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNo_telp() {
        return no_telp;
    }

}
