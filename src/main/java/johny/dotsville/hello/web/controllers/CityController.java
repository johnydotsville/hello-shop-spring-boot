package johny.dotsville.hello.web.controllers;

import johny.dotsville.hello.domain.entities.city.City;
import johny.dotsville.hello.domain.repos.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CityController {
    private final CityRepository cityRepo;
    public CityController(CityRepository actorRepo) {
        this.cityRepo = actorRepo;
    }

    @GetMapping("/city/{id}")
    public City findCityById(@PathVariable(name = "id") long id) {
        Optional<City> city = cityRepo.findById(id);

        return city.orElse(null);
    }

    @GetMapping("/city")
    public List<City> findCityByName(@RequestParam(name = "name") String name) {
        List<City> cities = cityRepo.findByName(name);

        return cities;
    }

    @GetMapping("/city/all")
    public Iterable<City> findAllCities()  {
        Iterable<City> cities = cityRepo.findAll();

        return cities;
    }

    @GetMapping("/city/page/{pageNo}")
    public Iterable<City> findCityPaged(@PathVariable(name = "pageNo") int pageNo)  {
        Page<City> cities = cityRepo.findAll(PageRequest.of(pageNo, 5));

        return cities.toList();
    }

    @PostMapping("/city/create")
    public City createNewCity(@RequestBody City city) {
        City newCity = cityRepo.save(city);

        return newCity;
    }
}
