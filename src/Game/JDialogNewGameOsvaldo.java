/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author osvaldo
 */
public class JDialogNewGameOsvaldo extends JDialog {

    String titulo;
    String deserrollador;
    String Plataforma;
    String Clasificacion;

    public JDialogNewGameOsvaldo() {
        this.setTitle("Añadir juego");
        createComponent();
        this.setMinimumSize(new Dimension(290, 220));
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.setVisible(true);
    }

    private void createComponent() {
        
        JTextField field = new JTextField(14);
        this.add(new JLabel("Título:"));
        this.add(field);
        JTextField field1 = new JTextField(14);
        this.add(new JLabel("Desarrollador:"));
        this.add(field1);
         JTextField field2 = new JTextField(14);
        this.add(new JLabel("Plataforma:"));
        this.add(field2);
        this.add(createClasificacio());
        this.add(createToolBar());
    }

    private JPanel createClasificacio() {
        JPanel jPanel =new JPanel();
        jPanel.add(new JLabel("Clasificación:"));
        JList listaClasificacion=new JList(new String []{"3+                                   ","7+","12+"} );
        jPanel.add(listaClasificacion);
        return jPanel;
    }

    private JPanel createToolBar() {
        JPanel jPanel =new JPanel();
        jPanel.add(createButtonAceptar());
        jPanel.add(createButtonCancelar());
        return jPanel;     
    }

    private JButton createButtonAceptar() {
        JButton button =new JButton("Aceptar");
        return button;
    }
    private JButton createButtonCancelar() {
        JButton button1 =new JButton("Cancelar");
        return button1;
    }

}
