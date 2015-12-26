package easymoney;
	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
public class mainone extends JPanel implements ListSelectionListener,ActionListener{
	



	/*
	This code has hard coded values for the database name, table names and names of the columns. The code is consistent with the
	following sqlite3 database schema:

	sqlite> .schema
	CREATE TABLE bookcodes (
	code text primary key,
	title text not null);

	CREATE TABLE songs(
	id integer primary key,
	bookcode text,
	page int,
	title text);

	Note some tables might have additional columns what that should not affect the code.

	*/

private String first;
	private JList list; 
	private Statement stat;
	private String ident;
		public static void main(String[] args) {
			  javax.swing.SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                createAndShowGUI();
		            }
		        });
		} 	
		
		public Statement getStat(){
			return stat;
		}
		public JList getlist(){
			return list;
		}
		
		  private static void createAndShowGUI() {
		        //Create and set up the window.
		        JFrame frame = new JFrame("ListDemo");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		        //Create and set up the content pane.
		        JComponent newContentPane = new mainone();
		        newContentPane.setOpaque(true); //content panes must be opaque
		        frame.setContentPane(newContentPane);
		     
		        //Display the window.
		        frame.pack();
		        frame.setVisible(true);
		    }
		public mainone(){ 
			super(new BorderLayout());
			System.out.println("Java With SQLite example");
			//GUI frame;
			

			//Connect to database
	        try {
	        	 JPanel here = new JPanel();
	        	//direct java to the sqlite-jdbc driver jar code
	        	// load the sqlite-JDBC driver using the current class loader
				Class.forName("org.sqlite.JDBC");
				
				//create connection to a database in the project home directory.
				//if the database does not exist one will be created in the home directory
			    
				//Connection conn = DriverManager.getConnection("jdbc:sqlite:mytest.db");
				
				//HARD CODED DATABASE NAME:
				Connection database = DriverManager.getConnection("jdbc:sqlite:realproj3005.db");
			       //create a statement object which will be used to relay a
			       //sql query to the database
			     this.stat = database.createStatement();

			    /*
			     * SQLite supports in-memory databases, which does not create any database files
			     * To use in memory database in your Java code, get the database connection as follows:
			     *
			     * Connection connection = DriverManager.getConnection("jdbc:sqlite::memory:");
			     * 
			    */
				
			   
	                //Query database for initial contents for GUI

		            String sqlQueryString = "select * from department;";
		            System.out.println("");
		          //  System.out.println(sqlQueryString);

			        ResultSet rs = stat.executeQuery(sqlQueryString);
			       
			    
			                //create the model and add elements
			                DefaultListModel<String> listModel = new DefaultListModel<>();
			                while (rs.next()) {
					           // System.out.print("code: " + rs.getString("depid"));
					           // System.out.println(" title = " + rs.getString("title"));    
					       Departments betterone = new Departments(rs.getString("depid"),rs.getString("title"));
					       
			                listModel.addElement(betterone.toString());

			            //  System.out.println(betterone);
			                }
			                this.list = new JList(listModel);
			                list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			                list.setSelectedIndex(0);
			                list.addListSelectionListener(this);
			               
			                list.setVisibleRowCount(5);
			                JScrollPane listScrollPane = new JScrollPane(list);
			         
			                //create the list
			                
			                list.addMouseListener(new MouseAdapter() {
			                    public void mouseClicked(MouseEvent evt) {
			                        JList list = (JList)evt.getSource();
			                        if (evt.getClickCount() == 2) {
			                          //  int index = list.locationToIndex(evt.getPoint());
			                        	  int index = list.locationToIndex(evt.getPoint());
			                
			                        	  String[] splited = (listModel.getElementAt(index)).split(" ");
			                        	  BrownRice handler=new BrownRice(splited[0]);
			                        	  handler.ricecontrol();
			                        	 }else if (evt.getClickCount() == 3) {   // Triple-click
			                            int index = list.locationToIndex(evt.getPoint());

			                        }
			                    
			                }});
			                
	
			              String hello="Search Departments";
			                JButton hireButton = new JButton(hello);
			               
			                HireListener hireListener = new HireListener(hireButton);
			                
			                hireButton.setActionCommand(hello);
			                
			                hireButton.addActionListener(hireListener);
			               
			                hireButton.setEnabled(true);
			                
			                String rice="Search Brown_rice";
			                JButton riceButton = new JButton(rice);
			               
			                RiceListener riceListener = new RiceListener(riceButton);
			                
			                riceButton.setActionCommand(rice);
			                
			                riceButton.addActionListener(riceListener);
			               
			                riceButton.setEnabled(true);
			              //  JTextField employeeName = new JTextField(10);
			                JPanel buttonPane = new JPanel();
			                buttonPane.setLayout(new BoxLayout(buttonPane,
			                                                   BoxLayout.LINE_AXIS));
			              //Create the menu bar.
			                
			              //  JTextField employeeName = new JTextField(10);
			                JPanel buttonPane1 = new JPanel();
			                buttonPane1.setLayout(new BoxLayout(buttonPane1,
			                                                   BoxLayout.LINE_AXIS));

			                //Build the first menu.
			              
			                buttonPane1.add(Box.createHorizontalStrut(5));
			                buttonPane1.add(new JSeparator(SwingConstants.VERTICAL));
			                buttonPane1.add(Box.createHorizontalStrut(5));
			                //buttonPane.add(employeeName);
			                buttonPane1.add(hireButton);
			               buttonPane1.add(riceButton);
			                buttonPane1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

			                JMenuBar menuBar = new JMenuBar();
			                add(listScrollPane, BorderLayout.CENTER);
			                add(buttonPane1, BorderLayout.PAGE_END);
			   Connection conn = null;
				/*           
			               

		            sqlQueryString = "select * from brown_rice;";
			        rs = stat.executeQuery(sqlQueryString);
		            System.out.println("");
		            System.out.println(sqlQueryString);
		            
		            ArrayList<FakeBookSong> riceResults = new ArrayList<FakeBookSong>();

			        int DISPLAY_LIMIT = 100;
			        int count = 0;

			        while (rs.next() && count < DISPLAY_LIMIT){
			            //System.out.print("id: " + rs.getString("id"));
			            //System.out.print("book: " + rs.getString("bookcode"));
			            //System.out.print(" page: " + rs.getInt("page"));
			            //System.out.println(" song: " + rs.getString("title"));
			            
			            FakeBookSong rice = new FakeBookSong(
			            		rs.getInt("id"),
			            		rs.getString("brand"),
			            		rs.getString("type"),
			            		rs.getString("name"),
			            		rs.getString("depid"),
			            		rs.getInt("size"),
			            		rs.getInt("score"),
			            		rs.getInt("price")
			            		);
			            riceResults.add(rice);
		            count++;
			        }
			        rs.close(); //close the query result table
			        
			        FakeBookSong[] riceArray = new FakeBookSong[1]; //just to establish array type
			        riceArray =  riceResults.toArray(riceArray);
					
			        //Create GUI with knowledge of database and initial query content
			        frame =  new GUI("Brown Rice Index", database, stat,departments ,riceResults); 
			        */
			        //Leave it to GUI to close database
			//       conn.close(); //close connection to database			
													
		
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        

			
	        //make GUI visible
		///	frame.setVisible(true);


		
	
		
}
		
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			// TODO Auto-generated method stub
		/*	 int[] selectedIx= getlist().getSelectedIndices();
			

		    Object sel =null;

		   
			 for (int i = 0; i < selectedIx.length; i++) {
			        sel = getlist().getModel().getElementAt(selectedIx[i]);
			    }
*/
			 if (!arg0.getValueIsAdjusting()) {
                 String a=getlist().getSelectedValue().toString();
                 String[] splited = a.split(" ");
                
                 this.ident=(splited[0]);
                  
                
               }
		
			   
		}public void setfirst(){
				this.first=this.ident;//System.out.println(ident);
				System.out.println(this.ident);
			}public String getfirst(){
		//System.out.println(ident);
		//	System.out.println(this.first);
		return first;
			
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	
		
}



