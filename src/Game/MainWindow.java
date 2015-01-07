package Game;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class MainWindow extends JFrame {

    ButtonGroup buttonGroup;
    RegisteredGames registeredGames;
    JTextArea area;
    JRadioButton jRadioButton1;
    JRadioButton jRadioButton2;
    // NewGame nuevoJuego;

    public MainWindow() throws HeadlessException {
        this.setTitle("Regestro de Juegos");
        //posicionamiento de la ventana de forma secuencial si se acaba el espacio sigue abajo
        this.setLayout(new FlowLayout());
        createCompomnent();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 330));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        registeredGames = new RegisteredGames();
        registeredGames.fill();
    }

    private void createCompomnent() {
        this.add(createToolBar());
        this.add(createScroll());
        this.add(createJpanelToOrder());
    }

    private JPanel createToolBar() {
        JPanel jpanel = new JPanel();
        //poscicinamiento de botones
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
                NewGame nuevoJuego = new NewGame(new JFrame());
                nuevoJuego.setVisible(true);
                if (nuevoJuego.isOK()) {
                    registeredGames.add(new Game(nuevoJuego.getGameTitle(), nuevoJuego.getDeveloper(), nuevoJuego.getPlatforma(), nuevoJuego.getAge()));
                }
            }
        });
        return button;
    }

    private JButton createBottonEstadistic() {
        JButton button = new JButton("Estadistica Plataformas");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarContenido();
            }
        });
        return button;
    }

    public void mostrarContenido() {
        area.setText("");
        Set<String> list = registeredGames.getListPlatforms();
        for (String elemento : list) {
            area.insert(elemento + "\n", 0);
        }
    }

    private JScrollPane createScroll() {
        area = new JTextArea(12, 25);
        //scroll para el text área
        return new JScrollPane(area);
    }

    private JRadioButton createRadioButtonTitulo() {
         jRadioButton1 = new JRadioButton("Por Título");
        jRadioButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                registeredGames.setOrder(0);
                mostrarDatoJuegos();
            }

        });
        return jRadioButton1;
    }

    private void mostrarDatoJuegos() {
        area.setText("");
        List<Game> list = registeredGames.getList();
        for (Game elemento : list) {
            area.insert(elemento.getTitle()+"|"+elemento.getDeveloper()+"|"+elemento.getPlatform()+"|"+elemento.getAge()+ "\n", 0);
        }
    }

    private JRadioButton createRadioButtonEdad() {
         jRadioButton2 = new JRadioButton("Por edad");
        jRadioButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                registeredGames.setOrder(1);
                mostrarDatoJuegos();
            }
        });
        return jRadioButton2;

    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
