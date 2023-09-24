package edu.mum.cs.cs425.junit;

import static org.junit.Assert.assertArrayEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;


@SpringBootTest

class ArrayReversorTestCases {
	@Mock
	private ArrayFlattener arrFlattenerMock;

	@InjectMocks
	@Autowired
	private ArrayReversor arrReversor;

	@Test
	void testArrayReversor_input_2DArray() {
		int[][] a_i = { { 1, 3 }, { 0 }, { 4, 5, 9 } };
		when(arrFlattenerMock.flattenArray(a_i)).thenReturn(new int[]{1,3,0,4,5,9});
		
		int[] a_o = arrReversor.reverseArray(a_i);

		int[] a_expected = { 9, 5, 4, 0, 3, 1 };

		//verify(arrFlattenerMock, times(1)).flattenArray(a_i);
		assertArrayEquals(a_expected, a_o);
	}

	@Test
	void testArrayReversor_input_null() {
		int[][] a_i = null;
		//when(arrFlattenerMock.flattenArray(a_i)).thenReturn(null);
		
		int[] a_o = arrReversor.reverseArray(a_i);
		
		int[] a_expected = null;

		//verify(arrFlattenerMock, times(1)).flattenArray(a_i);
		assertArrayEquals(a_expected, a_o);
	}
}
