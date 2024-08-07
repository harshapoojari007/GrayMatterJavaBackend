package com.grayMatter.Beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
public class DbUtils implements DbInterface {
 Connection con;
 @Override
 public List<Regions> getAll() throws SQLException {
  Statement st = con.createStatement();
  ResultSet rs = st.executeQuery("SELECT * FROM regions");
  
  List<Regions> rlist = new ArrayList<Regions>();
  
  while(rs.next())
   rlist.add(new Regions(rs.getInt(1), rs.getString(2)));
  
  return rlist;
 }
 @Override
 public Regions addRegion(Regions region) throws SQLException {
  PreparedStatement ps=con.prepareStatement("insert into regions values(?,?)");
  ps.setInt(1,region.getRid());
  ps.setString(2,region.getRname());
  ps.executeUpdate();
  
  Regions savedREgion=getRegionById(region.getRid());
  
return savedREgion;
 }
@Override
public Regions getRegionById(int id) throws SQLException {
	 PreparedStatement ps=con.prepareStatement("Select * from regions where region_id=?");
	  ps.setInt(1,id);
	  ResultSet rs=ps.executeQuery();
	  Regions savedREgion=null;
	  while(rs.next())
	   savedREgion=new  Regions(rs.getInt(1),rs.getString(2));
	  
	return savedREgion;
}
@Override
public Regions updateRegions(Regions region) throws SQLException {
	PreparedStatement ps=con.prepareStatement("update regions SET region_name=? where region_id=?");
	  ps.setInt(2,region.getRid());
	  ps.setString(1,region.getRname());
	  ps.executeUpdate();
	  Regions savedREgion=getRegionById(region.getRid());
	  
	  return savedREgion;
	  
}
@Override
public void deleteRegion(int id) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement ps=con.prepareStatement("delete from regions where region_id=?");
	  ps.setInt(1,id);
	  
	  ps.executeUpdate();
	  System.out.println("Successfully Deleted");
	
}
 
 

}