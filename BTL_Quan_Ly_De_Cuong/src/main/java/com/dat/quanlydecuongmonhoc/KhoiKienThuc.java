package com.dat.quanlydecuongmonhoc;

public enum KhoiKienThuc {

    CO_SO(1),
    CO_SO_NGANH(2),
    CHUYEN_NGANH(3);
    private int flag;

    private KhoiKienThuc(int flag) {
        this.flag = flag;
    }
    
    public static KhoiKienThuc getKKT(int f){
        for(KhoiKienThuc k: KhoiKienThuc.values()){
            if(f == k.flag)
                return k;
        }
        return null;
    }

}
