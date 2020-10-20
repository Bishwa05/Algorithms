package map;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * kv.set("foo", "bar", 1);
 * // store the key "foo" and value "bar" along with timestamp = 1
 *
 * kv.get("foo", 1);  // output "bar"    
 * kv.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"    
 * kv.set("foo", "bar2", 4);    
 * kv.get("foo", 4); // output "bar2"    
 * kv.get("foo", 5); //output "bar2"
 *
 *
 * kv.set("foo", "bar", 1);
 * kv.set("foo", "bar", 33)
 *
 * kv.get("foo",2); --> bar
 *
 */
public class TimeMap
{
    Map<String, Map<Long, String>> timeMap;
    Map<Long, String> inMap;

    public TimeMap(){
        timeMap = new HashMap<>();
        inMap = new HashMap<>();

    }


    public void set(String key, String value, Long timer) {

        if(timeMap.containsKey(key)){
            inMap = timeMap.get(key);
            inMap.put(timer, value);
        } else{
            inMap = new HashMap<>();
            inMap.put(timer, value);
            timeMap.put(key, inMap);
        }
    }

    public String get(String key, Long timer){

        if(timeMap.containsKey(key)){
            inMap = timeMap.get(key);
            if(inMap.containsKey(timer)){
                return inMap.get(timer);
            } else{
                String retVal = "";
                for(Map.Entry e : inMap.entrySet()){
                    if((int)e.getKey()<timer){
                        retVal = e.getValue().toString();
                    } else{
                        return retVal;
                    }
                }
            }
        }
        return "";
    }

}
