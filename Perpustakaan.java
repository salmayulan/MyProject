import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
class Perpustakaan{
    public static void main(String[] args) throws ParseException{
        String pilihan, choose, daftar, nama, nim, alamat, programstudi,KodeBuku;
        int jmlhBuku;
        Scanner sc = new Scanner(System.in);
        //object class DaftarBuku
        DaftarBuku D1 = new DaftarBuku();
        D1.setJenisBuku("PELAJARAN");
        D1.setKodeBuku("P101");
        D1.setJudul("IPA");

        DaftarBuku D2 = new DaftarBuku();
        D2.setJenisBuku("NOVEL");
        D2.setKodeBuku("N101");
        D2.setJudul("SHERLOCK HOLMES");

        DaftarBuku D3 = new DaftarBuku();
        D3.setJenisBuku("DICTIONARY");
        D3.setKodeBuku("D101");
        D3.setJudul("BAHASA JERMAN");
        //object class Keanggotaan
        Keanggotaan K1 = new Keanggotaan();
        K1.setNim("J3D117122");
        K1.setNama("SALMA");
        Keanggotaan K2 = new Keanggotaan();
        //object class Peminjaman
        Peminjaman P1 = new Peminjaman();
        P1.setAnggota(K1);
        //object date
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = sdf.parse("26-12-2018");
        Date date2 = sdf.parse("27-12-2018");

        do{
            System.out.println("===========================MENU UTAMA================================");
            System.out.println("\n");
            System.out.println("1. DAFTAR BUKU");
            System.out.println("2. KEANGGOTAAN");
            System.out.println("3. PEMINJAMAN");
            System.out.println("4. PENGEMBALIAN");
            System.out.println("\n");
            System.out.print("INPUTKAN PILIHAN ANDA (1-4): ");
            pilihan = sc.next();

            switch(pilihan){
            case "1" : {
                System.out.println("\n");

                D1.infoDaftarBuku();
                System.out.println("\n");
                D2.infoDaftarBuku();
                System.out.println("\n");
                D3.infoDaftarBuku();
                System.out.println("\n");

                break;
            }
            case "2" : {
                System.out.println("\n");
                System.out.print("PASTIKAN ANDA TERDAFTAR SEBAGAI ANGGOTA SEBELUM MEMINJAM");
                System.out.println("\n");
                System.out.print("INPUTKAN NIM : ");
                nim = sc.next();
                if(nim.equals(K1.getNim()))
                {
                    System.out.println("HALO" + " "+ K1.getNama()+(",")+" "+ "ANDA TELAH TERDAFTAR SEBAGAI ANGGOTA");
                }
                else
                {
                    System.out.print("ANDA TIDAK TERDAFTAR LAKUKAN PENDAFTARAN (Y/N) : ");
                    daftar = sc.next();
                    if(daftar.equals("Y"))
                    {
                        //Keanggotaan K2 = new Keanggotaan();
                        System.out.print("NAMA   : ");
                        nama = sc.next();
                        System.out.print("NIM    : ");
                        nim = sc.next();
                        System.out.print("ALAMAT : ");
                        alamat = sc.next();
                        System.out.print("PROGRAM STUDI : ");
                        programstudi = sc.next();
                        K2 = new Keanggotaan(nama,nim,alamat,programstudi);
                        System.out.println("\n");
                        System.out.println("HALO" + " "+ K2.getNama()+(",")+" "+ "ANDA TELAH TERDAFTAR  SEBAGAI ANGGOTA");
                    }
                }
                break;}
            case "3" : {
                System.out.println("\n");
                System.out.println("================PASTIKAN ANDA TELAH TERDAFTAR SEBAGAI ANGGOTA================");
                System.out.println("==============MAKSIMAL PEMINJAMAN BUKU BERLAKU SELAMA 1 MINGGU===============");
                System.out.println("==============JIKA MELANGGAR DIKENAI DENDA SEBESAR Rp.5000/HARI==============");
                System.out.println("=====UNTUK 1 KEANGOTAAN PEMINJAMAN SAMPAI DENGAN 3 JENIS BUKU YANG BERBEDA===");

                System.out.println("\n");
                System.out.print("NIM : ");
                nim = sc.next();
                if((nim.equals(K1.getNim())) || (nim.equals(K2.getNim())))
                {
                    System.out.print("JUMLAH PINJAMAN BUKU : ");
                    jmlhBuku = sc.nextInt();
                    if(jmlhBuku <= 3)
                    {
                        for(int i=0; i<jmlhBuku; i++)
                        {
                            System.out.print("KODE BUKU "+(i+1)+ " : ");
                            KodeBuku = sc.next();
                            P1.infoPinjam(i,KodeBuku);
                        }
                        System.out.println("\n");
                        System.out.println("PEMINJAMAN YANG DILAKUKAN");
                        P1.infoPeminjaman();
                        for(int i=0; i<jmlhBuku; i++)
                        {
                        System.out.println("KODE BUKU : "+P1.infoPinjam(i));
                        }
                        System.out.println("Tanggal Peminjaman   : "+sdf.format(date));
                        System.out.println("Tanggal Pengembalian : "+sdf.format(date1));
                    }
                    else
                    {
                        System.out.println("PEMINJAMAN MAKSIMAL 3 BUKU");
                    }
                }
                else
                {
                    System.out.println("DAFTARKAN DIRI ANDA SEBAGAI ANGGOTA TERLEBIH DAHULU");
                }

                break;
            }

            case "4" : {
                System.out.println("\n");
                System.out.print("INPUTKAN NIM : ");
                nim = sc.next();
                if(nim.equals(K1.getNim()))
                {
                    if(date2.before(date1))
                    {
                        System.out.println("DATA PENGEMBALIAN");
                        P1.infoPeminjaman();
                        /*for(int i=0; i<3; i++)
                        {
                        System.out.println("KODE BUKU : "+P1.infoPinjam(i));
                        }*/
                        System.out.println("Tanggal Peminjaman : "+sdf.format(date));
                        System.out.println("Tanggal Pengembalian : "+sdf.format(date1));
                        System.out.println("ANDA TERKENA DENDA");
                    }
                    else
                    {   System.out.println("DATA PENGEMBALIAN");
                        P1.infoPeminjaman();
                        /*for(int i=0; i<3; i++)
                        {
                        System.out.println("KODE BUKU : "+P1.infoPinjam(i));
                        }*/
                        System.out.println("Tanggal Peminjaman : "+sdf.format(date));
                        System.out.println("Tanggal Pengembalian : "+sdf.format(date1));
                        System.out.println("ANDA TIDAK TERKENA DENDA");
                    }
                }
                else
                {
                    System.out.println("PENCARIAN TIDAK DITEMUKAN");
                }

                break;
            }
            default :
                System.out.println("PILIHAN TIDAK DITEMUKAN");
            }
            System.out.print("KEMBALI PADA MENU UTAMA (Y/N) : ");
            choose = sc.next();
        }while((choose.equals("Y")) || (choose.equals("y")));
    }
}
