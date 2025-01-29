package dao;

import utils.DataBaseConnectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FloorDAO {
    public List<String> getFloors(){
        List<String> floors = new ArrayList<String>();
        DataBaseConnectivity db = new DataBaseConnectivity();
        Connection conn = db.getConnection();
        String query ="SELECT name FROM floors";
        try(PreparedStatement ps=conn.prepareStatement(query)){
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                floors.add(rs.getString("name"));
            }
        }
        catch(SQLException e){
            System.err.println("Error while retrieving floors: " + e.getMessage());
        }
        finally{
            db.closeConnection();
        }
        return floors;
    }
}
