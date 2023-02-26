package edu.itstep.java_course_2023.props;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class PropsTest {
    private final Properties propsMean = new Properties();
    private static Logger logger = Logger.getLogger(PropsTest.class);
    private final Properties propsAction = new Properties();
    @BeforeEach
    void setUp(){
        //8=Warning - data could not be retrieved. For the specified date and time range, either partial data or no data at all could be retrieved by the ERB3XDRS service because time gaps have been detected in the gathered data.
        //9=Warning - VSAM retrieval errors occurred. For the specified date and time range, either partial data or no data at all could be retrieved.
        //13=Warning - inconsistent data returned by ERB3XDRS. The WLM service policy has changed, or the IPS values have been modified.
        //8=Warning - data could not be retrieved. For the specified date and time range, either partial data or no data at all could be retrieved by the ERB3XDRS service because time gaps have been detected in the gathered data.
       // 9=Warning - VSAM retrieval errors occurred. For the specified date and time range, either partial data or no data at all could be retrieved.
        propsMean.put("8","Warning - data could not be retrieved. For the specified date and time range, either partial data or no data at all could be retrieved by the ERB3XDRS service because time gaps have been detected in the gathered data.");
        propsMean.put("9","VSAM retrieval errors occurred. For the specified date and time range, either partial data or no data at all could be retrieved.");
        propsMean.put("13","inconsistent data returned by ERB3XDRS. The WLM service policy has changed, or the IPS values have been modified.");
        propsAction.put("8", "data could not be retrieved. For the specified date and time range, either partial data or no data at all could be retrieved by the ERB3XDRS service because time gaps have been detected in the gathered data" );
        propsAction.put("9", "VSAM retrieval errors occurred. For the specified date and time range, either partial data or no data at all could be retrieved.");
    }
   @Test
   void streamTest(){
        //create map from propertiesMap
       Map<Long, String> mapProperties = new HashMap<>();
       Enumeration<?> propName = propsMean.propertyNames();
       while(propName.hasMoreElements()){
           String key = (String)propName.nextElement();//cast to concrete type - Long
           mapProperties.put(Long.parseLong(key), propsMean.getProperty(String.valueOf(key)));
       }
       Assertions.assertEquals(3, mapProperties.size());
       //assertIterableEquals(mapProperties.keySet(),(Iterable<?>) propsMean.propertyNames());
       Stream<Map.Entry<Object,Object>> stream = propsMean.entrySet().stream();
       Map<Long,String> mapStreamProps = stream.collect(Collectors.toMap(
               e-> Long.parseLong((String)e.getKey()),
               e-> String.valueOf(e.getValue())));
       assertEquals(3, mapStreamProps.size());
   }
   @Test
    void useGuava() {
       Map<String, String> propAction = Maps.fromProperties(propsAction);
       assertEquals(2, propAction.size());

       String map = Joiner.on("###").withKeyValueSeparator("=").join(propAction);
       logger.info(map);



   }

}
