package dealership.desafio_mirante.ms_car.application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dealership.desafio_mirante.ms_car.application.dto.CarDTO;
import dealership.desafio_mirante.ms_car.domain.Car;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  private static final String URL = "/cars";

  @Test
public void testFindAll() {
    ResponseEntity<List<CarDTO>> response = restTemplate.exchange(
        URL + "/all", 
        HttpMethod.GET, 
        null, 
        new ParameterizedTypeReference<List<CarDTO>>() {}
    );
    assertEquals(response.getStatusCode(), HttpStatus.OK);
}

  @Test
  public void findById() {
    ResponseEntity<CarDTO> response = restTemplate.getForEntity(URL + "/1", CarDTO.class);
    assertEquals(response.getStatusCode(), HttpStatus.OK);
  }

  @Test
  public void create() {
    Car car = new Car.Builder()
      .name("Gol")
      .brand("Volkswagen")
      .model("Gol")
      .year("2021")
      .color("Black")
      .price("R$ 50.000,00")
      .description("Carro em ótimo estado")
      .build();
    ResponseEntity<CarDTO> response = restTemplate.postForEntity(URL + "/create", car, CarDTO.class);
    assertEquals(response.getStatusCode(), HttpStatus.OK);
  }
  
}
