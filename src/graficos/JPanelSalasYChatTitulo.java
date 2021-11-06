package graficos;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class JPanelSalasYChatTitulo extends JPanel{
	
	public JPanelSalasYChatTitulo() {
		super();
		this.addTitulo();
		this.addSalaButton();
	}
	
	private void addSalaButton() {
		ImageIcon iconoAddSala = new ImageIcon("recursos/addButton.png");
		Image imgAddSala = iconoAddSala.getImage();
		Image imgAddSalaRed = imgAddSala.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon iconAddSalaRed = new ImageIcon(imgAddSalaRed);
		
		ImageIcon iconoAddSalaPressed = new ImageIcon("recursos/addButtonPressed.png");
		Image imgAddSalaPressed = iconoAddSalaPressed.getImage();
		Image imgAddSalaPressedRed = imgAddSalaPressed.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon iconAddSalaPressedRed = new ImageIcon(imgAddSalaPressedRed);
		
		JButton addSalaButton = new JButton(iconAddSalaRed);
		
		addSalaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialogCrearSala jDialogCrearSala = new JDialogCrearSala();
				jDialogCrearSala.setBounds(0, 0, 600, 100);
				jDialogCrearSala.setResizable(false);
				jDialogCrearSala.setLocationRelativeTo(null);
				jDialogCrearSala.setTitle("CrearSala");
				jDialogCrearSala.setModal(true);
				jDialogCrearSala.getContentPane().setLayout(null);
				jDialogCrearSala.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				jDialogCrearSala.setVisible(true);
			}
		});
		addSalaButton.setOpaque(false);
		addSalaButton.setPressedIcon(iconAddSalaPressedRed);
		addSalaButton.setContentAreaFilled(false);
		addSalaButton.setBorderPainted(false);
		addSalaButton.setToolTipText("Crear sala");
		addSalaButton.setBounds(0, 0, Constantes.salaHeight, Constantes.salaHeight);
		
		this.add(addSalaButton);
	}

	private void addTitulo() {
		JLabel label=new JLabel("Salas");  
		label.setFont(new Font("BOLD", Font.PLAIN, 22));
		label.setBounds(Constantes.salaHeight,0,Constantes.salaWidth-Constantes.salaHeight,Constantes.salaHeight);
	    this.add(label);
	}
}
