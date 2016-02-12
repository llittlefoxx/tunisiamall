package GUI.ShopRequestInterfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import javafx.scene.Parent;
import GUI.ShopRequestInterfaces.JTableModelViewRequest;
import Delegates.ManageShopRequestDelegate;
import edu.tunisiamall.entities.ShopRequest;

import javax.swing.JTable;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.TitledBorder;
import com.toedter.components.JLocaleChooser;

//import client.test.FramePrincipalTest;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewShopRequestAdminPannel extends JPanel {
	private JTable table;
	private List<ShopRequest> reqs;
	private JTable table_1;
	private JTextField textField;
	ShopRequest sr2=new ShopRequest();
	/**
	 * Create the panel.
	 */
	public ViewShopRequestAdminPannel() {
		setBackground(SystemColor.menu);
		setLayout(null);
		setBounds(500, 500, 777, 496); 
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(26, 220, 714, 149);
		add(tabbedPane);
		tabbedPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Shop Request List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		table_1 = new JTable();
		
		table_1.setColumnSelectionAllowed(true);
		JTableModelViewRequest jt = new JTableModelViewRequest();
		table_1.setModel(jt);
		
		tabbedPane.addTab("All Shop Request", null, table_1, null);
		table_1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				        
			        ////// 
				ShopRequest sr=new ShopRequest();
			     /*  if(e.getClickCount()==2)
			       {
			            
			             	int col=table_1.getSelectedColumn();
			            
			           
			                int ligne = table_1.getSelectedRow();
			                if(ligne==0)
			                return;
			             
			                System.out.println("iiiiiii "+ col + "kkkk " + ligne);
			                String chaine=table_1.getValueAt(ligne,col ).toString();
			                if(chaine.equals(null)|| chaine.equals(""))
			                {
			                	return;
			                }
			                System.out.println("pppppppppchaine "+ chaine );
			             
			                int id=jt.getShopRequest().get(ligne-1).getIdRequest();
			                System.out.println("iddd" + id);
			                sr=ManageShopRequestDelegate.doFindShopRequestById(id); 
			                System.out.println("srrr "+ sr.toString());
			                affiche(sr);
			                
			            }
			       else if (e.getClickCount()==1)
			       {*/
			    	  	int col=table_1.getSelectedColumn();
			            
				           
		                int ligne = table_1.getSelectedRow();
		                if(ligne==0)
		                return;
		             
		                System.out.println("iiiiiii "+ col + "kkkk " + ligne);
		                String chaine=table_1.getValueAt(ligne,col ).toString();
		                if(chaine.equals(null)|| chaine.equals(""))
		                {
		                	return;
		                }
		                System.out.println("pppppppppchaine "+ chaine );
		             
		                int id=jt.getShopRequest().get(ligne-1).getIdRequest();
		                System.out.println("iddd" + id);
		                sr=ManageShopRequestDelegate.doFindShopRequestById(id); 
		                System.out.println("srrr "+ sr.toString());
		                sr2=sr;
		                setShopRequest(sr2);
		            	System.out.println("sr2click**** "+sr2.toString());
			       
			                
			            
			                
				 
				
				
				
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("Manage Shop Request");
		lblNewLabel.setIcon(new ImageIcon(ViewShopRequestAdminPannel.class.getResource("/gui/images/shop.png.-m1.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Brush Script MT", Font.BOLD, 26));
		lblNewLabel.setBounds(184, 11, 375, 81);
		add(lblNewLabel);
		
		JLabel lblNewRequest = new JLabel("New Request");
		lblNewRequest.setBounds(612, 78, 80, 14);
		add(lblNewRequest);
		
		JButton button = new JButton("");
		button.setBounds(694, 69, 46, 33);
		add(button);
		button.setIcon(new ImageIcon(ViewShopRequestAdminPannel.class.getResource("/gui/images/newsletter-icon.png")));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(84, 142, 155, 22);
		add(dateChooser);
		
		JLabel lblDate = new JLabel("");
		lblDate.setIcon(new ImageIcon(ViewShopRequestAdminPannel.class.getResource("/gui/images/images (1).jpg")));
		lblDate.setBounds(26, 125, 62, 52);
		add(lblDate);
		
		textField = new JTextField();
		textField.setBounds(419, 142, 246, 22);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(675, 142, 37, 33);
		add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(ViewShopRequestAdminPannel.class.getResource("/gui/images/search (1).png")));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(552, 399, 89, 23);
		add(btnCancel);
		
		JButton btnNewButton_1 = new JButton("Verify");
		btnNewButton_1.setBounds(651, 399, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Search Tools");
		btnNewButton_2.setBounds(552, 170, 113, 22);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("All");
		btnNewButton_3.setBounds(501, 170, 46, 22);
		add(btnNewButton_3);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				
					System.out.println("sr2affiche**** "+sr2.toString());
	                affiche(getShopRequest());
				
			}
				
			
			});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
	}
	
	public void affiche(ShopRequest sr2){
		
	
		
		JFrame f1 = (JFrame) SwingUtilities.windowForComponent(this);
		//f1.setContentPane(new DisplayShopRequestPanel(getShopRequest()));
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(false);
		f1.setVisible(true);
		
		
		
		
		
	}
	
	public void setShopRequest(ShopRequest sr2)
	{
		this.sr2=sr2;
	}
	public ShopRequest getShopRequest()
	{
		return sr2;
	}
	
	
}
