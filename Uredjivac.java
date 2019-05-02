package zad3;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Uredjivac implements ActionListener{
	JFrame prozor;
	JTextArea tekst;
	JButton novi,otvr,spre,ispis,izr,kop,zalj,zatv;
	JPanel meni;
	public Uredjivac(){
		prozor = new JFrame("TxtEditor");
		tekst = new JTextArea(44,4);
		novi = new JButton("Novi dokument");
		novi.addActionListener(this);
		otvr = new JButton("Otvori");
		otvr.addActionListener(this);
		spre = new JButton("Spremi");
		spre.addActionListener(this);
		ispis = new JButton("Ispis");
		ispis.addActionListener(this);
		izr = new JButton("Izrezi");
		izr.addActionListener(this);
		kop = new JButton("Kopiraj");
		kop.addActionListener(this);
		zalj = new JButton("Zaljepi");
		zalj.addActionListener(this);
		zatv = new JButton("Zatvori");
		zatv.addActionListener(this);
		
		meni = new JPanel();
		meni.add(novi);
		meni.add(otvr);
		meni.add(spre);
		meni.add(ispis);
		meni.add(izr);
		meni.add(kop);
		meni.add(zalj);
		meni.add(zatv);
		
		prozor.add(meni, BorderLayout.NORTH);
		prozor.add(tekst, BorderLayout.SOUTH);
		prozor.setSize(700, 800);
		prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prozor.setVisible(true);
		
		
	}
	
	
	public static void main(String[] a){
		Uredjivac editor = new Uredjivac();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String a = e.getActionCommand();
		if(a.equals("Novi dokument")){
			Uredjivac novi = new Uredjivac();
		}
		else if(a.equals("Otvori")){
	            // Create an object of JFileChooser class 
	            JFileChooser j = new JFileChooser("f:"); 
	  
	            // Invoke the showsOpenDialog function to show the save dialog 
	            int r = j.showOpenDialog(null); 
	  
	            // If the user selects a file 
	            if (r == JFileChooser.APPROVE_OPTION) { 
	                // Set the label to the path of the selected directory 
	                File fi = new File(j.getSelectedFile().getAbsolutePath()); 
	  
	                try { 
	                    // String 
	                    String s1 = "", sl = ""; 
	  
	                    // File reader 
	                    FileReader fr = new FileReader(fi); 
	  
	                    // Buffered reader 
	                    BufferedReader br = new BufferedReader(fr); 
	  
	                    // Initilize sl 
	                    sl = br.readLine(); 
	  
	                    // Take the input from the file 
	                    while ((s1 = br.readLine()) != null) { 
	                        sl = sl + "\n" + s1; 
	                    } 
	  
	                    // Set the text 
	                    tekst.setText(sl); 
	                } 
	                catch (Exception evt) { 
	                    JOptionPane.showMessageDialog(prozor, evt.getMessage()); 
	                } 
	            } 
	            // If the user cancelled the operation 
	            else
	                JOptionPane.showMessageDialog(prozor, "the user cancelled the operation"); 
		}
		else if(a.equals("Spremi")){
			JFileChooser j = new JFileChooser("f:"); 
			  
            // Invoke the showsSaveDialog function to show the save dialog 
            int r = j.showSaveDialog(null); 
  
            if (r == JFileChooser.APPROVE_OPTION) { 
  
                // Set the label to the path of the selected directory 
                File fi = new File(j.getSelectedFile().getAbsolutePath()); 
  
                try { 
                    // Create a file writer 
                    FileWriter wr = new FileWriter(fi, false); 
  
                    // Create buffered writer to write 
                    BufferedWriter w = new BufferedWriter(wr); 
  
                    // Write 
                    w.write(tekst.getText()); 
  
                    w.flush(); 
                    w.close(); 
                } 
                catch (Exception evt) { 
                    JOptionPane.showMessageDialog(prozor, evt.getMessage()); 
                } 
            } 
            // If the user cancelled the operation 
            else
                JOptionPane.showMessageDialog(prozor, "Korisnik otkazao operaciju"); 
		}
		else if(a.equals("Ispis")){
			
		}
		else if(a.equals("Izrezi")){
			tekst.cut();
		}
		else if(a.equals("Kopiraj")){
			tekst.copy();
		}
		else if(a.equals("Zaljepi")){
			tekst.paste();
		}
		else if(a.equals("Zatvori")){
			
		}
		
	}
}
