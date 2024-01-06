package com.dat.quanlydecuongmonhoc;

public class HinhThucDanhGia {

    private String tenHinhThuc;
    private String moTa;

    public HinhThucDanhGia() {
    }

    public HinhThucDanhGia(String tenHinhThuc, String moTa) {
        this.tenHinhThuc = tenHinhThuc;
        this.moTa = moTa;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof HinhThucDanhGia){
            HinhThucDanhGia h = (HinhThucDanhGia) obj;
            return this.tenHinhThuc.equals(h.tenHinhThuc)
                    && this.moTa.equals(h.moTa);
        }
        return false;
    }
    
    
    public void nhapHTDG(){
        System.out.print("Nhap Hinh thuc Danh gia: ");
        this.tenHinhThuc = CauHinh.sc.nextLine();
        System.out.print("Nhap Mo ta Hinh thuc danh gia: ");
        this.moTa = CauHinh.sc.nextLine();
    }

    public void hienThi(){
        System.out.printf("Hinh thuc Danh gia: %s\nMo ta hinh thuc danh gia: %s\n",
                this.tenHinhThuc, this.moTa);
    }
    
    /**
     * @return the tenHinhThuc
     */
    public String getTenHinhThuc() {
        return tenHinhThuc;
    }

    /**
     * @param tenHinhThuc the tenHinhThuc to set
     */
    public void setTenHinhThuc(String tenHinhThuc) {
        this.tenHinhThuc = tenHinhThuc;
    }

    /**
     * @return the moTa
     */
    public String getMoTa() {
        return moTa;
    }

    /**
     * @param moTa the moTa to set
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
