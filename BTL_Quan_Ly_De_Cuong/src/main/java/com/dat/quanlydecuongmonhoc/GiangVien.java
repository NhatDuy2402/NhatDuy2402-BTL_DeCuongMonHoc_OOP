package com.dat.quanlydecuongmonhoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GiangVien {

    private int maGv;
    private String tenGv;
    private List<DeCuong> dcGv = new ArrayList();

    public GiangVien() {
    }

    public GiangVien(int maGv, String tenGv) {
        this.maGv = maGv;
        this.tenGv = tenGv;
    }
    
    public DeCuong timKiemDc(int ma){
        return this.dcGv.stream().filter(x -> x.getMonHoc().getMaMh() == ma)
                .findFirst().get();
    }

    public void themDcGv(DeCuong... dc){
        this.dcGv.addAll(Arrays.asList(dc));
    }
    
    public void xoaDcGv(DeCuong... dc){
        this.dcGv.removeAll(Arrays.asList(dc));
    }
    
    public void nhapGv(){
        System.out.print("Nhap ma Giang Vien : ");
        this.maGv = Integer.parseInt(CauHinh.sc.nextLine());
        System.out.print("Nhap ten Giang vien: ");
        this.tenGv = CauHinh.sc.nextLine();
    }
    
    public void hienThiGv(){
        System.out.printf("Ma giang vien: %s\nTen Giang vien: %s\n", 
                this.maGv, this.tenGv);
    }
    
    
    public int getMaGv() {
        return maGv;
    }

    /**
     * @param maGv the maGv to set
     */
    public void setMaGv(int maGv) {
        this.maGv = maGv;
    }

    /**
     * @return the tenGv
     */
    public String getTenGv() {
        return tenGv;
    }

    /**
     * @param tenGv the tenGv to set
     */
    public void setTenGv(String tenGv) {
        this.tenGv = tenGv;
    }

   
    /**
     * @return the dcGv
     */
    public List<DeCuong> getDcGv() {
        return dcGv;
    }

    /**
     * @param dcGv the dcGv to set
     */
    public void setDcGv(List<DeCuong> dcGv) {
        this.dcGv = dcGv;
    }

    /**
     * @return the dcGv
     */
 

}
