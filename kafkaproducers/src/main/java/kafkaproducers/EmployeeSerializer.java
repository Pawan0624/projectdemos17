package kafkaproducers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class EmployeeSerializer implements Serializer<Employee> {

	private ObjectMapper mapper=new ObjectMapper();
	@Override
	public byte[] serialize(String topic, Employee employee) {
		// TODO Auto-generated method stub
		byte[] array=null;
		try {
			array=mapper.writeValueAsBytes(employee);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

}

