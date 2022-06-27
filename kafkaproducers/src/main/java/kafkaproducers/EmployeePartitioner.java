package kafkaproducers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;



public class EmployeePartitioner implements Partitioner{

	private Properties properties=new Properties();
	@Override
	public void configure(Map<String, ?> props) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fin=new FileInputStream("designation.properties");
			properties.load(fin);
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		properties=null;
	}

	@Override
	public int partition(String topic, Object key, byte[] keyBytes, 
			Object value, byte[] valueBytes, Cluster cluster) {
		// TODO Auto-generated method stub
		int partition=1;
		Employee employee=(Employee)value;
		String designation=employee.getDesignation();
		if(properties.containsKey(designation)) {
				 partition=Integer.parseInt(properties.getProperty(designation));
		}
		System.out.println("sending employee with id "+employee.getId()+" to partition "+
		partition);
		return partition;
}
}

