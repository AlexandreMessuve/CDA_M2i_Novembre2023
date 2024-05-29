package exercice.zoo;

import exercice.zoo.dao.AnimalDAO;
import exercice.zoo.entity.Animal;
import exercice.zoo.util.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DataBaseManager.getConnection();
            Animal animal = Animal.builder()
                    .name("Felix")
                    .type("Chat")
                    .age(10)
                    .description("Bonjour je suis felix le chat, je suis de couleur noire et blanche")
                    .habitat("domestic")
                    .build();
            AnimalDAO animalDAO = new AnimalDAO(connection);
            System.out.println(animal);
            animal = animalDAO.get(1);
            System.out.println(animal);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }



    }
}
