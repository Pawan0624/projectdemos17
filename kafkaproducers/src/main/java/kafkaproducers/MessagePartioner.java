package kafkaproducers;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

public class MessagePartioner implements Partitioner{

	@Override
	public void configure(Map<String, ?> configs) {
		// TODO Auto-generated method stub
		System.out.println("************** customer partitioning started **********");
		
	}

	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		// TODO Auto-generated method stub
		int partition=1;
		
		if(key.equals("first-key")) {
			partition=4;
		}
		else if(key.equals("second-key")) {
			partition=3;
		}
		else if(key.equals("third-key")) {
			partition=2;
		}
		else if(key.equals("fourth-key")) {
			partition=0;
		}
		
			
		return partition;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("************** customer partitioning done********");
		
	}

}
