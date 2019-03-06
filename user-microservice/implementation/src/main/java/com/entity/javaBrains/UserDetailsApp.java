package com.entity.javaBrains;

import com.repository.UserDetailsRepositoty;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;

@Component
public class UserDetailsApp implements CommandLineRunner {
    private UserDetailsRepositoty userDetailsRepositoty;



    public UserDetailsApp(UserDetailsRepositoty userDetailsRepositoty){
        this.userDetailsRepositoty =  userDetailsRepositoty;
    }

    @Override
    public void run(String... args) throws Exception {

        addUserDetails();

        getUser();


    }



    void getUser() {
        UserDetails userDetails = userDetailsRepositoty.findById(1L).orElseGet(null);
        Collection<Article> articlesArrays = userDetails.getArticlesArrays();
        articlesArrays.size();
    }


    private void addUserDetails() {
        UserDetails userDetails = new UserDetails();

        Address homeaddress = new Address();
        Address officeaddress = new Address();

        homeaddress.setCity("Courbevoie");
        homeaddress.setState("Hauts-De-Seine");
        homeaddress.setStreet("48 andré Prohtin");
        homeaddress.setCodePostal(92400);

        officeaddress.setCity("Paris");
        officeaddress.setState("Region-Paris");
        officeaddress.setStreet("22 Rue Saint George");
        officeaddress.setCodePostal(75015);

        userDetails.setUsername("Yaya");

        userDetails.setHomeAddress(homeaddress);
        userDetails.setOfficeAddress(officeaddress);


        // Article

        Article article = new Article();
        Article article2 = new Article();

        article.setName("Article one");
        article.setPrice(250);

        article2.setName("Article two");
        article.setPrice(360);

        userDetails.getArticles().addAll(Arrays.asList(article,article2));
        userDetails.getArticlesArrays().addAll(Arrays.asList(article,article2));

        /// ONE to ONE Vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");

        userDetails.setVehicle(vehicle);

        // ONE TO MANY avec LIST
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Jeep");

        userDetails.getVehiclesCollection().addAll(Arrays.asList(vehicle,vehicle2));


        userDetailsRepositoty.save(userDetails);
    }
}
