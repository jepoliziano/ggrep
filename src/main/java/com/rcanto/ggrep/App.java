	/*1. Programa Grep. Ejemplo:

	java ej1 patro fitxer */
package com.rcanto.ggrep;

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class window implements ActionListener
{
	private JFrame jf = null;
	private JPanel jp = null;
	private JLabel jl1 = null;
	private JLabel jl2 = null;
	private JTextField jtf1 = null;
	private JTextField jtf2 = null;
	private JButton jb = null;
	private JTextArea jta = null;

	public  void run()
	{/*
/*		if(args.length < 2)
		{
			System.out.println("Debes especificar el patrón y el nombre del fichero");
			System.exit(0);
		}*/
//		for (String s: v)
//			System.out.println(s);
		jf = new JFrame("GRAPHIC GREP");
		jp = new JPanel(new GridLayout(3,2));
		jf.add(jp);
		jp.add(jl1 = new JLabel("Pattern search:"));
		jp.add(jtf1 = new JTextField());
		jp.add(jl2 = new JLabel("Path to file:"));
		jp.add(jtf2 = new JTextField());
		jp.add(jb = new JButton("Muestra líneas"));
		jp.add(jta = new JTextArea());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jb.addActionListener(this);
//				new ActionListener(){
//	});
		Vector<String> v = compruebaLineas(jtf2.getText(),jtf1.getText());
	}

	public void actionPerformed(ActionEvent e)
	{
		if (!jtf2.getText().isEmpty())
		{
			Vector v=null;
			v = compruebaLineas(jtf2.getText(),jtf1.getText());
			Iterator<String> it = v.iterator();
			jta.setText("");
			while ( it.hasNext())
				jta.append(it.next()+"\n");
		}
		else
			jta.setText("");
	}

	public static Vector<String> compruebaLineas(String file,String patr)
	{
		Vector<String> v = new Vector<String>();
		String linea;
		File f = null;
		FileReader fr = null;

		f = new File(file);
		try
		{
			fr = new FileReader(f);
		}
		catch(FileNotFoundException FNE)
		{
			System.out.println("Se ha liado parda");
		}
		BufferedReader br = new BufferedReader(fr);
		try
		{
			while((linea = br.readLine()) != null)
				if(linea.contains(patr))	// args[0] és el patró de búsqueda
				    //System.out.println(linea);
				    v.add(linea);
	        	if (br != null) { br.close(); fr.close(); }
			return v;
		}
		catch(IOException e)
		{
			System.out.println("IOException");
			return null;
		}
	}
}

public class App
{
	public static void main(String[] args) {
		window w = new window();
		w.run();
	}
}
