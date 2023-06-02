/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.market;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Nghiem Quynh
 */
public class HomeForm extends javax.swing.JPanel {

    static info info;
    static theXP theXP;
    private Boolean input = false;
    private boolean cardready = false;
    private boolean connected = false;
    public byte[] rsaPubKey = new byte[128];
    String ht;
    int sd;

    /**
     * Creates new form Home
     */
    public HomeForm() {
        info = new info();
        theXP = new theXP();
        initComponents();
    }

    public void setCommandAPDU(byte[] cmnds, byte lc, byte[] data, byte le) {
        txt_cla.setText(theXP.byteToHex(cmnds[0]));
        txt_ins.setText(theXP.byteToHex(cmnds[1]));
        txt_p1.setText(theXP.byteToHex(cmnds[2]));
        txt_p2.setText(theXP.byteToHex(cmnds[3]));
        txt_lc.setText(theXP.byteToHex(lc));
        //data
        String temp = "";
        for (int i = 0; i < data.length; i++) {
            temp += theXP.byteToHex(data[i]);
            temp += " ";
        }
        txt_cmd.setText(temp);
        txt_le.setText(theXP.byteToHex(le));
    }

    //hien thi apdu phan hoi len
    public void setResponseAPDU(byte[] datares, short le) {
        int status1 = theXP.resAPDU.getSW1();
        int status2 = theXP.resAPDU.getSW2();
        txt_sw1.setText(theXP.shorttoHex((short) status1));
        txt_sw2.setText(theXP.shorttoHex((short) status2));
        if (le != 0 && datares.length != 0) {
            //hien thi du lieu ra
            String temp = "";
            for (int i = 0; i < datares.length; i++) {
                temp += theXP.byteToHex(datares[i]);
                temp += " ";
            }
            txt_respon.setText(temp);
        }
    }

    public int check_pin(String pin) {
        short lc = (short) pin.length(); //do dai du lieu gui vao applet
        short le = 1;//du lieu nhan mong doi (Le)
        byte[] cmd = {(byte) 0xA0, (byte) 0x19, (byte) 0x00, (byte) 0x00};
        byte[] data = pin.getBytes();
        setCommandAPDU(cmd, (byte) lc, data, (byte) le);
        theXP.sendAPDUtoApplet(cmd, data);
        byte[] dataRes = theXP.resAPDU.getData();
        int lenRes = theXP.resAPDU.getNr();
        setResponseAPDU(dataRes, (byte) lenRes);
        //String a = new String(dataRes);
        if (dataRes[0] == (byte) 0x01) {//đúng mã PIN
            return 1;
        } else if (dataRes[0] == (byte) 0x00) {
            return 0;
        } else {
            return 2;
        }
    }

    public void MVlist() {
//        Main.connection.cnSQL("jdbc:mysql://localhost:3306/cinema", "root","");
//        String tvSQL2 = "select * from movies";
//        ResultSet rsdv = Main.connection.HienThongTin(tvSQL2);
//        System.out.println(rsdv);
//        Object[] obj = new Object[]{"STT","Mã Phim","Tên phim","Số ghế","Ngày chiếu","Phòng Chiếu","Giá vé"};
//        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
//        tblMovies.setModel(tableModel);
//        int c = 0;
//        try {
//            while (rsdv.next()) {
//                c++;
//                Object[] item = new Object[7];
//                item[0] = c;
//                item[1] = rsdv.getInt("id");
//                item[2] = rsdv.getString("name");
//                item[3] = rsdv.getInt("seat");
//                item[4] = rsdv.getString("date");
//                item[5] = rsdv.getInt("room");
//                item[6] = rsdv.getInt("price");
//                tableModel.addRow(item);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        txt_cla = new javax.swing.JTextField();
        txt_ins = new javax.swing.JTextField();
        txt_p1 = new javax.swing.JTextField();
        txt_p2 = new javax.swing.JTextField();
        txt_lc = new javax.swing.JTextField();
        txt_le = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        txt_sw1 = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        txt_sw2 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        txt_respon = new javax.swing.JTextField();
        Button_connect = new javax.swing.JButton();
        Button_Disconnect = new javax.swing.JButton();
        txt_cmd = new javax.swing.JTextField();
        btn_init = new javax.swing.JButton();
        Button_Unblock = new javax.swing.JButton();
        btn_sendata = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_sendata1 = new javax.swing.JButton();
        btn_sendata2 = new javax.swing.JButton();
        btn_sendata3 = new javax.swing.JButton();

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel68.setText("APDU Lệnh");

        jLabel69.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel69.setText("CLA");
        jLabel69.setToolTipText("");

        jLabel70.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel70.setText("INS");

        jLabel71.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel71.setText("P1");

        jLabel72.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel72.setText("P2");

        jLabel73.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel73.setText("LC");

        jLabel74.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel74.setText("LE");

        txt_cla.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        txt_cla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_claActionPerformed(evt);
            }
        });

        txt_ins.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N

        txt_p1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N

        txt_p2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        txt_p2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_p2ActionPerformed(evt);
            }
        });

        txt_lc.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N

        txt_le.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        txt_le.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_leActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel75.setText("Dữ liệu:");

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel78.setText("APDU phản hồi");

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setText("SW1");

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setText("SW2");

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel79.setText("Dữ liệu:");

        txt_respon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_responActionPerformed(evt);
            }
        });

        Button_connect.setText("Kết nối");
        Button_connect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Button_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_connectActionPerformed(evt);
            }
        });

        Button_Disconnect.setText("Ngắt kết nối");
        Button_Disconnect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Button_Disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_DisconnectActionPerformed(evt);
            }
        });

        btn_init.setText("Khởi tạo thẻ");
        btn_init.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_init.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_initActionPerformed(evt);
            }
        });

        Button_Unblock.setText("Mở khóa thẻ");
        Button_Unblock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Button_Unblock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_UnblockActionPerformed(evt);
            }
        });

        btn_sendata.setText("Gửi đến Applet");
        btn_sendata.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_sendata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendataActionPerformed(evt);
            }
        });

        btn_clear.setText("Xóa Thẻ");
        btn_clear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_sendata1.setText("Xem thông tin");
        btn_sendata1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_sendata1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendata1ActionPerformed(evt);
            }
        });

        btn_sendata2.setText("Mua hàng");
        btn_sendata2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_sendata2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendata2ActionPerformed(evt);
            }
        });

        btn_sendata3.setText("Nạp tiền vào thẻ");
        btn_sendata3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_sendata3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendata3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txt_cla, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_ins, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(152, 152, 152)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_sw1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(66, 66, 66)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_sw2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txt_p1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_p2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_lc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(86, 86, 86))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(338, 338, 338)
                                .addComponent(txt_le, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cmd, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btn_sendata, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_sendata1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_sendata3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Button_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_init, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Button_Disconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Button_Unblock, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_sendata2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txt_respon, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cla, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ins, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_p1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_p2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_lc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_le, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cmd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_sw1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sw2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_respon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Disconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_init, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Unblock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sendata, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sendata1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sendata2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_sendata3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_claActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_claActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_claActionPerformed

    private void txt_p2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_p2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_p2ActionPerformed

    private void txt_responActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_responActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_responActionPerformed

    private void Button_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_connectActionPerformed
        Main.connection.cnSQL("jdbc:mysql://localhost:3306/market", "root", "Bach682001");
        if (theXP.connectApplet() == true) {//thiet lap ket noi
            byte[] cmd = {(byte) 0x00, (byte) 0xA4, (byte) 0x04, (byte) 0x00};// select
            //mang data gui di la RID,PIX
            byte[] data = {(byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x00};
            byte lc = 6;
            byte le_expect = 2;
            setCommandAPDU(cmd, lc, data, le_expect);//hien thi apdu cmd
            theXP.sendAPDUtoApplet(cmd, data);
            byte[] dataRes = theXP.resAPDU.getData();
            int le = theXP.resAPDU.getNr();
            setResponseAPDU(dataRes, (short) le);//hien thi du lieu phan hoi tu applet
            Button_connect.setText("Đang kết nối...");
            Button_connect.setBackground(Color.green);
            Button_Disconnect.setText("Ngắt kết nối");
            Button_Disconnect.setBackground(Color.gray);
            MVlist();
            connected = true;
        } else
            JOptionPane.showMessageDialog(this, "Kết nối không thành công. Hãy thử lại.");
    }//GEN-LAST:event_Button_connectActionPerformed

    private void Button_DisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_DisconnectActionPerformed
        if (theXP.disconnectApplet() == true) {
            Button_connect.setText("Kết nối");
            Button_connect.setBackground(Color.gray);
            Button_Disconnect.setText("Đã ngắt kết nối");
            Button_Disconnect.setBackground(Color.red);
            txt_respon.setText("");
            txt_sw1.setText("");
            txt_sw2.setText("");
            txt_cmd.setText("");
            txt_cla.setText("");
            txt_ins.setText("");
            txt_p1.setText("");
            txt_p2.setText("");
            txt_lc.setText("");
            txt_le.setText("");
            connected = false;
            cardready = false;
        } else
            JOptionPane.showMessageDialog(this, "Ngắt kết nối không thành công.");
    }//GEN-LAST:event_Button_DisconnectActionPerformed

    private void btn_initActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_initActionPerformed
        if (connected == true) {
            if (input == false) {
                InfoInputForm initform = new InfoInputForm();
             
                initform.setVisible(true);
                initform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            } else {
                JOptionPane.showMessageDialog(null, "Thẻ đã có dữ liệu");
            }
        } else
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
    }//GEN-LAST:event_btn_initActionPerformed

    private void Button_UnblockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_UnblockActionPerformed
        if (connected == true) {
            byte[] cmd = {(byte) 0xA0, (byte) 0x20, (byte) 0x00, (byte) 0x00};
            byte[] data = {0};
            setCommandAPDU(cmd, (byte) 0, data, (byte) 0);//hien thi apdu cmd len GUI
            theXP.sendAPDUtoApplet(cmd);
            byte[] dataRes = theXP.resAPDU.getData();
            int le = theXP.resAPDU.getNr();
            setResponseAPDU(dataRes, (short) le);//hien thi du lieu phan hoi tu applet
            JOptionPane.showMessageDialog(null, "Thẻ đã được mở khóa.");
        } else
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
    }//GEN-LAST:event_Button_UnblockActionPerformed

    private void btn_sendataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendataActionPerformed
        if (connected == true) {
            if (input == false) {
                //chuyen du lieu xuong applet
                String sothe = info.getSothe();
                String hoten = info.getHoten();
                String ngaysinh = info.getNgaysinh();
               
                String pin = info.getPin();
                System.out.println("pin to apley0" + pin);
                String cmnd = info.getCmnd();
                String sdt = info.getSdt();
                String arraysend = sothe.concat(".").concat(hoten)
                        .concat(".").concat(ngaysinh)
                        .concat(".").concat(pin)
                        .concat(".").concat(sdt)
                        .concat(".").concat(cmnd);
                System.out.println("send:" + arraysend);
                int lc = arraysend.length();
                byte datalen = (byte) lc; //do dai du lieu gui vao applet
                System.out.println("length" + lc);
                byte[] cmd = {(byte) 0xA0, (byte) 0x10, (byte) 0x00, (byte) 0x00};
                byte[] data = arraysend.getBytes();
                setCommandAPDU(cmd, (byte) lc, data, (byte) 0);
                theXP.sendAPDUtoApplet(cmd, data);
                byte[] dataRes = theXP.resAPDU.getData();
                int le = theXP.resAPDU.getNr();
                setResponseAPDU(dataRes, (byte) le);//hien thi du lieu phan hoi tu applet
//                String tach = new String(dataRes);
//                System.out.print("a:" + tach);
//                String[] a = tach.split(":");
//                String st = a[0];
//                ht = a[1];
//                String ns = a[2];
//                byte[] cmd1 = {(byte) 0xA0, (byte) 0x21, (byte) 0x00, (byte) 0x00};
//                theXP.sendAPDUtoApplet(cmd1);
//                byte[] b = theXP.resAPDU.getData();
//                String sodu = "";
//                for (int i = 0; i < b.length; i++) {
//                    sodu += theXP.byteToHex(b[i]);
//                }
//                sd = Integer.valueOf(sodu,16).intValue();
//                txt_sodiem.setText(""+Integer.valueOf(sodu,16).intValue());
                input = true;
            } else {
                JOptionPane.showMessageDialog(null, "Thẻ đã có dữ liệu.");
            }
        } else
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
    }//GEN-LAST:event_btn_sendataActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        if (connected == true) {
            if (input == false) {
                JOptionPane.showMessageDialog(null, "Thẻ chưa có dữ liệu.");
            } else {
                byte[] cmd = {(byte) 0xA0, (byte) 0x18, (byte) 0x00, (byte) 0x00};
                byte[] data = {0};
                setCommandAPDU(cmd, (byte) 0, data, (byte) 0);//hien thi apdu cmd len GUI
                theXP.sendAPDUtoApplet(cmd);
                byte[] dataRes = theXP.resAPDU.getData();
                int le = theXP.resAPDU.getNr();
                setResponseAPDU(dataRes, (short) le);//hien thi du lieu phan hoi tu applet
                JOptionPane.showMessageDialog(null, "Thẻ đã xóa dữ liệu.");
                input = false;
            }
        } else
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
    }//GEN-LAST:event_btn_clearActionPerformed

    private void txt_leActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_leActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_leActionPerformed

    private void btn_sendata1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendata1ActionPerformed
        if (connected == true) {
            InfoForm initform = new InfoForm();
            initform.setVisible(true);
            initform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            initform.setData(info);
            System.out.println("name:"+initform.info.getHoten());
        } else
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
    }//GEN-LAST:event_btn_sendata1ActionPerformed

    private void btn_sendata2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendata2ActionPerformed
        if (connected == true) {
            ListForm initform = new ListForm();
            initform.setVisible(true);
            initform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            initform.setData();
        } else
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
    }//GEN-LAST:event_btn_sendata2ActionPerformed

    private void btn_sendata3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendata3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_sendata3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Disconnect;
    private javax.swing.JButton Button_Unblock;
    private javax.swing.JButton Button_connect;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_init;
    private javax.swing.JButton btn_sendata;
    private javax.swing.JButton btn_sendata1;
    private javax.swing.JButton btn_sendata2;
    private javax.swing.JButton btn_sendata3;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JTextField txt_cla;
    private javax.swing.JTextField txt_cmd;
    private javax.swing.JTextField txt_ins;
    private javax.swing.JTextField txt_lc;
    private javax.swing.JTextField txt_le;
    private javax.swing.JTextField txt_p1;
    private javax.swing.JTextField txt_p2;
    private javax.swing.JTextField txt_respon;
    private javax.swing.JTextField txt_sw1;
    private javax.swing.JTextField txt_sw2;
    // End of variables declaration//GEN-END:variables
}
