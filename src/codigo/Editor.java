/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;
import java_cup.runtime.Symbol;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JToolBar;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.StringReader;
import javax.swing.JButton;

public class Editor {
        ArrayDB array = new ArrayDB();
	private JFrame jFrame = null;  
	private JPanel jContentPane = null;
	private JPanel aboutContentPane = null;
	private JLabel aboutVersionLabel = null;
	private JToolBar jToolBar = null;
	private JScrollPane jScrollPane = null;
	private JTextPane jTextPane = null;
	private JScrollPane jScrollPane1 = null;
	private JTextPane jTextPane1 = null;
	private JButton jButton = null;
	
	Sintax parser;
	String file = "";  //  @jve:decl-index=0:
	String PAR = "";  
	boolean lock_ini = true;
	boolean lock_cer = false;
	boolean lock = true;
        
	


	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(20, 20, 370, 191));
			jScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Editor", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jScrollPane.setViewportView(getJTextPane());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();

			jTextPane.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if(e.getKeyChar()==(java.awt.event.KeyEvent.VK_ENTER)){
						try {
							
							Document document = getJTextPane().getDocument();
							Element rootElem = document.getDefaultRootElement();
							int numLines = rootElem.getElementCount();
							Element lineElem = rootElem.getElement(numLines - 1);
							int lineStart = lineElem.getStartOffset();
							int lineEnd = lineElem.getEndOffset();
							String lineText = document.getText(lineStart, lineEnd - lineStart);
							if(lineText.length()<3){lineText=lineText+"xxx";}
							parser(lineText);
						}
						catch(Exception ex){System.out.println("Cosas");}
					}
				}
			});
		}
		return jTextPane;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(20, 240, 370, 160));
			jScrollPane1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Consola", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jScrollPane1.setViewportView(getJTextPane1());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jTextPane1	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	public JTextPane getJTextPane1() {
		if (jTextPane1 == null) {
			jTextPane1 = new JTextPane();
		}
		return jTextPane1;
	}

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Editor application = new Editor();
				application.getJFrame().setVisible(true);
			}
		});
	}

	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
                        array.delFile();
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//jFrame.setJMenuBar(getJJMenuBar());
			jFrame.setSize(422, 484);
			jFrame.setContentPane(getJContentPane());
			jFrame.setTitle("Traductor Dirigido por Sintaxis");
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	        int x = (screen.width-jFrame.getWidth())/2;
	        int y = (screen.height-jFrame.getHeight())/2;
	        jFrame.setBounds(x,y,jFrame.getWidth(),jFrame.getHeight());				
		}
		return jFrame;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			//jContentPane.add(getJToolBar(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJScrollPane1(), null);
		}
		return jContentPane;
	}


	

	
	public void setConsola(String cons){
		//cons = cons + "\n";
		try {
		    SimpleAttributeSet atributo = new SimpleAttributeSet();
			getJTextPane1().getDocument().insertString(getJTextPane1().getDocument().getLength(),cons, atributo);
			
		} catch (BadLocationException e) {e.printStackTrace();}
	}
	
	
	
	public void getMsjError(){
            array.delFile();
            JOptionPane.showMessageDialog(getJContentPane(),"Error Sintactico","Mensaje Error",JOptionPane.ERROR_MESSAGE,null);						
            getJTextPane().setEnabled(false);
                
	}
	
	public void setFin(){
		JOptionPane.showMessageDialog(getJContentPane(),"Análisis Completado","Mensaje",JOptionPane.INFORMATION_MESSAGE,null);						
		getJTextPane().setEnabled(false);
                array.delFile();
	}
        
        public void parser(String instr){
            @SuppressWarnings("unused")
            String aux = instr.substring(0,3);
            int verf = 0;
		
            if(aux.compareTo("PAR")==0){
                Symbol parse_tree = null;
		String gram = instr+"\n"+"FINALIZAR";
		StringReader s = new StringReader(gram);
		parser = new Sintax(new LexerCup(s));
		parser.setEditor(Editor.this);
		try {
                    verf=1;
                    parse_tree = parser.parse();	
                    } catch (Exception e) {
                    getMsjError();
                    }
            }
            if(aux.compareTo("INI")==0){
		@SuppressWarnings("unused")
                Symbol parse_tree = null;
		String gram = "PARTIR"+"\n"+instr+"\n"+"FINALIZAR";
		StringReader s = new StringReader(gram);
		parser = new Sintax(new LexerCup(s));
		parser.setEditor(Editor.this);
                try {
                    verf=1;
                    parse_tree = parser.parse();	
                    } catch (Exception e) {
                    getMsjError();
                    }
            }
            if(aux.compareTo("MET")==0){
                @SuppressWarnings("unused")
                Symbol parse_tree = null;
                String gram = "PARTIR"+"\n"+instr+"\n"+"FINALIZAR";
                StringReader s = new StringReader(gram);
                parser = new Sintax(new LexerCup(s));
                parser.setEditor(Editor.this);
                try {
                        verf=1;
                        parse_tree = parser.parse();	
			} catch (Exception e) {
			getMsjError();
                    }
		}
                 if(aux.compareTo("MIR")==0){
                    @SuppressWarnings("unused")
                    Symbol parse_tree = null;
                    String gram = "PARTIR"+"\n"+instr+"\n"+"FINALIZAR";
                    StringReader s = new StringReader(gram);
                    parser = new Sintax(new LexerCup(s));
                    parser.setEditor(Editor.this);
                    try {
                        verf=1;
                        parse_tree = parser.parse();	
			} catch (Exception e) {
                            getMsjError();
                    }
		}
                if(aux.compareTo("SAC")==0){
                    @SuppressWarnings("unused")
                    Symbol parse_tree = null;
                    String gram = "PARTIR"+"\n"+instr+"\n"+"FINALIZAR";
                    StringReader s = new StringReader(gram);
                    parser = new Sintax(new LexerCup(s));
                    parser.setEditor(Editor.this);
                    try {
                        verf=1;
                        parse_tree = parser.parse();	
			} catch (Exception e) {
			getMsjError();
                    }
		}
                if(aux.compareTo("DAT")==0){
                    @SuppressWarnings("unused")
                    Symbol parse_tree = null;
                    String gram = "PARTIR"+"\n"+instr+"\n"+"FINALIZAR";
                    StringReader s = new StringReader(gram);
                    parser = new Sintax(new LexerCup(s));
                    parser.setEditor(Editor.this);
                    try {
                        verf=1;
                        parse_tree = parser.parse();	
			} catch (Exception e) {
			getMsjError();
                    }
		}                
                
             if(aux.compareTo("FIN")==0){
			@SuppressWarnings("unused")
			Symbol parse_tree = null;
			String gram = "PARTIR"+"\n"+instr;
			StringReader s = new StringReader(gram);
			parser = new Sintax(new LexerCup(s));
			parser.setEditor(Editor.this);

			try {
				verf=1;
				parse_tree = parser.parse();
				setFin();
			} catch (Exception e) {
				getMsjError();
			}
		}
                
		
		if(verf==0){
			String gram = "PARTIR"+"\n"+instr;
			StringReader s = new StringReader(gram);
			parser = new Sintax(new LexerCup(s));
			try {
				parser.parse();
			} catch (Exception e) {
                            getMsjError();
			}
		}
        }
	
	
}

