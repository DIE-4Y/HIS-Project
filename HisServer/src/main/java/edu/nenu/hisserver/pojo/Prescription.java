package edu.nenu.hisserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    private Integer id;
    private Integer registerId;
    private Integer drugId;
    private String drugUsage;
    private Integer drugNumber;
    private LocalDateTime creationTime;
    private String drugState;

}
