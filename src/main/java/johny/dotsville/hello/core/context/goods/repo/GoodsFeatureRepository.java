package johny.dotsville.hello.core.context.goods.repo;

import johny.dotsville.hello.core.context.goods.entities.GoodsFeature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsFeatureRepository extends JpaRepository<GoodsFeature, GoodsFeature.Id> {
}
