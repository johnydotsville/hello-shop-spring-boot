package johny.dotsville.hello.core.context.goods.repo;

import johny.dotsville.hello.core.context.goods.entities.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
