package easymoney;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Rice extends JFrame implements ListSelectionListener{
public Rice(DefaultListModel<String> a){
	DefaultComboBoxModel model = new DefaultComboBoxModel();
    
    
    JFrame frame = new JFrame("Searched Rice");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
   

  

    JList list = new JList(a);
    JScrollPane scrollPane = new JScrollPane(list);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setSize(300, 200);
    frame.setVisible(true);
   list.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {
            JList list = (JList)evt.getSource();
            if (evt.getClickCount() == 2) {
              //  int index = list.locationToIndex(evt.getPoint());
            	  int index = list.locationToIndex(evt.getPoint());
            	
            	  String[] splited = (a.getElementAt(index)).split(" ");
            	  ListenHandle listen=new ListenHandle(splited[0]);
            	 }else if (evt.getClickCount() == 3) {   // Triple-click
                int index = list.locationToIndex(evt.getPoint());

            }
        
    }});
    
    
}

@Override
public void valueChanged(ListSelectionEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
