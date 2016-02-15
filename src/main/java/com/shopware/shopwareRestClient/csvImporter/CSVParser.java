package com.shopware.shopwareRestClient.csvImporter;

//import java.io.IOException;
//import java.io.StringReader;
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//
//import com.shopware.shopwareRestClient.dto.article.Data;

public class CSVParser {

//TODO: JSefa-Code als Beispiel für OpenCSV implementierung

//	public ArrayList<Data> readCsvBySefaToEntity() {
//		Path path = Paths.get("");
//
//		Charset charset = StandardCharsets.ISO_8859_1;
//		String content = null;
//
//		try {
//			content = new String(Files.readAllBytes(path), charset);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		CsvConfiguration csvConfiguration = new CsvConfiguration();
//		csvConfiguration.setFieldDelimiter(';');
//		// csvConfiguration.getSimpleTypeConverterProvider().registerConverterType(Integer.class, IntegerConverter.class);
//
//		Deserializer deserializer = CsvIOFactory.createFactory(csvConfiguration, Data.class).createDeserializer();
//		deserializer.open(new StringReader(content));
//
//		ArrayList<Data> readedArtikelList = new ArrayList<Data>();
//		while (deserializer.hasNext()) {
//			readedArtikelList.add((Data) deserializer.next());
//		}
//		deserializer.close(true);
//
//		return readedArtikelList;
//	}
}