import java.awt.*;  
import javax.swing.*;

public class EmployeeView extends JFrame{

	JPanel panel;
	JLabel user_label, id_label;
	JTextField userName_text, id_text;
	JButton submit, get, cancel;
	
	EmployeeView(){
	   user_label = new JLabel();
	   user_label.setText("                 Employee Name :");
	   userName_text = new JTextField();
	      
	   id_label = new JLabel();
	   id_label.setText("                        Employee ID :");
	   id_text = new JTextField();
	      
	   submit = new JButton("ENTER");
	   get = new JButton("GET ATTENDANCE");
	   panel = new JPanel(new GridLayout(3, 1));
	      
	   panel.add(user_label);
	   panel.add(userName_text);
	   panel.add(id_label);
	   panel.add(id_text);
      panel.add(submit);
	   panel.add(get);
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   add(panel, BorderLayout.CENTER);
	   setTitle("Employee Time and Attendance");
	   setSize(450,300);
	   setVisible(true);
	}
	  
	public JTextField getUserNameText() {
	return userName_text;
	}
		 
	public JTextField getIDText() {
	return id_text;
	}
		 
	public JButton getSubmit() {
	return submit;
	}
		 
	public JButton getGet() {
	return get;
	}
}