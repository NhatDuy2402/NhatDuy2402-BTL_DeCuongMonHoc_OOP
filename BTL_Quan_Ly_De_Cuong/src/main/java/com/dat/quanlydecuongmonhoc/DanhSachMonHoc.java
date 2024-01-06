package com.dat.quanlydecuongmonhoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DanhSachMonHoc {

    private List<MonHoc> dsmh = new ArrayList<>();

    public void themMh(MonHoc... mh) {
        this.dsmh.addAll(Arrays.asList(mh));
    }

    public MonHoc timKiemMh(int maMonHoc) {
        try {
            return this.dsmh.stream().filter(s -> s.getMaMh() == maMonHoc).findFirst().get();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<MonHoc> timMonHocTruocTheoMa(int maMonHoc){
        List<MonHoc> kq = new ArrayList<>();
        for(MonHoc h: this.dsmh){
            if(h.getMhTruoc().stream().anyMatch(x -> x.getMaMh() == maMonHoc)){
                kq.add(h);
            }
        }   
        return kq;
    }
    
    public List<MonHoc> timMonTienQuyetTheoMa(int maMonHoc){
        List<MonHoc> kq = new ArrayList<>();
        for(MonHoc h: this.dsmh){
            if(h.getMhTienQuyet().stream().anyMatch(x -> x.getMaMh() == maMonHoc)){
                kq.add(h);
            }
        }
        return kq;
    }

    public List<MonHoc> timKiemMh(String kw) {
        try {
            Class c = Class.forName(kw);
            return this.dsmh.stream().filter(s -> c.isInstance(s)).collect(Collectors.toList());
        } catch (ClassNotFoundException ex) {
            return this.dsmh.stream().filter(s -> s.getTenMh().contains(kw)).collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }

    
      public int timMaxSoTinChi() {
        int max = 0;
        for (int i = 0; i < this.dsmh.size(); i++) {
            if (max < this.dsmh.get(i).getSoTinChi()) {
                max = this.dsmh.get(i).getSoTinChi();
            }
        }
        return max;
    }

    public void thongKeTheoSoTinChi() {
        int soLuongDeCuong;
        int soTinChi;
        int n = this.timMaxSoTinChi();
        for (int i = 0; i <= n; i++) {
            soTinChi = i;
            soLuongDeCuong = 0;
            for (int j = 0; j < dsmh.size(); j++) {
                if (soTinChi == dsmh.get(j).getSoTinChi()) {
                    soLuongDeCuong += dsmh.get(j).getDsDeCuong().size();
                }
            }
            if (soLuongDeCuong > 0) {
            // System.out.println("So tin Chi: " + soTinChi);
            // System.out.println("So Luong De Cuong: " + soLuongDeCuong);
            // System.out.println("-------------------------------------");

                System.out.printf("|     So tin chi: %-10d|      So luong de cuong: %-9d|\n", soTinChi, soLuongDeCuong);
            }
        }
    }
   
            
            
    public void hienThidsMonHoc() {
        this.dsmh.forEach(s -> s.hienThi());
    }

    /**
     * @return the dsmh
     */
    public List<MonHoc> getDsmh() {
        return dsmh;
    }

    /**
     * @param dsmh the dsmh to set
     */
    public void setDsmh(List<MonHoc> dsmh) {
        this.dsmh = dsmh;
    }

}
