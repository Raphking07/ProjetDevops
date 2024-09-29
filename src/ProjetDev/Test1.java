package ProjetDev;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class Test1 {
	
	
	class ListTest {
		
	}
	 @Test
	    void shouldContainOnlyFirstameAndLastName() {
	        List<String> Infos = List.of("N'GUESSAN Raphël");
	        assertThat(Infos)
	            .containsExactly("N'GUESSAN Raphaël")
	            .doesNotContain("Big");
	            
	    }
	
}
	
