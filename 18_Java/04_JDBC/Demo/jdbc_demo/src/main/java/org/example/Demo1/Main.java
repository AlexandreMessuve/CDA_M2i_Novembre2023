package org.example.Demo1;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/demo_jdbc";
        String user = "root";
        String password = "Root";

        try{
            Connection connection = DriverManager.getConnection (url,user,password);
            if(connection != null ){
                System.out.println("La connection est reussis");

                String request = "INSERT INTO person (firstname,lastname) VALUE (?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(request,Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1,"firstname");
                preparedStatement.setString(2,"lastname");

                int row = preparedStatement.executeUpdate();

                ResultSet resultSetKey = preparedStatement.getGeneratedKeys();

                if(row>0){
                    System.out.println("Person add ");
                }
                if(resultSetKey.next()){
                    System.out.println("id : "+resultSetKey.getInt(1));
                }

                System.out.println("Requete  executée");


                String request2 = "SELECT * FROM person";
                Statement statement2 = connection.createStatement();
                ResultSet result = statement2.executeQuery(request2);
                while (result.next()){
                    System.out.println(result.getString("firstname") + " " + result.getString("lastname"));
                }

            }else{
                System.out.println("connexion echoué");
            }
        }catch (SQLException ex){
            throw  new RuntimeException(ex);
        }


    }
}