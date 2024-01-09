package lk.ijse.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Boat {
    private String id;
    private String capacity;
    private String status;
    private String model;
}
