package en93.sample.northwindmodulith.config;

import en93.sample.northwindmodulith.generated.webapp.model.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class EnumConverterConfig implements WebMvcConfigurer {

    //Allows users to supply enums such in either upper or lower case. e.g. 'asc' or 'ASC'
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DirectionSortToEnumConverter());
        registry.addConverter(new OrderSortToEnumConverter());
        registry.addConverter(new ProductToEnumConverter());
        registry.addConverter(new SupplierToEnumConverter());
        registry.addConverter(new CustomerToEnumConverter());
    }
}

// TODO why don't these work as lambdas?
// TODO, rework issue so that won't need this config
class DirectionSortToEnumConverter implements Converter<String, SortDirectionEnumDTO> {
    @Override
    public SortDirectionEnumDTO convert(String source) {
        return SortDirectionEnumDTO.valueOf(source.toUpperCase());
    }
}

class OrderSortToEnumConverter implements Converter<String, OrderSortEnumDTO> {
    @Override
    public OrderSortEnumDTO convert(String source) {
        return OrderSortEnumDTO.valueOf(source.toUpperCase());
    }
}

class CustomerToEnumConverter implements Converter<String, CustomerSortEnumDTO> {
    @Override
    public CustomerSortEnumDTO convert(String source) {
        return CustomerSortEnumDTO.valueOf(source.toUpperCase());
    }
}

class ProductToEnumConverter implements Converter<String, ProductSortEnumDTO> {
    @Override
    public ProductSortEnumDTO convert(String source) {
        return ProductSortEnumDTO.valueOf(source.toUpperCase());
    }
}

class SupplierToEnumConverter implements Converter<String, SupplierSortEnumDTO> {
    @Override
    public SupplierSortEnumDTO convert(String source) {
        return SupplierSortEnumDTO.valueOf(source.toUpperCase());
    }
}

