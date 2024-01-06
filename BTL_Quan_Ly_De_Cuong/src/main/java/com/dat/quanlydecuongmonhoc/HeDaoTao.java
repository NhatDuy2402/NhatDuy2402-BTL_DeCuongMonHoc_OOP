package com.dat.quanlydecuongmonhoc;

public enum HeDaoTao {

    CHINH_QUY(1),
    LIEN_THONG(2);
    private int flag;

    private HeDaoTao(int flag) {
        this.flag = flag;
    }

    public static HeDaoTao getHDT(int f) {
        for (HeDaoTao h : HeDaoTao.values()) {
            if (f == h.flag) {
                return h;
            }
        }
        return null;
    }
}
