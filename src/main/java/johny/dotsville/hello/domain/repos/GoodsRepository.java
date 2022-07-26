package johny.dotsville.hello.domain.repos;

import johny.dotsville.hello.domain.entities.goods.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
