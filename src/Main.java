import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
    // write your code here
        MetodosCuadrados MC = new MetodosCuadrados();
        ChiCuadrada CH = new ChiCuadrada();

        //Creación de Frame
        JFrame frame = new JFrame("Proyecto 1");
        frame.setSize(500, 500);
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
                MCFrame.setSize(500, 500);
                MCFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //Creación de un nuevo panel
                JPanel MCJp = new JPanel();
                MCJp.setLayout(new GridLayout(3,1));

                JTextField MCJtextSeed  = new JTextField("Semilla",16);
                JTextField MCJtextTries  = new JTextField("Repeticiones",16);
                JButton MCCalculate = new JButton("Consultar");
                MCCalculate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MC.GenerarMC(Integer.parseInt(MCJtextSeed.getText()), Integer.parseInt(MCJtextTries.getText()));
                    }
                });

                MCJp.add(MCJtextSeed);
                MCJp.add(MCJtextTries);
                MCJp.add(MCCalculate);
                MCFrame.setContentPane(MCJp);
                MCFrame.pack();
                MCFrame.setLocationRelativeTo(null);
                MCFrame.setVisible(true);
            }
        });
        JButton ConLin = new JButton("Congruencial Lineal");
        JButton ConMix = new JButton("Congruencial Mixto");
        JButton GenMul = new JButton("Generador Multiplicativo");

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
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
