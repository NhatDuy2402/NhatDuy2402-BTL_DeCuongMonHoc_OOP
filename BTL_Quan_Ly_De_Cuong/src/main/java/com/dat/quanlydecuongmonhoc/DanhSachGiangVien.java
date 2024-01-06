/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dat.quanlydecuongmonhoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author PHAT
 */
public class DanhSachGiangVien {
    private List<GiangVien> dsgv = new ArrayList<>();

    
    public void themGv(GiangVien... gv){
        this.dsgv.addAll(Arrays.asList(gv));
    }
    
    public void xoaGv(GiangVien... gv){
        this.dsgv.removeAll(Arrays.asList(gv));
    }
    
    public GiangVien timKiemGiangVien(int ma){
        try {
            return this.dsgv.stream().filter(x -> x.getMaGv() == ma).findFirst().get();
        } catch (Exception e) {
            return null;
        }
 
            
    }
    /**
     * @return the dsgv
     */
    public List<GiangVien> getDsgv() {
        return dsgv;
    }

    /**
     * @param dsgv the dsgv to set
     */
    public void setDsgv(List<GiangVien> dsgv) {
        this.dsgv = dsgv;
    }
    
    
}
