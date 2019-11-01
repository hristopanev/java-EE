package service;

import domain.entites.Product;
import domain.models.service.ProductServiceModel;
import org.modelmapper.ModelMapper;
import repository.ProductRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Inject
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createProduct(ProductServiceModel productServiceModel) {
        Product product = this.modelMapper.map(productServiceModel, Product.class);
        this.productRepository.save(product);
    }

    @Override
    public ProductServiceModel getById(String id) {
        return this.modelMapper.map(this.productRepository.findById(id), ProductServiceModel.class);
    }

    @Override
    public List<ProductServiceModel> getAllProducts() {
        return this.productRepository.findAll()
                .stream()
                .map(p -> this.modelMapper.map(p, ProductServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean editProduct(ProductServiceModel productServiceModel) {
        try {
            this.productRepository.edit(this.modelMapper.map(productServiceModel, Product.class));

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void deleteProduct(String id) {
        this.productRepository.delete(id);
    }
}
