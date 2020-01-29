import org.testng.annotations.Test;
import okhttp3.*;
import static org.testng.Assert.assertEquals;
import java.io.IOException;


public class testService {
	
  private final OkHttpClient httpClient = new OkHttpClient();	
	
  @Test
  public void verifyService() throws IOException {
	  
	  // Estructura del request 
	  
	  Request request = new Request.Builder()
              .url("https://postman-echo.com/get")
              .addHeader("too1", "bar1")  // envió de parametros 
              .addHeader("too2", "bar2")
              .build();

	  // Ejecución del request
	  
      try (Response response = httpClient.newCall(request).execute()) {
    	  
     // validación si el código de repuesta no es 200 
    	  
          if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

     //validación ok 
          
          assertEquals(response.code(),200 );
      }
	  
  }

}
