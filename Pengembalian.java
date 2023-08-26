class Pengembalian{


   private Date tanggal_lahir;

   public Mahasiswa(String tanggal_lahir) {

		int d = Integer.parseInt(tanggal_lahir.substring(0, 2));
		int m = Integer.parseInt(tanggal_lahir.substring(3, 5));
		int y = Integer.parseInt(tanggal_lahir.substring(6));

		this.tanggal_lahir = new Date(d, m, y);
	}
public void info() {
		System.out.println("Tanggal Pengembalian : " + tanggal_lahir.convertString());
}
}
