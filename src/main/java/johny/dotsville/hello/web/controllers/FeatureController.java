package johny.dotsville.hello.web.controllers;

import johny.dotsville.hello.core.context.goods.dto.FeatureDto;
import johny.dotsville.hello.core.context.goods.entities.Feature;
import johny.dotsville.hello.core.context.goods.repo.FeatureRepository;
import johny.dotsville.hello.core.utils.exceptions.DataException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FeatureController {
    private final FeatureRepository featureRepo;
    private final ModelMapper mapper;

    @Autowired
    public FeatureController(FeatureRepository featureRepo, ModelMapper mapper) {
        this.featureRepo = featureRepo;
        this.mapper = mapper;
    }

    @GetMapping("/feature/all")
    public List<FeatureDto> getAllFeatures() {
        List<Feature> features = featureRepo.findAll();

        if (!features.isEmpty()) {
            return features.stream()
                    .map(f -> mapper.map(f, FeatureDto.class))
                    .collect(Collectors.toList());
        }

        throw new DataException();
    }
}
