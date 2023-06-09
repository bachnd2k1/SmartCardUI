/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ZZ
 */
public class info {

    private String sothe, hoten, ngaysinh, pin, rank, cmnd, sdt;
    private byte[] avatar;

    public info(String sothe, String hoten, String ngaysinh, String pin, byte[] avatar, String rank) {
        this.sothe = sothe;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.pin = pin;
        this.avatar = avatar;
        this.rank = rank;
    }

    public info() {

    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

  
    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getSothe() {
        return sothe;
    }

    public void setSothe(String sothe) {
        this.sothe = sothe;
    }

    public String getHoten() {
        return hoten;
    }

    public String getRank() {
        return rank;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

}
