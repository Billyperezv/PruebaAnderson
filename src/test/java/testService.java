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
              .addHeader("too1", "bar1")  // envi� de parametros 
              .addHeader("too2", "bar2")
              .build();

	  // Ejecuci�n del request
	  
      try (Response response = httpClient.newCall(request).execute()) {
    	  
     // validaci�n si el c�digo de repuesta no es 200 
    	  
          if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

     //validaci�n ok 
          
          assertEquals(response.code(),200 );
      }
	  
  }

}
