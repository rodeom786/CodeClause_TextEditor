// Java Program to create a text editor using java
// Created By : Om Anil Rode

package TextEditor;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;


class TextEditor extends JFrame implements ActionListener 
{
	// Text component
	JTextArea t;
	
	JFrame f;				

	// Constructor
	TextEditor()			
	{
		// Create a frame
		f = new JFrame("Text Editor"); 		

		try {
			
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
			}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		// Text component
		t = new JTextArea();	

		// Create a menu bar
		JMenuBar mb = new JMenuBar();

		// Create a menu for menu
		JMenu m1 = new JMenu("File");

		// Create menu items
		JMenuItem Element = new JMenuItem("New");
		JMenuItem Element1 = new JMenuItem("Open");
		JMenuItem Element2 = new JMenuItem("Save");
		JMenuItem Element3 = new JMenuItem("Print");

		// Add action listener
		Element.addActionListener(this);
		Element1.addActionListener(this);
		Element2.addActionListener(this);
		Element3.addActionListener(this);

		m1.add(Element);
		m1.add(Element1);
		m1.add(Element2);
		m1.add(Element3);

		// Create a menu for menu
		JMenu m2 = new JMenu("Edit");

		// Create menu items
		JMenuItem Inelement4 = new JMenuItem("cut");
		JMenuItem Inelement5 = new JMenuItem("copy");
		JMenuItem Inelement6 = new JMenuItem("paste");

		// Add action listener
		Inelement4.addActionListener(this);
		Inelement5.addActionListener(this);
		Inelement6.addActionListener(this);

		m2.add(Inelement4);
		m2.add(Inelement5);
		m2.add(Inelement6);

		JMenuItem Mclose = new JMenuItem("close");

		Mclose.addActionListener(this);

		mb.add(m1);
		mb.add(m2);
		mb.add(Mclose);

		f.setJMenuBar(mb);
		f.add(t);
		f.setSize(500, 500);
		f.show();
	}

	// If a button is pressed
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

		if (s.equals("cut")) 
		{
			t.cut();
		}
		else if (s.equals("copy"))
		{
			t.copy();
		}
		else if (s.equals("paste")) 
		{
			t.paste();
		}
		else if (s.equals("Save")) 
		{
			// Create an object of JFileChooser class
			JFileChooser j = new JFileChooser("f:");

			// Invoke the showsSaveDialog function to show the save dialog
			int r = j.showSaveDialog(null);

			if (r == JFileChooser.APPROVE_OPTION) 
			{

				// Set the label to the path of the selected directory
				File fi = new File(j.getSelectedFile().getAbsolutePath());

				try {
					// Create a file writer
					FileWriter wr = new FileWriter(fi, false);

					// Create buffered writer to write
					BufferedWriter w = new BufferedWriter(wr);

					// Write
					w.write(t.getText());

					w.flush();
					w.close();
				}
				catch (Exception evt) {
					JOptionPane.showMessageDialog(f, evt.getMessage());
				}
			}
			// If the user cancelled the operation
			else
				JOptionPane.showMessageDialog(f, "the user cancelled the operation");
		}
		else if (s.equals("Print")) {
			try {
				// print the file
				t.print();
			}
			catch (Exception evt) {
				JOptionPane.showMessageDialog(f, evt.getMessage());
			}
		}
		else if (s.equals("Open"))
		{
			// Create an object of JFileChooser class
			JFileChooser j = new JFileChooser("f:");

			// Invoke the showsOpenDialog function to show the save dialog
			int r = j.showOpenDialog(null);

			// If the user selects a file
			if (r == JFileChooser.APPROVE_OPTION)
			{
				// Set the label to the path of the selected directory
				File fi = new File(j.getSelectedFile().getAbsolutePath());

				try {
					// String
					String s1 = "", sl = "";

					// File reader
					FileReader fr = new FileReader(fi);

					// Buffered reader
					BufferedReader br = new BufferedReader(fr);

					// Initialize sl
					sl = br.readLine();

					// Take the input from the file
					while ((s1 = br.readLine()) != null) {
						sl = sl + "\n" + s1;
					}

					// Set the text
					t.setText(sl);
					}
				catch (Exception evt) 
				{
					JOptionPane.showMessageDialog(f, evt.getMessage());
				}
			}
			
			// If the user cancelled the operation
			else 
			{
				JOptionPane.showMessageDialog(f, "the user cancelled the operation");
			}
				
		}
		else if (s.equals("New")) 
		{
			t.setText("");
		}
		else if (s.equals("close"))
		{
			f.setVisible(false);
		}
	}

	// Main class
	public static void main(String args[])
	{
		TextEditor e = new TextEditor();
	}
}


