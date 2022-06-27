package kafkaconsumers;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;



public class SimpleConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "group-1");
		
		System.out.println("Consumer waiting for messages....");
		KafkaConsumer<String,String> consumer = new KafkaConsumer(props);
		
		
		List<String> topicList = Collections.singletonList("kafkatopic2");
		consumer.subscribe(topicList);
		
		while(true) {
			ConsumerRecords<String,String> records = consumer.poll(Duration.ofSeconds(1));
			records.forEach(record->{
				System.out.println(record.key()+"  "+record.value()+" "+record.partition());
			});
		}

	}

}
