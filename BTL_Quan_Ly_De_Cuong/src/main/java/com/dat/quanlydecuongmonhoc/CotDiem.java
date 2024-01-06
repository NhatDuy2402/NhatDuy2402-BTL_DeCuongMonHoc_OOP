package com.dat.quanlydecuongmonhoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CotDiem {

    private String ppdg;
    private String noiDungDg;
    private double tyTrong;
    private List<HinhThucDanhGia> hinhThuc = new ArrayList<>();

    public CotDiem() {
    }

    public CotDiem(String ppdg, String noiDungDg, double tyTrong, HinhThucDanhGia hinhThuc) {
        this.ppdg = ppdg;
        this.noiDungDg = noiDungDg;
        this.tyTrong = tyTrong;
        this.hinhThuc.add(hinhThuc);
    }

    public void themHTDG(HinhThucDanhGia... htdg) {
        this.hinhThuc.addAll(Arrays.asList(htdg));
    }

    public void themHTDG(int index, HinhThucDanhGia htdg) {
        this.hinhThuc.add(index, htdg);
    }

    public void xoaHTDG(HinhThucDanhGia... htdg) {
        this.hinhThuc.removeAll(Arrays.asList(htdg));
    }

    public void hienthi() {
        System.out.printf("Phuong phap danh gia: %s\nNoi dung danh gia : %s\nTy trong: %s\n",
                this.ppdg, this.noiDungDg, this.tyTrong);
        this.getHinhThuc().forEach(x -> x.hienThi());
    }

    public void nhapCotDiem() {
        System.out.print("Nhap phuong phap danh gia: ");
        this.ppdg = CauHinh.sc.nextLine();
        System.out.print("Nhap noi dung danh gia: ");
        this.noiDungDg = CauHinh.sc.nextLine();
        System.out.print("Nhap ty trong Diem: ");
        this.setTyTrong(Double.parseDouble(CauHinh.sc.nextLine()));
        HinhThucDanhGia h = new HinhThucDanhGia();
        h.nhapHTDG();
        getHinhThuc().add(h);
    }

    /**
     * @return the ppdg
     */
    public String getPpdg() {
        return ppdg;
    }

    /**
     * @param ppdg the ppdg to set
     */
    public void setPpdg(String ppdg) {
        this.ppdg = ppdg;
    }

    /**
     * @return the noiDungDg
     */
    public String getNoiDungDg() {
        return noiDungDg;
    }

    /**
     * @param noiDungDg the noiDungDg to set
     */
    public void setNoiDungDg(String noiDungDg) {
        this.noiDungDg = noiDungDg;
    }

    /**
     * @return the tyTrong
     */
    public double getTyTrong() {
        return tyTrong;
    }

    /**
     * @param tyTrong the tyTrong to set
     */
    public void setTyTrong(int tyTrong) {
        this.setTyTrong(tyTrong);
    }

    /**
     * @param tyTrong the tyTrong to set
     */
    public void setTyTrong(double tyTrong) {
        this.tyTrong = tyTrong;
    }

    /**
     * @return the hinhThuc
     */
    public List<HinhThucDanhGia> getHinhThuc() {
        return hinhThuc;
    }

    /**
     * @param hinhThuc the hinhThuc to set
     */
    public void setHinhThuc(List<HinhThucDanhGia> hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

}
