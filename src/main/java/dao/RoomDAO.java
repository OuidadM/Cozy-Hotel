package dao;

import utils.DataBaseConnectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomDAO {
    public Map<Integer,String> retrieveRooms(String type,String floor){
        Map<Integer,String> imagesPath = new HashMap<>();
        DataBaseConnectivity db = new DataBaseConnectivity();
        Connection conn = db.getConnection();
        String query;
        if(type == null) {
            query = "select r.num, r.image from rooms r " +
                    " JOIN floors f ON r.floor_id=f.id " +
                    " WHERE f.name=?";
        }
        else{
            query = "select r.num, r.image from rooms r"+
                    " JOIN floors f ON r.floor_id=f.id "+
                    " WHERE r.type=? AND f.name=?";
        }
        try(PreparedStatement ps = conn.prepareStatement(query)){
            if(type == null)
                ps.setString(1,floor);
            else{
                ps.setString(1,type);
                ps.setString(2,floor);
            }
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                imagesPath.put(rs.getInt("num"),rs.getString("image"));
            }
        }
        catch(SQLException e){
            System.err.println("Error while retrieving images's path from database");
        }
        finally{
            db.closeConnection();
        }
        return imagesPath;
    }

    public Map<String,String> retrieveRoomInformations(int num){
        Map<String,String> roomInfo = new HashMap<>();
        DataBaseConnectivity db = new DataBaseConnectivity();
        Connection conn = db.getConnection();
        String query= "select type, state, price, description from rooms WHERE num=?";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1,num);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                roomInfo.put("type",rs.getString("type"));
                roomInfo.put("state",rs.getString("state"));
                roomInfo.put("price",rs.getString("price"));
                roomInfo.put("description",rs.getString("description"));
            }
        }
        catch(SQLException e){
            System.err.println("Error while retrieving images's path from database");
        }
        finally{
            db.closeConnection();
        }
        return roomInfo;
    }

}
