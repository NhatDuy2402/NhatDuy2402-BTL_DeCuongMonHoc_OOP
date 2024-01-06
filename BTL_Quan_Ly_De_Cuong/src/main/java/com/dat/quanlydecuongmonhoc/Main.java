/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dat.quanlydecuongmonhoc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PHAT
 */
public class Main {

    public static void menu() {
        System.out.println("=========================== MENU ===============================");
        System.out.println("1. Tao de cuong mon hoc.");
        System.out.println("2. Cap nhat thong tin de cuong.");
        System.out.println("3. Tim kiem mon hoc.");
        System.out.println(
                "4. Xac dinh danh sach mon theo ma mon hoc ma no la mon hoc truoc hoac tien quyet cua danh sach.");
        System.out.println("5. Sap xep danh sach de cuong giam dan theo tin chi.");
        System.out.println("6. Xac dinh danh sach de cuong cua giang vien (theo ma giang vien).");
        System.out.println("7. Xuat de cuong hoan chinh.");
        System.out.println("8. Thong ke so luong de cuong theo so tin chi.");
        System.out.println("0. Thoat.");
    }

    public static void menuXuaThongTin() {
        System.out.println("\n------------------------- Menu sua thong tin -------------------------");
        System.out.println("1. Sua noi dung mon hoc");
        System.out.println("2. Them mon tien quyet");
        System.out.println("3. Xoa mon tien quyet");
        System.out.println("4. Them mon hoc truoc");
        System.out.println("5. Xoa mon hoc truoc");
        System.out.println("6. Them hinh thuc danh gia");
        System.out.println("7. Xoa hinh thuc danh gia");
        System.out.println("0. Quay lai");
        System.out.print("Moi ban chon: ");
    }

    public static void main(String[] args) {
        DanhSachMonHoc dsmh = new DanhSachMonHoc();
        DanhSachDeCuong dsdc = new DanhSachDeCuong();
        DanhSachGiangVien dsgv = new DanhSachGiangVien();

        GiangVien gv1 = new GiangVien(1, "Nguyen Thi mai Trang");
        MonHoc mh1 = new MonHoc("co so lap trinh", "Hoc ngon ngu C++", 4, KhoiKienThuc.CO_SO);
        MonHoc mh2 = new MonHoc("ky thuat lap trinh", "Tim hieu con tro, mang, struct", 3, KhoiKienThuc.CO_SO);
        MonHoc mh3 = new MonHoc("cau truc du lieu giai thuat", "Tim hieu cac thuat toan sap xep", 4,
                KhoiKienThuc.CO_SO);

        GiangVien gv2 = new GiangVien(2, "Duong Huu Thanh");
        ChuanDauRa cdr1 = new ChuanDauRa("C001", "Hieu va lam quen ngon ngu c++");
        ChuanDauRa cdr2 = new ChuanDauRa("C002", "Su dung cau lenh if else va vong lap");
        ChuanDauRa cdr3 = new ChuanDauRa("C003", "Code duoc chuong trinh c++ co ban");

        CotDiem cd1 = new CotDiem("Kiem tra Giua ki", "Danh gia Chuong 1 2 3", 0.4, new HinhThucDanhGia(
                "kiem tra tren may", "Sinh vien Kiem tra tren may theo quy dinh cau giang vien phu trach"));
        CotDiem cd2 = new CotDiem("Kiem tra Cuoi Ki", "Danh gia Chuong 1 2 3 4 5 6", 0.4,
                new HinhThucDanhGia("kiem tra tren may", "Sinh vien Kiem tra tren may theo quy dinh cau giang vien"));
        CotDiem cd3 = new CotDiem("Kiem tra cuoi ki", "Danh gia Chuong 2 3 4 5 6", 0.6,
                new HinhThucDanhGia("kiem tra tren Giay", "Sinh vien Kiem tra Giay Khong duoc su dung tai lieu"));

        DeCuong dc1 = new DeCuong(mh1, "Giup sinh vien lam quen ngon ngu lap trinh", "Hoc cau lenh, vong lap",
                HeDaoTao.CHINH_QUY, gv2);
        DeCuong dc2 = new DeCuong(mh2, "Giup sinh vien lam quen ngon ngu lap trinh", "Hoc cau lenh, vong lap",
                HeDaoTao.CHINH_QUY, gv1);
        DeCuong dc3 = new DeCuong(mh3, "Giup sinh vien lam Hieu cac thuat toan", "Hoc DSLK, grap, prim,...",
                HeDaoTao.LIEN_THONG, gv1);
        DeCuong dc4 = new DeCuong(mh3, "Giup sinh vien hieu giai thuat", "Hoc DSLK, grap, prim,..., ngon ngu c++",
                HeDaoTao.CHINH_QUY, gv1);

        mh1.themDc(dc1);

        mh2.themDc(dc2);
        mh2.themMhTruoc(mh1);

        mh3.themDc(dc3, dc4);
        mh3.themMhTruoc(mh1);
        mh3.themMhTienQuyet(mh2);

        dc1.themCDR(cdr1, cdr2);
        dc1.themCotDiem(cd1, cd2);

        dc2.themCDR(cdr2, cdr3);
        dc2.themCotDiem(cd1, cd2);

        dc3.themCDR(cdr3);
        dc3.themCotDiem(cd1, cd3);

        dc4.themCDR(cdr1, cdr3);
        dc4.themCotDiem(cd1, cd3);

        dsmh.themMh(mh1, mh2, mh3);
        dsdc.themDc(dc1, dc2, dc3, dc4);

        dsgv.themGv(gv1, gv2);
        gv1.themDcGv(dc2, dc3, dc4);
        gv2.themDcGv(dc1);

        do {

            // endl();
            menu();
            System.out.print("==> Chon Chuc Nang: ");
            int chon;
            chon = Integer.parseInt(CauHinh.sc.nextLine());
            switch (chon) {
                case 1 -> {
                    System.out.println(
                            "========================= Chuc Nang: Tao De Cuong Mon Hoc =========================");
                    DeCuong dc = new DeCuong();
                    GiangVien gv;
                    do {
                        System.out.printf("1. Tao de cuong cho mon hoc moi\n");
                        System.out.println("2. Tao de cuong cho mon hoc Da co de cuong\n0. Thoat");
                        System.out.print("Moi ban chon: ");
                        int x = Integer.parseInt(CauHinh.sc.nextLine());
                        if (x == 0) {
                            break;
                        }
                        if (x == 1) {
                            MonHoc h = new MonHoc();
                            h.nhapMonHoc();
                            h.nhapMhTruocVaMHTienQuyet();
                            dc.setMonHoc(h);
                            System.out.println(
                                    "\n========================= Nhap De cuong mon hoc =========================");
                            dc.nhapDeCuong();
                            System.out.print("Nhap ma Giang Vien : ");
                            int ma = Integer.parseInt(CauHinh.sc.nextLine());
                            gv = dsgv.timKiemGiangVien(ma);
                            String ten = "";
                            if (gv == null) {
                                System.out.print("Nhap ten Giang vien: ");
                                ten = CauHinh.sc.nextLine();
                                gv = new GiangVien(ma, ten);
                            }
                            dc.setMonHoc(h);
                            dc.setGv(gv);
                            gv.themDcGv(dc);
                            h.themDc(dc);
                            dsmh.themMh(h);
                            dsgv.themGv(gv);
                            dsdc.themDc(dc);
                         
                            break;
                        } else if (x == 2) {
                            System.out.print("Nhap vao ma mon hoc can tao de cuong: ");
                            int ma = Integer.parseInt(CauHinh.sc.nextLine());
                            MonHoc h1 = dsmh.timKiemMh(ma);
                            if (h1 == null) {
                                System.out.println("Khong tim thay ma mon hoc \n");
                                System.out.println("Khong the tao mon hoc\n");
                            } else {
                                System.out.println("\n=== Nhap De cuong mon hoc ===\n");
                                dc.nhapDeCuong();
                                System.out.print("Nhap ma Giang Vien : ");
                                int ma1 = Integer.parseInt(CauHinh.sc.nextLine());
                                gv = dsgv.timKiemGiangVien(ma1);
                                String ten = "";
                                if (gv == null) {
                                    System.out.print("Nhap ten Giang vien: ");
                                    ten = CauHinh.sc.nextLine();
                                    gv = new GiangVien(ma1, ten);
                                    dsgv.themGv(gv);
                                }
                                HeDaoTao hdt = dc.getHdt();
                                List<DeCuong> d = h1.getDsDeCuong();
                                if (d.size() >= 2) {
                                    System.out.println("Khong the tao de Cuong");
                                } else {
                                    for (DeCuong d1 : d) {
                                        if (!d1.getHdt().equals(hdt)) {
                                            System.out.println("=== Tao de cuong thanh cong ===");

                                            dc.setMonHoc(h1);

                                            dc.setGv(gv);
                                            gv.themDcGv(dc);
                                            dsdc.themDc(dc);
                                            h1.themDc(dc);
                                            

                                            break;
                                        } else {

                                            System.out.println("Mon hoc cung he dao tao khong the co 2 de cuong");
                                            System.out.println("---- Nhap lai he dao tao ----");
                                            System.out.printf("Nhap he dao tao\n1 - Chinh quy\n2 - Lien Thong\n");
                                            dc.setHdt(HeDaoTao.getHDT(Integer.parseInt(CauHinh.sc.nextLine())));
                                            if (d1.getHdt().equals(dc.getHdt())) {
                                                System.out.println("Tao de Cuong That Bai");
                                                break;
                                            } else {
                                                System.out.println("Tao De Cuong Thanh Cong");
                                            }
                                        }
                                    }
                                    break;
                                }
                            }

                        }
                    } while (true);
                }

                case 2 -> {
                    System.out.println(
                            "============== Chuc Nang: Cap Nhap Thong Tin De Cuong ================");
                    int ma;
                    int choice = 0;
                    do {
                        System.out.print("Nhap ma mon hoc can sua thong tin : ");
                        ma = Integer.parseInt(CauHinh.sc.nextLine());
                        MonHoc mh0 = dsmh.timKiemMh(ma);
                        if (mh0 == null) {
                            System.out.println("Khong tim thay mon hoc ");
                            System.out.print("Nhap lai ma mon hoc : ");
                        } else {
                            mh0.hienThi();
                            System.out.printf("\nNhap he dao tao\n1 - Chinh quy\n2 - Lien Thong\n");
                            HeDaoTao hdt = HeDaoTao.getHDT(Integer.parseInt(CauHinh.sc.nextLine()));
                            DeCuong dc0 = mh0.timKiemDeCuong(hdt);
                            if (dc0 == null) {
                                System.out.println("Khong tim thay De cuong ");
                            } else {

                                do {
                                    menuXuaThongTin();
                                    choice = Integer.parseInt(CauHinh.sc.nextLine());
                                    switch (choice) {
                                        case 1 -> {
                                            System.out.print("Sua noi dung mon hoc : ");
                                            dc0.setNoiDungMh(CauHinh.sc.nextLine());
                                        }
                                        
                                        case 2 -> {
                                            System.out.print("Nhap ma mon tien quyet can them: ");
                                            int maMonTienQuyet = Integer.parseInt(CauHinh.sc.nextLine());
                                            MonHoc mhThem = dsmh.timKiemMh(maMonTienQuyet);
                                            if (mhThem != null) {
                                                MonHoc monTienQuyet = mhThem.timKiemMhTienQuyet(maMonTienQuyet);
                                                if (monTienQuyet == null) {
                                                    mh0.themMhTienQuyet(monTienQuyet);
                                                    System.out.println("Them mon tien quyet thanh cong.");
                                                    mh0.hienThiMhTienQuyet();
//                                                    return;
                                                } else {
                                                    System.out.println(
                                                            "Mon hoc da co trong danh sach mon hoc tien quyet");
                                                }
                                            }
                                        }

                                        case 3 -> {
                                            System.out.print("Nhap ma mon tien quyet can xoa: ");
                                            int maMonTienQuyet = Integer.parseInt(CauHinh.sc.nextLine());
                                            MonHoc mhThem = dsmh.timKiemMh(maMonTienQuyet);
                                            if (mhThem != null) {
                                                MonHoc monTienQuyet = mhThem.timKiemMhTienQuyet(maMonTienQuyet);
                                                if (monTienQuyet == null) {
                                                    mh0.xoaMhTienQuyet(monTienQuyet);
                                                    System.out.println("Xoa mon tien quyet thanh cong.");
                                                    mh0.hienThiMhTienQuyet();
                                                } else {
                                                    System.out.println(
                                                            "Mon hoc da co trong danh sach mon hoc tien quyet");
                                                }
                                            }
                                        }

                                        case 4 -> {
                                            System.out.print("Nhap ma mon Hoc Truoc can them: ");
                                            int maMonHocTruoc = Integer.parseInt(CauHinh.sc.nextLine());
                                            MonHoc mhThem = dsmh.timKiemMh(maMonHocTruoc);
                                            if (mhThem != null) {
                                                MonHoc MonHocTruoc = mhThem.timKiemMhTruoc(maMonHocTruoc);
                                                if (MonHocTruoc == null) {
                                                    mh0.themMhTruoc(mhThem);
                                                    System.out.println("Them mon hoc truoc thanh cong.");
                                                    mh0.hienThiMhTruoc();
                                                } else {
                                                    System.out.println("Mon hoc da co trong danh sach mon hoc truoc ");
                                                }
                                            }
                                        }

                                        case 5 -> {
                                            System.out.print("Nhap ma mon Hoc Truoc can xoa: ");
                                            int maMonHocTruoc = Integer.parseInt(CauHinh.sc.nextLine());
                                            MonHoc mhThem = dsmh.timKiemMh(maMonHocTruoc);
                                            if (mhThem != null) {
                                                MonHoc monHocTruoc = mhThem.timKiemMhTruoc(maMonHocTruoc);
                                                if (monHocTruoc == null) {
                                                    mh0.xoaMhTruoc(mhThem);
                                                    System.out.println("Xoa mon truoc thanh cong.");
                                                    mh0.hienThiMhTruoc();
                                                } else {
                                                    System.out.println("Mon hoc da co trong danh sach mon hoc Truoc");
                                                }
                                            }
                                        }

                                        case 6 -> {
                                            System.out.print("Nhap ten hinh thuc danh gia moi: ");
                                            String tenHinhThucMoi = CauHinh.sc.nextLine();
                                            System.out.print("Nhap mo ta hinh thuc danh gia moi: ");
                                            String moTaHinhThucMoi = CauHinh.sc.nextLine();
                                            HinhThucDanhGia htdgMoi = new HinhThucDanhGia(tenHinhThucMoi,
                                                    moTaHinhThucMoi);

                                            System.out.print("Nhap thu tu cot diem de them hinh thuc danh gia : ");
                                            int a = Integer.parseInt(CauHinh.sc.nextLine());
                                            List<CotDiem> c = dc0.getDsCotDiem();
                                            int i;
                                            for (i = 0; i < c.size(); i++) {
                                                if (i == a - 1) {
                                                    c.get(i).themHTDG(htdgMoi);
                                                    for (CotDiem e : dc0.getDsCotDiem()) {
                                                        e.hienthi();
                                                    }
                                                    System.out.println("Them Hinh thuc danh gia thanh cong");
                                                    break;
                                                }
                                            }
                                            if (i >= c.size()) {
                                                System.out.println("Them Hinh thuc THAT BAI (Error) ");
                                            }
                                        }

                                        case 7 -> {
                                            System.out.println("Xoa hinh thuc danh gia: ");
                                            System.out.print("Nhap ten hinh thuc danh gia: ");
                                            String tenHinhThucMoi = CauHinh.sc.nextLine();
                                            System.out.print("Nhap mo ta hinh thuc danh gia: ");
                                            String moTaHinhThucMoi = CauHinh.sc.nextLine();

                                            HinhThucDanhGia htdgMoi = new HinhThucDanhGia(tenHinhThucMoi,
                                                    moTaHinhThucMoi);

                                            List<CotDiem> c = dc0.getDsCotDiem();
                                            int i = 0;
                                            for (i = 0; i < c.size(); i++) {
                                                List<HinhThucDanhGia> h = c.get(i).getHinhThuc();
                                                int j = 0;
                                                for (j = 0; j < h.size(); j++) {
                                                    if (h.get(j).equals(htdgMoi)) {
                                                        c.get(i).xoaHTDG(htdgMoi);
                                                        for (CotDiem e : dc0.getDsCotDiem()) {
                                                            e.hienthi();
                                                        }
                                                        System.out.println("Xoa hinh thuc danh gia thanh cong");
                                                        break;
                                                    }
                                                }
                                            }

                                            if (c.size() <= i) {
                                                System.out.println("khong the xoa hinh thuc danh gia");
                                            }

                                        }

                                        case 0 -> {
                                            System.out.println("----------------- Thoat chinh sua de cuong ---------------------");
                                        }

                                        default ->
                                            System.out.println("Nhap sai vui long nhap lai");
                                    }
                                } while (choice != 0);
                            }
                        }

                    } while (choice != 0);

                }

                case 3 -> {
                    int x;
                    do {
                        System.out.println(
                                "========================= Chuc Nang: Tim kiem mon hoc=========================");
                        System.out.printf(
                                "1 - Tim Kiem theo ma Mon hoc\n2 - Tim Kiem theo ten\n0 - Thoat\nMoi ban chon: ");
                        x = Integer.parseInt(CauHinh.sc.nextLine());
                        switch (x) {
                            case 1 -> {
                                System.out.print("Nhap Ma Mon Hoc Can Tim Kiem: ");
                                MonHoc mh0 = dsmh.timKiemMh(Integer.parseInt(CauHinh.sc.nextLine()));
                                if (mh0 == null) {
                                    System.out.println("Khong tim thay Mon hoc nao co ma " + x);
                                } else {
                                    System.out.println("----------------- Tim Thay mon hoc -------------------");
                                    mh0.hienThi();
                                }
                            }

                            case 2 -> {
                                System.out.print("Nhap ten mon hoc can tim: ");
                                List<MonHoc> mh0 = dsmh.timKiemMh(CauHinh.sc.nextLine());
                                if (mh0.isEmpty()) {
                                    System.out.println("Khong tim thay mon hoc!");
                                } else {
                                    System.out.println("--- Danh sach mon hoc can tim");
                                    mh0.forEach(a -> a.hienThi());
                                }
                            }
                            case 0 ->
                                System.out.println("-------------- Thoat chuc nang tim kiem -------------------");
                            default -> {
                                System.out.println("Nhap sai vui long nhap lai!");
                            }
                        }
                    } while (x != 0);
                }

                case 4 -> {
                    System.out.println(
                            "=== Chuc Nang: Xac dinh danh sach mon hoc (Theo Ma Mon Hoc) ma no la mon hoc truoc hoac"
                            + " mon hoc tien quyet cua mon khac trong danh sach ===");
                    System.out.printf("1 - Xac dinh theo mon hoc truoc\n2 - Xac dinh theo mon tien quyet\n0 - Thoat\n");
                    System.out.print("Moi Ban chon: ");
                    int t = Integer.parseInt(CauHinh.sc.nextLine());
                    switch (t) {
                        case 1 -> {
                            System.out.print("Nhap ma mon hoc ma ban muon kiem tra: ");
                            int mamhTruoc = Integer.parseInt(CauHinh.sc.nextLine());

                            List<MonHoc> dsMhsauMhTruoc = dsmh.timMonHocTruocTheoMa(mamhTruoc);

                            if (!dsMhsauMhTruoc.isEmpty()) {
                                System.out.println("ma mon hoc " + mamhTruoc + " la mon hoc truoc cua cac mon hoc: ");
                                for (MonHoc mh : dsMhsauMhTruoc) {
                                    System.out.println("- " + mh.getTenMh());
                                }
                            } else {
                                System.out.println(
                                        "ma mon hoc " + mamhTruoc + " Khong la mon hoc truoc cua cac mon khac.");
                            }

                        }

                        case 2 -> {
                            System.out.print("Nhap ma mon hoc ma ban muon kiem tra: ");
                            int mamhTruoc = Integer.parseInt(CauHinh.sc.nextLine());

                            List<MonHoc> dsMhTienQuyet = dsmh.timMonTienQuyetTheoMa(mamhTruoc);

                            if (!dsMhTienQuyet.isEmpty()) {
                                System.out.println(
                                        "ma mon hoc " + mamhTruoc + " la mon hoc tien quyet cua cac mon hoc: ");
                                for (MonHoc mh : dsMhTienQuyet) {
                                    System.out.println("- " + mh.getTenMh());
                                }
                            } else {
                                System.out.println(
                                        "ma mon hoc " + mamhTruoc + " Khong la mon hoc tien quyet cua cac mon khac.");
                            }

                        }

                        default ->
                            System.out.println("Nhap sai vui long nhap lai");
                    }

                    // System.out.print("Nhap vao ma mon hoc : ");
                    // MonHoc mh0 = dsmh.timKiemMh(Integer.parseInt(CauHinh.sc.nextLine()));
                    // if (mh0 == null) {
                    // System.out.println("Khong tim thay mon hoc ");
                    // } else {
                    // System.out.println("--- Danh sach mon hoc truoc ---");
                    // mh0.hienThiMhTruoc();
                    // System.out.println("--- Danh Sach Mon hoc tien quet ---");
                    // mh0.hienThiMhTienQuyet();
                    // }
                }

                case 5 -> {
                    System.out.println("=========== Sap xep de cuong giam dan theo tin chi =============");
                    dsdc.sapXep();
                    dsdc.hienThiSapXep();
                    // dsdc.hienThiDsDeCuong();
                }

                case 6 -> {
                    System.out.println(
                            "================= Xac dinh danh sach de cuong giang vien chiu trach nhiem =================");
                    System.out.print("Nhap ma giang vien muon tim kiem danh sach de cuong: ");
                    GiangVien gv0 = dsgv.timKiemGiangVien(Integer.parseInt(CauHinh.sc.nextLine()));
                    if (gv0 == null) {
                        System.out.println("Khong tim thay ma Giang vien ");
                    } else {
                        System.out.println("Tim Thay Giang Vien ");
                        if (gv0.getDcGv().isEmpty()) {
                            System.out.println("Giang Vien Khong Phu trach De Cuong");
                        } else {
                            System.out.println("--------------- Danh Sach de Cuong Giang Vien -------------------");
                            gv0.getDcGv().forEach(x -> x.hienThi());
                        }
                    }
                }

                case 7 -> {
                    System.out.println("================== Xuat De Cuong Hoan Chinh =====================");
                    int luachon;
                    do {
                        System.out.println("--------------------------------------------");
                        System.out.println("1. Hien thi de cuong theo ma mon hoc.");
                        System.out.println("2. Hien thi toan bo danh sach de cuong.");
                        System.out.println("0. Thoat");
                        System.out.print("Bam chon: ");
                        luachon = Integer.parseInt(CauHinh.sc.nextLine());
                        switch (luachon) {
                            case 1 -> {
                                System.out.print("Nhap ma mon hoc muon hien thi de cuong: ");
                                int maMh = Integer.parseInt(CauHinh.sc.nextLine());

                                MonHoc monHocChon = dsmh.timKiemMh(maMh);
                                if (monHocChon != null) {
                                    List<DeCuong> dsDeCuong = monHocChon.getDsDeCuong();
                                    for (DeCuong deCuong : dsDeCuong) {
                                        deCuong.hienThi();
                                    }
                                } else {
                                    System.out.println("Khong tim thay mon hoc ma: " + maMh);
                                }

                            }
                            case 2 -> {
                                System.out.println("============ Hien thi toan bo danh sach de cuong =========");
                                dsdc.hienThiDsDeCuong();
                            }
                            case 0 -> {
                                System.out.println("---------- Thoat hien thi danh sach de cuong --------");
                            }
                            default -> {
                                System.out.println("Nhap sai, vui long nhap lai.");
                            }
                        }

                    } while (luachon != 0);
                }

                case 8 -> {
                    System.out.println("======== Thong Ke So Luong De Cuong Theo So Tin Chi ============");
                    dsmh.thongKeTheoSoTinChi();
                }

                case 0 -> {
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    System.out.println("Hen Gap Lai Ban Vao Lan Sau...");
                    return;
                }

                default ->
                    System.out.println("Chuc nang khong hop le. Vui long chon lai.");
            }

        } while (true);
    }
}
