package com.dat.quanlydecuongmonhoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeCuong {

    private MonHoc monHoc;
    private String mucTieu;
    private String noiDungMh;
    private HeDaoTao hdt;
    private List<ChuanDauRa> cdr = new ArrayList<>();
    private List<CotDiem> dsCotDiem = new ArrayList<>();
    private GiangVien Gv;

    public DeCuong() {
    }

    public DeCuong(MonHoc monHoc, String mucTieu, String noiDungMh, HeDaoTao hdt,
            GiangVien gv) {
        this.monHoc = monHoc;
        this.mucTieu = mucTieu;
        this.noiDungMh = noiDungMh;
        this.hdt = hdt;
        this.Gv = gv;
    }

    public void themCDR(ChuanDauRa... cdr) {
        this.cdr.addAll(Arrays.asList(cdr));
    }

    public void xoaCDR(ChuanDauRa... cdr) {
        this.cdr.removeAll(Arrays.asList(cdr));
    }

    public void themCotDiem(CotDiem... cd) {
        this.dsCotDiem.addAll(Arrays.asList(cd));
    }

    public void xoaCotDiem(CotDiem... cd) {
        this.dsCotDiem.removeAll(Arrays.asList(cd));
    }

    public void capNhapNoiDung(String noiDungMh) {
        this.noiDungMh = noiDungMh;
    }

    public void themMonHocTruoc(MonHoc monHocTruoc) {
        if (!monHoc.getMhTruoc().contains(monHocTruoc)) {
            monHoc.getMhTruoc().add(monHocTruoc);
        }
    }

    public void hienThi() {
        monHoc.hienThi();
        System.out.printf("\nMuc tieu mon hoc: %s\nNoi dung mon Hoc: %s\nHe Dao tao: %s\n",
                this.mucTieu, this.noiDungMh, this.hdt);
        System.out.println("\n------------------------- Chuan Dau Ra -------------------------");
        this.cdr.forEach(x -> x.hienThi());
        System.out.println("\n---------------------- Danh Sach cot Diem -----------------------");
        int[] i = {0};
        this.dsCotDiem.forEach(x -> {
            System.out.println("------------------------ Cot Diem thu " + (i[0] + 1) + " -------------------------");
            x.hienthi();
            i[0]++;
        });

        System.out.println("\n---------------------- Giang vien phu trach ---------------------");
        this.Gv.hienThiGv();
        System.out.println("\n");
    }

    public void hienThiSapXep() {
        System.out.println("Ten Mon Hoc : " + this.monHoc.getTenMh());
        System.out.println("Ma mon hoc : " + this.monHoc.getMaMh());
        System.out.println("So tin Chi : " + this.monHoc.getSoTinChi());
        System.out.println("He dao tao : " + this.getHdt());
    }

    public void nhapDeCuong() {
        System.out.print("Nhap muc tieu: ");
        this.mucTieu = CauHinh.sc.nextLine();
        System.out.printf("Nhap noi dung Mon Hoc : ");
        this.noiDungMh = CauHinh.sc.nextLine();
        System.out.printf("Nhap he dao tao\n1 - Chinh quy\n2 - Lien Thong\n");
        this.hdt = HeDaoTao.getHDT(Integer.parseInt(CauHinh.sc.nextLine()));
        System.out.print("Nhap So Luong chuan dau ra : ");
        int x = Integer.parseInt(CauHinh.sc.nextLine());
        for (int i = 0; i < x; i++) {
            System.out.printf("-------------------------- Chuan dau ra %d ----------------------------\n", i + 1);
            ChuanDauRa c = new ChuanDauRa();
            c.nhapCDR();
            this.cdr.add(c);
        }
        System.out.print("Nhap So Luong Cot diem danh gia : ");
        x = Integer.parseInt(CauHinh.sc.nextLine());
        for (int i = 0; i < x; i++) {
            System.out.printf("-------------------------- Cot diem danh gia %d -------------------------\n", i + 1);
            CotDiem c = new CotDiem();
            c.nhapCotDiem();
            this.dsCotDiem.add(c);
        }
    }

    /**
     * @return the monHoc
     */
    public MonHoc getMonHoc() {
        return monHoc;
    }

    /**
     * @param monHoc the monHoc to set
     */
    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    /**
     * @return the mucTieu
     */
    public String getMucTieu() {
        return mucTieu;
    }

    /**
     * @param mucTieu the mucTieu to set
     */
    public void setMucTieu(String mucTieu) {
        this.mucTieu = mucTieu;
    }

    /**
     * @return the noiDungMh
     */
    public String getNoiDungMh() {
        return noiDungMh;
    }

    /**
     * @param noiDungMh the noiDungMh to set
     */
    public void setNoiDungMh(String noiDungMh) {
        this.noiDungMh = noiDungMh;
    }

    /**
     * @return the hdt
     */
    public HeDaoTao getHdt() {
        return hdt;
    }

    /**
     * @param hdt the hdt to set
     */
    public void setHdt(HeDaoTao hdt) {
        this.hdt = hdt;
    }

    /**
     * @return the cdr
     */
    public List<ChuanDauRa> getCdr() {
        return cdr;
    }

    /**
     * @param cdr the cdr to set
     */
    public void setCdr(List<ChuanDauRa> cdr) {
        this.cdr = cdr;
    }

    /**
     * @return the dsCotDiem
     */
    public List<CotDiem> getDsCotDiem() {
        return dsCotDiem;
    }

    /**
     * @param dsCotDiem the dsCotDiem to set
     */
    public void setDsCotDiem(List<CotDiem> dsCotDiem) {
        this.dsCotDiem = dsCotDiem;
    }

    /**
     * @return the Gv
     */
    public GiangVien getGv() {
        return Gv;
    }

    /**
     * @param Gv the Gv to set
     */
    public void setGv(GiangVien Gv) {
        this.Gv = Gv;
    }

    /**
     * @return the cdr
     */
}
