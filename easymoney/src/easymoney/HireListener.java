package easymoney;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class HireListener implements ActionListener{
private JButton button;
	
	public HireListener(JButton hireButton) {
		this.button=button;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Create the menu bar.
		  String[] choices = { "Id", "Name"};
		    String input = (String) JOptionPane.showInputDialog(null, "Search by",
		        "Search Options", JOptionPane.QUESTION_MESSAGE, null, // Use
		                                                                        // default
		                                                                        // icon
		        choices, // Array of choices
		        choices[1]); // Initial choice
		    System.out.println(input);
		    
		    
		  if (input=="Id"){String search = JOptionPane.showInputDialog("Enter Input:");System.out.println(search);
		    String sqlQueryString = "select * from department where depid="+search;
            System.out.println("");
          //  System.out.println(sqlQueryString);
            mainone main=new mainone();
	        try {
				ResultSet rs = (main.getStat()).executeQuery(sqlQueryString);
				 while (rs.next()) {
			            System.out.print("code: " + rs.getString("depid"));
			            System.out.println(" title = " + rs.getString("title"));}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
		  if (input=="Name"){String search = JOptionPane.showInputDialog("Enter Input:");System.out.println(search);
			  String sqlQueryString = "select * from department where title like '%"+search+"%';";
	            System.out.println("");
	          //  System.out.println(sqlQueryString);
	            mainone main=new mainone();
		        try {
					ResultSet rs = (main.getStat()).executeQuery(sqlQueryString);
					 while (rs.next()) {
				            System.out.print("code: " + rs.getString("depid"));
				            System.out.println(" title = " + rs.getString("title"));}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		  }
	}


	}
