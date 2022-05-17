package Dialog;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import Dialog.NotepadCustomDialog.MyDialog;

public class WarningDialog extends JFrame implements MouseListener,ActionListener,WindowListener{

	JMenuBar bar;
	JMenu Menu1,SubMenu1;
	JMenuItem Item1,Item2,Item3,Item4;
	
	JPopupMenu popUpMenu;
	JMenuItem cut,copy,paste;
	Container contentPane;
	
	public WarningDialog() {
		
		bar  =new JMenuBar();
		Menu1 = new JMenu("Menu1");
		SubMenu1 = new JMenu("SubMenu1");
		
		Item1 = new JMenuItem("Item1");
		Item2 = new JMenuItem("Item2");
		Item3 = new JMenuItem("Item3");
		Item4 = new JMenuItem("Item4");
		
		Menu1.add(Item1);
		Menu1.add(Item2);
		
		SubMenu1.add(Item3);
		SubMenu1.add(Item4);
		
		bar.add(Menu1);
		Menu1.add(SubMenu1);
		
		setJMenuBar(bar);
		
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		popUpMenu = new JPopupMenu();
		cut = new JMenuItem("Cut");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		
		// add menuitems to popup menu
		popUpMenu.add(cut);
		popUpMenu.add(copy);
		popUpMenu.add(paste);
		
		// adding popup menu to frame
		contentPane.add(popUpMenu);
		
		this.addMouseListener(this);
		
		this.addWindowListener(this);
		
	}
	public class NewDialog extends JDialog implements ActionListener
	{
		JLabel message;
		JButton yesBtn,noBtn;
//		Container contentPane;
		
		public NewDialog(Frame owner,boolean modal) {
			// TODO Auto-generated constructor stub
			super(owner, modal);
			message = new JLabel("Do you want to exit?");
			
			yesBtn = new JButton("Yes");
			noBtn = new JButton("No");
			
			contentPane = getContentPane();
			contentPane.setLayout(new FlowLayout());
			
			contentPane.add(message);
			contentPane.add(yesBtn);
			contentPane.add(noBtn);
			
			yesBtn.addActionListener(this);
			noBtn.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==noBtn)
			{
				this.dispose();  //Only dialog will be closed
			}
			else if (e.getSource()==yesBtn) {
				System.out.println("Data saved Successfully !");
				WarningDialog.this.dispose();
			}
		}

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//ggggggggggggggggggggggggggggggggggggg
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.isPopupTrigger())
		{
			popUpMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.isPopupTrigger())
		{
			popUpMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		JDialog dialog = new NewDialog(this,true);
		dialog.setTitle("My Notepad");
		dialog.setSize(300, 100);
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
	}



	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
/*		// TODO Auto-generated method stub
		if(e.getSource()==saveMnItem)
		{
			JFileChooser saveFileDg = new JFileChooser();
			saveFileDg.showSaveDialog(this);
		}
	
	*/
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WarningDialog d = new WarningDialog();
		d.setTitle("My WarningDialog");
		d.setSize(400, 300);
		d.setLocationRelativeTo(null);
		d.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		d.setVisible(true);
	}
}