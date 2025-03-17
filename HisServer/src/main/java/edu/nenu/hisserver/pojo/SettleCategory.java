package edu.nenu.hisserver.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SettleCategory {
    Integer id;
    String settleCode;
    String settleName;
    Integer sequenceNo;
    Integer delmark;
}
