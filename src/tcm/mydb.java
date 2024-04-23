
package tcm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class mydb {
    private Connection conn;
    private Statement stm;
    private ResultSet rs;
public Connection getConnection(){

try{
    String url="jdbc:mysql://localhost/tcm";
    String user="root";
    String pass="";

    
    Class.forName("com.mysql.jdbc.Driver");
    conn=DriverManager.getConnection(url, user, pass);
    System.out.println("connected");
    }
catch(SQLException e){
    System.out.println("Error : "+e.getMessage());

    }
catch(ClassNotFoundException e){
    System.out.println("Error : "+e.getMessage());
 }
finally{
    return conn;
    }
}
public ResultSet searchQuery(String sql)
{
    try{
        getConnection();
        stm=conn.createStatement();
        rs=stm.executeQuery(sql);
        }
    catch(SQLException e){
        System.out.println("Error :" + e.getMessage());
        }
    
        return rs;

}
 public boolean addStaff(String id, String branch_id, String name, String branch_name, String designation, String dob, String age, String joining_date, String address, String experience, String speciality, String basic) {
     
     String query=" insert into staff ( branch_id, name , branch_name, designation , dob, age, joining_date, address, exp, speciality, basic)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setString(1, branch_id);
        pst.setString(2, name);
        pst.setString(3, branch_name );
        pst.setString(4,designation);
        pst.setString(5, dob);
        pst.setString(6, age);
        pst.setString(7, joining_date);
        pst.setString(8, address);
        pst.setString(9, experience);
        pst.setString(10, speciality);
        pst.setString(11, basic);
        int affected=pst.executeUpdate();
        System.out.println("affected rows :"+affected);
        return true;
        }
        catch(SQLException e){System.err.println(e.getMessage());}
            
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 public boolean UpdateStaff(String id, String branch_id, String name, String branch_name, String designation, String dob, String age, String joining_date, String address, String experience, String speciality, String basic) {
     
     String query=" update staff set branch_id= ?, name= ? , branch_name= ?, designation= ? , dob= ?, age= ?, joining_date =?, address= ?, exp= ?, speciality= ?, basic =? where id= ?";
        try{
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setString(1, branch_id);
        pst.setString(2, name);
        pst.setString(3, branch_name );
        pst.setString(4,designation);
        pst.setString(5, dob);
        pst.setString(6, age);
        pst.setString(7, joining_date);
        pst.setString(8, address);
        pst.setString(9, experience);
        pst.setString(10, speciality);
        pst.setString(11, basic);
        pst.setString(12, id);
        
        int affected=pst.executeUpdate();
        System.out.println("affected rows :"+affected);
        return true;
        }
        catch(SQLException e){System.err.println(e.getMessage());}
            
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 public boolean deleteStaff(String id)
{
    try{
      String query = "delete from staff where id = ?";
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setInt(1,Integer.parseInt(id));
      preparedStmt.execute();
      return true;
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}
 
 boolean addUser(String name, String address, String phone, String uname, String pass) {
        String query=" insert into users ( name, address, phone, uname, pass)" + " values (?, ?, ?, ?, ?)";
        try{
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setString(1, name);
        pst.setString(2, address);
        pst.setString(3, phone);
        pst.setString(4, uname);
        pst.setString(5, pass);
        int affected=pst.executeUpdate();
        System.out.println("affected rows :"+affected);
        return true;
        }
        catch(SQLException e){System.err.println(e.getMessage());}
            
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 public boolean addPoint(String name, String location, String milestone, String sensitivity, String description) {
     
     String query=" insert into point ( name, location, milestone, sensitivity, description)" + " values (?, ?, ?, ?, ?)";
        try{
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setString(1, name);
        pst.setString(2, location);
        pst.setString(3, milestone );
        pst.setString(4, sensitivity);
        pst.setString(5, description);
        int affected=pst.executeUpdate();
        System.out.println("affected rows :"+affected);
        return true;
        }
        catch(SQLException e){System.err.println(e.getMessage());}
            
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
 public boolean UpdatePoint(String id,String name, String location, String milestone, String sensitivity, String description) {
     
     String query=" update point set name= ?, location= ? , milestone= ?, sensitivity= ? ,description= ? where id= ?";
        try{
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setString(1, name);
        pst.setString(2, location );
        pst.setString(3, milestone);
        pst.setString(4, sensitivity);
        pst.setString(5, description);
        pst.setString(6, id);

        
        int affected=pst.executeUpdate();
        System.out.println("affected rows :"+affected);
        return true;
        }
        catch(SQLException e){System.err.println(e.getMessage());}
            
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
  public boolean deletePoint(String id)
{
    try{
      String query = "delete from point where id = ?";
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setInt(1,Integer.parseInt(id));
      preparedStmt.execute();
      return true;
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}
  
  public boolean addDriver(String name, String age, String dob, String height, String email, String address1, String address2) {
     
     String query=" insert into driver ( name ,age ,dob ,height ,email ,address1 ,address2 )" + " values (?, ?, ?, ?, ?, ?, ?)";
        try{
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setString(1, name);
        pst.setString(2, age);
        pst.setString(3, dob );
        pst.setString(4,height );
        pst.setString(5, email);
        pst.setString(6, address1);
        pst.setString(7, address2);

        int affected=pst.executeUpdate();
        System.out.println("affected rows :"+affected);
        return true;
        }
        catch(SQLException e){System.err.println(e.getMessage());}
            
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
  }
  public boolean addVehical(String name, String regno,String fuel,String engine)     
  {
     String query=" insert into vehical ( reg_no ,name ,fuel_type ,engine_type )" + " values (?, ?, ?, ?)";
        try{
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setString(1, regno);
        pst.setString(2, name);
        pst.setString(3, fuel);
        pst.setString(4,engine );

        int affected=pst.executeUpdate();
        System.out.println("affected rows :"+affected);
        return true;
        }
        catch(SQLException e){System.err.println(e.getMessage());}
            
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public boolean addChalan(String Cfine, String Cipc_no, String Cnorm_des, String Coffence_no, String Coffence_des, String Clong_des, String Cterms) {
        String query=" insert into chalan ( fine,ipc_no,description,offence_no,offence_description,long_description,terms)" + " values ( ?, ?, ?, ?, ?, ?, ?)";
        try{
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setString(1, Cfine);
        pst.setString(2, Cipc_no);
        pst.setString(3, Cnorm_des);
        pst.setString(4,Coffence_no);
        pst.setString(5,Coffence_des);
        pst.setString(6,Clong_des);
        pst.setString(7,Cterms);
        int affected=pst.executeUpdate();
        System.out.println("affected rows :"+affected);
        return true;
        }
        catch(SQLException e){System.err.println(e.getMessage());}
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  public boolean uptChalan(int Cid,String Cfine, String Cipc_no, String Cnorm_des, String Coffence_no, String Coffence_des, String Clong_des, String Cterms) {
        String query=" update chalan set fine= ?,ipc_no= ?,description= ?,offence_no= ?,offence_description= ?,long_description= ?,terms= ? where c_id= ?";
        try{
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setString(1, Cfine);
        pst.setString(2, Cipc_no);
        pst.setString(3, Cnorm_des);
        pst.setString(4,Coffence_no);
        pst.setString(5,Coffence_des);
        pst.setString(6,Clong_des);
        pst.setString(7,Cterms);
        pst.setInt(9, Cid);        
        
        int affected=pst.executeUpdate();
        System.out.println("affected rows :"+affected);
        return true;
        }
        catch(SQLException e){System.err.println(e.getMessage());}
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
  public boolean uptVehical(int Vid,String name, String regno,String fuel,String engine)     
  {
     String query=" update vehical set reg_no= ? ,name= ? ,fuel_type= ? ,engine_type= ? where id= ?";
        try{
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setString(1, regno);
        pst.setString(2, name);
        pst.setString(3, fuel);
        pst.setString(4,engine );
        pst.setInt(5, Vid);

        int affected=pst.executeUpdate();
        System.out.println("affected rows :"+affected);
        return true;
        }
        catch(SQLException e){System.err.println(e.getMessage());}
            
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
  public boolean uptDriver(int Did,String name, String age, String dob, String height, String email, String address1, String address2) {
     
     String query=" update driver set name= ?,age= ? ,dob= ? ,height= ? ,email= ? ,address1= ? ,address2= ? where id= ?";
        try{
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setString(1, name);
        pst.setString(2, age);
        pst.setString(3, dob );
        pst.setString(4,height );
        pst.setString(5, email);
        pst.setString(6, address1);
        pst.setString(7, address2);
        pst.setInt(8, Did);

        int affected=pst.executeUpdate();
        System.out.println("affected rows :"+affected);
        return true;
        }
        catch(SQLException e){System.err.println(e.getMessage());}
            
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
  }
  boolean deleteQuery(String sql)
  {
      try{
        getConnection();
        stm=conn.createStatement();
        stm.execute(sql);
        
        return true;
        }
    catch(SQLException e){
        System.out.println("Error :" + e.getMessage());
        }
      return false;
  }
  
   public boolean addAllocation(String Ano, String Ono, String Tpno, String ftime, String ttime, String rm) {
       String query=" insert into allocation ( auth_officer_no ,onduty_officer_no , tp_no , remarks ,from_time, to_time )" + " values (?, ?, ?, ? ,? ,?)";
        try{
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setString(1, Ano);
        pst.setString(2, Ono);
        pst.setString(3, Tpno);
        pst.setString(4,rm );
        pst.setString(5, ftime);
        pst.setString(6,ttime );
        int affected=pst.executeUpdate();
        System.out.println("affected rows :"+affected);
        return true;
        }
        catch(SQLException e){System.err.println(e.getMessage());}
      
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean addRaising(String d, String nid, String did, String vid) {
        String query=" insert into raising ( date ,norm_id , driver_id , vehical_id )" + " values (?, ?, ?, ?)";
        try{
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setString(1, d);
        pst.setString(2, nid);
        pst.setString(3, did);
        pst.setString(4,vid );
        int affected=pst.executeUpdate();
        System.out.println("affected rows :"+affected);
        return true;
        }
        catch(SQLException e){System.err.println(e.getMessage());}
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
 
}