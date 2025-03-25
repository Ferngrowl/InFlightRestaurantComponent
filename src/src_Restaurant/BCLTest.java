package src_Restaurant;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner;
import javax.swing.Timer;

import org.junit.jupiter.api.Test;

class BCLTest {
	
	
	@Test
	void testNumSuccess() {
		assertEquals(true, BCL_Restaurant_UI.numCheck("1234567")); // Success would mean an integer returns true
		assertEquals(true, BCL_Restaurant_UI.numCheck("1")); // even if a single digit is the only input it should still return true
	}
	
	@Test
	void testNumFailure() {
		assertEquals(false, BCL_Restaurant_UI.numCheck("AbCdEfG")); //Letters should not return true
		assertEquals(false, BCL_Restaurant_UI.numCheck("111 222 333")); // White space should not return true
	}
	
	@Test
	void testCharSuccess() {
		assertEquals(true, BCL_Restaurant_UI.charCheck("Aaron")); // Success would mean a string returns true
		assertEquals(true, BCL_Restaurant_UI.charCheck("Aaron Samuels")); // Success would mean a string with spaces also returns true
	}
	
	@Test
	void testCharFailure() {
		assertEquals(false, BCL_Restaurant_UI.charCheck("123")); //Numbers should not return true
		assertEquals(false, BCL_Restaurant_UI.charCheck("AAA8AAA")); //even one number within a string should not return true
	}
	
	public static int stock = 100;
	JSpinner spinnerTest = new JSpinner(); //make a test spinner
	
	ActionListener restockTest = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
	        spinnerTest.setEnabled(true);
	        stock = 100;
		}
	};
	Timer timer = new Timer(10000, restockTest);
	
	@Test
	void testStockSuccess() {

		spinnerTest.setValue(5);
		assertEquals(95, BCL_Restaurant_UI.stockCheck(spinnerTest,stock,timer)); // if 5 items are purchased, should return 95
		
	}
	
	@Test
	void testStockZeroSuccess() {

		stock = 0;
		spinnerTest.setValue(1);
		assertEquals(0, BCL_Restaurant_UI.stockCheck(spinnerTest,stock,timer)); //if stock is zero and a user attempts to buy an item
																				// purchase is unsuccessful and stock should stay at zero
	}
	
	
}
