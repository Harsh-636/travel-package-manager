package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Activity {
    private String name;
    private String description;
    private Double cost;
    private Integer capacity;
}
