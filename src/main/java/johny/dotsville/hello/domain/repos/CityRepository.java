package johny.dotsville.hello.domain.repos;

import johny.dotsville.hello.domain.entities.city.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByName(String name);
}
