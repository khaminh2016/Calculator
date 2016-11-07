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
	int MS,MR,MC,bDele;
	int x = 0, y = 50, w = 45, h = 45, d = 5;
	JPanel penStandard = new JPanel();
	JPanel penScientific = new JPanel();
	JPanel penSub = new JPanel();
	String[][] btn = { { "MC", "MR", "MS", "M+", "M-" }, { "<--", "CE", "C", "∓", "√" }, { "7", "8", "9", "/", "%" },
			{ "4", "5", "6", "*", "1/x" }, { "1", "2", "3", "-", "=" }, { "0", "he", ",", "+", " " }, };
	String[][] btn2 = { { " ", "Inv", "ln", "(", ")" }, { "Int", "sinh", "sin", "x2", "n!" },
			{ "dms", "cosh", "cos", "xy", "y√x" }, { "Pi", "tanh", "tan", "x3", "3√x" },
			{ "F-E", "Exp", "Mod", "log", "10x" }, };
	JButton[][] btnBut = new JButton[6][5];
	JButton[][] btnBut2 = new JButton[5][5];
	JMenuBar mnBar;
	JMenu mneView, mneEdit, mneHelp;
	JMenuItem mniStan, mniScien, mniPro, mniExit;
	JTextField txtSrc;
	JTextField txtSrc2;
	JRadioButton bgDeg, bgRa, bgGra;
	ButtonGroup bgSelect = new ButtonGroup();
	int count = 0;
	int NumberChange = 0;
	int NumberChange2 = 0;

	public Calculator() {
		setSize(400, 450);
		setTitle("Calculator");
		setLayout(null);
		MenuMinhStandrad();
		ActionBtnMinhStandard();
		// MenuMinhScientific();

	}
	public void MenuMinhStandrad() {

		txtSrc = new JTextField();
		add(txtSrc);
		txtSrc.setBounds(20, 10, 250, 60);
		txtSrc.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		txtSrc.setHorizontalAlignment(JTextField.RIGHT);
		Font f = txtSrc.getFont();
		txtSrc.setFont(new Font(f.getName(),Font.BOLD,f.getSize()+20));
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
	// public void MenuMinhScientific() {
	// txtSrc2 = new JTextField();
	// add(txtSrc2);
	// txtSrc2.setBounds(10, 10, 500, 60);
	// txtSrc2.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
	// txtSrc2.setEnabled(false);
	// mnBar = new JMenuBar();
	// mneView = new JMenu("View");
	// mneEdit = new JMenu("Edit");
	// mneHelp = new JMenu("Help");
	// mniStan = new JMenuItem("Standard");
	// mniScien = new JMenuItem("Scientific");
	// mniPro = new JMenuItem("Programmer");
	// mniExit = new JMenuItem("Exit");
	// mneView.add(mniStan);
	// mneView.addSeparator();
	// mneView.add(mniScien);
	// mneView.addSeparator();
	// mneView.add(mniPro);
	// mneView.addSeparator();
	// mneView.add(mniExit);
	// mnBar.add(mneView);
	// mnBar.add(mneEdit);
	// mnBar.add(mneHelp);
	// setJMenuBar(mnBar);
	// mneView.setMnemonic(KeyEvent.VK_V);
	// mneEdit.setMnemonic(KeyEvent.VK_E);
	// mneHelp.setMnemonic(KeyEvent.VK_H);
	// penScientific.setLayout(null);
	// penSub.setLayout(null);
	// y=0;
	// Insets s = new Insets(1, 1, 1, 1);
	// for (int i = 0; i < 6; i++) {
	// x = 260;
	// for (int j = 0; j < 5; j++) {
	// btnBut[i][j] = new JButton(btn[i][j]);
	// penScientific.add(btnBut[i][j]);
	// btnBut[i][j].setBounds(x, y, w, h);
	// btnBut[i][j].setMargin(s);
	//
	// x = x + d + w;
	// }
	// y = y + d + w;
	// }
	// y=w+d;
	// for (int i = 0; i < 5; i++) {
	// x=10;
	// for (int j = 0; j < 5; j++) {
	// btnBut2[i][j] =new JButton(btn2[i][j]);
	// penScientific.add(btnBut2[i][j]);
	// btnBut2[i][j].setBounds(x,y,w,h);
	// btnBut2[i][j].setMargin(s);
	// x=x+w+d;
	// }
	// y = y + d + w;
	// }
	// bgDeg = new JRadioButton("Degrees");
	// bgRa = new JRadioButton("Radians");
	// bgGra = new JRadioButton("Grads");
	// bgSelect.add(bgDeg);
	// bgSelect.add(bgGra);
	// bgSelect.add(bgRa);
	// penSub.add(bgDeg);
	// penSub.add(bgRa);
	// penSub.add(bgGra);
	// bgDeg.setBounds(10,10,80,30);
	// bgRa.setBounds(90,10,80,30);
	// bgGra.setBounds(170,10,85,30);
	// penSub.setBounds(10,0,245,30);
	// penSub.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
	// penScientific.add(penSub);
	// this.add(penScientific);
	// penScientific.setBounds(0, 80,550, 300);
	// // penScientific.setBackground(Color.GREEN);
	// btnBut[5][4].setVisible(false);
	// btnBut[5][1].setVisible(false);
	// btnBut[4][4].setSize(w, h + h + d);
	// btnBut[5][0].setSize(w + w + d, h);
	// mniExit.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // TODO Auto-generated method stub
	// System.exit(0);
	// }
	// });
	// mniExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
	// ActionEvent.CTRL_MASK));
	// }

	public void ActionBtnMinhStandard() {
		ActionListener bactUoin = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent g) {
				
				JButton btnReply = (JButton)g.getSource();
				String bNumber =btnReply.getText();
				String bCurrent = txtSrc.getText();
				if(bCurrent.equals("0")){
					txtSrc.setText(bNumber);
				}else {
					txtSrc.setText(bCurrent+bNumber);
				}
			}
		};
		//FIXME xem lai số 0
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
				if(g.getSource()==btnBut[5][3]){
					Plus();
				}else if(g.getSource()==btnBut[4][3]){
					Minus();
				}else if(g.getSource()==btnBut[3][3]){
					Multi();
				}else if(g.getSource()==btnBut[2][3]){
					division();
				}else if(g.getSource()==btnBut[4][4]){
					EqualMinh();
				}else if(g.getSource()==btnBut[1][1]){
					butCE();
				}else if(g.getSource()==btnBut[0][2]){
					bMS();
				}else if(g.getSource()==btnBut[0][1]){
					bMR();
				}else if(g.getSource()==btnBut[0][0]){
					bMC();
				}else if(g.getSource()==btnBut[1][0]){
					bDelete();
				}
			}
		};
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				btnBut[i][j].addActionListener(bAction);
			}
		}
//		btnBut[5][3].addActionListener(bAction);
//		btnBut[4][3].addActionListener(bAction);
//		btnBut[3][3].addActionListener(bAction);
//		btnBut[2][3].addActionListener(bAction);
//		btnBut[4][4].addActionListener(bAction);
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
public void butCE(){
	txtSrc.setText("");
}
public void bMS(){
	String a;
	a=txtSrc.getText();
	MS=Integer.parseInt(a);
}
public void bMR(){
	txtSrc.setText(MS+"");
}
public void bMC(){
	MS=0;
}
public void bDelete(){
	String a= txtSrc.getText();
	a=a.substring(0,a.length()-1);
	txtSrc.setText(Integer.parseInt(a)+"");
}
 


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calculator maindown =new Calculator();
		maindown.setDefaultCloseOperation(EXIT_ON_CLOSE);
		maindown.setVisible(true);
	}

}
