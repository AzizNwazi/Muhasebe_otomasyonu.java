
package muhasebeotomasyonu;


public class Calisan {
    
    private String isim_soyisim;
    private String telefon;
    private String departman;
    public int maas;
    private int gun_sayisi;
    
    public Calisan(String isim_soyisim,String telefon, String departman,int maas, int gun_sayisi) {
        this.isim_soyisim = isim_soyisim;
        this.departman = departman;
        this.maas = maas;
        this.gun_sayisi = gun_sayisi;
        this.telefon=telefon;
    }
    
    //Overloding
    public Calisan(){
        
    }
    
    public String getIsim_soyisim() {
        return isim_soyisim;
    }

    public void setIsim_soyisim(String isim_soyisim) {
        this.isim_soyisim = isim_soyisim;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public int getGun_sayisi() {
        return gun_sayisi;
    }

    public void setGun_sayisi(int gun_sayisi) {
        this.gun_sayisi = gun_sayisi;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
