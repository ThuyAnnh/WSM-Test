package WSM_Women_Mode;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.WebElement;

import java.util.List;

@Data
@AllArgsConstructor
public class UserGroup {
    List<WebElement> list;
}
