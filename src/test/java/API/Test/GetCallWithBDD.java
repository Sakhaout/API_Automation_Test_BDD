package API.Test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*** I am using https://ergast.com/mrd/ site for API testing ***/

public class GetCallWithBDD {
	
	
	@Test
	public void get_circuitNumber_of_Seasion_2017() {
		given().
		when().
			get("http://ergast.com/api/f1/2017/circuits.json").
		then().
			assertThat().
			statusCode(200).
			and().
			body("MRData.CircuitTable.Circuits.circuitId", hasSize(20));


	}
	

}
