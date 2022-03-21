package View;

import Model.Monom;
import Model.Polinom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Calculator extends JFrame{

    private String pol1,pol2;
    private JLabel label0, label1, label2, label3,label7;
    private JTextField text1, text2, text3,text7;
    private JPanel pnl0, pnl1, pnl2, pnl3, pnl4, pnl5, pnl6, pnl12,pnl7,pnl47;
    private JButton btn1, btn2, btnadd, btnsub, btnclose,btnmul,btnder,btnreset,btnint,btndev;
    private Polinom<Monom> polinom1,polinom2,rezultat;


    public Calculator(){

        polinom1 = new Polinom<Monom>();
        polinom2 = new Polinom<Monom>();
        rezultat = new Polinom<Monom>();


        label0 = new JLabel("Calculator");
        pnl0 = new JPanel();
        pnl0.add(label0);
        pnl0.setBackground(Color.cyan);
        add(pnl0);

        label1 = new JLabel("Polinomul 1");
        text1 = new JTextField();
        text1.setMaximumSize( new Dimension(450,20) );
        pnl1 = new JPanel();
        btn1 = new JButton("Adauga");
        btn1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        String pol1 = text1.getText();
                        double coef,ptr;
                        Pattern p = Pattern.compile( "([x+-]?[^-+]+)" );
                        Matcher m = p.matcher( pol1 );
                        while(m.find()){
                            String termen=m.group(1);
                            if(termen.contains("x^")){
                                String nr[]=termen.split("x\\^");
                                coef=Integer.parseInt(nr[0]);
                                ptr=Integer.parseInt(nr[1]);
                                polinom1.add(new Monom(coef,ptr));
                            }
                            else{
                                ptr=0;
                                if(termen.contains("x")){
                                    termen=termen.replace("x","");
                                    ptr=1;
                                }
                                coef=Integer.parseInt(termen);
                                polinom1.add(new Monom(coef,ptr));
                            }
                        }
                    }

                });
        pnl1.setLayout(new BoxLayout(pnl1,BoxLayout.X_AXIS));
        pnl1.add(Box.createHorizontalStrut(20));
        pnl1.add(label1);
        pnl1.add(Box.createHorizontalStrut(20));
        pnl1.add(text1);
        pnl1.add(Box.createHorizontalStrut(20));
        pnl1.add(btn1);
        pnl1.add(Box.createHorizontalStrut(20));
        pnl1.setBackground(Color.blue);
        add(pnl1);

        label2 = new JLabel("Polinomul 2");
        text2 = new JTextField();
        text2.setMaximumSize( new Dimension(450,20) );
        pnl2 = new JPanel();
        btn2 = new JButton("Adauga");
        btn2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        String pol2 = text2.getText();
                        double coef,ptr;
                        Pattern p = Pattern.compile( "([x+-]?[^-+]+)" );
                        Matcher m = p.matcher( pol2 );
                        while(m.find()){
                            String termen=m.group(1);
                            if(termen.contains("x^")){
                                String nr[]=termen.split("x\\^");
                                coef=Integer.parseInt(nr[0]);
                                ptr=Integer.parseInt(nr[1]);
                                polinom2.add(new Monom(coef,ptr));
                            }
                            else{
                               ptr=0;
                               if(termen.contains("x")){
                                   termen=termen.replace("x","");
                                   ptr=1;
                               }
                                coef=Integer.parseInt(termen);
                                polinom2.add(new Monom(coef,ptr));
                            }
                        }
                    }
                });
        pnl2.setLayout(new BoxLayout(pnl2,BoxLayout.X_AXIS));
        pnl2.add(Box.createHorizontalStrut(20));
        pnl2.add(label2);
        pnl2.add(Box.createHorizontalStrut(20));
        pnl2.add(text2);
        pnl2.add(Box.createHorizontalStrut(20));
        pnl2.add(btn2);
        pnl2.add(Box.createHorizontalStrut(20));
        pnl2.setBackground(Color.CYAN);
        add(pnl2);

        pnl12 = new JPanel();
        pnl12.setLayout(new BoxLayout(pnl12,BoxLayout.Y_AXIS));
        pnl12.add(pnl1);
        pnl12.add(pnl2);

        pnl3 = new JPanel();
        pnl3.setLayout(new BoxLayout(pnl3,BoxLayout.X_AXIS));

        btnadd = new JButton("+");
        btnadd.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
           rezultat= polinom1.adunare(polinom1,polinom2);
             text3.setText( rezultat.afisare(rezultat) );}});

            pnl3.add(btnadd);
        pnl3.add(Box.createHorizontalStrut(20));

        btnsub = new JButton("-");
        btnsub.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
            rezultat=polinom1.scadere(polinom1,polinom2);
            text3.setText( rezultat.afisare(rezultat) );}});
        pnl3.add(btnsub);
        pnl3.add(Box.createHorizontalStrut(20));


        btnmul = new JButton("*");
        btnmul.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
            rezultat=polinom1.inmultire(polinom1,polinom2);
            text3.setText( rezultat.afisare(rezultat) );}});
        pnl3.add(btnmul);
        pnl3.add(Box.createHorizontalStrut(20));

        btndev = new JButton(":");
        btndev.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
            rezultat=polinom1.impartire(polinom1);
            System.out.println(rezultat);
            text3.setText( rezultat.afisare(rezultat) );
        }});
        pnl3.add(btndev);
        pnl3.add(Box.createHorizontalStrut(20));

        btnder = new JButton("'");
        btnder.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
            rezultat=polinom1.derivare(polinom1);
            System.out.println(rezultat);
            text3.setText( rezultat.afisare(rezultat) );
        }});
        pnl3.add(btnder);
        pnl3.add(Box.createHorizontalStrut(20));

        btnint = new JButton("dx");
        btnint.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
            rezultat=polinom1.integrare(polinom1);
            text3.setText( rezultat.afisare(rezultat) );}});
        pnl3.add(btnint);
        pnl3.add(Box.createHorizontalStrut(20));

        pnl3.setBackground(Color.ORANGE);
        add(pnl3);
        pnl3.setBackground(Color.BLUE);
        add(pnl3);

        label3 = new JLabel("Rezultat:  ");
        text3 = new JTextField();
        text3.setMaximumSize( new Dimension(450,20) );
        pnl4 = new JPanel();
        pnl4.setLayout(new BoxLayout(pnl4,BoxLayout.X_AXIS));
        pnl4.add(label3);
        pnl4.add(Box.createHorizontalStrut(20));
        pnl4.add(text3);
        pnl4.setBackground(Color.cyan);
        add(pnl4);

        label7 = new JLabel("   Rest:     ");
        text7 = new JTextField();
        text7.setMaximumSize( new Dimension(450,20) );
        pnl7 = new JPanel();
        pnl7.setLayout(new BoxLayout(pnl7,BoxLayout.X_AXIS));
        pnl7.add(label7);
        pnl7.add(Box.createHorizontalStrut(20));
        pnl7.add(text7);
        pnl7.setBackground(Color.cyan);
        add(pnl7);

        pnl47 = new JPanel();
        pnl47.setLayout(new BoxLayout(pnl47,BoxLayout.Y_AXIS));
        pnl47.add(pnl4);
        pnl47.add(pnl7);


        btnclose = new JButton("Inchide");
        btnclose.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){System.exit(1);}});


        btnreset = new JButton("Reset");
        btnreset.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
            text1.setText(null);
            text2.setText(null);
            text3.setText(null);
            polinom1 = new Polinom<Monom>();
            polinom2 = new Polinom<Monom>();
            rezultat = new Polinom<Monom>();
        }});

        pnl5 = new JPanel();
        pnl5.add(Box.createHorizontalStrut(20));
        pnl5.add(btnclose);
        pnl5.add(Box.createHorizontalStrut(20));
        pnl5.add(btnreset);
        pnl5.setBackground(Color.blue);
        add(pnl5);


        pnl6 = new JPanel();
        pnl6.setLayout(new BoxLayout(pnl6,BoxLayout.Y_AXIS));
        pnl6.setBackground(Color.BLUE);
        add(pnl6);
        pnl6.add(Box.createVerticalStrut(50));
        pnl6.add(pnl0);
        pnl6.add(pnl12);
        pnl6.add(pnl3);
        pnl6.add(pnl47);
        pnl6.add(pnl5);
        pnl6.add(Box.createVerticalStrut(50));
        this.add(pnl6);

    }
}
