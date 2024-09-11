package Dao;

public interface DaoInterf {
	void addProduct(int prodId);
	void deleteProduct(int prodId);
	void changePrice(int userId, Double newPrice);
	void calculateBill(int userId);
}
