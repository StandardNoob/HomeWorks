package sometests;

import java.util.HashMap;
import java.util.Map;

public class CollectTest {

	public static void main(String[] args) {

		Map<Integer, String> passportsAndNames = new HashMap<Integer, String>();

		passportsAndNames.put(212133, "����� ���������� ���������");
		passportsAndNames.put(162348, "���� ���������� ����������");
		passportsAndNames.put(8082771, "������� ���� �����");
		passportsAndNames.put(162348, "������ ���������� �������");

		for(Map.Entry keyValue : passportsAndNames.entrySet()) {
			System.out.println(keyValue.hashCode());
		}
		
	}

}
