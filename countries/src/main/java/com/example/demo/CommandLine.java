package com.example.demo;
import com.example.demo.Administration.entity.City;
import com.example.demo.Administration.entity.Country;
import com.example.demo.Administration.service.CityService;
import com.example.demo.Administration.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

/**
 * Component for interaction with user using command line. Components annotated with {@link @Component} implementing
 * {@link CommandLineRunner} are executed automatically.
 */
@Component
public class CommandLine implements CommandLineRunner {

    private CityService cityService;

    private CountryService countryService;

    private Scanner scanner = new Scanner(System.in).useLocale(Locale.US);


    @Autowired
    public CommandLine(CityService cityService, CountryService countryService){
        this.cityService = cityService;
        this.countryService = countryService;
    }

    @Override
    public void run(String... args) throws Exception {

        //this.showMenu();
        /*cityService.create(City.builder().name("JDC").build());
        Optional<City> city = cityService.find(4);
        if(city.isPresent()){
            City c = city.get();
            c.setCountry(city.get().getCountry());//map(City::getCountry).orElse(null));
            c.setName(city.map(City::getName).orElseThrow());
            c.setNrOfStreets(399);
            cityService.update(c);
        }
        cityService.findAll().forEach(System.out::println);
        cityService.findAll(countryService.find("Spain").orElseThrow()).forEach(System.out::println);

        System.out.println();

        countryService.create(Country.builder().name("USA").build());
        Optional<Country> country = countryService.find("France");
        if(country.isPresent()){
            Country c = country.get();
            c.setGdpChange(3.123);
            c.setName(country.map(Country::getName).orElseThrow());
            c.setNrOfInhabitants(300_000_000);
            countryService.update(c);
        }
        countryService.findAll().forEach(System.out::println);
        cityService.delete(3);
        System.out.println();

        cityService.findAll().forEach(System.out::println);*/

    }

    /*public void showMenu(){
        System.out.println("---------------------------");
        System.out.println("1. List available commands");
        System.out.println("2. List all categories");
        System.out.println("3. List all elements");
        System.out.println("4. Add new element");
        System.out.println("5. Delete existing element");
        System.out.println("6. Stop the application");
        System.out.println("Make a choice: ");

        int choice;
        choice = scanner.nextInt();

        this.doWork(choice);

    }

    public void doWork(int choice){
        switch (choice){
            case 1:
                break;
            case 2:
                countryService.findAllCountries().forEach(System.out::println);
                break;
            case 3:
                cityService.findAllCities().forEach(System.out::println);
                break;
            case 4:
                this.addElement();
                break;
            case 5:
                this.deleteElement();
                break;
            case 6:
                System.exit(0);
                break;
        }
        this.showMenu();
    }

    public void addElement(){
        System.out.println("Pick a category:");
        System.out.println("1. Country");
        System.out.println("2. City");

        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice == 1){
            String name;
            double gdpChange;
            int nrOfInhabitants;
            System.out.println("Name:");
            name = scanner.nextLine();
            System.out.println("gdpChange:");
            gdpChange = scanner.nextDouble();
            System.out.println("nrOfInhabitants:");
            nrOfInhabitants = scanner.nextInt();
            Country country = new Country();
            country.setName(name);
            country.setGdpChange(gdpChange);
            country.setNrOfInhabitants(nrOfInhabitants);
            countryService.createCountryByObj(country);
        }
        else{
            String name;
            String countryName;
            int nrOfStreets;
            System.out.println("Name:");
            name = scanner.nextLine();
            System.out.println("Country name:");
            countryName = scanner.nextLine();
            System.out.println("Number of streets:");
            nrOfStreets = scanner.nextInt();
            Optional<Country> countryOptional = countryService.findByName(countryName);
            Country country = new Country();
            int nrOfInhabs = countryOptional.map(Country::getNrOfInhabitants).orElse(0);
            String countryName1 = countryOptional.map(Country::getName).orElse("");
            double gdp = countryOptional.map(Country::getGdpChange).orElse(0.0);
            country.setNrOfInhabitants(nrOfInhabs);
            country.setName(countryName1);
            country.setGdpChange(gdp);

            City city = new City();
            city.setCountry(country);
            city.setNrOfStreets(nrOfStreets);
            city.setName(name);
            cityService.createCityByObj(city);
        }
    }

    public void deleteElement(){
        System.out.println("Pick a category:");
        System.out.println("1. Country");
        System.out.println("2. City");

        int choice = scanner.nextInt();
        if(choice == 1){
            System.out.println("Type the name of the country to delete: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            countryService.deleteCountry(name);
        }
        else{
            System.out.println("Type the name of the city to delete: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            cityService.deleteCity(name);
        }
    }*/

}
