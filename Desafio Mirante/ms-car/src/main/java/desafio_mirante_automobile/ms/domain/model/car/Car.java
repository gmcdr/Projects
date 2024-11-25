package desafio_mirante_automobile.ms.domain.model.car;

import java.util.List;

import desafio_mirante_automobile.ms.domain.model.valueobjects.CarInfo;
import desafio_mirante_automobile.ms.domain.model.valueobjects.OptionalFeature;

public class Car {
  
  private List<OptionalFeature> optionalFeatures;
  private CarInfo carInfo;

  public Car(List<OptionalFeature> optionalFeatures, CarInfo carInfo) {
    this.optionalFeatures = optionalFeatures;
    this.carInfo = carInfo;
  }

  public List<OptionalFeature> getOptionalFeatures() {
    return optionalFeatures;
  }

  public void setOptionalFeatures(List<OptionalFeature> optionalFeatures) {
    this.optionalFeatures = optionalFeatures;
  }

  public CarInfo getCarInfo() {
    return this.carInfo;
  }

  public void setCarInfo(CarInfo carInfo) {
    this.carInfo = carInfo;
  }

}
