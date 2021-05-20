import java.util.*;  
import java.text.*;
import javax.swing.*;

public class Employee {

	private String employeeName;
    private String employeeID;
    private String checkInTime;
    private String checkOutTime;
    private String timeWorked;
    private String attendance;

  
    public Employee(String employeeName, String employeeID){
       this.employeeName = employeeName;
       this.employeeID = employeeID;
    }

    
    public String getEmployeeName(){
       return employeeName;
    }

    public String getEmployeeID(){
       return employeeID;
    }

    public String getCheckInTime(){
       return checkInTime;
    }
    
    public void setCheckInTime()
    {
       String checkInHour = null;
       String checkInMinute = null;
       int i1 = 0;
       int i2 = 0;
       while (true){
              try{
                  checkInHour = JOptionPane.showInputDialog(null, "Check in hour : ");
                  i1 = Integer.parseInt(checkInHour);
                  while (i1 < 0 || i1 > 23){
           JOptionPane.showMessageDialog(null, "Not a valid input, please try again","", JOptionPane.INFORMATION_MESSAGE);
                    checkInHour = JOptionPane.showInputDialog(null, "Check in hour : ");
                    i1 = Integer.parseInt(checkInHour);
                  }
                  break;
                }
             catch (NumberFormatException e){
           JOptionPane.showMessageDialog(null, "Not a valid input, please try again","", JOptionPane.INFORMATION_MESSAGE); } 
              }

       while (true){
             try{
                 checkInMinute = JOptionPane.showInputDialog(null, "Check in minute : ");
                 i2 = Integer.parseInt(checkInMinute);
                 while (i2 < 0 || i2 > 59){
            JOptionPane.showMessageDialog(null, "Not a valid input, please try again","", JOptionPane.INFORMATION_MESSAGE);
                   checkInMinute = JOptionPane.showInputDialog(null, "Check in minute : ");
                   i2 = Integer.parseInt(checkInMinute);
                 }
                 break;
               }
             catch (NumberFormatException e){  
            JOptionPane.showMessageDialog(null, "Not a valid input, please try again","", JOptionPane.INFORMATION_MESSAGE); } 
             }

       this.checkInTime = checkInHour + ":" + checkInMinute;
    }
    
    public String getCheckOutTime(){
       return checkOutTime;
    }
    
    
    public void setCheckOutTime(){
       String checkOutHour = null;
       String checkOutMinute = null;
       int i1 = 0;
       int i2 = 0;
       while (true){
              try{
                  checkOutHour = JOptionPane.showInputDialog(null, "Check out hour : ");
                  i1 = Integer.parseInt(checkOutHour);
                  while (i1 < 0 || i1 > 23){ 
             JOptionPane.showMessageDialog(null, "Not a valid input, please try again","", JOptionPane.INFORMATION_MESSAGE);
                    checkOutHour = JOptionPane.showInputDialog(null, "Check out hour : ");
                    i1 = Integer.parseInt(checkOutHour);
                  }
                  break;
                }
              catch (NumberFormatException e){ 
            JOptionPane.showMessageDialog(null, "Not a valid input, please try again","", JOptionPane.INFORMATION_MESSAGE); } 
              }

       while (true){
              try{
                  checkOutMinute = JOptionPane.showInputDialog(null, "Check out minute : ");
                  i2 = Integer.parseInt(checkOutMinute);
                  while (i2 < 0 || i2 > 59){  
                JOptionPane.showMessageDialog(null, "Not a valid input, please try again","", JOptionPane.INFORMATION_MESSAGE);
                   checkOutMinute = JOptionPane.showInputDialog(null, "Check out minute : ");
                   i2 = Integer.parseInt(checkOutMinute);
                  }
                  break;
                }
              catch (NumberFormatException e){  
            	JOptionPane.showMessageDialog(null, "Not a valid input, please try again","", JOptionPane.INFORMATION_MESSAGE); } 
                }
       this.checkOutTime = checkOutHour + ":" + checkOutMinute;;
    }
    
    public String getTimeWorked() throws Exception{
       SimpleDateFormat format = new SimpleDateFormat("HH:mm");
       Date date1 = format.parse(checkInTime);
       Date date2 = format.parse(checkOutTime);
       long difference = date2.getTime() - date1.getTime();
       if (date1.compareTo(date2) > 0)
          { difference = (format.parse("25:00")).getTime() + difference; }
       long diffMinutes = difference / (60 * 1000) % 60;
       long diffHours = difference / (60 * 60 * 1000) % 24;
       this.timeWorked = diffHours + ":" + diffMinutes;
       return timeWorked;
    }
    

    public String getAttendance() throws Exception{
       SimpleDateFormat format = new SimpleDateFormat("HH:mm");
       Date date1 = format.parse(timeWorked);
       String timeNeededToWork = 8 + ":" + 00;
       Date date2 = format.parse(timeNeededToWork);
       if (date1.compareTo(date2) == 0 || date1.compareTo(date2) > 0)
          {this.attendance = "EMPLOYEE ATTENDED AND WORKED FOR " + timeWorked + " HOURS";}
       else if (date1.compareTo(date2) < 0 && date1.compareTo(format.parse("00:00")) > 0)
          {this.attendance = "EMPLOYEE ATTENDED, BUT WORKED ONLY FOR " + timeWorked + " HOURS";}
       else
          {this.attendance = "EMPLOYEE DID NOT ATTEND";}
       return attendance;
    }
}