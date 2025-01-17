package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@SuppressWarnings("unused")
class TestDemoJUnit {

	
	private TestDemo testDemo = new TestDemo();
	
	@Test
	void assertThatPairsOfPosititveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(10, 20)).isEqualTo(30);
		assertThat(testDemo.addPositive(100, 200)).isEqualTo(300);
		assertThat(testDemo.addPositive(1, 1)).isEqualTo(2);
		//works
	}
	 @Test
	 void testMultiplyPositive() {
	        // Test cases where neither number is zero
		 assertThat(testDemo.multiplyPositive(4, 5)).isEqualTo(20);
	     assertThat(testDemo.multiplyPositive(3, 7)).isEqualTo(21);
	     assertThat(testDemo.multiplyPositive(10, 10)).isEqualTo(100);  
	        
	        // Test case where one of the numbers is zero, should throw IllegalArgumentException
	     assertThatThrownBy(() -> testDemo.multiplyPositive(0, 5))
	     	.isInstanceOf(IllegalArgumentException.class) 
	        .hasMessage("Neither number can be zero"); 

	        // Test case where both numbers are zero, should throw IllegalArgumentException
	     assertThatThrownBy(() -> testDemo.multiplyPositive(0, 0))
	         .isInstanceOf(IllegalArgumentException.class) 
	         .hasMessage("Neither number can be zero");  
	 }//works
	
	 @Test
	 void assertThatNumberSquaredIsCorrect() {
	        // Create a spy on the testDemo object to mock the getRandomInt method
		 TestDemo mockDemo = spy(testDemo);

	        // Mock the getRandomInt method to return 5
	     doReturn(5).when(mockDemo).getRandomInt();

	        // Call randomNumberSquared on the mocked object
	     int fiveSquared = mockDemo.randomNumberSquared();

	        // Assert that the result is 5 squared (25)
	     assertThat(fiveSquared).isEqualTo(25);
	 }
	   
	   
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly
	(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);
		}else {
			assertThatThrownBy(()-> testDemo.addPositive(a,b))
				.isInstanceOf(IllegalArgumentException.class);
				
		}
		
	}
	
	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
				Arguments.arguments(2,4,5,false),
				Arguments.arguments(0,4,4,false),
				Arguments.arguments(-1,4,0,false),
				Arguments.arguments(1,-1,0,true),
				Arguments.arguments(-2,-2,0,true)
				);
	}
	
	
	

}
