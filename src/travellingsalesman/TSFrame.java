/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesman;

import java.awt.Adjustable;
import java.awt.event.ActionEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.LayoutStyle;

/**
 *
 * @author ASUS
 */
public class TSFrame extends javax.swing.JFrame {

    private final TravellingSalesman Greedy;
    private final TravellingSalesman Uninform;
    private final TravellingSalesman AStar;
    private int i = 0;

    /////////////////////////////////////////////
    private javax.swing.JButton jButton1; // NEXT STATE
    private javax.swing.JButton jButton2; // UNFORMED
    private javax.swing.JButton jButton3; // GREEDY
    private javax.swing.JButton jButton4; //A*
    private javax.swing.JLabel jLabel1; // Title
    private javax.swing.JLabel jLabel0;
    private javax.swing.JLabel jLabel2; // 
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.ImageIcon jImage1;
    private javax.swing.JButton jButton5;
    private javax.swing.JTextArea jText1;
    private javax.swing.JScrollPane Scroll;
    private String goalSeq = "";

    public TSFrame() {

        initComponents();
        setLocationRelativeTo(null);
        //setSize(780, 970);
        jButton1.setVisible(false);
        fillStates();
        Scroll.setAutoscrolls(true);
        Scroll.setBounds(100, 100, 50, 100);
        Scroll.setEnabled(true);
        Scroll.setVisible(true);

        Greedy = new TravellingSalesman();
        Uninform = new TravellingSalesman();
        AStar = new TravellingSalesman();

    }

    private final TreeMap<String, String> state = new TreeMap();

    private void fillStates() {
        
        /////////////////////////////////////
        // KSA
        state.put("Map", "Map.png");
        state.put("J", "ksa.png");
        state.put("JM", "ksa-jm.png");
        state.put("JMT", "ksa-jmt.png");
        state.put("JMTM", "ksa-jmtm.png");
        state.put("JMTMA", "ksa-jmtma.png");
        state.put("JMTMAJ", "ksa-jmtmaj.png");
        state.put("JMTMAJN", "ksa-jmtmajn.png");
        state.put("JMTMAJNQ", "ksa-jmtmajnq.png");
        state.put("JMTMAJNQH", "ksa-jmtmajnqh.png");
        state.put("JMTMAJNQHT", "ksa-jmtmajnqht.png");
        state.put("JMTMAJNQHTR", "ksa-jmtmajnqhtr.png");
        state.put("JMTMAJNQHTRD", "ksa-jmtmajnqhtrd.png");
        state.put("JMTMAJNQHTRDJ", "ksa-jmtmajnqhtrdj.png");

        ///////////////////////////////////////////////
        //Turkey
        state.put("T", "T.png");
        state.put("I", "T.png");
        state.put("IB", "T-IB.png");
        state.put("IBC", "T-IBC.png");
        state.put("IBCP", "T-IBCP.png");
        state.put("IBCPA", "T-IBCPA.png");
        state.put("IBCPAK", "T-IBCPAK.png");
        state.put("IBCPAKK", "T-IBCPAKK.png");
        state.put("IBCPAKKA", "T-IBCPAKKA.png");
        state.put("IBCPAKKAC", "T-IBCPAKKAC.png");
        state.put("IBCPAKKACI", "T-IBCPAKKACI.png");
        state.put("IBA", "T-IBA.png");
        state.put("IBAC", "T-IBAC.png");
        state.put("IBACK", "T-IBACK.png");
        state.put("IBACKA", "T-IBACKA.png");
        state.put("IBACKAP", "T-IBACKAP.png");
        state.put("IBACKAPK", "T-IBACKAPK.png");
        state.put("IBACKAPKC", "T-IBACKAPKC.png");
        state.put("IBACKAPKCI", "T-IBACKAPKCI.png");
        
        /////////////////////////////////////////////////
        //Australia
        state.put("AUS", "AUS.png");
        state.put("AM", "AUS-AM.png");
        state.put("AMC", "AUS-AMC.png");
        state.put("AMCS", "AUS-AMCS.png");
        state.put("AMCSA", "AUS-AMCSA.png");
        state.put("AMCSAB", "AUS-AMCSAB.png");
        state.put("AMCSABC", "AUS-AMCSABC.png");
        state.put("AMCSABCP", "AUS-AMCSABCP.png");
        state.put("AMCSABCPD", "AUS-AMCSABCPD.png");
        state.put("AMCSABCPDA", "AUS-AMCSABCPDA.png");
        state.put("AMCSB", "AUS-AMCSB.png");
        state.put("AMCSBC", "AUS-AMCSBC.png");
        state.put("AMCSBCA", "AUS-AMCSBCA.png");
        state.put("AMCSBCAD", "AUS-AMCSBCAD.png");
        state.put("AMCSBCADP", "AUS-AMCSBCADP.png");
        state.put("AMCSBCADPA", "AUS-AMCSBCADPA.png");
        ////////////////////////////////////////////////////////

    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel(); 
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Scroll = new javax.swing.JScrollPane();
        jText1 = new javax.swing.JTextArea();

        //////////////////////////////////////////////////
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Travelling Salesman");
        setBackground(new java.awt.Color(255, 255, 255));

        ///////////////////////////////////////////////////////////
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 40));
        jLabel1.setForeground(new java.awt.Color(43, 24, 50));
        jLabel1.setText("Travelling Salesman");
        jLabel2.setSize(1000, 1000);
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jLabel7.setText("Select (KSA , Turkey , Australia) ");
        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jButton3.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jButton4.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jText1.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jText1.setBounds(250, 250, 200, 2);

        ////////////////////////////////////////////////////////////
        jButton1.setText("Next Move");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }

        });
        jButton2.setText("Uninform cost");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton2ActionPerformed(evt);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TSFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        jButton3.setText("Greedy");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton3ActionPerformed(evt);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TSFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        jButton4.setText("A*");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton4ActionPerformed(evt);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TSFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        ///////////////////////////////////////////////////////////////
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("Map.png"))); 

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 212, javax.swing.GroupLayout.DEFAULT_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(100, 100, 100)
                                                        .addComponent(jButton2)
                                                        .addGap(20, 20, 20)
                                                        .addComponent(jButton3)
                                                        .addGap(20, 20, 20)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.SIZE)
                                                        .addComponent(jButton4))))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(205, 205, 205)
                                        .addComponent(jLabel7)
                                )
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(220, 220, 220)
                                        .addComponent(jText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, 300))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(170, 170, 170)
                                        .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, javax.swing.GroupLayout.DEFAULT_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(108, 108, 108))
                .addComponent(Scroll)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2)
                                .addComponent(jButton3)
                                .addComponent(jButton4)
                        )
                        .addComponent(jLabel7)
                        .addComponent(jText1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, javax.swing.GroupLayout.DEFAULT_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGap(100, 100, 100)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGap(28, 28, 28))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                .addComponent(Scroll)
        );

        jButton1.getAccessibleContext().setAccessibleName("");
        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {

        if (jButton1.getText().equalsIgnoreCase("Back")) {
            jButton1.setVisible(false);
            jLabel2.setText("");
            jLabel5.setText("");
            jText1.setVisible(true);
            jLabel7.setVisible(true);
            jText1.setText("");
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("Map.png")));
        } else {
            jButton1.setText("Next Move");
            if (i == 0) {
                if (jText1.getText().equalsIgnoreCase("KSA")) {
                    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("ksa.png")));
                } else if (jText1.getText().equalsIgnoreCase("Turkey")) {
                    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("T.png")));
                } else if (jText1.getText().equalsIgnoreCase("Australia")) {
                    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("AUS.png")));
                }
                jLabel2.setText("Sequence of moves to goal: " + goalSeq);
                jLabel5.setText("Number of cites explored: " + TravellingSalesman.numberOfExpand);

            } else if (goalSeq.length() != 0 && goalSeq.length() > i) {

                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(state.get(goalSeq.substring(0, i + 1)))));
                if (i == goalSeq.length() - 1) {
                    jButton1.setText("Finished");

                }

            } else if (i == goalSeq.length()) {
                jButton1.setVisible(false);
                jLabel2.setText("");
                jLabel5.setText("");
                jText1.setVisible(true);
                jLabel7.setVisible(true);
                jText1.setText("");
                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("Map.png")));
            }
            i++;
        }
    }

    private void jButton2ActionPerformed(ActionEvent evt) throws FileNotFoundException {
        goalSeq = "";
        jText1.setVisible(false);
        jLabel7.setVisible(false);
        if (jText1.getText().equalsIgnoreCase("KSA")) {
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("ksa.png")));
        } else if (jText1.getText().equalsIgnoreCase("Turkey")) {
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("T.png")));
        } else if (jText1.getText().equalsIgnoreCase("Australia")) {
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("AUS.png")));
        } else {
            jLabel2.setText("Unvailed input");
        }

        if (jText1.getText().equalsIgnoreCase("KSA")) {
            jLabel2.setText("This algorithm can't handle a huge input data for this problem");
            jButton1.setVisible(true);
            jButton1.setText("Back");
        } else {
            String TravellingList = Uninform.UuniformCostSearch(jText1.getText().toUpperCase());
            String[] TravellingCity = TravellingList.split("-");

            for (int i = TravellingCity.length - 1; i >= 0; i--) {

                goalSeq = goalSeq + (TravellingCity[i]).charAt(0);
            }
            jButton1.setVisible(true);
            jButton1.setText("Start");
            i = 0;
        }
    }

    private void jButton3ActionPerformed(ActionEvent evt) throws FileNotFoundException {
        goalSeq = "";
        jText1.setVisible(false);
        jLabel7.setVisible(false);
        if (jText1.getText().equalsIgnoreCase("KSA")) {
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("ksa.png")));
        } else if (jText1.getText().equalsIgnoreCase("Turkey")) {
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("T.png")));
        } else if (jText1.getText().equalsIgnoreCase("Australia")) {
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("AUS.png")));
        } else {
            jLabel2.setText("Unvailed input");
        }

        ArrayList<City> TravellingList = Greedy.GreedySearch(jText1.getText().toUpperCase());
        Object[] TravellingCity = TravellingList.toArray();

        for (int i = 0; i < TravellingCity.length; i++) {

            goalSeq = goalSeq + ((City) TravellingCity[i]).getLebal().charAt(0);
        }

        jButton1.setVisible(true);
        jButton1.setText("Start");
        i = 0;

    }

    private void jButton4ActionPerformed(ActionEvent evt) throws FileNotFoundException {
        goalSeq = "";
        jText1.setVisible(false);
        jLabel7.setVisible(false);
        if (jText1.getText().equalsIgnoreCase("KSA")) {
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("ksa.png")));
        } else if (jText1.getText().equalsIgnoreCase("Turkey")) {
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("T.png")));
        } else if (jText1.getText().equalsIgnoreCase("Australia")) {
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("AUS.png")));
        } else {
            jLabel2.setText("Unvailed input");

        }

        if (jText1.getText().equalsIgnoreCase("KSA")) {
            jLabel2.setText("This algorithm can't handle a huge input data for this problem");
            jButton1.setVisible(true);
            jButton1.setText("Back");
        } else {
            String TravellingList = AStar.Astar(jText1.getText().toUpperCase());
            String[] TravellingCity = TravellingList.split("-");
            for (int i = TravellingCity.length - 1; i >= 0; i--) {

                goalSeq = goalSeq + (TravellingCity[i]).charAt(0);
            }

            jButton1.setVisible(true);
            jButton1.setText("Start");
            i = 0;
        }
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {

            java.util.logging.Logger.getLogger(TSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TSFrame().setVisible(true);
            }
        }
        );
    }
}
