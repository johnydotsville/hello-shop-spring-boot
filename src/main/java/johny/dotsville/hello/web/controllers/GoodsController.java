package johny.dotsville.hello.web.controllers;

import johny.dotsville.hello.core.context.goods.dto.GoodsDto;
import johny.dotsville.hello.core.context.goods.entities.Goods;
import johny.dotsville.hello.core.context.goods.repo.GoodsRepository;
import johny.dotsville.hello.core.utils.exceptions.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GoodsController {
    private GoodsRepository goodsRepo;

    @Autowired
    public GoodsController(GoodsRepository goodsRepo) {
        this.goodsRepo = goodsRepo;
    }

    @GetMapping("/goods/{id}")
    public GoodsDto findGoodsById(@PathVariable(name = "id") long id) {
        Optional<Goods> goods = goodsRepo.findById(id);

        if (goods.isPresent()) {
            return goods.get().toDto();
        }
        throw new DataException();
    }
}
