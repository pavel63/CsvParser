import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CsvReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  readFile();
	}
		   
		   public static void readFile(){
		         List<Map<String, String>> csvInputList = new CopyOnWriteArrayList<>();
		         List<Map<String, Integer>> headerList = new CopyOnWriteArrayList<>();

		         String fileName = "/Users/ios_razrab/Downloads/SalesJan2009.csv";
		         CSVFormat format = CSVFormat.newFormat(',').withHeader();

		          try (BufferedReader inputReader = new BufferedReader(new FileReader(new File(fileName)));
		                  CSVParser dataCSVParser = new CSVParser(inputReader, format); ) {

		             List<CSVRecord> csvRecords = dataCSVParser.getRecords();

		             Map<String, Integer> headerMap = dataCSVParser.getHeaderMap();
		              headerList.add(headerMap);
		              headerList.forEach(System.out::println);

		             for(CSVRecord record : csvRecords){
		                 Map<String, String> inputMap = new LinkedHashMap<>();

		                 for(Map.Entry<String, Integer> header : headerMap.entrySet()){
		                     inputMap.put(header.getKey(), record.get(header.getValue()));
		                 }

		                 if (!inputMap.isEmpty()) {
		                     csvInputList.add(inputMap);
		                } 
		             }

		             csvInputList.forEach(System.out::println);

		          } catch (Exception e) {
		             System.out.println(e);
		          }
		   
	}

}
