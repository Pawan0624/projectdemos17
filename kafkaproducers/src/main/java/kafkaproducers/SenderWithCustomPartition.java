package kafkaproducers;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class SenderWithCustomPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.setProperty(ProducerConfig.PARTITIONER_CLASS_CONFIG, MessagePartioner.class.getName());
		
		KafkaProducer<String, String> producer = new KafkaProducer<>(props);
		String topic = "kafkatopic2";
		for(int i=0;i<=10;i++) {
			ProducerRecord<String,String> record = new ProducerRecord<>(topic,"first-key","This is test message - "+i);
			producer.send(record);
		}
		
		for(int i=11;i<=20;i++) {
			ProducerRecord<String,String> record = new ProducerRecord<>(topic,"second-key","This is test message - "+i);
			producer.send(record);
		}
		for(int i=21;i<=30;i++) {
			ProducerRecord<String,String> record = new ProducerRecord<>(topic,"third-key","This is test message - "+i);
			producer.send(record);
		}
		
		for(int i=31;i<=40;i++) {
			ProducerRecord<String,String> record = new ProducerRecord<>(topic,"fourth-key","This is test message - "+i);
			producer.send(record);
		}
		for(int i=41;i<=50;i++) {
			ProducerRecord<String,String> record = new ProducerRecord<>(topic,"fifth-key","This is test message - "+i);
			producer.send(record);
		}
		producer.close();
		System.out.println("Messages sent from producer...");

	}

}
