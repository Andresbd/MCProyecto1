import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Main {

    static boolean CLChiTest, CLSmirTest, CMChiTest, CMSmirTest, GenMulChiTest, GenMulSmirTest;

    public static void main(String[] args) {
    // write your code here
        MetodosCuadrados MC = new MetodosCuadrados();
        ChiCuadrada CH = new ChiCuadrada();
        CongruencialLineal CL = new CongruencialLineal();
        CongruencialMixto CM = new CongruencialMixto();
        GeneradorMultiplicativo GenMul = new GeneradorMultiplicativo();

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
                JTextField CMSeed;
                JTextField CMMult;
                JTextField CMMod;
                JTextField CMInc;
                JTextField CMIterations;
                JTextField CMAlpha;

                JButton CMCalculate;
                JButton CMBack;

                JCheckBox CMCHi;
                JCheckBox CMSmir;

                CMiPanel = new JPanel();
                CMiPanel.setLayout(new GridLayout(4,2));

                CMSeed = new JTextField("Semilla");
                CMMult = new JTextField("Multiplicador");
                CMInc = new JTextField("Incremento");
                CMMod = new JTextField("Modulo");
                CMIterations = new JTextField("Repeticiones");
                CMCHi = new JCheckBox("Chi Cuadrada");
                CMSmir = new JCheckBox("Smirnov");
                CMAlpha = new JTextField("Alpha");

                CMCHi.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(CMCHi.isSelected()) {
                            CMChiTest = true;
                        }
                    }
                });

                CMSmir.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        CMSmirTest = true;
                    }
                });

                CMCalculate = new JButton("Consultar");
                CMCalculate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CM.GenMix(Integer.parseInt(CMSeed.getText()),Integer.parseInt(CMMult.getText()),
                                Integer.parseInt(CMInc.getText()),Integer.parseInt(CMMod.getText()),
                                Integer.parseInt(CMIterations.getText()));

                        CMiFrame.setVisible(false);

                        JFrame CMRFrame;
                        JPanel CMRPanel;
                        JPanel CMUPanel;
                        JPanel CMDPanel;

                        JLabel CMres;
                        JLabel CMSeed;
                        JLabel CMAle;
                        JLabel CMRi;
                        JLabel CMCHText;
                        JLabel CMSmirText;

                        JList CMRSeed;
                        JList CMRAle;
                        JList CMRRi;

                        JButton CMRBack;

                        CMRSeed = new JList(CM.semilla.toArray());
                        CMRRi = new JList(CM.generatedRandoms.toArray());
                        CMRAle= new JList(CM.randomNumber.toArray());

                        if(CMChiTest) {
                            CH.ChiTest(CM.generatedRandoms);
                            double CMTable = CH.ChiTable(Integer.parseInt(CMIterations.getText()), Double.parseDouble(CMAlpha.getText()));
                            CMChiTest = false;
                            CMCHi.setSelected(false);

                            if(CH.acumulated < CMTable) {
                                CMCHText = new JLabel("Se acepta la hipótesis nula debido a "+CH.acumulated+ " < " +CMTable);
                            }else {
                                CMCHText = new JLabel("No se acepta la hipótesis nula debido a "+CH.acumulated+ " > " +CMTable);
                            }

                            CH.acumulated = 0;

                        }else {
                            CMCHText = new JLabel("No fue seleccionada la prueba Chi");
                        }

                        if(CMSmirTest) {

                            CMSmirTest = false;
                            CMSmir.setSelected(false);
                            CMSmirText = new JLabel("Prueba de Smirnov");
                        }else {
                            CMSmirText = new JLabel("No fue seleccionada la prueba Smirnov");
                        }

                        CMRFrame = new JFrame("Congruencial mixto");
                        CMRFrame.setSize(500,500);
                        CMRFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        CMUPanel = new JPanel();
                        CMUPanel.setLayout(new BorderLayout());
                        CMRPanel = new JPanel();
                        CMRPanel.setLayout(new GridLayout(1,6));
                        CMDPanel = new JPanel();
                        CMDPanel.setLayout(new GridLayout(3,1));


                        CMRBack = new JButton("Regresar");
                        CMRBack.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CM.generatedRandoms.clear();
                                CM.randomNumber.clear();
                                CM.semilla.clear();
                                CMRFrame.setVisible(false);
                                frame.setVisible(true);
                            }
                        });

                        CMres = new JLabel("Los resultados son: ");
                        CMSeed = new JLabel("Semilla");
                        CMAle = new JLabel("Aleatorio");
                        CMRi = new JLabel("Ri");

                        CMUPanel.add(CMres,BorderLayout.PAGE_START);
                        CMUPanel.add(CMRPanel,BorderLayout.CENTER);
                        CMRPanel.add(CMSeed);
                        CMRPanel.add(CMRSeed);
                        CMRPanel.add(CMAle);
                        CMRPanel.add(CMRAle);
                        CMRPanel.add(CMRi);
                        CMRPanel.add(CMRRi);
                        CMUPanel.add(CMDPanel,BorderLayout.PAGE_END);
                        CMDPanel.add(CMCHText);
                        CMDPanel.add(CMSmirText);
                        CMDPanel.add(CMRBack);

                        CMRFrame.setContentPane(CMUPanel);
                        CMRFrame.setLocationRelativeTo(null);
                        frame.setVisible(false);
                        CMiFrame.setVisible(false);
                        CMRFrame.setVisible(true);
                    }
                });

                CMBack = new JButton("Regresar");
                CMCalculate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CMiFrame.setVisible(false);
                        frame.setVisible(true);
                    }
                });

                CMiPanel.add(CMSeed);
                CMiPanel.add(CMMult);
                CMiPanel.add(CMInc);
                CMiPanel.add(CMMod);
                CMiPanel.add(CMIterations);
                CMiPanel.add(CMCalculate);
                CMiPanel.add(CMCHi);
                CMiPanel.add(CMSmir);
                CMiPanel.add(CMAlpha);
                CMiPanel.add(CMBack);

                CMiFrame.add(CMiPanel);
                CMiFrame.setLocationRelativeTo(null);
                frame.setVisible(false);
                CMiFrame.setVisible(true);
            }
        });

        JButton GenMulti = new JButton("Generador Multiplicativo");
        GenMulti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                //Creación de un nuevo frame
                JFrame GenMulFrame = new JFrame("Generador Multiplicativo");
                GenMulFrame.setSize(250, 250);
                GenMulFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //Creación de un nuevo panel
                JPanel GenMulJp = new JPanel();
                GenMulJp.setLayout(new GridLayout(9,1));

                JTextField GenMulJtextSeed  = new JTextField("Semilla",16);
                JTextField GenMulJtextValueA  = new JTextField("Valor a",16);
                JTextField GenMulJtextMod  = new JTextField("Modulo",16);
                JTextField GenMulJtextItera  = new JTextField("Iteraciones",16);
                JTextField GenMulJtextAlpha  = new JTextField("Alpha",16);
                JCheckBox GenMulCHi = new JCheckBox("Chi Cuadrada");
                JCheckBox GenMulSmir = new JCheckBox("Smirnov");
                JButton GenMulBack = new JButton("Regresar");

                GenMulCHi.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(GenMulCHi.isSelected()) {
                            GenMulChiTest = true;
                        }
                    }
                });

                GenMulSmir.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(GenMulSmir.isSelected()) {
                            GenMulSmirTest = true;
                        }
                    }
                });


                GenMulBack.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GenMulFrame.setVisible(false);
                        frame.setVisible(true);
                    }
                });
                JButton GenMulCalculate = new JButton("Consultar");
                GenMulCalculate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        GenMulFrame.setVisible(false);
                        GenMul.GenerarGenMult(Float.parseFloat(GenMulJtextSeed.getText()),
                                Float.parseFloat(GenMulJtextMod.getText()),
                                Float.parseFloat(GenMulJtextValueA.getText()),
                                Float.parseFloat(GenMulJtextItera.getText()));

                        JList GenMulRList;
                        JList GenMulXList;
                        JList GenMulRi;

                        JFrame GenMulRFrame = new JFrame("Generador Multiplicativo");
                        GenMulRFrame.setSize(1100, 500);
                        GenMulRFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        JPanel GenMulRPanel = new JPanel();
                        JPanel GenMulLPanel = new JPanel();
                        JPanel GenMulAbajoPanel = new JPanel();
                        GenMulLPanel.setLayout(new GridLayout(1,4));
                        GenMulRPanel.setLayout(new BorderLayout());
                        GenMulAbajoPanel.setLayout(new GridLayout(3,1));
                        JLabel GenMulCHText;
                        JLabel GenMulSmirText;
                        JLabel GenMulRRi;
                        JButton GenMulRBack = new JButton("Regresar");


                        GenMulRBack.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                GenMul.GenMulRandomRi.clear();
                                GenMul.GenMulSeed.clear();
                                GenMul.GenMulValueA.clear();
                                GenMul.GenMulMod.clear();
                                GenMul.GenMulItera.clear();
                                GenMulRFrame.setVisible(false);
                                frame.setVisible(true);
                            }
                        });

                        GenMulXList = new JList(GenMul.GenMulValueX.toArray());
                        GenMulRList = new JList(GenMul.GenMulValueR.toArray());
                        GenMulRi = new JList(GenMul.GenMulRandomRi.toArray());

                        if(GenMulChiTest) {
                            //CH.ChiTest(GenMul.GenMulRandomRi);
                            double CLTable = CH.ChiTable(Integer.parseInt(GenMulJtextItera.getText()), Double.parseDouble(GenMulJtextAlpha.getText()));
                            GenMulChiTest = false;
                            GenMulCHi.setSelected(false);

                            if(CH.acumulated < CLTable) {
                                GenMulCHText = new JLabel("Se acepta la hipótesis nula debido a "+CH.acumulated+ " < " +CLTable);
                            }else {
                                GenMulCHText = new JLabel("No se acepta la hipótesis nula debido a "+CH.acumulated+ " > " +CLTable);
                            }

                            CH.acumulated = 0;

                        }else {
                            GenMulCHText = new JLabel("No fue seleccionada la prueba Chi");
                        }

                        if(GenMulSmirTest) {
                            GenMulSmirTest = false;
                            GenMulSmir.setSelected(false);
                            GenMulSmirText = new JLabel("Prueba de Smirnov");
                        }else {
                            GenMulSmirText = new JLabel("No fue seleccionada la prueba Smirnov");
                        }
                        GenMulRPanel.add(new JLabel("Los resultados son: "), BorderLayout.PAGE_START);
                        GenMulRPanel.add(GenMulLPanel,BorderLayout.CENTER);
                        GenMulLPanel.add(new JLabel("Valor X:"));
                        GenMulLPanel.add(GenMulXList);
                        GenMulLPanel.add(new JLabel("Valor R:"));
                        GenMulLPanel.add(GenMulRList);
                        GenMulLPanel.add(new JLabel("Ri:"));
                        GenMulLPanel.add(GenMulRi);
                        GenMulRPanel.add(GenMulAbajoPanel,BorderLayout.PAGE_END);
                        GenMulAbajoPanel.add(GenMulCHText);
                        GenMulAbajoPanel.add(GenMulSmirText);
                        GenMulAbajoPanel.add(GenMulRBack);

                        GenMulRFrame.add(GenMulRPanel);

                        GenMulRFrame.setLocationRelativeTo(null);
                        GenMulRFrame.setVisible(true);
                    }
                });


                GenMulJp.add(GenMulJtextSeed);
                GenMulJp.add(GenMulJtextValueA);
                GenMulJp.add(GenMulJtextMod);
                GenMulJp.add(GenMulJtextItera);
                GenMulJp.add(GenMulCalculate);
                GenMulJp.add(GenMulCHi);
                GenMulJp.add(GenMulSmir);
                GenMulJp.add(GenMulJtextAlpha);
                GenMulJp.add(GenMulBack);

                GenMulFrame.add(GenMulJp);
                GenMulFrame.setLocationRelativeTo(null);
                frame.setVisible(false);
                GenMulFrame.setVisible(true);

            }
        });

        JButton ConLiCom = new JButton("Congruencial Lineal Combinado");
        ConLiCom.addActionListener(new ActionListener() {
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
        jp.add(ConLiCom);
        jp.add(GenMulti);
        jp.add(new JLabel(""));
        frame.setContentPane(jp);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
