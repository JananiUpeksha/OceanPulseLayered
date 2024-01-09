package lk.ijse.dto;

import lk.ijse.entity.Boat;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoatDto extends Boat {
    private String id;
    private String capacity;
    private String status;
    private String model;


}
