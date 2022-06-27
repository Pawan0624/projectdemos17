package kafkaproducers;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentSerializer implements Serializer<Student> {
	
	ObjectMapper mapper = new ObjectMapper();

	@Override
	public byte[] serialize(String topic, Student data) {
		// TODO Auto-generated method stub
		byte[] array = null ;
		try {
			array= mapper.writeValueAsBytes(data);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

}
