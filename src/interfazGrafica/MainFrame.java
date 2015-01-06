package interfazGrafica;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class MainFrame extends JFrame {

    ButtonGroup buttonGroup;

    public MainFrame() throws HeadlessException {
        this.setTitle("Regestro de Juegos");
        this.setLayout(new FlowLayout());
        createCompomnent();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 300));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        buttonGroup = new ButtonGroup();
    }

    private void createCompomnent() {
        this.add(createToolBar());
        this.add(createScroll());
        this.add(createJpanelToOrder());
    }

    private JPanel createToolBar() {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
        jpanel.add(createBottonAddGame());
        jpanel.add(createBottonEstadistic());
        return jpanel;
    }

    private JPanel createJpanelToOrder() {
        JPanel jpanel = new JPanel();
        jpanel.setBorder(new TitledBorder("Orden"));
        JRadioButton jRadioButton1 = createRadioButtonTitulo();
        JRadioButton jRadioButton2 = createRadioButtonEdad();
        jpanel.add(jRadioButton1);
        jpanel.add(jRadioButton2);
        return jpanel;

    }

    private JButton createBottonAddGame() {
        JButton button = new JButton("Añadir juego");
        button.addActionListener(new ActionListener() {
            //código para lanzar la ventana de un nuevo juego
            @Override
            public void actionPerformed(ActionEvent e) {
                new JDialogNewGame();
            }
        });
        return button;
    }

    private JButton createBottonEstadistic() {
        JButton button = new JButton("Estadistica Plataformas");
        return button;
    }

    private JScrollPane createScroll() {
        JTextArea area = new JTextArea(10, 20);
        return new JScrollPane(area);
    }

    private JRadioButton createRadioButtonTitulo() {
        JRadioButton jRadioButton = new JRadioButton("Por Título");
        return jRadioButton;
    }

    private JRadioButton createRadioButtonEdad() {
        JRadioButton jRadioButton = new JRadioButton("Por edad");
        return jRadioButton;

    }

}
