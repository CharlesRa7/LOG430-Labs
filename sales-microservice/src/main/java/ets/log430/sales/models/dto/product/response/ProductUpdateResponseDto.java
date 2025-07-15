package ets.log430.sales.models.dto.product.response;

import ets.log430.sales.models.dto.product.request.ProductUpdateRequestDto;

public class ProductUpdateResponseDto {
    private ProductUpdateRequestDto oldProduct;
    private ProductUpdateRequestDto newProduct;

    public ProductUpdateResponseDto() {}

    public ProductUpdateResponseDto(ProductUpdateRequestDto oldProduct, ProductUpdateRequestDto newProduct) {
        this.oldProduct = oldProduct;
        this.newProduct = newProduct;
    }

    public ProductUpdateRequestDto getOldProduct() {
        return oldProduct;
    }

    public void setOldProduct(ProductUpdateRequestDto oldProduct) {
        this.oldProduct = oldProduct;
    }

    public ProductUpdateRequestDto getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(ProductUpdateRequestDto newProduct) {
        this.newProduct = newProduct;
    }
}
