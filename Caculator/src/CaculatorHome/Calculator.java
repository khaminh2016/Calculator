/**
 * 
 */
package CaculatorHome;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.script.ScriptException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;

/**
 * @author KhaMinh T150737
 *
 */
public class Calculator extends JFrame {
	int MS, MR, MC, bDele;
	int x = 0, y = 50, w = 45, h = 45, d = 5;
	int x2=0,y2=100;
	int x3=0,y3=170 ;
	JPanel penStandard = new JPanel();
	JPanel penScientific = new JPanel();
	JPanel penProGrammer = new JPanel();
	JPanel penSubScien = new JPanel();

	String[][] btn = { { "MC", "MR", "MS", "M+", "M-" }, { "<--", "CE", "C", "∓", "√" }, { "7", "8", "9", "/", "%" },
			{ "4", "5", "6", "*", "1/x" }, { "1", "2", "3", "-", "=" }, { "0", "he", ",", "+", " " }, };
	String[][] btn2 = { { " ", "Inv", "ln", "(", ")" }, { "Int", "sinh", "sin", "x2", "n!" },
			{ "dms", "cosh", "cos", "xy", "y√x" }, { "Pi", "tanh", "tan", "x3", "3√x" },
			{ "F-E", "Exp", "Mod", "log", "10x" }, };
	String[] lbll={
			"0000","0000","0000","0000","0000","0000","0000","0000"
	};
	JLabel lbllPro[] = new JLabel[8];
	JLabel lbllPro2[] = new JLabel[8];
	int xl=20,yl=90;
	JButton[][] btnBut = new JButton[6][5];
	JButton[][] btnBut2 = new JButton[5][5];
	JButton[][] btnBut3 = new JButton[6][5];
	JMenuBar mnBar;
	JMenu mneView, mneEdit, mneHelp;
	JMenuItem mniStan, mniScien, mniPro, mniExit;
	JTextField txtSrc;
	JTextField txtSrc2;
	JTextField txtSrc3;
	JRadioButton bgDeg, bgRa, bgGra;
	ButtonGroup bgSelect = new ButtonGroup();
	int count = 0;
	int NumberChange = 0;
	int NumberChange2 = 0;
	/** ProGramer  **/
	String[][] btn3 ={
			{" ","Mod","A"},
			{"(",")","B"},
			{"RoL","RoR","C"},
			{"Or","Xor","D"},
			{"Lsh","Rsh","E"},
			{"Not","And","F"},
	};
	JButton[][] btnProGram = new JButton[6][3];
	int xbtnP= 110,ybtnP=170;
	JRadioButton rProrame[] = new JRadioButton[4];
	String []rRadioPro = {
			"Hex","Dec","Oct","Bin"
	};
	ButtonGroup bgSelecR = new ButtonGroup();
	int xR=20,yR=170;
	int xrS=20,yrS=5;
	JPanel penRaPro = new JPanel();
	public Calculator() {
		setSize(400, 450);
		setTitle("Calculator");
		setLayout(null);
		MenuProGrammer();
		ActionMenu();

	}

	public void ActionMenu() {
		ActionListener bAcMeo = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent g) {
				// TODO Auto-generated method stub
				if (g.getSource() == mniStan) {
					MenuMinhStandrad();
					ActionBtnMinhStandard();
					penScientific.setVisible(false);
					penStandard.setVisible(true);
					penProGrammer.setVisible(false);
				} else if (g.getSource() == mniScien) {
					MenuMinhScientific();
					penScientific.setVisible(true);
					penStandard.setVisible(false);
					penProGrammer.setVisible(false);
				}else if(g.getSource()==mniPro){
					MenuProGrammer();
					penProGrammer.setVisible(true);
					penStandard.setVisible(false);
					penScientific.setVisible(false);
				}
			}
		};
		mniScien.addActionListener(bAcMeo);
		mniStan.addActionListener(bAcMeo);
		mniPro.addActionListener(bAcMeo);
	}

	public void MenuMinhStandrad() {

		txtSrc = new JTextField();
		add(txtSrc);
		txtSrc.setBounds(20, 10, 250, 60);
		txtSrc.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		txtSrc.setHorizontalAlignment(JTextField.RIGHT);
		txtSrc.setEnabled(false);
		Font f = txtSrc.getFont();
		txtSrc.setFont(new Font(f.getName(), Font.BOLD, f.getSize() + 20));
		txtSrc.setEnabled(false);
		mnBar = new JMenuBar();
		mneView = new JMenu("View");
		mneEdit = new JMenu("Edit");
		mneHelp = new JMenu("Help");
		mniStan = new JMenuItem("Standard");
		mniScien = new JMenuItem("Scientific");
		mniPro = new JMenuItem("Programmer");
		mniExit = new JMenuItem("Exit");
		mneView.add(mniStan);
		mneView.addSeparator();
		mneView.add(mniScien);
		mneView.addSeparator();
		mneView.add(mniPro);
		mneView.addSeparator();
		mneView.add(mniExit);
		mnBar.add(mneView);
		mnBar.add(mneEdit);
		mnBar.add(mneHelp);
		setJMenuBar(mnBar);
		mneView.setMnemonic(KeyEvent.VK_V);
		mneEdit.setMnemonic(KeyEvent.VK_E);
		mneHelp.setMnemonic(KeyEvent.VK_H);
		penStandard.setLayout(null);
		y = 0;
		Insets s = new Insets(1, 1, 1, 1);
		for (int i = 0; i < 6; i++) {
			x = 0;
			for (int j = 0; j < 5; j++) {
				btnBut[i][j] = new JButton(btn[i][j]);
				penStandard.add(btnBut[i][j]);
				btnBut[i][j].setBounds(x, y, w, h);
				btnBut[i][j].setMargin(s);
				x = x + d + w;
			}
			y = y + d + w;
		}
		this.add(penStandard);
		penStandard.setBounds(20, 80, 250, 300);
		penStandard.setBackground(Color.BLACK);
		btnBut[5][4].setVisible(false);
		btnBut[5][1].setVisible(false);
		btnBut[4][4].setSize(w, h + h + d);
		btnBut[5][0].setSize(w + w + d, h);
		mniExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		mniExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
	}

	// FIXME chinh loi cua boder bg
	public void MenuMinhScientific() {
		txtSrc2 = new JTextField();
		penScientific.add(txtSrc2);
		txtSrc2.setBounds(10, 20, 500, 60);
		txtSrc2.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		txtSrc2.setHorizontalAlignment(JTextField.RIGHT);
		txtSrc2.setEnabled(false);
		mnBar = new JMenuBar();
		mneView = new JMenu("View");
		mneEdit = new JMenu("Edit");
		mneHelp = new JMenu("Help");
		mniStan = new JMenuItem("Standard");
		mniScien = new JMenuItem("Scientific");
		mniPro = new JMenuItem("Programmer");
		mniExit = new JMenuItem("Exit");
		mneView.add(mniStan);
		mneView.addSeparator();
		mneView.add(mniScien);
		mneView.addSeparator();
		mneView.add(mniPro);
		mneView.addSeparator();
		mneView.add(mniExit);
		mnBar.add(mneView);
		mnBar.add(mneEdit);
		mnBar.add(mneHelp);
		setJMenuBar(mnBar);
		mneView.setMnemonic(KeyEvent.VK_V);
		mneEdit.setMnemonic(KeyEvent.VK_E);
		mneHelp.setMnemonic(KeyEvent.VK_H);
		penScientific.setLayout(null);
		penSubScien.setLayout(null);
	
		Insets s = new Insets(1, 1, 1, 1);
		for (int i = 0; i < 6; i++) {
			x2 = 260;
			for (int j = 0; j < 5; j++) {
				btnBut[i][j] = new JButton(btn[i][j]);
				penScientific.add(btnBut[i][j]);
				btnBut[i][j].setBounds(x2, y2, w, h);
				btnBut[i][j].setMargin(s);

				x2 = x2 + d + w;
			}
			y2 = y2 + d + w;
		}
		y2 = w + d;
		y2 = 150;
		for (int i = 0; i < 5; i++) {
			x2 = 10;
			for (int j = 0; j < 5; j++) {
				btnBut2[i][j] = new JButton(btn2[i][j]);
				penScientific.add(btnBut2[i][j]);
				btnBut2[i][j].setBounds(x2, y2, w, h);
				btnBut2[i][j].setMargin(s);
				x2 = x2 + w + d;
			}
			y2 = y2 + d + w;
		}
		bgDeg = new JRadioButton("Degrees");
		bgRa = new JRadioButton("Radians");
		bgGra = new JRadioButton("Grads");
		bgSelect.add(bgDeg);
		bgSelect.add(bgGra);
		bgSelect.add(bgRa);
		penSubScien.add(bgDeg);
		penSubScien.add(bgRa);
		penSubScien.add(bgGra);
		bgDeg.setBounds(5, 10, 75, 30);
		bgRa.setBounds(80, 10, 75, 30);
		bgGra.setBounds(160,10, 80, 30);
		penSubScien.setBounds(10,100, 245,45);
		penSubScien.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
		penScientific.add(penSubScien);
		this.add(penScientific);
		penScientific.setBounds(0,0, 550, 500);
		// penScientific.setBackground(Color.GREEN);
		btnBut[5][4].setVisible(false);
		btnBut[5][1].setVisible(false);
		btnBut[4][4].setSize(w, h + h + d);
		btnBut[5][0].setSize(w + w + d, h);
		mniExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		mniExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));

	}
	public void MenuProGrammer(){
		txtSrc3 = new JTextField();
		penProGrammer.add(txtSrc3);
		txtSrc3.setBounds(10, 20, 500, 60);
		txtSrc3.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		txtSrc3.setHorizontalAlignment(JTextField.RIGHT);
		txtSrc3.setEnabled(false);
		Font f = txtSrc3.getFont();
		txtSrc3.setFont(new Font(f.getName(), Font.BOLD, f.getSize() + 20));
		mnBar = new JMenuBar();
		mneView = new JMenu("View");
		mneEdit = new JMenu("Edit");
		mneHelp = new JMenu("Help");
		mniStan = new JMenuItem("Standard");
		mniScien = new JMenuItem("Scientific");
		mniPro = new JMenuItem("Programmer");
		mniExit = new JMenuItem("Exit");
		mneView.add(mniStan);
		mneView.addSeparator();
		mneView.add(mniScien);
		mneView.addSeparator();
		mneView.add(mniPro);
		mneView.addSeparator();
		mneView.add(mniExit);
		mnBar.add(mneView);
		mnBar.add(mneEdit);
		mnBar.add(mneHelp);
		setJMenuBar(mnBar);
		mneView.setMnemonic(KeyEvent.VK_V);
		mneEdit.setMnemonic(KeyEvent.VK_E);
		mneHelp.setMnemonic(KeyEvent.VK_H);
		penProGrammer.setLayout(null);
		penRaPro.setLayout(null);
		Insets s = new Insets(1, 1, 1, 1);

		for (int i = 0; i < 6; i++) {
			x3 = 260;
			for (int j = 0; j < 5; j++) {
				btnBut3[i][j] = new JButton(btn[i][j]);
				penProGrammer.add(btnBut3[i][j]);
				btnBut3[i][j].setBounds(x3, y3, w, h);
				btnBut3[i][j].setMargin(s);

				x3 = x3 + d + w;
			}
			y3 = y3 + d + w;
		}
		y3 = w + d;
		for (int i = 0; i <8; i++) {
			lbllPro[i]=new JLabel(lbll[i]);
			add(lbllPro[i]);
			lbllPro2[i] = new JLabel(lbll[i]);
			add(lbllPro2[i]);
			lbllPro[i].setBounds(xl,yl,w,h);
			lbllPro2[i].setBounds(xl,yl+30,w,h);
			xl=xl+65;
		}
		for (int i = 0; i < 6; i++) {
			xbtnP=110;
			for (int j = 0; j < 3; j++) {
				btnProGram[i][j]=new JButton(btn3[i][j]);
				add(btnProGram[i][j]);
				btnProGram[i][j].setMargin(s);
				btnProGram[i][j].setBounds(xbtnP, ybtnP, w,h);
				xbtnP=xbtnP+w+d;
			}
			ybtnP=ybtnP+w+d;
		}
		for (int i = 0; i < 6; i++) {
			btnProGram[i][2].setEnabled(false);
		}
		btnProGram[0][0].setEnabled(false);
		for (int i = 0; i < 4; i++) {
			rProrame[i]= new JRadioButton(rRadioPro[i]);
			penRaPro.add(rProrame[i]);
			rProrame[i].setMargin(s);
			bgSelecR.add(rProrame[i]);
			rProrame[i].setBounds(xrS, yrS, w,h);
			yrS=yrS+30;
		}
		rProrame[0].setSelected(true);
		
		penRaPro.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
		penRaPro.setBounds(xR,yR,w+40,145);
		penProGrammer.add(penRaPro);
		this.add(penProGrammer);
		penProGrammer.setBounds(0,0, 550, 500);
		btnBut3[5][4].setVisible(false);
		btnBut3[5][1].setVisible(false);
		btnBut3[4][4].setSize(w, h + h + d);
		btnBut3[5][0].setSize(w + w + d, h);
		mniExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		mniExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
	}
	public void ActionBtnMinhStandard() {
		ActionListener bactUoin = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent g) {

				JButton btnReply = (JButton) g.getSource();
				String bNumber = btnReply.getText();
				String bCurrent = txtSrc.getText();
				if (bCurrent.equals("0")) {
					txtSrc.setText(bNumber);
				} else {
					txtSrc.setText(bCurrent + bNumber);
				}
			}
		};
		// FIXME xem lai số 0
		for (int i = 2; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				btnBut[i][j].addActionListener(bactUoin);
			}
		}
		btnBut[5][0].addActionListener(bactUoin);
		ActionListener bAction = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent g) {
				// TODO Auto-generated method stub
				if (g.getSource() == mniStan) {
					penStandard.setVisible(true);
					penScientific.setVisible(false);
				} else if (g.getSource() == mniScien) {
					penScientific.setVisible(true);
					penStandard.setVisible(false);
				} else if (g.getSource() == btnBut[5][3]) {
					Plus();
				} else if (g.getSource() == btnBut[4][3]) {
					Minus();
				} else if (g.getSource() == btnBut[3][3]) {
					Multi();
				} else if (g.getSource() == btnBut[2][3]) {
					division();
				} else if (g.getSource() == btnBut[4][4]) {
					EqualMinh();
				} else if (g.getSource() == btnBut[1][1]) {
					butCE();
				} else if (g.getSource() == btnBut[0][2]) {
					bMS();
				} else if (g.getSource() == btnBut[0][1]) {
					bMR();
				} else if (g.getSource() == btnBut[0][0]) {
					bMC();
				} else if (g.getSource() == btnBut[1][0]) {
					bDelete();
				}
			}
		};
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				btnBut[i][j].addActionListener(bAction);
			}
		}
		mniScien.addActionListener(bAction);
		mniStan.addActionListener(bAction);
	}

	public void Plus() {
		String Number1 = txtSrc.getText();
		txtSrc.setText("");
		NumberChange = Integer.parseInt(Number1);
		count = 1;
	}

	public void Minus() {
		String Number1 = txtSrc.getText();
		txtSrc.setText("");
		NumberChange = Integer.parseInt(Number1);
		count = 2;
	}

	public void Multi() {
		String Number1 = txtSrc.getText();
		txtSrc.setText("");
		NumberChange = Integer.parseInt(Number1);
		count = 3;
	}

	public void division() {
		String Number1 = txtSrc.getText();
		txtSrc.setText("");
		NumberChange = Integer.parseInt(Number1);
		count = 4;
	}

	public void EqualMinh() {
		if (count == 1) {
			String Number2 = txtSrc.getText();
			NumberChange2 = Integer.parseInt(Number2);
			txtSrc.setText(NumberChange + NumberChange2 + "");
		} else if (count == 2) {
			String Number2 = txtSrc.getText();
			NumberChange2 = Integer.parseInt(Number2);
			txtSrc.setText(NumberChange - NumberChange2 + "");
		} else if (count == 3) {
			String Number2 = txtSrc.getText();
			NumberChange2 = Integer.parseInt(Number2);
			txtSrc.setText(NumberChange * NumberChange2 + "");
		} else if (count == 4) {
			String Number2 = txtSrc.getText();
			NumberChange2 = Integer.parseInt(Number2);
			txtSrc.setText(NumberChange / NumberChange2 + "");
		}
	}

	public void butCE() {
		txtSrc.setText("");
	}

	public void bMS() {
		String a;
		a = txtSrc.getText();
		MS = Integer.parseInt(a);
	}

	public void bMR() {
		txtSrc.setText(MS + "");
	}

	public void bMC() {
		MS = 0;
	}

	public void bDelete() {
		String a = txtSrc.getText();
		a = a.substring(0, a.length() - 1);
		txtSrc.setText(Integer.parseInt(a) + "");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calculator maindown = new Calculator();
		maindown.setDefaultCloseOperation(EXIT_ON_CLOSE);
		maindown.setVisible(true);
	}

}
