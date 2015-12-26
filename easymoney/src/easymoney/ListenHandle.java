package easymoney;

import java.awt.FlowLayout;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JTextField;

public class ListenHandle extends JFrame{
	String id;
	String brand;
	String name;
	String type;
	String depid;
	String size;
	String price;
	String score;
	    public ListenHandle(String a){
	        super("Brown Rice");
	    
	        String sqlQueryString = "select * from brown_rice where id="+a+";";
            System.out.println("");
          //  System.out.println(sqlQueryString);
            try{
	        ResultSet rs = (new mainone().getStat()).executeQuery(sqlQueryString);
	        while (rs.next()) {
		           // System.out.print("code: " + rs.getString("depid"));
		           // System.out.println(" title = " + rs.getString("title"));    
		       this.id=rs.getString("id");
		       this.brand=rs.getString("brand");
		       this.name=rs.getString("name");
		       this.type=rs.getString("type");
		       this.size=rs.getString("size");
		       this.price=rs.getString("price");
		       this.score=rs.getString("score");
		       
       
  
             }
            }catch(SQLException e){System.out.println("didnt work");
	    
}    // Use the dafault metal styled titlebar
	        setUndecorated(true);
	        getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
	        // Set the style of the frame
	        add(new JTextField(this.id, 10));
	        add(new JTextField(this.brand, 10));
	        add(new JTextField(this.name, 10));
	        add(new JTextField(this.type, 10));
	        add(new JTextField(this.size, 10));
	        add(new JTextField(this.price, 10));
	        add(new JTextField(this.score, 10));
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setResizable(false);
	        setLayout(new FlowLayout());
	        pack();
	        setLocationRelativeTo(null);
	        setVisible(true);
}}
