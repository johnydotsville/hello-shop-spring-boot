package johny.dotsville.hello.web.controllers;

import johny.dotsville.hello.domain.entities.goods.Goods;
import johny.dotsville.hello.domain.repos.GoodsRepository;
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
    public Goods findGoodsById(@PathVariable(name = "id") long id) {
        Optional<Goods> goods = goodsRepo.findById(id);
        return goods.orElse(null);
    }
}
