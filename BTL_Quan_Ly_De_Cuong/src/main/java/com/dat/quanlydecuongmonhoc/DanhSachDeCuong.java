package com.dat.quanlydecuongmonhoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DanhSachDeCuong {

    private List<DeCuong> dsdc = new ArrayList<>();

    public void themDc(DeCuong... dc) {
        this.dsdc.addAll(Arrays.asList(dc));
    }

    public void xoaDc(DeCuong... dc) {
        this.dsdc.removeAll(Arrays.asList(dc));
    }

    public void sapXep() {
        this.dsdc.sort(
                Comparator.<DeCuong, Integer>comparing(dc -> dc.getMonHoc().getSoTinChi(), Comparator.reverseOrder())
                        .thenComparing(dc -> dc.getMonHoc().getMaMh())
        );
    }

//    public void sapXep(int f) {
//        this.dsdc.sort((d1, d2) -> {
//            int e = d1.getMonHoc().getSoTinChi() - d2.getMonHoc().getSoTinChi();
//            if (e == 0) {
//                int t = d1.getMonHoc().getMaMh() - d2.getMonHoc().getMaMh();
//                return t > 0 ? 1 : t < 0 ? -1 : 0;
//            }
//            return e > 0 ? 1 : e < 0 ? -1 : 0;
//        });
//    }
 
    public void hienThiSapXep() {
       int[] i = {0};
        for (DeCuong dc : dsdc) {
            System.out.println("======================= De Cuong thu " +  (i[0] + 1)+ " ==========================");
            dc.hienThiSapXep();
            i[0]++;
        }
    }

    public DeCuong timKiemDcTheoTen(String tenMonHoc) {
        for (DeCuong dc : dsdc) {
            if (dc.getMonHoc().getTenMh().equalsIgnoreCase(tenMonHoc)) {
                return dc;
            }
        }
        return null;
    }

    public void hienThiDsDeCuong() {
        int[] i = {0};
        this.dsdc.forEach(s -> {
           
            System.out.printf("======================= De Cuong thu " +(i[0] + 1) + " ==========================\n");
            s.hienThi();
              i[0]++;
        });
    }

    public void hienThiDsTenDeCuong() {
        for (DeCuong deCuong : this.dsdc) {
            System.out.println("\n===============================================");
            System.out.println("Ma Mon Hoc: " + deCuong.getMonHoc().getMaMh());
            System.out.println("Ten Mon Hoc: " + deCuong.getMonHoc().getTenMh());
            System.out.println("So Tin Chi: " + deCuong.getMonHoc().getSoTinChi());

        }
    }
    
    

    /**
     * @return the dsdc
     */
    public List<DeCuong> getDsdc() {
        return dsdc;
    }

    /**
     * @param dsdc the dsdc to set
     */
    public void setDsdc(List<DeCuong> dsdc) {
        this.dsdc = dsdc;
    }

}
