import java.util.*;

// examples of primitive types
// int, short, byte, long, float, double, boolean, and strings
// casting

public class primType{
	public static void main(String[] args){
		int minIntVal = Integer.MIN_VALUE; //minimum value int can hold
		int maxIntVal = Integer.MAX_VALUE; //maximum value int can hold

		boolean yes = true;
		boolean no = false;

		byte minByteVal = Byte.MIN_VALUE;
		byte maxByteVal = Byte.MAX_VALUE;

		short minShortVal = Short.MIN_VALUE;
		short maxShortVal = Short.MAX_VALUE;

		long minLongVal = Long.MIN_VALUE;
		long maxLongVal = Long.MAX_VALUE;

		long test = 2_147_483_647_234L; //must put L to declare value is of type long, or else java will think it's an int


		System.out.println(minIntVal);
		System.out.println(maxIntVal);

		System.out.println();

		System.out.println(minByteVal);
		System.out.println(maxByteVal);

		System.out.println();

		System.out.println(minShortVal);
		System.out.println(maxShortVal);

		System.out.println();

		System.out.println(minLongVal);
		System.out.println(maxLongVal);

		System.out.println(test);

		byte newMinByteVal = (byte) (maxByteVal/2); //even though minByteVal is of type byte, you still need to cast because the result is of type int

		short newShortVal = (short) (maxShortVal/2);

		int newMinIntVal = (int) (maxIntVal/2);

		long longVal = 50000L+10L*(newMinByteVal+newShortVal+newMinIntVal);

		System.out.println(longVal);

		float floatValMax = Float.MAX_VALUE;
		float floatValMin = Float.MIN_VALUE;

		float ranVal = 5.25f; //must add f to declare it's a float can also cast to float

		System.out.println();
		System.out.println(floatValMax);
		System.out.println(floatValMin);

		double doubleValMax = Double.MAX_VALUE;
		double doubleValMin = Double.MIN_VALUE;

		double ranValDouble = 5.25d;

		System.out.println();
		System.out.println(doubleValMax);
		System.out.println(doubleValMin);

		System.out.println(ranVal);
		System.out.println(ranValDouble);

	}
}