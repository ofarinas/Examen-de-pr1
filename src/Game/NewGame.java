package Game;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class NewGame extends JDialog {
	private final JPanel contentPanel;
	private final JTextField title;
	private final JTextField developer;
	private final JTextField platforma;
	private final JList<String> age;
	private final JButton ok;
	private final JButton cancel;
	private boolean wasOK;
	private ActionListener okHandler= new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		    wasOK =true;
                    setVisible(false);			
		}
	};
	private ActionListener cancelHandler= new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);			
		}
	};
	private void addEntryLine(String text, JComponent comp, int aling){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(aling));
		panel.add(new JLabel(text+":"));
		panel.add(comp);
		contentPanel.add(panel);		
	}
	private void addButtons(){
		JPanel buttons= new JPanel();
		buttons.add(ok);
		buttons.add(cancel);
		contentPanel.add(buttons);		
	}
	public NewGame(JFrame f) {
		//Init JDialog options
		super(f,"Añadir nuevo juego");
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(f);
		wasOK=false;
		//Create and set visual components
		contentPanel = new JPanel();
		title = new JTextField(15);
		title.addActionListener(okHandler);
		developer = new JTextField(15);
		developer.addActionListener(okHandler);
		platforma = new JTextField(15);
		platforma.addActionListener(okHandler);
		age = new JList<>(new String[]{"Todas las edades","3+","7+","12+","16+","18+"});
		age.setVisibleRowCount(3);
		ok = new JButton("Aceptar");
		ok.addActionListener(okHandler);
		cancel = new JButton("Cancelar");
		cancel.addActionListener(cancelHandler);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		addEntryLine("Título",title,FlowLayout.RIGHT);
		addEntryLine("Desarrollador",developer,FlowLayout.RIGHT);
		addEntryLine("Plataforma",platforma,FlowLayout.RIGHT);
		addEntryLine("Clasificación",new JScrollPane(age),FlowLayout.LEFT);
		addButtons();
		pack();
	}
//	@Override
//	public void setVisible(boolean b){
//		super.setVisible(b);
//		if(b){
//		    wasOK=false;
//		}
//	}
	public String getGameTitle() {
		return title.getText();
	}
	public String getDeveloper() {
		return developer.getText();
	}
	public String getPlatforma() {
		return platforma.getText();
	}
	public int getAge() {
		if(age.isSelectionEmpty()) return 0;
		return (new int[]{0,3,7,12,16,18})[age.getSelectedIndex()];
	}
	public boolean isOK() {
		return wasOK;
	}
}
