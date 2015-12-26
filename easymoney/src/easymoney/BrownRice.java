package easymoney;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class BrownRice extends JFrame implements ListSelectionListener,ActionListener{
	private String a;
	  public BrownRice(String string) {
		// TODO Auto-generated constructor stub
		  this.a=string;
	}
	public void ricecontrol(){
		JPanel rice = new JPanel();
   //  System.out.println(sqlQueryString);
try{String sqlQueryString = "select * from brown_rice where depid="+a+";";
     System.out.println("");
     mainone main=new mainone();
     ResultSet rs = main.getStat().executeQuery(sqlQueryString);
    
 
             //create the model and add elements
             DefaultListModel<String> brownricelistModel = new DefaultListModel<>();
             ArrayList<String>brownricearray=new ArrayList<String>();
             while (rs.next()) {
		           System.out.print("code: " + rs.getString("id"));
		           System.out.println(" title = " + rs.getString("name"));    
		       Departments good = new Departments(rs.getString("id"),rs.getString("name"));
		      brownricearray.add(good.toString());
             brownricelistModel.addElement(good.toString());

         //  System.out.println(betterone);
             }
             DefaultComboBoxModel model = new DefaultComboBoxModel();
         
             
             JFrame frame = new JFrame("Shared Data");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

             JPanel panel = new JPanel();
            

           

             JList brownricelist = new JList(brownricelistModel);
             JScrollPane scrollPane = new JScrollPane(brownricelist);
             frame.add(scrollPane, BorderLayout.CENTER);
    brownricelist.addMouseListener(new MouseAdapter() {
                 public void mouseClicked(MouseEvent evt) {
                     JList list = (JList)evt.getSource();
                     if (evt.getClickCount() == 2) {
                       //  int index = list.locationToIndex(evt.getPoint());
                     	  int index = list.locationToIndex(evt.getPoint());
                     	  
                     	  String[] splited = (brownricelistModel.getElementAt(index)).split(" ");
                     	  
                     	  ListenHandle listen=new ListenHandle(splited[0]);
                     	 }else if (evt.getClickCount() == 3) {   // Triple-click
                         int index = list.locationToIndex(evt.getPoint());

                     }
                 
             }});

             JButton button = new JButton("Search");
             frame.add(button, BorderLayout.SOUTH); 
            
             
             ActionListener actionListener = new ActionListener(){
               public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("search rice");
                String search1 = JOptionPane.showInputDialog("search name:");
                try{String sqlQueryString = "select * from brown_rice where depid="+a+" and name like '%"+search1+"%';";
                System.out.println("");
                mainone main=new mainone();
                ResultSet rs = main.getStat().executeQuery(sqlQueryString);
               
            
                        //create the model and add elements
                        DefaultListModel<String> brownricesearchlistModel = new DefaultListModel<>();
                        ArrayList<String>brownricesearcharray=new ArrayList<String>();
                        String searchdata[];
                        while (rs.next()) {
           		      //     System.out.print("code: " + rs.getString("id"));
           		       //    System.out.println(" title = " + rs.getString("name"));    
           		       Departments search = new Departments(rs.getString("id"),rs.getString("name"));
           		    
           		      brownricesearcharray.add(search.toString());
                        brownricesearchlistModel.addElement(search.toString());
                        }
                       Rice rice=new Rice(brownricesearchlistModel);
                }catch (SQLException e) {
                	// TODO Auto-generated catch block
                	e.printStackTrace();
                	}
               }
             };
         button.addActionListener(actionListener);

             frame.setSize(300, 200);
             frame.setVisible(true);
             
             
             
        
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
