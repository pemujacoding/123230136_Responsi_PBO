/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Recruit;
import java.sql.*;
import java.util.*;
import Model.Connector;

/**
 *
 * @author Lab Informatika
 */
public class RecruitDAO implements  RecruitMethod{
    @Override
    public void insert(ModelRecruit recruit){
        try{
            String query = "INSERT INTO recruit (nama, path, writing, coding, interview, score, status) SET VALUE (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, recruit.getNama());
            statement.setString(2, recruit.getPath());
            statement.setInt(3, recruit.getWriting());
            statement.setInt(4, recruit.getCoding());
            statement.setInt(5, recruit.getInterview());
            statement.setInt(6, recruit.getScore());
            statement.setString(7, recruit.getStatus());
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            System.out.print("Input Failed" + e.getLocalizedMessage());
        }
    }

    @Override
    public void edit(ModelRecruit recruit) {
       try{
            String query = "UPDATE recruit SET nama = ?, path = ?, writing = ?, coding = ?, interview = ?, score = ?, status = ?  WHERE id = ?";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, recruit.getNama());
            statement.setString(2, recruit.getPath());
            statement.setInt(3, recruit.getWriting());
            statement.setInt(4, recruit.getCoding());
            statement.setInt(5, recruit.getInterview());
            statement.setInt(6, recruit.getScore());
            statement.setString(7, recruit.getStatus());
             statement.setInt(8,recruit.getId());
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            System.out.print("Input Failed" + e.getLocalizedMessage());
        }
    }

    @Override
    public void delete(int id) {
        try{
            String query = "DELETE recruit WHERE id = ?";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
             statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            System.out.print("Input Failed" + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelRecruit> getAll() {
         List<ModelRecruit> listRecruit = null;
          try{
            listRecruit = new ArrayList<>();
            Statement statement = Connector.Connect().createStatement();
            String query = "DELETE recruit WHERE id = ?";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                ModelRecruit rct = new ModelRecruit();
                rct.setId(resultSet.getInt("id"));
                rct.setNama(resultSet.getString("nama"));
                rct.setPath(resultSet.getString("path"));
                rct.setWriting(resultSet.getInt("writing"));
                rct.setCoding(resultSet.getInt("coding"));
                rct.setInterview(resultSet.getInt("interview"));
                rct.setScore(resultSet.getInt("score"));
                rct.setNama(resultSet.getString("nama"));
            }
            statement.close();
        }catch(SQLException e){
            System.out.print("Input Failed" + e.getLocalizedMessage());
        }
         return  listRecruit;
    }
}
