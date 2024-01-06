package com.dat.quanlydecuongmonhoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonHoc {

    private int maMh;
    private String tenMh;
    private String moTa;
    private int soTinChi;
    private List< MonHoc> mhTruoc = new ArrayList<>();
    private List< MonHoc> mhTienQuyet = new ArrayList<>();
    private List< DeCuong> dsDeCuong = new ArrayList<>();
    private KhoiKienThuc khoiKT;

    private static int dem = 0;
    private static int SO_MON = 3;
 

    {
        this.maMh = ++dem;
    }

    public MonHoc() {
    }

    public MonHoc timKiemMhTienQuyet(int ma) {
        try {
            return this.mhTienQuyet.stream().filter(x -> x.maMh == ma).findFirst().get();
        } catch (Exception e) {
            return null;
        }
    }

    public MonHoc timKiemMhTruoc(int ma) {
        try {
            return this.mhTruoc.stream().filter(x -> x.maMh == ma).findFirst().get();
        } catch (Exception e) {
            return null;
        }
    }

    public DeCuong timKiemDeCuong(HeDaoTao hdt) {
        try {
            return this.dsDeCuong.stream().filter(x -> x.getHdt().equals(hdt))
                    .findFirst().get();
        } catch (Exception e) {
            return null;
        }
    }

    public void themDc(DeCuong... dc) {
        this.dsDeCuong.addAll(Arrays.asList(dc));
    }

    public MonHoc(String tenMh, String moTa, int soTinChi, KhoiKienThuc khoiKT) {
        this.tenMh = tenMh;
        this.moTa = moTa;
        this.soTinChi = soTinChi;
        this.khoiKT = khoiKT;
    }

    public void themDsDeCuong(DeCuong... dc) {
        this.dsDeCuong.addAll(Arrays.asList(dc));
    }

    public void xoaDsDeCuong(DeCuong... dc) {
        this.dsDeCuong.removeAll(Arrays.asList(dc));
    }

    public void themMhTienQuyet(MonHoc... mh) {
        this.mhTienQuyet.addAll(Arrays.asList(mh));
    }

    public void xoaMhTienQuyet(MonHoc... mh) {
        this.mhTienQuyet.addAll(Arrays.asList(mh));
    }

    public void themMhTruoc(MonHoc... mh) {
        this.mhTruoc.addAll(Arrays.asList(mh));
    }

    public void xoaMhTruoc(MonHoc... mh) {
        this.mhTruoc.removeAll(Arrays.asList(mh));
    }

    public void hienThi() {
        System.out.printf("Ma mon Hoc : %03d\nTen Mon Hoc: %s\nMo ta Mon hoc: %s\nSo tin chi: %s\n",
                this.maMh, this.tenMh, this.moTa, this.soTinChi);
        System.out.printf("Khoi Kien thuc: %s\n", this.khoiKT);
        System.out.print("Mon hoc truoc : ");
        hienThiTenMhTruoc();
        if (this.mhTruoc == null) {
            System.out.println("");
        }
        System.out.print("Mon Tien Quyet: ");
        hienThiTenMhTienQuyet();
        if (this.mhTienQuyet == null) {
            System.out.println("");
        }
        System.out.println("\n");

    }

    public void hienThiMhTruoc() {
        try {
            this.mhTruoc.forEach(x -> x.hienThi());

        } catch (Exception e) {
            System.out.println("Mon hoc khong co mon hoc truoc");
        }
    }

    public void hienThiMhTienQuyet() {
        try {
            this.mhTienQuyet.forEach(x -> x.hienThi());
        } catch (Exception e) {
            System.out.println("Mon hoc Khong co mon tien Quyet");
        }
    }

    public void hienThiTenMh() {
        System.out.printf("%-20s |   Ma Mon Hoc: %03d   |   So tin Chi %d\n",
                this.getTenMh(), this.getMaMh(), this.getSoTinChi());
    }

    public void hienThiTenMhTruoc() {
        try {
            this.mhTruoc.forEach(x -> x.hienThiTenMh());
        } catch (Exception e) {
            System.out.println("Mon hoc khong co mon hoc truoc");
        }
    }

    public void hienThiTenMhTienQuyet() {
        try {
            this.mhTienQuyet.forEach(x -> x.hienThiTenMh());
        } catch (Exception e) {
            System.out.println("Mon Hoc Khong co mon tien Quyet\n");
        }
    }

    public void hienThiDsDeCuong() {
        this.dsDeCuong.forEach(x -> x.hienThi());
    }

    public void nhapMonHoc() {
        System.out.print("Nhap ten Mon Hoc : ");
        this.tenMh = CauHinh.sc.nextLine();
        System.out.print("Nhap Mo ta mon hoc : ");
        this.moTa = CauHinh.sc.nextLine();
        System.out.print("Nhap so tin chi: ");
        this.soTinChi = Integer.parseInt(CauHinh.sc.nextLine());
        System.out.print("Nhap Khoi kien thuc: \n1 - Co so\n2 - Co so nganh\n3 - Chuyen nganh\n");
        this.khoiKT = KhoiKienThuc.getKKT(Integer.parseInt(CauHinh.sc.nextLine()));
    }

    public void nhapMhTruocVaMHTienQuyet() {
        int x, y;
        do {
            System.out.print("Mon Hoc Co mon hoc truoc Khong?\n1 - Co; 2 - Khong: ");
            x = Integer.parseInt(CauHinh.sc.nextLine());
            if (x == 1) {
                System.out.print("Mon hoc co may mon hoc truoc: ");
                y = Integer.parseInt(CauHinh.sc.nextLine());
                if (SO_MON - this.mhTruoc.size() >= y) {
                    for (int i = 0; i < y; i++) {
                        MonHoc a = new MonHoc();
                        a.nhapMonHoc();
                        this.mhTruoc.add(a);
                    }
                }
            } else if (x == 2) {
                break;
            }
        } while (x != 1);
        do {
            System.out.print("Mon Hoc Co mon hoc Tien Quyet Khong?\n1 - Co; 2 - Khong: ");
            x = Integer.parseInt(CauHinh.sc.nextLine());
            if (x == 1) {
                System.out.print("Mon hoc co may mon hoc tien quyet: ");
                y = Integer.parseInt(CauHinh.sc.nextLine());
                if (SO_MON - this.mhTienQuyet.size() >= y) {
                    for (int i = 0; i < y; i++) {
                        MonHoc a = new MonHoc();
                        a.nhapMonHoc();
                        this.mhTruoc.add(a);
                    }
                }
            } else if (x == 2) {
                break;
            }
        } while (x != 1);
    }

    /**
     * @return the maMh
     */
    public int getMaMh() {
        return maMh;
    }

    /**
     * @param maMh the maMh to set
     */
    public void setMaMh(int maMh) {
        this.maMh = maMh;
    }

    /**
     * @return the tenMh
     */
    public String getTenMh() {
        return tenMh;
    }

    /**
     * @param tenMh the tenMh to set
     */
    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
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

    /**
     * @return the soTinChi
     */
    public int getSoTinChi() {
        return soTinChi;
    }

    /**
     * @param soTinChi the soTinChi to set
     */
    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    /**
     * @return the khoiKT
     */
    public KhoiKienThuc getKhoiKT() {
        return khoiKT;
    }

    /**
     * @param khoiKT the khoiKT to set
     */
    public void setKhoiKT(KhoiKienThuc khoiKT) {
        this.khoiKT = khoiKT;
    }

    /**
     * @return the mhTruoc
     */
    public List< MonHoc> getMhTruoc() {
        return mhTruoc;
    }

    /**
     * @param mhTruoc the mhTruoc to set
     */
    public void setMhTruoc(List< MonHoc> mhTruoc) {
        this.mhTruoc = mhTruoc;
    }

    /**
     * @return the mhTienQuyet
     */
    public List< MonHoc> getMhTienQuyet() {
        return mhTienQuyet;
    }

    /**
     * @param mhTienQuyet the mhTienQuyet to set
     */
    public void setMhTienQuyet(List< MonHoc> mhTienQuyet) {
        this.mhTienQuyet = mhTienQuyet;
    }

    /**
     * @return the dsDeCuong
     */
    public List<DeCuong> getDsDeCuong() {
        return dsDeCuong;
    }

    /**
     * @param dsDeCuong the dsDeCuong to set
     */
    public void setDsDeCuong(List< DeCuong> dsDeCuong) {
        this.dsDeCuong = dsDeCuong;
    }

}
