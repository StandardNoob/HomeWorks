package sometests;

import java.util.HashMap;
import java.util.Map;

public class CollectTest {

	public static void main(String[] args) {

		Map<Integer, String> passportsAndNames = new HashMap<Integer, String>();

		passportsAndNames.put(212133, "Лидия Аркадьевна Бубликова");
		passportsAndNames.put(162348, "Иван Михайлович Серебряков");
		passportsAndNames.put(8082771, "Дональд Джон Трамп");
		passportsAndNames.put(162348, "Виктор Михайлович Стычкин");

		for(Map.Entry keyValue : passportsAndNames.entrySet()) {
			System.out.println(keyValue.hashCode());
		}
		
	}

}
