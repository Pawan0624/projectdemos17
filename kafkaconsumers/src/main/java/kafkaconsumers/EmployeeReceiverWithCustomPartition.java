package kafkaconsumers;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

public class EmployeeReceiverWithCustomPartition {
	public static void main(String[] args) {
		Properties props=new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, EmployeeDeserializer.class.getName());
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "group-1");
	//	Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the partition");
		int partitionNo=Integer.parseInt(args[0]);
		String topic="emp-topic-new";
			
		KafkaConsumer<String, Employee> consumer=new KafkaConsumer<>(props);
		
		TopicPartition partition=new TopicPartition(topic, partitionNo);
		List<TopicPartition> partitions=Collections.singletonList(partition);
		
		consumer.assign(partitions);
		System.out.println("waiting for the messages from partition "+partitionNo);
		
		while(true) {
			ConsumerRecords<String, Employee> records=consumer.poll(Duration.ofSeconds(1));
			records.forEach(record->{
				System.out.println("key: "+record.key()+"\tpartition:"
						+record.partition());
				System.out.println("Value");
				Employee employee=(Employee)record.value();
				System.out.println(employee.getId()+"\t"+employee.getName()+"\t"+employee.getDesignation());
			});

			
		}
	}


}
