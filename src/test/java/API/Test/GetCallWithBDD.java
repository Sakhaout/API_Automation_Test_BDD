package API.Test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GetCallWithBDD {
	
	
	@Test
	public void get_circuitNumber_2017_Seasion() {
		given().
		when().
			get("http://ergast.com/api/f1/2017/circuits.json").
		then().
			assertThat().
			body("MRData.CircuitTable.Circuits.circuitId", hasSize(20));


	}
	

}
