package kafkaproducers;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;



public class SimpleProducer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// set the properties like location of kafka server, key serializer and value serializer names
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		
		// create a a kafka producer by passing the above properties
		KafkaProducer<String, String> producer = new KafkaProducer<>(props);
		//ProducerRecord<String,String> record = new ProducerRecord<>("kafkatopic1", "testkey", "This is a test msg from java api");
		//producer.send(record);
		
		
		
	
		
		String topic = "kafkatopic1";
		String key="key - ";
		String value="This is my message - ";
		for(int i=0;i<=10;i++) {
			ProducerRecord<String,String> record = new ProducerRecord<>(topic,key+i,value+i);
			producer.send(record);
		}
		

		producer.close();
		System.out.println("Messages sent from producer...");

	}

}
