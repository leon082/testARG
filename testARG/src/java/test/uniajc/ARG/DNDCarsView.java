package co.com.nexura.test.dashboard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.DragDropEvent;

@ManagedBean(name = "dndCarsView")
@ViewScoped
public class DNDCarsView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{carService}")
	private CarService service;

	private List<Car> cars;
	private List<Car> cars1;

	private List<Car> droppedCars;

	private Car selectedCar;

	@PostConstruct
	public void init() {
		cars = service.createCars(4);
		droppedCars = new ArrayList<Car>();
	}

	public void onCarDrop(DragDropEvent ddEvent) {
		Car car = ((Car) ddEvent.getData());
		System.out.println(DNDCarsView.class.getName()+".log(onCarDrop)");
		droppedCars.add(car);
		cars.remove(car);
	}

	public void setService(CarService service) {
		this.service = service;
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<Car> getDroppedCars() {
		return droppedCars;
	}

	public Car getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}

	/**
	 * @return the cars1
	 */
	public List<Car> getCars1() {
		return cars1;
	}

	/**
	 * @param cars1
	 *            the cars1 to set
	 */
	public void setCars1(List<Car> cars1) {
		this.cars1 = cars1;
	}
}
