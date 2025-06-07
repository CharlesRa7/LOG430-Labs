package ets.log430.lab.models.dto;


public class ProductCategoryDto {
    private long id;
    private String name;

    public ProductCategoryDto() {}

    public ProductCategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}