package sapsan.homework.controllers;

import org.springframework.web.bind.annotation.*;
import sapsan.homework.entities.dto.AnimalDto;
import sapsan.homework.entities.dto.BookDto;
import sapsan.homework.entities.dto.BoxerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/homework")
public class TestController {

    @GetMapping("/get-random-number")
    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(1000) + 1;
    }

    @GetMapping("/get-week-weather-forecast")
    public List<String> getWeekWeatherForecast() {
        Random random = new Random();

        enum Weather {
            Sunny,
            Rainy,
            Cloudy,
            Windy,
            Snowy,
            Stormy
        }

        Weather[] weather = Weather.values();
        List<String> weatherList = new ArrayList<>(7);

        for (int i = 0; i < 7; i++) {
            weatherList.add(String.valueOf(weather[random.nextInt(weather.length)]));
        }

        return weatherList;
    }

    @PostMapping("/get-animal-info")
    public String getAnimalInfo(@RequestBody AnimalDto animal) {
        return "This is " + animal.getName() + ". It is a " + animal.getSpecies() + ". It is " + animal.getAge() + " years old";
    }

    @PostMapping("/get-boxer-info")
    public String getBoxerInfo(@RequestBody BoxerDto boxer) {
        return boxer.getName() + " is a boxer. They are " + boxer.getAge() + " years old. His alias is " + boxer.getAlias();
    }

    @PostMapping("/get-book-info")
    public String getBookInfo(@RequestBody BookDto book) {
        return book.getTitle() + " is a book written by " + book.getAuthor() + ", published in " + book.getPublishYear();
    }
}
