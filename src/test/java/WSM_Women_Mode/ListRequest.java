package WSM_Women_Mode;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
@Data
@AllArgsConstructor
public class ListRequest {
    private String staffCode;
    private String staffName;
    private String timeOfCreation;
    private String timeRequest;
    private String kind;
    private String typeOfSwap;
    private String time;
    private String status;
    private String beingHandledBy;
    private String action1;
    private String action2;

}
