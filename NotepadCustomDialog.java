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


public class NotepadCustomDialog extends JFrame implements MouseListener,WindowListener,ActionListener{
	JMenuBar bar;
	JMenu fileMenu,editMenu;
	JMenuItem newMnItem,saveMnItem,cutMnItem,cpyMnItem,pstMnItem;
	
	JPopupMenu popUpMenu;
	JMenuItem cut,copy,paste;
	Container contentPane;
	
	public NotepadCustomDialog() {
		// TODO Auto-generated constructor stub
		bar = new JMenuBar();
		
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		
		newMnItem = new JMenuItem("New");
		saveMnItem = new JMenuItem("Save");
		
		cutMnItem = new JMenuItem("Cut");
		cpyMnItem = new JMenuItem("Copy");
		pstMnItem = new JMenuItem("Paste");
		
		fileMenu.add(newMnItem);
		fileMenu.add(saveMnItem);
		
		editMenu.add(cutMnItem);
		editMenu.add(cpyMnItem);
		editMenu.add(pstMnItem);
		
		bar.add(fileMenu);
		bar.add(editMenu);
		
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
		
		saveMnItem.addActionListener(this);
	
	}
	
	
	// custom dialog
	public class MyDialog extends JDialog implements ActionListener
	{
		JLabel messageLbl;
		JButton saveBtn,dontSaveBtn,cancelBtn;
		Container contentPane;
		
		public MyDialog(Frame owner,boolean modal) {
			// TODO Auto-generated constructor stub
			super(owner, modal);
			messageLbl = new JLabel("Do you want to save changes to Untitled?");
			
			saveBtn = new JButton("Save");
			dontSaveBtn = new JButton("Don't Save");
			cancelBtn = new JButton("Cancel");
			
			contentPane = getContentPane();
			contentPane.setLayout(new FlowLayout());
			
			contentPane.add(messageLbl);
			contentPane.add(saveBtn);
			contentPane.add(dontSaveBtn);
			contentPane.add(cancelBtn);
			
			cancelBtn.addActionListener(this);
			saveBtn.addActionListener(this);
			dontSaveBtn.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==cancelBtn)
			{
				this.dispose();
			}
			else if (e.getSource()==saveBtn) {
				System.out.println("Data saved Successfully !");
				NotepadCustomDialog.this.dispose();
			}
			else if (e.getSource()==dontSaveBtn) {
				System.out.println("Data Not saved !");
				NotepadCustomDialog.this.dispose();
			}
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotepadCustomDialog notePad = new NotepadCustomDialog();
		notePad.setTitle("My Notepad");
		notePad.setSize(400, 300);
		notePad.setLocationRelativeTo(null);
		notePad.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		notePad.setVisible(true);
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
		JDialog dialog = new MyDialog(this,true);
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
		// TODO Auto-generated method stub
		if(e.getSource()==saveMnItem)
		{
			JFileChooser saveFileDg = new JFileChooser();
			saveFileDg.showSaveDialog(this);
		}
	}
} 
