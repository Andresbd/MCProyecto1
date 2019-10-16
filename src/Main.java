import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Main {

    static boolean CLChiTest, CLSmirTest;

    public static void main(String[] args) {
    // write your code here
        MetodosCuadrados MC = new MetodosCuadrados();
        ChiCuadrada CH = new ChiCuadrada();
        CongruencialLineal CL = new CongruencialLineal();

        //Creación de Frame
        JFrame frame = new JFrame("Proyecto 1");
        frame.setSize(750, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creación de Panel
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(3,3));
        jp.setMaximumSize(new Dimension(500,500));
        //Botones y sus métodos
        JButton MetCua = new JButton("Metodos cuadrados");
        //Acción de Metodos cuadrados
        MetCua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                //Creación de un nuevo frame
                JFrame MCFrame = new JFrame("Métodos cuadrados");
                MCFrame.setSize(250, 250);
                MCFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //Creación de un nuevo panel
                JPanel MCJp = new JPanel();
                MCJp.setLayout(new GridLayout(4,1));

                JTextField MCJtextSeed  = new JTextField("Semilla",16);
                JTextField MCJtextTries  = new JTextField("Repeticiones",16);
                JButton MCBack = new JButton("Regresar");
                MCBack.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MCFrame.setVisible(false);
                        frame.setVisible(true);
                    }
                });
                JButton MCCalculate = new JButton("Consultar");
                MCCalculate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        MCFrame.setVisible(false);
                        MC.GenerarMC(Integer.parseInt(MCJtextSeed.getText()), Integer.parseInt(MCJtextTries.getText()));

                        JFrame MCRFrame = new JFrame("Métodos cuadrados");
                        MCRFrame.setSize(500, 500);
                        MCRFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        JPanel MCRPanel = new JPanel();
                        JPanel MCLPanel = new JPanel();
                        MCLPanel.setLayout(new GridLayout(1,4));
                        MCRPanel.setLayout(new BorderLayout());
                        JButton MCRBack = new JButton("Regresar");
                        MCRBack.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MC.MCRandomRi.clear();
                                MC.MCSeed.clear();
                                MC.MCAleatorio.clear();
                                MCRFrame.setVisible(false);
                                frame.setVisible(true);
                            }
                        });

                        JList MCList = new JList(MC.MCRandomRi.toArray());
                        JList MCSList = new JList(MC.MCSeed.toArray());

                        MCRPanel.add(new JLabel("Los resultados son: "), BorderLayout.PAGE_START);
                        MCRPanel.add(MCLPanel,BorderLayout.CENTER);
                        MCLPanel.add(new JLabel("Semilla"));
                        MCLPanel.add(MCSList);
                        MCLPanel.add(new JLabel("Ri"));
                        MCLPanel.add(MCList);
                        MCRPanel.add(MCRBack,BorderLayout.PAGE_END);

                        MCRFrame.add(MCRPanel);

                        MCRFrame.setLocationRelativeTo(null);
                        MCRFrame.setVisible(true);
                    }
                });

                MCJp.add(MCJtextSeed);
                MCJp.add(MCJtextTries);
                MCJp.add(MCCalculate);
                MCJp.add(MCBack);
                MCFrame.setContentPane(MCJp);
                MCFrame.setLocationRelativeTo(null);
                MCFrame.setVisible(true);
            }
        });

        JButton ConLin = new JButton("Congruencial Lineal");
        ConLin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField CLSeed;
                JTextField CLMult;
                JTextField CLMod;
                JTextField CLInc;
                JTextField CLIterations;
                JTextField CLAlpha;

                JButton CLCalculate;
                JButton CLBack;

                JCheckBox CLCHi;
                JCheckBox CLSmir;

                JFrame CLFrame;
                JPanel CLPanel;

                CLFrame = new JFrame("Congruencial  Lineal");
                CLFrame.setSize(500, 500);
                CLFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                CLPanel = new JPanel();
                CLPanel.setLayout(new GridLayout(4,2));

                CLSeed = new JTextField("Semilla");
                CLMult = new JTextField("Multiplicador");
                CLInc = new JTextField("Incremento");
                CLMod = new JTextField("Modulo");
                CLIterations = new JTextField("Repeticiones");
                CLCHi = new JCheckBox("Chi Cuadrada");
                CLSmir = new JCheckBox("Smirnov");
                CLAlpha = new JTextField("Alpha");

                CLCHi.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(CLCHi.isSelected()) {
                            CLChiTest = true;
                        }
                    }
                });

                CLSmir.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(CLSmir.isSelected()) {
                            CLSmirTest = true;
                        }
                    }
                });

                CLCalculate = new JButton("Consultar");
                CLCalculate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        CL.CongLineal(Float.parseFloat(CLSeed.getText()),Float.parseFloat(CLMult.getText()),
                                Float.parseFloat(CLInc.getText()),Float.parseFloat(CLMod.getText()),
                                        Float.parseFloat(CLIterations.getText()));


                        CLFrame.setVisible(false);

                        JFrame CLRFrame;
                        JPanel CLRPanel;
                        JPanel CLRLPanel;
                        JPanel CLPanelAbajo;

                        JLabel CLres;
                        JLabel CLSeed;
                        JLabel CLAle;
                        JLabel CLRi;
                        JLabel CLCHText;
                        JLabel CLSmirText;

                        JList CLRSeed;
                        JList CLRAle;
                        JList CLRRi;

                        JButton CLRBack;

                        CLRSeed = new JList(CL.CLSeed.toArray());
                        CLRAle = new JList((CL.CLAleatorio.toArray()));
                        CLRRi = new JList(CL.CLRandomRi.toArray());

                        if(CLChiTest) {
                            CH.ChiTest(CL.CLRandomRi);
                            double CLTable = CH.ChiTable(Integer.parseInt(CLIterations.getText()), Double.parseDouble(CLAlpha.getText()));
                            CLChiTest = false;
                            CLCHi.setSelected(false);

                            if(CH.acumulated < CLTable) {
                                CLCHText = new JLabel("Se acepta la hipótesis nula debido a "+CH.acumulated+ " < " +CLTable);
                            }else {
                                CLCHText = new JLabel("No se acepta la hipótesis nula debido a "+CH.acumulated+ " > " +CLTable);
                            }

                            CH.acumulated = 0;

                        }else {
                            CLCHText = new JLabel("No fue seleccionada la prueba Chi");
                        }

                        if(CLSmirTest) {
                            CLSmirTest = false;
                            CLSmir.setSelected(false);
                            CLSmirText = new JLabel("Prueba de Smirnov");
                        }else {
                            CLSmirText = new JLabel("No fue seleccionada la prueba Smirnov");
                        }

                        CLRFrame = new JFrame("Congruencial lineal");
                        CLRFrame.setSize(500,500);
                        CLRFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        CLRPanel = new JPanel();
                        CLRPanel.setLayout(new BorderLayout());
                        CLRLPanel = new JPanel();
                        CLRLPanel.setLayout(new GridLayout(1,6));
                        CLPanelAbajo = new JPanel();
                        CLPanelAbajo.setLayout(new GridLayout(3,1));


                        CLRBack = new JButton("Regresar");
                        CLRBack.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CL.CLSeed.clear();
                                CL.CLAleatorio.clear();
                                CL.CLRandomRi.clear();
                                CLRFrame.setVisible(false);
                                frame.setVisible(true);
                            }
                        });

                        CLres = new JLabel("Los resultados son: ");
                        CLSeed = new JLabel("Semilla");
                        CLAle = new JLabel("Aleatorio");
                        CLRi = new JLabel("Ri");

                        CLRPanel.add(CLres,BorderLayout.PAGE_START);
                        CLRPanel.add(CLRLPanel,BorderLayout.CENTER);
                        CLRLPanel.add(CLSeed);
                        CLRLPanel.add(CLRSeed);
                        CLRLPanel.add(CLAle);
                        CLRLPanel.add(CLRAle);
                        CLRLPanel.add(CLRi);
                        CLRLPanel.add(CLRRi);
                        CLRPanel.add(CLPanelAbajo,BorderLayout.PAGE_END);
                        CLPanelAbajo.add(CLCHText);
                        CLPanelAbajo.add(CLSmirText);
                        CLPanelAbajo.add(CLRBack);

                        CLRFrame.setContentPane(CLRPanel);
                        CLRFrame.setLocationRelativeTo(null);
                        CLRFrame.setVisible(true);
                    }
                });
                CLBack = new JButton("Regresar");
                CLBack.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CLFrame.setVisible(false);
                        frame.setVisible(true);
                    }
                });

                CLPanel.add(CLSeed);
                CLPanel.add(CLMult);
                CLPanel.add(CLInc);
                CLPanel.add(CLMod);
                CLPanel.add(CLIterations);
                CLPanel.add(CLCalculate);
                CLPanel.add(CLCHi);
                CLPanel.add(CLSmir);
                CLPanel.add(CLAlpha);
                CLPanel.add(CLBack);

                CLFrame.add(CLPanel);
                CLFrame.setLocationRelativeTo(null);
                frame.setVisible(false);
                CLFrame.setVisible(true);

            }
        });

        JButton ConMix = new JButton("Congruencial Mixto");
        ConMix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame CMiFrame = new JFrame("Congruencial Mixto");
                CMiFrame.setSize(500,500);
                CMiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel CMiPanel;

                frame.setVisible(false);
            }
        });

        JButton GenMul = new JButton("Generador Multiplicativo");
        GenMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        jp.add(new JLabel(""));
        jp.add(new JLabel("Seleccione la metodología a usar:"));
        jp.add(new JLabel(""));
        jp.add(MetCua);
        jp.add(ConLin);
        jp.add(ConMix);
        jp.add(new JLabel(""));
        jp.add(GenMul);
        jp.add(new JLabel(""));
        frame.setContentPane(jp);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
