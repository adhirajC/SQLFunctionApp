package easymoney;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class RiceListener implements ActionListener{
JButton button;

	public RiceListener(JButton riceButton) {
		// TODO Auto-generated constructor stub
		this.button=riceButton;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  String[] choices = { "Id", "Name","Brand","Type","Size","Score","Price"};
		    String input = (String) JOptionPane.showInputDialog(null, "Search by",
		        "Search Options", JOptionPane.QUESTION_MESSAGE, null, // Use
		                                                                        // default
		                                                                        // icon
		        choices, // Array of choices
		        choices[1]); // Initial choice
		    System.out.println(input);
		    if (input=="Id"){
		    String search = JOptionPane.showInputDialog("Enter Input:");
		    System.out.println(search);
		    String sqlQueryString = "select * from brown_rice where id="+search;
            System.out.println("");
          //  System.out.println(sqlQueryString);
            mainone main=new mainone();
	        try {
				ResultSet rs = (main.getStat()).executeQuery(sqlQueryString);
				 while (rs.next()) {
			            System.out.print("code: " + rs.getString("id"));
			            System.out.println(" title = " + rs.getString("name"));}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}if (input=="Name"){
		   String search = JOptionPane.showInputDialog("Enter Input:");
		    System.out.println(search);
		    String sqlQueryString = "select * from brown_rice where name like '%"+search+"%';";
           System.out.println("");
         //  System.out.println(sqlQueryString);
           mainone main=new mainone();
           DefaultListModel<String> nameModel = new DefaultListModel<>();
           ArrayList<String>namearray=new ArrayList<String>();
	        try {
				ResultSet rs = (main.getStat()).executeQuery(sqlQueryString);
				 while (rs.next()) {
			            System.out.print("code: " + rs.getString("id"));
			            System.out.println(" title = " + rs.getString("name"));
			            Departments name = new Departments(rs.getString("id"),rs.getString("name"));
			            namearray.add(name.toString());
			             nameModel.addElement(name.toString());}Rice name=new Rice(nameModel);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
	}
	}
	if (input=="Brand"){
		   String search = JOptionPane.showInputDialog("Enter Input:");
		    System.out.println(search);
		    String sqlQueryString = "select * from brown_rice where brand like '%"+search+"%';";
		    DefaultListModel<String> BrandModel = new DefaultListModel<>();
            ArrayList<String>brandarray=new ArrayList<String>();
        System.out.println("");
      //  System.out.println(sqlQueryString);
        mainone main=new mainone();
	        try {
				ResultSet rs = (main.getStat()).executeQuery(sqlQueryString);
				 while (rs.next()) {
			            System.out.print("code: " + rs.getString("id"));
			            System.out.println(" title = " + rs.getString("name"));
					       Departments brand = new Departments(rs.getString("id"),rs.getString("name"));

			            brandarray.add(brand.toString());
			             BrandModel.addElement(brand.toString());
}Rice rice=new Rice(BrandModel);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
	}
	}
	if (input=="Type"){
		   String search = JOptionPane.showInputDialog("Enter Input:");
		    System.out.println(search);
		    String sqlQueryString = "select * from brown_rice where type like '%"+search+"%';";
     System.out.println("");
   //  System.out.println(sqlQueryString);
     mainone main=new mainone();
	        try {
				ResultSet rs = (main.getStat()).executeQuery(sqlQueryString);
				  DefaultListModel<String> typeModel = new DefaultListModel<>();
		           ArrayList<String>typearray=new ArrayList<String>();
				 while (rs.next()) {
			            System.out.print("code: " + rs.getString("id"));
			            System.out.println(" title = " + rs.getString("name"));
			            Departments type = new Departments(rs.getString("id"),rs.getString("name"));
			            typearray.add(type.toString());
			             typeModel.addElement(type.toString());}Rice type=new Rice(typeModel);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
	}
	}
	if (input=="Size"){
		   String search1 = JOptionPane.showInputDialog("Enter Min:");
		   String search2 = JOptionPane.showInputDialog("Enter Max:");
		    System.out.println(search1);
		    String sqlQueryString = "select * from brown_rice where size>"+search1+" and size<"+search2+";";
    System.out.println("");
  //  System.out.println(sqlQueryString);
    mainone main=new mainone();
	        try {
				ResultSet rs = (main.getStat()).executeQuery(sqlQueryString);
				  DefaultListModel<String> sizeModel = new DefaultListModel<>();
		           ArrayList<String>sizearray=new ArrayList<String>();
				 while (rs.next()) {
			            System.out.print("code: " + rs.getString("id"));
			            System.out.println(" title = " + rs.getString("name"));				   
			            Departments size = new Departments(rs.getString("id"),rs.getString("name"));
 sizearray.add(size.toString());
		             sizeModel.addElement(size.toString());}
				 
		           Rice size=new Rice(sizeModel);
				 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
	}
	}
	if (input=="Price"){
		  
		   String search1 = JOptionPane.showInputDialog("Enter Min:");
		   String search2 = JOptionPane.showInputDialog("Enter Max:");
		    String sqlQueryString = "select * from brown_rice where price>"+search1+" and price<"+search2+";";
 System.out.println("");
//  System.out.println(sqlQueryString);
 mainone main=new mainone();
	        try {	  DefaultListModel<String> priceModel = new DefaultListModel<>();
	           ArrayList<String>pricearray=new ArrayList<String>();
				ResultSet rs = (main.getStat()).executeQuery(sqlQueryString);
				 while (rs.next()) {
			            System.out.print("code: " + rs.getString("id"));
			            System.out.println(" title = " + rs.getString("name"));
			            Departments price = new Departments(rs.getString("id"),rs.getString("name"));
pricearray.add(price.toString());
priceModel.addElement(price.toString());}   Rice price=new Rice(priceModel);

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
	}
	}
	if (input=="Score"){
		  
		   String search1 = JOptionPane.showInputDialog("score is more than:");
		 
		    String sqlQueryString = "select * from brown_rice where score>"+search1+";";
System.out.println("");
//System.out.println(sqlQueryString);
mainone main=new mainone();
	        try {DefaultListModel<String> scoreModel = new DefaultListModel<>();
	           ArrayList<String>scorearray=new ArrayList<String>();
			
				ResultSet rs = (main.getStat()).executeQuery(sqlQueryString);
				 while (rs.next()) {
			            System.out.print("code: " + rs.getString("id"));
			            System.out.println(" title = " + rs.getString("name"));
			            Departments score = new Departments(rs.getString("id"),rs.getString("name"));
			            scorearray.add(score.toString());
			            scoreModel.addElement(score.toString());
				 }  Rice score=new Rice(scoreModel);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
	}
	}
	
}}
