
import DAO.CountryDAO;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.Country;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tiago
 */
public class Principal {

    static Stream<Country> streamCountries;
    static Scanner scanner = new Scanner(System.in);

    public static void show(List<Country> countries) {
        countries.forEach(c -> System.out.println(c.getCountryName()));
    }

    public static long TotalCountriesStartsWithLetterB(List<Country> countries) {
        streamCountries = countries.stream();
        long result = streamCountries.filter(c -> c.getCountryName().startsWith("B")).count();
        return result;
    }

    public static void countriesStartsWithLetter(List<Country> countries,String letter) {
        streamCountries = countries.stream();
        countries = streamCountries.filter(c -> c.getCountryName().startsWith(letter)).collect(Collectors.toList());
        countries.forEach(c -> System.out.println(c.getCountryName()));
    }

    public static void main(String[] args) {
        List<Country> countries = new CountryDAO().finAll();
        if (countries != null) {
            System.out.println("Digite a inicial do País:");
            countriesStartsWithLetter(countries,scanner.nextLine());
        }

    }

}
