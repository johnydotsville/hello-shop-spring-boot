package johny.dotsville.hello.web.controllers;

import johny.dotsville.hello.core.context.goods.dto.GoodsDto;
import johny.dotsville.hello.core.context.goods.entities.Goods;
import johny.dotsville.hello.core.context.goods.repo.GoodsRepository;
import johny.dotsville.hello.core.utils.exceptions.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class GoodsController {
    private static final int defaultPageSize = 25;

    private GoodsRepository goodsRepo;

    @Autowired
    public GoodsController(GoodsRepository goodsRepo) {
        this.goodsRepo = goodsRepo;
    }

    @GetMapping("/goods/{id}")
    public GoodsDto findGoodsById(@PathVariable(name = "id") long id) {
        Optional<Goods> goods = goodsRepo.findById(id);

        if (goods.isPresent()) {
            return Goods.toDto(goods.get());
        }
        throw new DataException();
    }

    // TODO: ввести еще таблицу категорий товаров
    @GetMapping("/goods/all/{pageNo}")
    public List<GoodsDto> getAllGoods(@PathVariable(name = "pageNo") int pageNo) {
        Page<Goods> goods = goodsRepo.findAll(PageRequest.of(pageNo, defaultPageSize));
        return goods.stream()
                .map(g -> Goods.toDto(g))
                .collect(Collectors.toList());
    }
}
