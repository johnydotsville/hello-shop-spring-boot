package johny.dotsville.hello.core.context.goods.service;

import johny.dotsville.hello.core.context.goods.dto.GoodsFeatureDto;
import johny.dotsville.hello.core.context.goods.entities.Feature;
import johny.dotsville.hello.core.context.goods.entities.Goods;
import johny.dotsville.hello.core.context.goods.entities.GoodsFeature;
import johny.dotsville.hello.core.context.goods.repo.FeatureRepository;
import johny.dotsville.hello.core.context.goods.repo.GoodsFeatureRepository;
import johny.dotsville.hello.core.context.goods.repo.GoodsRepository;
import johny.dotsville.hello.core.utils.exceptions.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoodsService {
    private final GoodsRepository goodsRepo;
    private final FeatureRepository featureRepo;
    private final GoodsFeatureRepository goodsFeatureRepo;

    @Autowired
    public GoodsService(GoodsRepository goodsRepo,
                        FeatureRepository featureRepo,
                        GoodsFeatureRepository goodsFeatureRepo) {
        this.goodsRepo = goodsRepo;
        this.featureRepo = featureRepo;
        this.goodsFeatureRepo = goodsFeatureRepo;
    }

    public void addOrUpdateGoodsFeature(GoodsFeatureDto newGoodsFeature) {
        Optional<Goods> optionalGoods = goodsRepo.findById(newGoodsFeature.getGoodsId());
        if (optionalGoods.isEmpty()) {
            throw new DataException(String.format("Товар с идентификатором %i не найден", newGoodsFeature.getGoodsId()));
        }

        Optional<Feature> optionalFeature = featureRepo.findById(newGoodsFeature.getFeatureId());
        if (optionalFeature.isEmpty()) {
            throw new DataException("Характеристика отсутствует в базе");
        }

        GoodsFeature.Id gfId = new GoodsFeature.Id(newGoodsFeature.getGoodsId(), newGoodsFeature.getFeatureId());
        Optional<GoodsFeature> optionalGoodsFeature = goodsFeatureRepo.findById(gfId);

        GoodsFeature goodsFeature = null;
        if (optionalGoodsFeature.isEmpty()) {
            goodsFeature = new GoodsFeature(optionalGoods.get(), optionalFeature.get(), newGoodsFeature.getFeatureValue());
        } else {
            goodsFeature = optionalGoodsFeature.get();
            goodsFeature.setValue(newGoodsFeature.getFeatureValue());
        }
        goodsFeatureRepo.save(goodsFeature);
    }
}
