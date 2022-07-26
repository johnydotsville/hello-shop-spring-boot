package johny.dotsville.hello.core.context.city.repo;

import johny.dotsville.hello.core.context.city.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByName(String name);
}
