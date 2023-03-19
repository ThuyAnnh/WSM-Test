package WSM_Women_Mode;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.WebElement;

import java.util.List;

@Data
@AllArgsConstructor
public class MonthYear {
    private List<WebElement> list;
}
