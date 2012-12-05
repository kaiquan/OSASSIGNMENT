package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Point;

import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JWindow;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

public class DiskOptimizationApp {

	private JWindow jWindow = null;  //  @jve:decl-index=0:visual-constraint="123,146"
	private JPanel jContentPane = null;
	private JToolBar jJToolBarBar = null;
	private JButton jButton_close = null;  //  @jve:decl-index=0:visual-constraint="740,79"
	/**
	 * This method initializes jWindow	
	 * 	
	 * @return javax.swing.JWindow	
	 */
	JWindow getJWindow() {
		if (jWindow == null) {
			jWindow = new JWindow(new JFrame());
			jWindow.setSize(new Dimension(622, 309));
			jWindow.setContentPane(getJContentPane());
			jWindow.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			jWindow.addMouseMotionListener(new MouseMotionListener() {
			    private int mx, my;

			    public void mouseMoved(MouseEvent e) {
			        mx = e.getXOnScreen();
			        my = e.getYOnScreen();
			    }

			    @Override
			    public void mouseDragged(MouseEvent e) {
			        Point p = getJWindow().getLocation();
			        p.x += e.getXOnScreen() - mx;
			        p.y += e.getYOnScreen() - my;
			        mx = e.getXOnScreen();
			        my = e.getYOnScreen();
			        getJWindow().setLocation(p);
			    }
			});
		}
		return jWindow;
	}
	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.setForeground(Color.WHITE);
			jContentPane.setBorder(BorderFactory.createMatteBorder(10,10, 0,0,new ImageIcon("C:/Users/MoistyBurger/Desktop/images.jpg")) );
			jContentPane.setBackground(Color.white);
			
			Border border = UIManager.getBorder("InternalFrame.border");
			//jContentPane.setBorder(border);
			jContentPane.add(getJJToolBarBar(), BorderLayout.NORTH);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jJToolBarBar	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getJJToolBarBar() {
		if (jJToolBarBar == null) {
			jJToolBarBar = new JToolBar();
			jJToolBarBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jJToolBarBar.setFloatable(false);
			jJToolBarBar.setBackground(Color.white);
			jJToolBarBar.add(getJButton_close());
			jJToolBarBar.setForeground(Color.WHITE);
		}
		return jJToolBarBar;
	}
	/**
	 * This method initializes jButton_close	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_close() {
		if (jButton_close == null) {
			jButton_close = new JButton();
			jButton_close.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getJWindow().setVisible(false);
					getJWindow().removeAll();
				}
			});
			jButton_close.setOpaque(false); 
			jButton_close.setFocusPainted(false);
			jButton_close.setText(" X ");
		}
		return jButton_close;
	}

}
