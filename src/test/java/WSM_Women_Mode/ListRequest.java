package WSM_Women_Mode;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
@Data
@AllArgsConstructor
public class ListRequest {
    ArrayList<String[]> listRequest = new ArrayList<>();
}
