package johny.dotsville.hello.core.context.goods.repo;

import johny.dotsville.hello.core.context.goods.entities.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
