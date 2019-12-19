package ua.kr.component;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

@Component
public class CityImportComponent {
	
	@Autowired private ResourceLoader loader;
	
	private final static String cityFile = "cities.txt";
	
	
	public List<String> importCity() throws Exception{
		Resource resource = loader.getResource("classpath:" + cityFile);
		InputStream inputStream = resource.getInputStream();
		List<String> cities = new ArrayList<String>();
		
		Scanner sc = new Scanner(inputStream);	
		while(sc.hasNext())
			cities.add(sc.nextLine());
        sc.close();
        
		return cities;
	}
}
