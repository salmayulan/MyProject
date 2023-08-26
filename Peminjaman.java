class Peminjaman{

    private Keanggotaan nim;
    private DaftarBuku kodeBuku;
    private String[] Buku=new String[3];
    private int jumlahBuku;

    public Peminjaman(){
    }
    public void setAnggota(Keanggotaan nim){
        this.nim = nim;
    }
    public void setKodeBuku(DaftarBuku kdBuku){
        kodeBuku = kdBuku;
    }
    public DaftarBuku getKodeBuku(){
        return kodeBuku;
    }
    public Keanggotaan getNim(){
        return nim;
    }
    public void infoPeminjaman(){
        System.out.println("NIM   : "+nim.getNim());
    }
    public void infoPinjam(int i,String kdBuku){
         Buku[i] = kdBuku;
    }
    public String infoPinjam(int i){
        return Buku[i];
    }
    }
