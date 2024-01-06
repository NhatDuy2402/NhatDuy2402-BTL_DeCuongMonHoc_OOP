package com.dat.quanlydecuongmonhoc;



public class ChuanDauRa {

    private String tenCDR;
    private String moTa;

    public ChuanDauRa() {
    }

    public ChuanDauRa(String tenCDR, String moTa) {
        this.tenCDR = tenCDR;
        this.moTa = moTa;
    }

    public void hienThi(){
        System.out.printf("Chuan Dau Ra : %s\nMo ta chuan dau ra : %s\n",
                this.tenCDR, this.moTa);
    }
    
    public void nhapCDR(){
        System.out.print("Nhap Chuan Dau ra: ");
        this.tenCDR = CauHinh.sc.nextLine();
        System.out.print("Nhap mo ta chuan dau Ra: ");
        this.moTa = CauHinh.sc.nextLine();
    }
    
    /**
     * @return the tenCDR
     */
    public String getTenCDR() {
        return tenCDR;
    }

    /**
     * @param tenCDR the tenCDR to set
     */
    public void setTenCDR(String tenCDR) {
        this.tenCDR = tenCDR;
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
