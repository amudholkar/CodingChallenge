import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Home extends JFrame {
	
	private Hotel hotel;
	private int restID;
	private String waiterName;
	private int tableNum;
	private ArrayList<String> waitersAvailable;
	private ArrayList<Integer> unassignedTables;
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Home(Hotel hotel) {
		
		this.hotel = hotel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 596, 500);
		
		contentPane = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout cl = new CardLayout(0, 0);
		contentPane.setLayout(cl);
		panel1.setLayout(null);
		panel2.setLayout(null);
		panel3.setLayout(null);
		panel4.setLayout(null);
		
	
		////// ADDING TO PANEL 1 //////////
		JButton viewTables = new JButton("View Tables");
		viewTables.setBounds(213, 56, 165, 67);
		panel1.add(viewTables);
				
		JButton viewAssignedTables = new JButton("View Assigned Tables");
		viewAssignedTables.setBounds(215, 193, 163, 82);
		panel1.add(viewAssignedTables);
				
		JButton assignTable = new JButton("Assign Table");
		assignTable.setBounds(215, 342, 165, 77);
		panel1.add(assignTable);
		
	
		////// ADDING TO PANEL 2 //////////
		JLabel lblNewLabel2 = new JLabel("View Tables - Select restaurant to view table assignments");
		lblNewLabel2.setBounds(126, 61, 374, 38);
		panel2.add(lblNewLabel2);
		
		JButton BackHomeFrom2 = new JButton("Back to Home");
		BackHomeFrom2.setBounds(220, 18, 151, 38);
		panel2.add(BackHomeFrom2);
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setBounds(243, 111, 325, 339);
		textArea2.setEditable(false);
		panel2.add(textArea2);
		
		JList list2 = new JList((hotel.restKeysToString()).toArray());
		//JList list = new JList();
		list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    list2.setSelectedIndex(-1);
		list2.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				//System.out.println(list1.getSelectedIndex());
				String result = hotel.viewTables((list2.getSelectedIndex())+1);
				textArea2.setText(result);
				
			}
		});
		list2.setBounds(23, 111, 208, 339);
		panel2.add(list2);
		
		
		////// ADDING TO PANEL 3 //////////
		JLabel lblNewLabel3 = new JLabel("View Tables Assigned - Select waiter to see asssigned tables");
		lblNewLabel3.setBounds(121, 75, 393, 16);
		panel3.add(lblNewLabel3);
		
		JButton BackHomeFrom3 = new JButton("Back to Home");
		BackHomeFrom3.setBounds(212, 20, 160, 43);
		panel3.add(BackHomeFrom3);
		
		JTextArea textArea3 = new JTextArea();
		textArea3.setBounds(212, 109, 357, 340);
		panel3.add(textArea3);
		
		JList list3 = new JList((hotel.waiterKeys()).toArray());
		list3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    list3.setSelectedIndex(-1);
		list3.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String result = hotel.viewAssignedTables((String)list3.getSelectedValue());
				textArea3.setText(result);
				
			}
		});
		list3.setBounds(26, 109, 174, 340);
		panel3.add(list3);
		
		
		///////////ADDING TO PANEL 4///////////
		JLabel lblAssignTable = new JLabel("Assign Table");
		lblAssignTable.setBounds(242, 53, 86, 16);
		panel4.add(lblAssignTable);
		
		JButton BackHomeFrom4 = new JButton("Back to Home");
		BackHomeFrom4.setBounds(215, 6, 141, 44);
		panel4.add(BackHomeFrom4);
		
		
		JList waiterList = new JList();
		waiterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		waiterList.setBounds(396, 92, 166, 290);
		panel4.add(waiterList);
		
		
		JList tableList = new JList();
		tableList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableList.setBounds(215, 92, 155, 290);
		panel4.add(tableList);
		

		JList restList = new JList((hotel.restKeysToString()).toArray());
		restList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    //list.setSelectedIndex(0);
		restList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				restID = restList.getSelectedIndex()+1;
				waitersAvailable = hotel.viewAvailableWaiters(restID);
				waiterList.setListData(waitersAvailable.toArray());
				
				unassignedTables = hotel.viewUnassignedTables(restID);
				tableList.setListData(unassignedTables.toArray());
				
				
				
				
				
			}
		
		}); 
		restList.setBounds(23, 92, 166, 290);
		panel4.add(restList);
		
		
		
		tableList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try{
					tableNum = (Integer)tableList.getSelectedValue();
				}
				catch(Exception NullPointerException){
					
				}
				
				
			}
		});
		
		waiterList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try{
					waiterName = (String)waiterList.getSelectedValue();
				}
				
				catch(Exception NullPointerException){
					
				}
				
				
			}
		});
		
		
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hotel.writeToFile(restID, waiterName, tableNum);
				hotel.assignWaiter(restID, waiterName, tableNum);
				
				//System.out.println(hotel.viewAssignedTables(waiterName));
				waitersAvailable = hotel.viewAvailableWaiters(restID);
				waiterList.setListData(waitersAvailable.toArray());
				
			
				unassignedTables = hotel.viewUnassignedTables(restID);
				tableList.setListData(unassignedTables.toArray());
				
				
				
			}
		});
		btnAssign.setBounds(228, 405, 128, 44);
		panel4.add(btnAssign);
		
		
		///////////// END ///////////////
		contentPane.add(panel1, "1");	
		contentPane.add(panel2, "2");
		contentPane.add(panel3, "3");
		contentPane.add(panel4, "4");
		
		
		cl.show(contentPane,"1");
			
		viewTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane,"2");
					
			}
		});
			
		viewAssignedTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane,"3");
					
			}
		});
		
		assignTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, "4");
			}
		});
		
		
		BackHomeFrom2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane,"1");
			}
		});
		
		BackHomeFrom3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane,"1");
			}
		});
		
		BackHomeFrom4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane,"1");
				
			}
		});
		
	}
}
